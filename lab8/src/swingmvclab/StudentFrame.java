package swingmvclab;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

/*
 * A megjelenítendõ ablakunk osztálya.
 */
public class StudentFrame extends JFrame {
    
    /*
     * Ebben az objektumban vannak a hallgatói adatok.
     * A program indulás után betölti az adatokat fájlból, bezáráskor pedig kimenti oda.
     * 
     * NE MÓDOSÍTSD!
     */
    private StudentData data;
    
    /*
     * Itt hozzuk létre és adjuk hozzá az ablakunkhoz a különbözõ komponenseket
     * (táblázat, beviteli mezõ, gomb).
     */
    private void initComponents() {
        this.setLayout(new BorderLayout());
        JTable table = new JTable();
        JScrollPane pane = new JScrollPane();
        pane.setViewportView(table);
        table.setFillsViewportHeight(true);
        table.setModel(data);
        table.setRowSorter(new TableRowSorter<>(data));
        table.setDefaultRenderer(String.class, new StudentTableCellRenderer(table.getDefaultRenderer(String.class)));
        table.setDefaultRenderer(Integer.class, new StudentTableCellRenderer(table.getDefaultRenderer(Integer.class)));
        table.setDefaultRenderer(Boolean.class, new StudentTableCellRenderer(table.getDefaultRenderer(Boolean.class)));
        add(pane);


        JPanel footer = new JPanel();
        JLabel nameLabel = new JLabel("Name: ");
        JTextField nameField = new JTextField();
        nameField.setColumns(20);
        JLabel neptunLabel = new JLabel("Neptun: ");
        JTextField neptunField = new JTextField();
        neptunField.setColumns(6);
        JButton button = new JButton("Aufnehmen");
        button.addActionListener(new AufnehmenListener(nameField, neptunField));
        footer.add(nameLabel);
        footer.add(nameField);
        footer.add(neptunLabel);
        footer.add(neptunField);
        footer.add(button);

        add(footer, BorderLayout.SOUTH);
    }

    /*
     * Az ablak konstruktora.
     * 
     * NE MÓDOSÍTSD!
     */
    @SuppressWarnings("unchecked")
    public StudentFrame() {
        super("Hallgatói nyilvántartás");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Induláskor betöltjük az adatokat
        try {
            data = new StudentData();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("out/production/lab8/students.dat"));
            data.students = (List<Student>)ois.readObject();
            ois.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        // Bezáráskor mentjük az adatokat
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("out/production/lab8/students.dat"));
                    oos.writeObject(data.students);
                    oos.close();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Felépítjük az ablakot
        setMinimumSize(new Dimension(500, 200));
        initComponents();
    }

    /*
     * A program belépési pontja.
     * 
     * NE MÓDOSÍTSD!
     */
    public static void main(String[] args) {
        // Megjelenítjük az ablakot
        StudentFrame sf = new StudentFrame();
        sf.setVisible(true);
    }

    private class AufnehmenListener implements ActionListener {
        private final JTextField name;
        private final JTextField neptun;
        public AufnehmenListener(JTextField nameField, JTextField neptunField) {
            name = nameField;
            neptun = neptunField;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            data.addStudent(name.getText(), neptun.getText());
            name.setText("");
            neptun.setText("");
            data.fireTableDataChanged();
        }
    }

    private class StudentTableCellRenderer implements TableCellRenderer {
        private TableCellRenderer renderer;

        public StudentTableCellRenderer(TableCellRenderer defRenderer) {
            this.renderer = defRenderer;
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if((Integer)data.getValueAt(row, 3) < 2)
                component.setBackground(Color.RED);
            else
                component.setBackground(Color.GREEN);
            return component;
        }
    }

}
