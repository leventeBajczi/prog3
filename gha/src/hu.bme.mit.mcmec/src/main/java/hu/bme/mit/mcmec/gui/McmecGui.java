package hu.bme.mit.mcmec.gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import hu.bme.mit.mcmec.Mcmec;
import hu.bme.mit.mcmec.c2xta.C2Xta;
import hu.bme.mit.mcmec.mitigationgenerator.MitigationGenerator;
import hu.bme.mit.mcmec.model2uppaal.Model2Uppaal;
import hu.bme.mit.mcmec.tricheckparser.dsl.TriCheckParser;
import hu.bme.mit.mcmec.verifier.Verifier;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The type Mcmec gui.
 */
public class McmecGui {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JButton browseButton;
    private JTextField textField1;
    private JList list1;
    private JButton newButton;
    private JButton viewButton;
    private JButton editButton;
    private JButton deleteButton;
    private JTextPane textPane1;
    private JButton generateButton;
    private JTextField textField3;
    private JButton browseButton3;
    private JTextPane textPane2;
    private JButton saveButton;
    private JTextPane textPane3;
    private JButton generateButton1;
    private JButton saveButton1;
    private JButton saveButton2;
    private JTextPane textPane4;
    private JTextPane textPane5;
    private JTextPane textPane6;
    private JTextField textField2;
    private JTextField textField4;
    private JButton browseButton1;
    private JButton browseButton2;
    private JButton generateButton2;
    private JButton saveButton5;
    private JButton saveButton4;
    private JButton saveButton3;
    private JTree tree1;
    private JButton saveButton6;
    private JButton saveButton7;
    private JTextPane textPane7;
    private JTextPane textPane8;
    private JTextField textField5;
    private JTextField textField6;
    private JButton browseButton4;
    private JButton browseButton5;
    private JButton generateButton3;
    private JLabel statusLabel;
    private JButton showMitigationButton;
    private JTextField textFieldAll1;
    private JTextField textFieldAll2;
    private JButton brosweAll1;
    private JButton brosweAll2;
    private JList litmuslist;
    private JTextPane textPaneAll2;
    private JButton saveButtonAll2;
    private JButton generateAll;
    private JTree treeAll;
    private JButton showMitigationButton2;
    private ListIssuesListener listIssuesListener;
    private boolean uppaal;
    private File uppaalHome;
    private String list;

    private final String UPPAL_END = "/bin-Linux/verifyta";


    /**
     * Sets ui.
     */
    public static void setupUI() {
        JFrame jFrame = new JFrame("MCMEC");
        McmecGui mcmecGui = new McmecGui();
        jFrame.setContentPane(mcmecGui.$$$getRootComponent$$$());
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(mcmecGui.panel1.getPreferredSize());
        jFrame.setLocationRelativeTo(null);
        mcmecGui.registerListeners();
        if (Mcmec.getUppaalHome() != null) mcmecGui.uppaalHome = new File(Mcmec.getUppaalHome());
        mcmecGui.checkUppaal();
        jFrame.setVisible(true);
    }

    private void checkUppaal() {
        if (uppaalHome != null) {
            if ((uppaalHome).exists()) {
                if (new File(uppaalHome.getAbsolutePath() + UPPAL_END).exists()) {
                    uppaal = true;
                    statusLabel.setText("OK");
                } else {
                    uppaal = false;
                    statusLabel.setText("Wrong directory. Click here to set.");
                }

            } else {
                uppaal = false;
                statusLabel.setText("Directory not found. Click here to set.");
            }
        }
        else
            statusLabel.setText("Directory not set. Click here to set.");
    }

    private void registerListeners() {
        saveButton.addActionListener(new SaveButtonListener(textPane1, null));
        saveButton1.addActionListener(new SaveButtonListener(textPane3, null));
        saveButton2.addActionListener(new SaveButtonListener(textPane2, textField3));
        saveButton3.addActionListener(new SaveButtonListener(textPane4, textField2));
        saveButton4.addActionListener(new SaveButtonListener(textPane5, textField4));
        saveButton5.addActionListener(new SaveButtonListener(textPane6, null));
        saveButton6.addActionListener(new SaveButtonListener(textPane7, textField5));
        saveButton7.addActionListener(new SaveButtonListener(textPane8, textField6));
        saveButtonAll2.addActionListener(new SaveButtonListener(textPaneAll2, textFieldAll2));

        browseButton.addActionListener(new BrowseButtonListener(textField1, true));
        browseButton1.addActionListener(new BrowseButtonListener(textField2));
        browseButton2.addActionListener(new BrowseButtonListener(textField4));
        browseButton3.addActionListener(new BrowseButtonListener(textField3));
        browseButton4.addActionListener(new BrowseButtonListener(textField5));
        browseButton5.addActionListener(new BrowseButtonListener(textField6));
        brosweAll1.addActionListener(new BrowseButtonListener(textFieldAll1, true));
        brosweAll2.addActionListener(new BrowseButtonListener(textFieldAll2));

        showMitigationButton.addActionListener(new ShowMitigationListener(textField5, true));
        showMitigationButton2.addActionListener(new ShowMitigationListener(textFieldAll2, false));

        listIssuesListener = new ListIssuesListener(textField1, list1);
        textField1.getDocument().addDocumentListener(listIssuesListener);
        textFieldAll1.getDocument().addDocumentListener(new ListIssuesListener(textFieldAll1, litmuslist));

        textField2.getDocument().addDocumentListener(new LoadTextListener(textField2, textPane4));
        textField3.getDocument().addDocumentListener(new LoadTextListener(textField3, textPane2));
        textField4.getDocument().addDocumentListener(new LoadTextListener(textField4, textPane5));
        textField5.getDocument().addDocumentListener(new LoadTextListener(textField5, textPane7));
        textField6.getDocument().addDocumentListener(new LoadTextListener(textField6, textPane8));
        textFieldAll2.getDocument().addDocumentListener(new LoadTextListener(textFieldAll2, textPaneAll2));

        newButton.addActionListener(new NewLitmusTestListener(textField1));
        viewButton.addActionListener(new ViewLitmusTestListener(textField1, list1));
        editButton.addActionListener(new EditLitmusTestListener(textField1, list1));
        deleteButton.addActionListener(new DeleteLitmusTestListener(textField1, list1));

        generateButton.addActionListener(new GenerateIssuesListener(textField1, textPane1));
        generateButton1.addActionListener(new GenerateXtaListener(textField3, textPane3));
        generateButton2.addActionListener(new GenerateQueryListener(textField2, textField4, textPane6));
        generateButton3.addActionListener(new VerifyListener(textField5, textField6, tree1));
        generateAll.addActionListener(new AllListener(textFieldAll1, textFieldAll2, treeAll));

        statusLabel.addMouseListener(new SetUppaalListener());
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setMinimumSize(new Dimension(920, 600));
        panel1.setPreferredSize(new Dimension(1000, 600));
        tabbedPane1 = new JTabbedPane();
        panel1.add(tabbedPane1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, new Dimension(720, 360), new Dimension(720, 360), null, 1, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1, true, false));
        tabbedPane1.addTab("All", panel2);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel2.add(panel3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Litmus test folder"));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel3.add(panel4, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        textFieldAll1 = new JTextField();
        panel4.add(textFieldAll1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        brosweAll1 = new JButton();
        brosweAll1.setText("Browse");
        panel4.add(brosweAll1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        panel3.add(scrollPane1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        litmuslist = new JList();
        scrollPane1.setViewportView(litmuslist);
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel2.add(panel5, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel5.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Result"));
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel5.add(panel6, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        generateAll = new JButton();
        generateAll.setText("Generate");
        panel6.add(generateAll, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel6.add(spacer1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        panel6.add(spacer2, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JScrollPane scrollPane2 = new JScrollPane();
        panel5.add(scrollPane2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        treeAll = new JTree();
        scrollPane2.setViewportView(treeAll);
        final JPanel panel7 = new JPanel();
        panel7.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel5.add(panel7, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        showMitigationButton2 = new JButton();
        showMitigationButton2.setEnabled(false);
        showMitigationButton2.setText("Show mitigation");
        panel7.add(showMitigationButton2, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        panel7.add(spacer3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        panel7.add(spacer4, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JPanel panel8 = new JPanel();
        panel8.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel2.add(panel8, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel8.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Source"));
        final JPanel panel9 = new JPanel();
        panel9.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel8.add(panel9, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        textFieldAll2 = new JTextField();
        textFieldAll2.setText("");
        panel9.add(textFieldAll2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        brosweAll2 = new JButton();
        brosweAll2.setText("Browse");
        panel9.add(brosweAll2, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel10 = new JPanel();
        panel10.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel8.add(panel10, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        saveButtonAll2 = new JButton();
        saveButtonAll2.setText("Save");
        panel10.add(saveButtonAll2, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        panel10.add(spacer5, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer6 = new Spacer();
        panel10.add(spacer6, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JScrollPane scrollPane3 = new JScrollPane();
        panel8.add(scrollPane3, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        textPaneAll2 = new JTextPane();
        scrollPane3.setViewportView(textPaneAll2);
        final JPanel panel11 = new JPanel();
        panel11.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1, true, false));
        tabbedPane1.addTab("Litmus->Issues", panel11);
        final JPanel panel12 = new JPanel();
        panel12.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel11.add(panel12, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel12.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Litmus tests"));
        browseButton = new JButton();
        browseButton.setText("Browse");
        panel12.add(browseButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField1 = new JTextField();
        textField1.setToolTipText("Litmus test folder...");
        panel12.add(textField1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel13 = new JPanel();
        panel13.setLayout(new GridLayoutManager(6, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel12.add(panel13, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final Spacer spacer7 = new Spacer();
        panel13.add(spacer7, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer8 = new Spacer();
        panel13.add(spacer8, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        newButton = new JButton();
        newButton.setText("New");
        panel13.add(newButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        viewButton = new JButton();
        viewButton.setText("View");
        panel13.add(viewButton, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        editButton = new JButton();
        editButton.setText("Edit");
        panel13.add(editButton, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        deleteButton = new JButton();
        deleteButton.setText("Delete");
        panel13.add(deleteButton, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane4 = new JScrollPane();
        panel12.add(scrollPane4, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        list1 = new JList();
        list1.setEnabled(true);
        list1.setSelectionMode(0);
        scrollPane4.setViewportView(list1);
        final JPanel panel14 = new JPanel();
        panel14.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel11.add(panel14, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel14.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Issues"));
        final JPanel panel15 = new JPanel();
        panel15.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel14.add(panel15, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        generateButton = new JButton();
        generateButton.setText("Generate");
        panel15.add(generateButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer9 = new Spacer();
        panel15.add(spacer9, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer10 = new Spacer();
        panel15.add(spacer10, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JPanel panel16 = new JPanel();
        panel16.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel14.add(panel16, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        saveButton = new JButton();
        saveButton.setText("Save");
        panel16.add(saveButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer11 = new Spacer();
        panel16.add(spacer11, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer12 = new Spacer();
        panel16.add(spacer12, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JScrollPane scrollPane5 = new JScrollPane();
        panel14.add(scrollPane5, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        textPane1 = new JTextPane();
        textPane1.setEnabled(true);
        textPane1.setText("");
        scrollPane5.setViewportView(textPane1);
        final JPanel panel17 = new JPanel();
        panel17.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1, true, false));
        tabbedPane1.addTab("C11->XTA", panel17);
        final JPanel panel18 = new JPanel();
        panel18.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel17.add(panel18, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel18.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "C11 Source Code"));
        final JPanel panel19 = new JPanel();
        panel19.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel18.add(panel19, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        textField3 = new JTextField();
        panel19.add(textField3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        browseButton3 = new JButton();
        browseButton3.setText("Browse");
        panel19.add(browseButton3, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel20 = new JPanel();
        panel20.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel18.add(panel20, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        saveButton2 = new JButton();
        saveButton2.setText("Save");
        panel20.add(saveButton2, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer13 = new Spacer();
        panel20.add(spacer13, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer14 = new Spacer();
        panel20.add(spacer14, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JScrollPane scrollPane6 = new JScrollPane();
        panel18.add(scrollPane6, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        textPane2 = new JTextPane();
        textPane2.setEditable(true);
        textPane2.setEnabled(true);
        scrollPane6.setViewportView(textPane2);
        final JPanel panel21 = new JPanel();
        panel21.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel17.add(panel21, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel21.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "XTA Model"));
        final JPanel panel22 = new JPanel();
        panel22.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel21.add(panel22, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        saveButton1 = new JButton();
        saveButton1.setText("Save");
        panel22.add(saveButton1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer15 = new Spacer();
        panel22.add(spacer15, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer16 = new Spacer();
        panel22.add(spacer16, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JPanel panel23 = new JPanel();
        panel23.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel21.add(panel23, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final Spacer spacer17 = new Spacer();
        panel23.add(spacer17, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer18 = new Spacer();
        panel23.add(spacer18, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        generateButton1 = new JButton();
        generateButton1.setText("Generate");
        panel23.add(generateButton1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane7 = new JScrollPane();
        panel21.add(scrollPane7, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        textPane3 = new JTextPane();
        scrollPane7.setViewportView(textPane3);
        final JPanel panel24 = new JPanel();
        panel24.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1, true, false));
        tabbedPane1.addTab("Query", panel24);
        final JPanel panel25 = new JPanel();
        panel25.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel24.add(panel25, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel25.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Issues"));
        final JPanel panel26 = new JPanel();
        panel26.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel25.add(panel26, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        textField2 = new JTextField();
        panel26.add(textField2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        browseButton1 = new JButton();
        browseButton1.setText("Browse");
        panel26.add(browseButton1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel27 = new JPanel();
        panel27.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel25.add(panel27, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        saveButton3 = new JButton();
        saveButton3.setText("Save");
        panel27.add(saveButton3, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer19 = new Spacer();
        panel27.add(spacer19, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer20 = new Spacer();
        panel27.add(spacer20, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JScrollPane scrollPane8 = new JScrollPane();
        panel25.add(scrollPane8, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        textPane4 = new JTextPane();
        scrollPane8.setViewportView(textPane4);
        final JPanel panel28 = new JPanel();
        panel28.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel24.add(panel28, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel28.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Query"));
        final JPanel panel29 = new JPanel();
        panel29.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel28.add(panel29, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        generateButton2 = new JButton();
        generateButton2.setText("Generate");
        panel29.add(generateButton2, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer21 = new Spacer();
        panel29.add(spacer21, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer22 = new Spacer();
        panel29.add(spacer22, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JPanel panel30 = new JPanel();
        panel30.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel28.add(panel30, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        saveButton5 = new JButton();
        saveButton5.setText("Save");
        panel30.add(saveButton5, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer23 = new Spacer();
        panel30.add(spacer23, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer24 = new Spacer();
        panel30.add(spacer24, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JScrollPane scrollPane9 = new JScrollPane();
        panel28.add(scrollPane9, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        textPane6 = new JTextPane();
        scrollPane9.setViewportView(textPane6);
        final JPanel panel31 = new JPanel();
        panel31.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel24.add(panel31, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel31.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "XTA Model"));
        final JPanel panel32 = new JPanel();
        panel32.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel31.add(panel32, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        textField4 = new JTextField();
        panel32.add(textField4, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        browseButton2 = new JButton();
        browseButton2.setText("Browse");
        panel32.add(browseButton2, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel33 = new JPanel();
        panel33.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel31.add(panel33, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        saveButton4 = new JButton();
        saveButton4.setText("Save");
        panel33.add(saveButton4, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer25 = new Spacer();
        panel33.add(spacer25, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer26 = new Spacer();
        panel33.add(spacer26, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JScrollPane scrollPane10 = new JScrollPane();
        panel31.add(scrollPane10, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        textPane5 = new JTextPane();
        scrollPane10.setViewportView(textPane5);
        final JPanel panel34 = new JPanel();
        panel34.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1, true, false));
        tabbedPane1.addTab("Verify", panel34);
        final JPanel panel35 = new JPanel();
        panel35.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel34.add(panel35, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel35.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "XTA Model"));
        final JPanel panel36 = new JPanel();
        panel36.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel35.add(panel36, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        textField5 = new JTextField();
        panel36.add(textField5, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        browseButton4 = new JButton();
        browseButton4.setText("Browse");
        panel36.add(browseButton4, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel37 = new JPanel();
        panel37.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel35.add(panel37, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        saveButton6 = new JButton();
        saveButton6.setText("Save");
        panel37.add(saveButton6, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer27 = new Spacer();
        panel37.add(spacer27, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer28 = new Spacer();
        panel37.add(spacer28, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JScrollPane scrollPane11 = new JScrollPane();
        panel35.add(scrollPane11, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        textPane7 = new JTextPane();
        scrollPane11.setViewportView(textPane7);
        final JPanel panel38 = new JPanel();
        panel38.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel34.add(panel38, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel38.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Result"));
        final JPanel panel39 = new JPanel();
        panel39.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel38.add(panel39, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        generateButton3 = new JButton();
        generateButton3.setText("Generate");
        panel39.add(generateButton3, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer29 = new Spacer();
        panel39.add(spacer29, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer30 = new Spacer();
        panel39.add(spacer30, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JScrollPane scrollPane12 = new JScrollPane();
        panel38.add(scrollPane12, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tree1 = new JTree();
        scrollPane12.setViewportView(tree1);
        final JPanel panel40 = new JPanel();
        panel40.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel38.add(panel40, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        showMitigationButton = new JButton();
        showMitigationButton.setEnabled(false);
        showMitigationButton.setText("Show mitigation");
        panel40.add(showMitigationButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer31 = new Spacer();
        panel40.add(spacer31, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer32 = new Spacer();
        panel40.add(spacer32, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JPanel panel41 = new JPanel();
        panel41.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel34.add(panel41, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel41.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Query"));
        final JPanel panel42 = new JPanel();
        panel42.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel41.add(panel42, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        textField6 = new JTextField();
        textField6.setText("");
        panel42.add(textField6, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        browseButton5 = new JButton();
        browseButton5.setText("Browse");
        panel42.add(browseButton5, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel43 = new JPanel();
        panel43.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel41.add(panel43, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        saveButton7 = new JButton();
        saveButton7.setText("Save");
        panel43.add(saveButton7, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer33 = new Spacer();
        panel43.add(spacer33, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer34 = new Spacer();
        panel43.add(spacer34, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JScrollPane scrollPane13 = new JScrollPane();
        panel41.add(scrollPane13, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        textPane8 = new JTextPane();
        scrollPane13.setViewportView(textPane8);
        final JToolBar toolBar1 = new JToolBar();
        toolBar1.setBorderPainted(false);
        toolBar1.setEnabled(false);
        toolBar1.setFloatable(false);
        panel1.add(toolBar1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(-1, 20), null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Uppaal status: ");
        toolBar1.add(label1);
        statusLabel = new JLabel();
        statusLabel.setText("STATUS");
        toolBar1.add(statusLabel);
    }

    /**
     * $$$ get root component $$$ j component.
     *
     * @return the j component
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

    private class SaveButtonListener implements ActionListener {
        private final JTextPane textPane;
        private JTextField textField;

        /**
         * Instantiates a new Save button listener.
         *
         * @param textPane  the text pane
         * @param textField the text field
         */
        public SaveButtonListener(JTextPane textPane, JTextField textField) {
            this.textPane = textPane;
            this.textField = textField;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (textField == null) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File(System.getenv("PWD")));
                int returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    write(chooser.getSelectedFile().getAbsolutePath());
                }
            } else
                write(textField.getText());
        }

        private void write(String fileName) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName)));
                bufferedWriter.write(this.textPane.getText());
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private class BrowseButtonListener implements ActionListener {
        private final JTextField textField;
        private final boolean onlyDir;

        /**
         * Instantiates a new Browse button listener.
         *
         * @param textField the text field
         * @param onlyDir   the only dir
         */
        public BrowseButtonListener(JTextField textField, boolean onlyDir) {
            this.textField = textField;
            this.onlyDir = onlyDir;
        }

        /**
         * Instantiates a new Browse button listener.
         *
         * @param textField the text field
         */
        public BrowseButtonListener(JTextField textField) {
            this(textField, false);
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File(System.getenv("PWD")));

            if (onlyDir) {
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);
            }
            int returnVal = chooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                textField.setText(chooser.getSelectedFile().getAbsolutePath());
            }
        }
    }

    private class ListIssuesListener implements DocumentListener {
        private final DefaultListModel listModel;
        private final JTextField folderTextField;

        /**
         * Instantiates a new List issues listener.
         *
         * @param folderTextField the folder text field
         * @param list            the list
         */
        public ListIssuesListener(JTextField folderTextField, JList list) {
            this.folderTextField = folderTextField;
            listModel = new DefaultListModel();
            list.setModel(listModel);
        }

        /**
         * List files.
         */
        public void listFiles() {
            java.util.List<String> fileList = new ArrayList<>();
            File file = new File(folderTextField.getText());
            if (file.exists() && file.isDirectory()) {
                listModel.removeAllElements();
                for (File f : file.listFiles()) {
                    if (!f.isDirectory())
                        fileList.add(f.getName());
                }
                Collections.sort(fileList);
                for (String s : fileList)
                    listModel.addElement(s);

            }
        }

        @Override
        public void insertUpdate(DocumentEvent documentEvent) {
            listFiles();
        }

        @Override
        public void removeUpdate(DocumentEvent documentEvent) {
            listFiles();
        }

        @Override
        public void changedUpdate(DocumentEvent documentEvent) {

        }
    }

    private class LoadTextListener implements DocumentListener {
        private final JTextField textField;
        private final JTextPane textPane;

        /**
         * Instantiates a new Load text listener.
         *
         * @param textField the text field
         * @param textPane  the text pane
         */
        public LoadTextListener(JTextField textField, JTextPane textPane) {
            this.textField = textField;
            this.textPane = textPane;
        }

        private void load() {
            File file = new File(textField.getText());
            if (file.exists() && !file.isDirectory()) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    String line;
                    textPane.setText("");
                    while ((line = bufferedReader.readLine()) != null) {
                        textPane.setText(textPane.getText().concat(line + "\n"));
                    }
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void insertUpdate(DocumentEvent documentEvent) {
            load();
        }

        @Override
        public void removeUpdate(DocumentEvent documentEvent) {
            load();
        }

        @Override
        public void changedUpdate(DocumentEvent documentEvent) {

        }
    }

    private void openEditor(String path, boolean editable) {
        File file = new File(path);
        JFrame editorFrame = new JFrame(file.getName());
        editorFrame.setSize(480, 480);
        editorFrame.setLocationRelativeTo(null);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JPanel footer = new JPanel();

        JScrollPane scrollPane = new JScrollPane();
        JTextPane textPane = new JTextPane();
        if (!editable) textPane.setEditable(false);

        if (file.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = bufferedReader.readLine()) != null)
                    textPane.setText(textPane.getText() + line + "\n");
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        scrollPane.setViewportView(textPane);

        textPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), file.getName()));
        JButton saveButton = new JButton("Save");
        JTextField textField = new JTextField(path);
        saveButton.addActionListener(new SaveButtonListener(textPane, textField));

        footer.add(saveButton);

        mainPanel.add(footer, BorderLayout.SOUTH);
        mainPanel.add(textField, BorderLayout.NORTH);
        mainPanel.add(scrollPane);
        editorFrame.add(mainPanel);

        editorFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                listIssuesListener.listFiles();
            }
        });
        editorFrame.setVisible(true);


    }


    private class NewLitmusTestListener implements ActionListener {
        private final JTextField textField;

        /**
         * Instantiates a new New litmus test listener.
         *
         * @param textField the text field
         */
        public NewLitmusTestListener(JTextField textField) {
            this.textField = textField;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String filename = JOptionPane.showInputDialog(null, "Enter file name");
            openEditor(textField.getText() + File.separator + filename, true);
        }
    }


    private class ViewLitmusTestListener implements ActionListener {
        private final JTextField textField;
        private final JList selectedValue;

        /**
         * Instantiates a new View litmus test listener.
         *
         * @param textField1    the text field 1
         * @param selectedValue the selected value
         */
        public ViewLitmusTestListener(JTextField textField1, JList selectedValue) {
            textField = textField1;
            this.selectedValue = selectedValue;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            openEditor(textField.getText() + File.separator + selectedValue.getSelectedValue(), false);

        }
    }

    private class EditLitmusTestListener implements ActionListener {
        private final JTextField textField;
        private final JList selectedValue;

        /**
         * Instantiates a new Edit litmus test listener.
         *
         * @param textField1    the text field 1
         * @param selectedValue the selected value
         */
        public EditLitmusTestListener(JTextField textField1, JList selectedValue) {
            textField = textField1;
            this.selectedValue = selectedValue;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            openEditor(textField.getText() + File.separator + selectedValue.getSelectedValue(), true);

        }
    }

    private class DeleteLitmusTestListener implements ActionListener {
        private final JTextField textField;
        private final JList selectedValue;

        /**
         * Instantiates a new Delete litmus test listener.
         *
         * @param textField1    the text field 1
         * @param selectedValue the selected value
         */
        public DeleteLitmusTestListener(JTextField textField1, JList selectedValue) {
            textField = textField1;
            this.selectedValue = selectedValue;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            File file = new File(textField.getText() + File.separator + selectedValue.getSelectedValue());
            if (file.exists())
                file.delete();
            listIssuesListener.listFiles();

        }
    }

    private class GenerateIssuesListener implements ActionListener {
        private final JTextField textField;
        private final JTextPane textPane;

        /**
         * Instantiates a new Generate issues listener.
         *
         * @param textField1 the text field 1
         * @param textPane1  the text pane 1
         */
        public GenerateIssuesListener(JTextField textField1, JTextPane textPane1) {
            textField = textField1;
            textPane = textPane1;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            File file = new File(".issues");
            while (file.exists()) {
                file = new File(file.getAbsolutePath() + "$");
            }
            file.deleteOnExit();
            TriCheckParser.parseLitmusIntoQuery(textField.getText(), file.getAbsolutePath());
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = bufferedReader.readLine()) != null)
                    textPane.setText(textPane.getText() + line + "\n");
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private class GenerateXtaListener implements ActionListener {
        private final JTextField textField;
        private final JTextPane textPane;

        /**
         * Instantiates a new Generate xta listener.
         *
         * @param textField3 the text field 3
         * @param textPane3  the text pane 3
         */
        public GenerateXtaListener(JTextField textField3, JTextPane textPane3) {
            textField = textField3;
            textPane = textPane3;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            File file = new File(".xta");
            while (file.exists()) {
                file = new File(file.getAbsolutePath() + "$");
            }
            file.deleteOnExit();
            C2Xta.transform(textField.getText(), file.getAbsolutePath());
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = bufferedReader.readLine()) != null)
                    textPane.setText(textPane.getText() + line + "\n");
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private class GenerateQueryListener implements ActionListener {
        private final JTextField textField1;
        private final JTextField textField2;
        private final JTextPane textPane;

        /**
         * Instantiates a new Generate query listener.
         *
         * @param textField1 the text field 1
         * @param textField2 the text field 2
         * @param textPane3  the text pane 3
         */
        public GenerateQueryListener(JTextField textField1, JTextField textField2, JTextPane textPane3) {
            this.textField1 = textField1;
            this.textField2 = textField2;
            textPane = textPane3;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            File file = new File(".query");
            while (file.exists()) {
                file = new File(file.getAbsolutePath() + "$");
            }
            file.deleteOnExit();
            Model2Uppaal.transform(textField2.getText(), textField1.getText(), file.getAbsolutePath());
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = bufferedReader.readLine()) != null)
                    textPane.setText(textPane.getText() + line + "\n");
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private class VerifyListener implements ActionListener {
        private final JTextField textField1;
        private final JTextField textField2;
        private final DefaultTreeModel model;

        /**
         * Instantiates a new Verify listener.
         *
         * @param textField5 the text field 5
         * @param textField6 the text field 6
         * @param tree1      the tree 1
         */
        public VerifyListener(JTextField textField5, JTextField textField6, JTree tree1) {
            textField1 = textField5;
            textField2 = textField6;
            model = new DefaultTreeModel(new DefaultMutableTreeNode("issues"));
            tree1.setModel(model);
            tree1.setRootVisible(false);
            tree1.setShowsRootHandles(true);
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (uppaal) {
                list = Verifier.verify(uppaalHome.getAbsolutePath(), textField1.getText(), textField2.getText());
                if (list.length() == 0) return;
                JSONObject jsonObject = new JSONObject(list);
                JSONArray jsonArray = jsonObject.getJSONArray("issues");
                DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode) model.getRoot();
                rootNode.removeAllChildren();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject issueObject = jsonArray.getJSONObject(i);
                    DefaultMutableTreeNode issueNode = new DefaultMutableTreeNode(issueObject.getString("name"));
                    rootNode.add(issueNode);
                    JSONArray issueArray = issueObject.getJSONArray("values");
                    for (int j = 0; j < issueArray.length(); j++) {
                        issueNode.add(new DefaultMutableTreeNode("line #" + issueArray.getInt(j)));
                    }
                }
                model.reload();
                showMitigationButton.setEnabled(true);
                showMitigationButton2.setEnabled(false);
            } else
                JOptionPane.showMessageDialog(null, "Please set a valid UPPAAL directory!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private class SetUppaalListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            if (mouseEvent.getComponent() == statusLabel) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File(System.getenv("PWD")));

                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);
                int returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    uppaalHome = chooser.getSelectedFile();
                }
                checkUppaal();
            }
        }
    }

    private class ShowMitigationListener implements ActionListener {
        private final JTextField textField;
        private final boolean xta;

        /**
         * Instantiates a new Show mitigation listener.
         *
         * @param textField the text field
         * @param xta       the xta
         */
        public ShowMitigationListener(JTextField textField, boolean xta) {
            this.textField = textField;
            this.xta = xta;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (uppaal) {
                if (list.length() != 0) {
                    if (xta)
                        mitigateGivenXTA();
                    else
                        mitigateGivenC();
                } else
                    JOptionPane.showMessageDialog(null, "Nothing to mitigate!", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else
                JOptionPane.showMessageDialog(null, "Please set a valid UPPAAL directory!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        private void mitigateGivenC() {
            File query = new File(".query");
            while (query.exists())
                query = new File(query.getAbsolutePath() + "$");
            query.deleteOnExit();

            MitigationGenerator.generateMitigation(uppaalHome.getAbsolutePath(), Mcmec.getXtaFileName(), list, textField.getText(), query.getAbsolutePath());
            openEditor(textField.getText(), true);
        }

        private void mitigateGivenXTA() {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File(System.getenv("PWD")));

            int returnVal = chooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File query = new File(".query");
                while (query.exists())
                    query = new File(query.getAbsolutePath() + "$");
                query.deleteOnExit();

                MitigationGenerator.generateMitigation(uppaalHome.getAbsolutePath(), textField.getText(), list, chooser.getSelectedFile().getAbsolutePath(), query.getAbsolutePath());
                openEditor(chooser.getSelectedFile().getAbsolutePath(), true);
            }
        }
    }


    private class AllListener implements ActionListener {
        private final JTextField textField1;
        private final JTextField textField2;
        private final DefaultTreeModel model;

        /**
         * Instantiates a new All listener.
         *
         * @param textField5 the text field 5
         * @param textField6 the text field 6
         * @param tree1      the tree 1
         */
        public AllListener(JTextField textField5, JTextField textField6, JTree tree1) {
            textField1 = textField5;
            textField2 = textField6;
            model = new DefaultTreeModel(new DefaultMutableTreeNode("issues"));
            tree1.setModel(model);
            tree1.setRootVisible(false);
            tree1.setShowsRootHandles(true);
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (uppaal) {
                TriCheckParser.parseLitmusIntoQuery(textField1.getText(), Mcmec.getIssuesFileName());
                C2Xta.transform(textField2.getText(), Mcmec.getXtaFileName());
                Model2Uppaal.transform(Mcmec.getXtaFileName(), Mcmec.getIssuesFileName(), Mcmec.getQueryFileName());
                list = Verifier.verify(uppaalHome.getAbsolutePath(), Mcmec.getXtaFileName(), Mcmec.getQueryFileName());
                if (list.length() == 0) return;
                JSONObject jsonObject = new JSONObject(list);
                JSONArray jsonArray = jsonObject.getJSONArray("issues");
                DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode) model.getRoot();
                rootNode.removeAllChildren();

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject issueObject = jsonArray.getJSONObject(i);
                    DefaultMutableTreeNode issueNode = new DefaultMutableTreeNode(issueObject.getString("name"));
                    rootNode.add(issueNode);
                    JSONArray issueArray = issueObject.getJSONArray("values");
                    for (int j = 0; j < issueArray.length(); j++) {
                        issueNode.add(new DefaultMutableTreeNode("line #" + issueArray.getInt(j)));
                    }
                }
                model.reload();
                showMitigationButton.setEnabled(false);
                showMitigationButton2.setEnabled(true);
            } else
                JOptionPane.showMessageDialog(null, "Please set a valid UPPAAL directory!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
