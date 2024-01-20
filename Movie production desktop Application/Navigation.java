import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Navigation {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Navigation Frame");

        JButton b1 = new JButton("Add Employee");
        b1.setBounds(50, 50, 200, 30); // Set the bounds for the button

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                // Open the Add_Employee class here
                Add_Employee.main(new String[0]);
            }
        });

        frame.add(b1);

        JButton b2 = new JButton("Grant_Details");
        b2.setBounds(50, 100, 200, 30); // Set the bounds for the button

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Grant_Detail.main(new String[0]);
            }
        });

        JButton b3 = new JButton("Add Crew");
        b3.setBounds(50, 150, 200, 30); // Set the bounds for the button

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Production_Company.main(new String[0]);
            }
        });

        JButton b4 = new JButton("Add Film");
        b4.setBounds(50, 200, 200, 30); // Set the bounds for the button

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Add_Crew.main(new String[0]);
            }
        });

        JButton b5 = new JButton("Add Staff");
        b5.setBounds(300, 50, 200, 30); // Set the bounds for the button

        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Add_Film.main(new String[0]);
            }
        });

        JButton b6 = new JButton("Production Company");
        b6.setBounds(300, 100, 200, 30); // Set the bounds for the button

        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Add_Staff.main(new String[0]);
            }
        });

        JButton b7 = new JButton("Stake holder");
        b7.setBounds(300, 150, 200, 30); // Set the bounds for the button

        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Stake_Holder.main(new String[0]);
            }
        });

        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);
        frame.add(b7);

        frame.setSize(800, 600);
        frame.getContentPane().setBackground(Color.white);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
