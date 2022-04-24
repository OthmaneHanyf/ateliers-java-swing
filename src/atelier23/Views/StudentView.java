package atelier23.Views;

import atelier23.Data.DbContext;
import atelier23.Models.StudentModel;
import atelier23.Repositories.StudentRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentView extends JFrame implements IStudentView {

    private StudentRepository _studentRepository;
    private JTable studentListTable = new JTable();
    private JTextField idField = new JTextField("", 15);
    private JTextField firstNameField = new JTextField("", 15);
    private JTextField birthdayField = new JTextField("", 15);
    private JTextField lastNameField = new JTextField("", 15);
    private JRadioButton genderField = new JRadioButton("");
    private JTextField fieldField = new JTextField("", 15);
    public StudentView(String title, DbContext db) throws HeadlessException {
        super(title);
        _studentRepository = new StudentRepository(db);

        Panel panel = new Panel();
        panel.setLayout(new BorderLayout());

        // North Area
        JMenuBar menuBar = new JMenuBar();
        JMenu optionsMenu = new JMenu("Options");
        JMenu helpMenu = new JMenu("Help");
        JMenuItem optionItem1 = new JMenuItem("Option1");
        JMenuItem optionItem2 = new JMenuItem("Option2");

        optionsMenu.add(optionItem1);
        optionsMenu.add(optionItem2);
        menuBar.add(optionsMenu);
        menuBar.add(helpMenu);
        panel.add(menuBar, BorderLayout.NORTH);

        // Center Area
        Panel cPanel = new Panel();
        cPanel.setLayout(new FlowLayout());

        // Left center Panel
        Panel cPanelLeft = new Panel();
        cPanelLeft.setLayout(new GridLayout(6, 2));

        cPanelLeft.add(new JLabel("ID"));
        JTextField idField = this.idField;
        cPanelLeft.add(idField);

        cPanelLeft.add(new JLabel("First Name"));
        JTextField firstNameField = this.firstNameField;
        cPanelLeft.add(firstNameField);

        cPanelLeft.add(new JLabel("Last Name"));
        JTextField lastNameField = this.lastNameField;
        cPanelLeft.add(lastNameField);

        cPanelLeft.add(new JLabel("Birthday"));
        JTextField birthdayField = this.birthdayField;
        cPanelLeft.add(birthdayField);

        cPanelLeft.add(new JLabel("Gender"));
        JRadioButton genderField = this.genderField;
        genderField.setLayout(new GridLayout(1, 2));
        JRadioButtonMenuItem maleOption = new JRadioButtonMenuItem("Male", true);
        genderField.add(maleOption);
        JRadioButtonMenuItem femaleOption = new JRadioButtonMenuItem("Female", false);
        genderField.add(femaleOption);

        cPanelLeft.add(genderField);

        cPanelLeft.add(new JLabel("Field"));
        JTextField fieldField = this.fieldField;
        cPanelLeft.add(fieldField);

        cPanel.add(cPanelLeft);

        // Right center Panel

        Panel cPanelRight = new Panel();
        cPanelRight.setLayout(new GridLayout(1, 5));

        JScrollPane jScrollPane = new JScrollPane();

        JTable studentTable = studentListTable;
//        studentTable.setBackground(new java.awt.Color(255, 255, 255));
//        studentTable.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
//        studentTable.setForeground(new java.awt.Color(0, 0, 0));
        studentTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "ID", "First Name", "Last Name", "Birthday", "Field", "Gender"
                }
        ));

        DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
        model.setRowCount(0);

        for (StudentModel student : _studentRepository.getAll()) {
            Object[] row = new Object[6];

            row[0] = student.getId();
            row[1] = student.getFirstname();
            row[2] = student.getLastname();
            row[3] = student.getBirthday();
            row[4] = student.getField();
            row[5] = student.getGender();

            model.addRow(row);
        }
//        studentTable.setGridColor(new java.awt.Color(255, 255, 255));
//        studentTable.setSelectionBackground(new java.awt.Color(33, 120, 219));
//        studentTable.setSelectionForeground(new java.awt.Color(255, 255, 255));

        jScrollPane.setViewportView(studentTable);

        cPanelRight.add(jScrollPane);

        cPanel.add(cPanelRight);

        panel.add(cPanel, BorderLayout.CENTER);

        // South Area
        Panel southPanel = new Panel();
        southPanel.setLayout(new FlowLayout());

        Button createBtn = new Button("Create");
        createBtn.addActionListener(this.createStudentHandler());
        southPanel.add(createBtn);
        Button clearBtn = new Button("Empty");
        clearBtn.addActionListener(this.clearStudentsHandler());
        southPanel.add(clearBtn);
        Button quitBtn = new Button("Quit");
        quitBtn.addActionListener(this.quitHandler());
        southPanel.add(quitBtn);

        panel.add(southPanel, BorderLayout.SOUTH);

        this.getContentPane().add(panel);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void refresh() {
        DefaultTableModel model = (DefaultTableModel) studentListTable.getModel();
        model.setRowCount(0);

        for (StudentModel student : _studentRepository.getAll()) {
            Object[] row = new Object[6];

            row[0] = student.getId();
            row[1] = student.getFirstname();
            row[2] = student.getLastname();
            row[3] = student.getBirthday();
            row[4] = student.getField();
            row[5] = student.getGender();

            model.addRow(row);
        }
    }
    public void show(int w, int h) {
        this.setVisible(true);
        this.setSize(w, h);
    }

    public static void main(String[] args) {
        StudentView studentView = new StudentView("Students Management System", new DbContext());
        studentView.show(900, 600);
    }

    @Override
    public ActionListener createStudentHandler() {
        System.out.println(genderField.getSelectedObjects());
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _studentRepository.create(new StudentModel(0, firstNameField.getText(), lastNameField.getText(),birthdayField.getText(), fieldField.getText(), ""));
                refresh();
            }
        };
    }

    @Override
    public ActionListener clearStudentsHandler() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _studentRepository.clear();
                refresh();
            }
        };
    }

    @Override
    public ActionListener quitHandler() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        };
    }
}
