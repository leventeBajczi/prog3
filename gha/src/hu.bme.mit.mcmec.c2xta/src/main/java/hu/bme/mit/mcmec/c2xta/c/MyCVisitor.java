package hu.bme.mit.mcmec.c2xta.c;

import hu.bme.mit.mcmec.c2xta.gen.CBaseVisitor;
import hu.bme.mit.mcmec.c2xta.gen.CParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type My c visitor.
 */
public class MyCVisitor extends CBaseVisitor {

    private List<String> atomicsList;
    private List<String> mutexList;
    private List<String> cndList;
    private Map<String, List<String>> threadStateLUT;
    private Map<String, Map<Integer, List<String>>> threadTransitionLUT;
    private String currentThread = "";

    private boolean external = false;
    private boolean function = false;


    private boolean atomic = false;
    private boolean mutex = false;
    private boolean cnd  = false;


    private static final String atomicQualifier = "_Atomic";
    private static final String mutexSpecifier = "mtx_t";
    private static final String conditionSpecifier = "cnd_t";


    private static final String atomic_load = "atomic_load_explicit(";
    private static final String atomic_store = "atomic_store_explicit(";
    private static final String cnd_wait = "cnd_wait(";
    private static final String cnd_signal = "cnd_signal(";
    private static final String cnd_broadcast = "cnd_broadcast(";
    private static final String mtx_lock = "mtx_lock(";
    private static final String mtx_unlock = "mtx_unlock(";
    private static final String thrd_create = "thrd_create(";
    private static final String thrd_join = "thrd_join(";
    private static final String _return = "return";
    private int cnt = 0;

    private static final String memory_mode = "memory_order_";


    /**
     * Instantiates a new My c visitor.
     */
    public MyCVisitor()
    {
        atomicsList = new ArrayList<>();
        mutexList = new ArrayList<>();
        cndList = new ArrayList<>();
        threadStateLUT = new HashMap<>();
        threadTransitionLUT = new HashMap<>();
    }


    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        String text = "";
        for(String s : mutexList)
            text = text.concat("int var_" + s + ";\n");

        text = text.concat("\nchan ");

        for(String s : mutexList)
            text = text.concat(s + ((cndList.size() == 0 && mutexList.get(mutexList.size() - 1) == s) ? ";" : ", "));
        for(String s : cndList)
            text = text.concat(s + (cndList.get(cndList.size() - 1) == s ? ";" : ", "));
        text = text.concat("\n");

        for (Map.Entry<String, List<String>> entry : threadStateLUT.entrySet()) {
            String thread = entry.getKey();
            List<String> statesList = entry.getValue();
            text = text.concat("\n\nprocess " + thread + "() {\nclock x;\nstate\n");
            for(String state : statesList)
            {
                text = text.concat("  " + state + ((state == statesList.get(statesList.size() - 1)) ? ";\n" : ",\n"));
            }
            text = text.concat("init " + statesList.get(0) + ";\ntrans");
            for (int i = 0; i < statesList.size() - 1; i++) {
                text = text.concat("\n  " + statesList.get(i) + "  ->  " + statesList.get(i+1) + "{ ");
                for(String transition : threadTransitionLUT.get(thread).get(i))
                {
                    text = text.concat(transition + (transition == threadTransitionLUT.get(thread).get(i).get(threadTransitionLUT.get(thread).get(i).size() - 1) ? "; " : ", "));
                }
                text = text.concat((i == statesList.size() - 2) ? "};\n}" : "},");
            }

        }
        text = text.concat("\nsystem ");
        for (Map.Entry<String, List<String>> entry : threadStateLUT.entrySet())
            text = text.concat(entry.getKey() + (entry == threadStateLUT.entrySet().toArray()[threadStateLUT.entrySet().size() - 1] ? "; " : ", "));
        return text;
    }

    /**
     * Visit external declaration object.
     *
     * @param ctx the ctx
     * @return the object
     */
    @Override
    public Object visitExternalDeclaration(CParser.ExternalDeclarationContext ctx) {
        external = true;
        return super.visitExternalDeclaration(ctx);
    }

    /**
     * Visit type qualifier object.
     *
     * @param ctx the ctx
     * @return the object
     */
    @Override
    public Object visitTypeQualifier(CParser.TypeQualifierContext ctx) {
        if(external)
            switch(ctx.getText())
            {
                case atomicQualifier:
                    atomic = true;
                    break;
                default:
                    break;
            }
        return super.visitTypeQualifier(ctx);
    }

    /**
     * Visit type specifier object.
     *
     * @param ctx the ctx
     * @return the object
     */
    @Override
    public Object visitTypeSpecifier(CParser.TypeSpecifierContext ctx) {
        if(external)
            switch(ctx.getText())
            {
                case mutexSpecifier:
                    mutex = true;
                    break;
                case conditionSpecifier:
                    cnd = true;
                    break;
                default:
                    break;
            }

        return super.visitTypeSpecifier(ctx);
    }

    /**
     * Visit function definition object.
     *
     * @param ctx the ctx
     * @return the object
     */
    @Override
    public Object visitFunctionDefinition(CParser.FunctionDefinitionContext ctx) {
        function = true;
        external = false;
        return super.visitFunctionDefinition(ctx);
    }

    /**
     * Visit block item object.
     *
     * @param ctx the ctx
     * @return the object
     */
    @Override
    public Object visitBlockItem(CParser.BlockItemContext ctx) {
        String text = ctx.getText();
        String memorder, variable;

        if(!currentThread.equals("main") && threadStateLUT.get(currentThread).size() == 0) {
            threadStateLUT.get(currentThread).add(currentThread + "_in");
            threadStateLUT.get(currentThread).add(currentThread + "_start");
            threadTransitionLUT.get(currentThread).put(0, new ArrayList<>());
            threadTransitionLUT.get(currentThread).get(0).add("sync " + currentThread.substring(1) + "?");
            threadTransitionLUT.get(currentThread).put(1, new ArrayList<>());

        }
        else if(threadStateLUT.get(currentThread).size() == 0)
        {
            threadStateLUT.get(currentThread).add(currentThread + "_in");
            threadTransitionLUT.get(currentThread).put(0, new ArrayList<>());
            for(String s :mutexList)
                threadTransitionLUT.get(currentThread).get(0).add("assign var_" + s + " = 0");
        }


        if(text.contains(atomic_load))
        {
            memorder = text.substring(text.indexOf(memory_mode), text.length()-2);
            variable = ctx.getText().substring(text.indexOf(atomic_load) + atomic_load.length() + 1).split(",")[0];
            threadStateLUT.get(currentThread).add(memorder.split("_")[memorder.split("_").length-1] + "_load_" + variable + "_" + ctx.getStart().getLine());
            threadTransitionLUT.get(currentThread).put(threadStateLUT.get(currentThread).size()-1, new ArrayList<>());
        }
        else if(text.contains(atomic_store))
        {
            memorder = text.substring(text.indexOf(memory_mode), text.length()-2);
            variable = ctx.getText().substring(text.indexOf(atomic_store) + atomic_store.length() + 1).split(",")[0];
            threadStateLUT.get(currentThread).add(memorder.split("_")[memorder.split("_").length-1] + "_store_" + variable + "_" + ctx.getStart().getLine());
            threadTransitionLUT.get(currentThread).put(threadStateLUT.get(currentThread).size()-1, new ArrayList<>());
        }
        else if(text.contains(cnd_wait))
        {
            String[] args = ctx.getText().substring(text.indexOf(cnd_wait) + cnd_wait.length() + 1).split(",");
            variable = args[0];
            threadTransitionLUT.get(currentThread).get(threadStateLUT.get(currentThread).size()-1).add( "assign var_" + args[1].substring(1, args[1].length()-2) + " = var_" + args[1].substring(1, args[1].length()-2) + " - 1");
            threadStateLUT.get(currentThread).add("cnd_wait_1_" + cnt++);
            threadTransitionLUT.get(currentThread).put(threadStateLUT.get(currentThread).size()-1, new ArrayList<>());
            threadTransitionLUT.get(currentThread).get(threadStateLUT.get(currentThread).size()-1).add( "sync " + variable + "?; assign var_" + args[1].substring(1, args[1].length()-2) + " = var_" + args[1].substring(1, args[1].length()-2) + " + 1");
            threadStateLUT.get(currentThread).add("cnd_wait_2_" + cnt++);
            threadTransitionLUT.get(currentThread).put(threadStateLUT.get(currentThread).size()-1, new ArrayList<>());
        }
        else if(text.contains(cnd_broadcast))
        {
            variable = ctx.getText().substring(text.indexOf(cnd_broadcast) + cnd_broadcast.length() + 1).split("\\)")[0];
            threadTransitionLUT.get(currentThread).get(threadStateLUT.get(currentThread).size()-1).add("sync " + variable + "!");
            threadStateLUT.get(currentThread).add("cnd_broadcast_" + cnt++);
            threadTransitionLUT.get(currentThread).put(threadStateLUT.get(currentThread).size()-1, new ArrayList<>());
        }
        else if(text.contains(cnd_signal))
        {
            variable = ctx.getText().substring(text.indexOf(cnd_signal) + cnd_signal.length() + 1).split("\\)")[0];
            threadTransitionLUT.get(currentThread).get(threadStateLUT.get(currentThread).size()-1).add("sync " + variable + "!");
            threadStateLUT.get(currentThread).add("cnd_signal_" + cnt++);
            threadTransitionLUT.get(currentThread).put(threadStateLUT.get(currentThread).size()-1, new ArrayList<>());
        }
        else if(text.contains(mtx_lock))
        {
            variable = ctx.getText().substring(text.indexOf(mtx_lock) + mtx_lock.length() + 1).split("\\)")[0];
            threadTransitionLUT.get(currentThread).get(threadStateLUT.get(currentThread).size()-1).add("guard var_" + variable + " == 0; assign var_" + variable + " = var_" + variable + " + 1");
            threadStateLUT.get(currentThread).add("mtx_lock_" + cnt++);
            threadTransitionLUT.get(currentThread).put(threadStateLUT.get(currentThread).size()-1, new ArrayList<>());
        }
        else if(text.contains(mtx_unlock))
        {
            variable = ctx.getText().substring(text.indexOf(mtx_unlock) + mtx_unlock.length() + 1).split("\\)")[0];
            threadTransitionLUT.get(currentThread).get(threadStateLUT.get(currentThread).size()-1).add("assign var_" + variable + " = var_" + variable + " - 1");
            threadStateLUT.get(currentThread).add("mtx_unlock_" + cnt++);
            threadTransitionLUT.get(currentThread).put(threadStateLUT.get(currentThread).size()-1, new ArrayList<>());
        }
        else if(text.contains(thrd_create))
        {
            variable = ctx.getText().substring(text.indexOf(thrd_create) + thrd_create.length() + 1).split(",")[0];
            threadTransitionLUT.get(currentThread).get(threadStateLUT.get(currentThread).size()-1).add("sync " + variable.substring(1, variable.length() - 2) + "!");
            cndList.add(variable.substring(1, variable.length() - 2));
            threadStateLUT.get(currentThread).add("thrd_create_" + cnt++);
            threadTransitionLUT.get(currentThread).put(threadStateLUT.get(currentThread).size()-1, new ArrayList<>());

        }
        else if(text.contains(thrd_join))
        {
            variable = ctx.getText().substring(text.indexOf(thrd_join) + thrd_join.length()).split(",")[0];
            threadTransitionLUT.get(currentThread).get(threadStateLUT.get(currentThread).size()-1).add("sync " + currentThread + "_" + variable.substring(1, variable.length() - 2) + "?");
            threadStateLUT.get(currentThread).add("thrd_join_" + cnt++);
            threadTransitionLUT.get(currentThread).put(threadStateLUT.get(currentThread).size()-1, new ArrayList<>());

        }
        else if(text.contains(_return))
        {

            threadTransitionLUT.get(currentThread).get(threadStateLUT.get(currentThread).size()-1).add("sync main_" + currentThread.substring(1) + "!");
            cndList.add("main_" + currentThread.substring(1));
            threadStateLUT.get(currentThread).add("final");
            function = false;
        }
        return super.visitBlockItem(ctx);
    }


    /**
     * Visit direct declarator object.
     *
     * @param ctx the ctx
     * @return the object
     */
    @Override
    public Object visitDirectDeclarator(CParser.DirectDeclaratorContext ctx) {
        if(ctx.directDeclarator() != null)
            return super.visitDirectDeclarator(ctx);
        if(external)
        {
            if(atomic)
                atomicsList.add(ctx.getText());
            else if(mutex)
                mutexList.add(ctx.getText());
            else if(cnd)
                cndList.add(ctx.getText());
            external = false;
            atomic = false;
            mutex = false;
            cnd = false;
        }
        else if(function)
        {
            threadStateLUT.put(ctx.getText(), new ArrayList<>());
            threadTransitionLUT.put(ctx.getText(), new HashMap<>());
            currentThread = ctx.getText();
            function = false;
        }
        return super.visitDirectDeclarator(ctx);
    }
}

