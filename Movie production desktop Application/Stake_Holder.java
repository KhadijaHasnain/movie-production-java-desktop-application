import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Stake_Holder {
    public static void main(String[] s) {
        JFrame f = new JFrame("Add StakeHolder");

        JLabel l1 = new JLabel("Company ID");
        l1.setBounds(10, 10, 100, 30);
        final JTextField tf1 = new JTextField();
        tf1.setBounds(130, 10, 100, 20);

        JLabel l2 = new JLabel("StakeHolder ID");
        l2.setBounds(240, 10, 100, 30);
        final JTextField tf2 = new JTextField();
        tf2.setBounds(350, 10, 100, 20);

        JLabel l3 = new JLabel("Place of Birth");
        l3.setBounds(460, 10, 100, 30);
        final JTextField tf3 = new JTextField();
        tf3.setBounds(570, 10, 100, 20);

        JLabel l4 = new JLabel("Mother Name");
        l4.setBounds(10, 50, 100, 30);
        final JTextField tf4 = new JTextField();
        tf4.setBounds(130, 50, 100, 20);

        JLabel l5 = new JLabel("Father Name");
        l5.setBounds(240, 50, 100, 30);
        final JTextField tf5 = new JTextField();
        tf5.setBounds(350, 50, 100, 20);

        JLabel l6 = new JLabel("Phone Number");
        l6.setBounds(460, 50, 100, 30);
        final JTextField tf6 = new JTextField();
        tf6.setBounds(570, 50, 100, 20);

        JLabel l7 = new JLabel("Insurance Number");
        l7.setBounds(10, 90, 100, 30);
        final JTextField tf7 = new JTextField();
        tf7.setBounds(130, 90, 100, 20);

        JLabel l8 = new JLabel("Passport Number");
        l8.setBounds(240, 90, 100, 30);
        final JTextField tf8 = new JTextField();
        tf8.setBounds(350, 90, 100, 20);

        JButton b1 = new JButton("Add Stakeholder");
        b1.setBounds(200, 200, 180, 30);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get data from text fields
                String companyID = tf1.getText();
                String stakeholderID = tf2.getText();
                String placeOfBirth = tf3.getText();
                String motherName = tf4.getText();
                String fatherName = tf5.getText();
                String phoneNumber = tf6.getText();
                String insuranceNumber = tf7.getText();
                String passportNumber = tf8.getText();

                // JDBC variables
                String url = "jdbc:mysql://localhost:3306/movieproduction";
                String user = "root";
                String password = "root";

                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    String query = "INSERT INTO stakeholder_table (company_id, stakeholder_id, place_of_birth, mother_name, father_name, phone_number, insurance_number, passport_number) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setString(1, companyID);
                        preparedStatement.setString(2, stakeholderID);
                        preparedStatement.setString(3, placeOfBirth);
                        preparedStatement.setString(4, motherName);
                        preparedStatement.setString(5, fatherName);
                        preparedStatement.setString(6, phoneNumber);
                        preparedStatement.setString(7, insuranceNumber);
                        preparedStatement.setString(8, passportNumber);

                        int rowsAffected = preparedStatement.executeUpdate();
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(f, "Stakeholder added successfully!");
                        } else {
                            JOptionPane.showMessageDialog(f, "Error adding stakeholder.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(f, "Error connecting to the database.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton b2 = new JButton("Back");
        b2.setBounds(400, 200, 180, 30);

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                Navigation.main(new String[0]);
            }
        });

        f.add(tf1);
        f.add(l1);
        f.add(l2);
        f.add(tf2);
        f.add(tf3);
        f.add(l3);
        f.add(tf4);
        f.add(l4);
        f.add(l5);
        f.add(tf5);
        f.add(tf6);
        f.add(l6);
        f.add(tf7);
        f.add(l7);
        f.add(l8);
        f.add(tf8);
        f.add(b1);
        f.add(b2);

        f.setSize(800, 600);
        f.getContentPane().setBackground(Color.white);
        f.setLayout(null);
        f.setVisible(true);
    }
}
