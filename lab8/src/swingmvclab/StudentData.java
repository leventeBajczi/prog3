package swingmvclab;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/*
 * A hallgat?k adatait t?rol? oszt?ly.
 */
public class StudentData extends AbstractTableModel {

    /*
     * Ez a tagv?ltoz? t?rolja a hallgat?i adatokat.
     * NE M?DOS?TSD!
     */
    List<Student> students = new ArrayList<Student>();

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return i1 == 2 || i1 == 3;
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        Student student = students.get(i);
        switch(i1)
        {
            case 2:
                student.setSignature((Boolean)o);
                break;
            case 3:
                student.setGrade((Integer)o);
                break;
        }

    }
    public void addStudent(String name, String neptun) {
        students.add(new Student(name, neptun, false, 0));
    }

    @Override
    public String getColumnName(int i) {
        switch(i)
        {
            case 0:
                return "Name";
            case 1:
                return "Neptun";
            case 2:
                return "Unterschrift";
            case 3:
                return "Note";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int i) {
        switch(i)
        {
            case 0:
            case 1:
                return String.class;
            case 2:
                return Boolean.class;
            case 3:
                return Integer.class;
        }
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return student.getName();
            case 1:
                return student.getNeptun();
            case 2:
                return student.hasSignature();
            default:
                return student.getGrade();
        }
    }
}