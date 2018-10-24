package aufgabe2;

import aufgabe1.Caesar;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

public class CaesarFrame extends JFrame {

    private BorderLayout borderLayout;
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JComboBox<Character> jComboBox;
    private JTextField jTextField;
    private JButton jButton;
    private JLabel jLabel;
    private JTextField outputTextField;

    public CaesarFrame()
    {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("SwingLab");
        this.setSize(400, 110);
        this.setResizable(false);

        borderLayout = new BorderLayout();
        mainPanel = new JPanel();
        mainPanel.setLayout(borderLayout);

        topPanel = new JPanel();
        bottomPanel = new JPanel();
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        Character[] ABC = generateABC();
        jComboBox = new JComboBox<>(ABC);
        jTextField = new JTextField();
        jTextField.setColumns(20);
        jTextField.getDocument().addDocumentListener(new InputFieldDocumentListener());
        //jTextField.addKeyListener(new InputFieldKeyListener());
        jButton = new JButton("Code!");
        jButton.addActionListener(new OkButtonListener());
        topPanel.add(jComboBox);
        topPanel.add(jTextField);
        topPanel.add(jButton);

        jLabel = new JLabel("Output:");
        outputTextField = new JTextField();
        outputTextField.setColumns(20);
        outputTextField.getDocument().addDocumentListener(new DecodeFieldDocumentListener());
        bottomPanel.add(jLabel);
        bottomPanel.add(outputTextField);

        this.setContentPane(mainPanel);
    }

    private Character[] generateABC() {

        Character[] ret = new Character[26];
        for(int i = 0; i < 26; i++)
            ret[i] =(char)( 'A' + i);
        return ret;
    }


    private void setOutput()
    {
        outputTextField.setText(Caesar.caesarCode(jTextField.getText(), (Character) jComboBox.getSelectedItem()));
    }

    private class OkButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            setOutput();
        }
    }

    private class InputFieldKeyListener extends KeyAdapter {



        @Override
        public void keyPressed(KeyEvent keyEvent) {
            setOutput();
        }


    }
    private class InputFieldDocumentListener implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent documentEvent) {
            if(jTextField.hasFocus())
                SwingUtilities.invokeLater(new MyRunnable());
        }

        @Override
        public void removeUpdate(DocumentEvent documentEvent) {
            if(jTextField.hasFocus())
                SwingUtilities.invokeLater(new MyRunnable());

        }

        @Override
        public void changedUpdate(DocumentEvent documentEvent) {
        }
    }
    private class DecodeFieldDocumentListener implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent documentEvent) {
            if(outputTextField.hasFocus())
            SwingUtilities.invokeLater(new MyRunnable());
        }

        @Override
        public void removeUpdate(DocumentEvent documentEvent) {
            if(outputTextField.hasFocus())
                SwingUtilities.invokeLater(new MyRunnable());

        }

        @Override
        public void changedUpdate(DocumentEvent documentEvent) {
        }
    }


    private void setEncoded() {
        Character c = (Character) jComboBox.getSelectedItem();

        jTextField.setText(Caesar.caesarDecode(outputTextField.getText(), c));
    }

    private class MyRunnable implements Runnable
    {

        @Override
        public void run() {
            if(jTextField.isFocusOwner()) setOutput();
            else setEncoded();
        }
    }
}
