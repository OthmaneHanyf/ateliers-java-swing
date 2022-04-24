package atelier1;

import javax.swing.*;
import javax.swing.text.IconView;
import javax.swing.text.html.parser.Element;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Initialize the frame
        JFrame frame = new JFrame("The principale window");
        frame.getContentPane().setLayout(new FlowLayout());

        // Add elements to the frame
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());

        panel1.add(new JLabel("Name"));
        JTextField nameField = new JTextField("Enter your name", 15);
        panel1.add(nameField);

        panel1.add(new JLabel("Password"));
        JTextField pwdField = new JTextField("Enter your password", 15);
        panel1.add(pwdField);

        panel1.setBorder(BorderFactory.createTitledBorder("User Authentication"));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());

        JButton okBtn = new JButton("Ok");
        panel2.add(okBtn);
        JButton quitBtn = new JButton("Quitter");
        panel2.add(quitBtn);

        // Add element to the frame content panel
        frame.getContentPane().add(panel1);
        frame.getContentPane().add(panel2);

        // Event Handlers
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(nameField.getText());
                System.out.println(pwdField.getText());
            }
        });

        quitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        // Handle Close and Display result with a size
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(600, 400);
    }
}
