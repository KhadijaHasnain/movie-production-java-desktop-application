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

public class Add_Film {
    public static void main(String[] s) {
        JFrame f = new JFrame("Add Film");

        JLabel l1 = new JLabel("Company ID");
        l1.setBounds(10, 10, 100, 30);
        final JTextField tf1 = new JTextField();
        tf1.setBounds(130, 10, 100, 20);

        JLabel l2 = new JLabel("Movie ID");
        l2.setBounds(240, 10, 100, 30);
        final JTextField tf2 = new JTextField();
        tf2.setBounds(350, 10, 100, 20);

        JLabel l3 = new JLabel("Movie Code");
        l3.setBounds(460, 10, 100, 30);
        final JTextField tf3 = new JTextField();
        tf3.setBounds(570, 10, 100, 20);

        JLabel l4 = new JLabel("Title");
        l4.setBounds(10, 50, 100, 30);
        final JTextField tf4 = new JTextField();
        tf4.setBounds(130, 50, 100, 20);

        JLabel l5 = new JLabel("Release Year");
        l5.setBounds(240, 50, 100, 30);
        final JTextField tf5 = new JTextField();
        tf5.setBounds(350, 50, 100, 20);

        JLabel l6 = new JLabel("Release Date");
        l6.setBounds(460, 50, 100, 30);
        final JTextField tf6 = new JTextField();
        tf6.setBounds(570, 50, 100, 20);

        JLabel l7 = new JLabel("Protagonist");
        l7.setBounds(10, 90, 100, 30);
        final JTextField tf7 = new JTextField();
        tf7.setBounds(130, 90, 100, 20);

        JButton b1 = new JButton("Add Movie");
        b1.setBounds(200, 200, 180, 30);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get data from text fields
                String companyID = tf1.getText();
                String movieID = tf2.getText();
                String movieCode = tf3.getText();
                String title = tf4.getText();
                String releaseYear = tf5.getText();
                String releaseDate = tf6.getText();
                String protagonist = tf7.getText();

                // JDBC variables
                String url = "jdbc:mysql://localhost:3306/movieproduction";
                String user = "root";
                String password = "root";

                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    String query = "INSERT INTO movie_table (company_id, movie_id, movie_code, title, release_year, release_date, protagonist) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)";

                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setString(1, companyID);
                        preparedStatement.setString(2, movieID);
                        preparedStatement.setString(3, movieCode);
                        preparedStatement.setString(4, title);
                        preparedStatement.setString(5, releaseYear);
                        preparedStatement.setString(6, releaseDate);
                        preparedStatement.setString(7, protagonist);

                        int rowsAffected = preparedStatement.executeUpdate();
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(f, "Movie added successfully!");
                        } else {
                            JOptionPane.showMessageDialog(f, "Error adding movie.", "Error", JOptionPane.ERROR_MESSAGE);
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
        f.add(l3);
        f.add(tf3);
        f.add(l4);
        f.add(tf4);
        f.add(l5);
        f.add(tf5);
        f.add(l6);
        f.add(tf6);
        f.add(l7);
        f.add(tf7);
        f.add(b1);
        f.add(b2);

        f.setSize(800, 600);
        f.getContentPane().setBackground(Color.white);
        f.setLayout(null);
        f.setVisible(true);
    }
}
