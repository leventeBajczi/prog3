package labdrei;

import java.io.*;

public class MyCommandHandler {
    private String[] args;
    private File pwd;

    void setArgs(String[] args)
    {
        this.args = args;
    }

    MyCommandHandler(String[] args) {
        this.args = args;
        pwd = new File(System.getProperty("user.dir"));
    }


    void execute() throws IOException, NotEnoughParamsException {
        if(args.length < 1) throw new NotEnoughParamsException();
        if(args[0].equals("exit"))
            exitProgram();
        else if(args[0].equals("reclist"))
            reclist(pwd);
        else if(args[0].equals("pwd"))
            path();
        else if(args[0].equals("cd"))
            cd();
        else if(args[0].equals("ls"))
            ls();
        else if(args[0].equals("length"))
            size();
        else if(args[0].equals("mkdir"))
            mkdir();
        else if(args[0].equals("wc"))
            wc();
    }

    private void wc() throws NotEnoughParamsException, IOException {
        if(args.length < 2) throw new NotEnoughParamsException();
        File f = new File(pwd.getAbsolutePath() + File.separator + args[1]);
        FileReader fileReader = new FileReader(f);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int line = 0, word = 0, letter = 0;
        String contents = "";
        while((contents = bufferedReader.readLine()) != null)
        {
            line++;
            for(String w : contents.split(" "))
            {
                word++;
                for(char l : w.toCharArray())
                    letter++;
            }
        }
        bufferedReader.close();
        fileReader.close();
        System.out.println("Lines: " + line + "\tWords: " + word + "\tLetters: " + letter);
    }

    private void mkdir() throws NotEnoughParamsException, IOException {
        if(args.length < 2) throw new NotEnoughParamsException();
        File f = new File(pwd.getAbsolutePath() + File.separator + args[1]);
        if(!f.mkdir()) throw new IOException();
    }

    private void size() throws NotEnoughParamsException, IOException {
        if(args.length < 2) throw new NotEnoughParamsException();
        File f;
        if(!(f = new File(args[1])).exists()) throw new IOException();
        System.out.println(f.length());
    }

    private void ls(){
        for(File f : pwd.listFiles())

        {
            if(args.length >= 2 && args[1].equals("-l"))
            {
                System.out.print((f.isDirectory() ? "d" : "f") + "\t" + f.length() + "\t");
            }
            System.out.println(f.getName());
        }
    }

    private void cd() throws NotEnoughParamsException {
        if(args.length < 2) throw new NotEnoughParamsException();
        pwd = new File(pwd.getAbsolutePath() + File.separator + args[1]);
    }

    private void path() throws IOException {
        System.out.println(pwd.getCanonicalPath());
    }

    private void reclist(File dir) {
        for(File f : dir.listFiles())
        {
            System.out.println(f.getName());
            if(f.isDirectory())
                reclist(f);
        }
    }

    private void exitProgram() {
        System.exit(0);
    }
}
