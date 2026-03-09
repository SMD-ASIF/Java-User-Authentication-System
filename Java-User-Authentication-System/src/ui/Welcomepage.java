package ui;

import java.awt.*;
import javax.swing.*;

public class Welcomepage {

    private JFrame frame;
    private JLabel welcomeLabel;

    public Welcomepage(String userID) {

        frame = new JFrame("Welcome page");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/background.png"));
        Image img = icon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon backgroundImage = new ImageIcon(img);

        JLabel background = new JLabel(backgroundImage);
        background.setBounds(0, 0, 500, 500);
        background.setLayout(null);

        welcomeLabel = new JLabel("Hello, " + userID);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 25));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setBounds(100, 200, 300, 40);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        background.add(welcomeLabel);

        frame.setContentPane(background);

        frame.setVisible(true);
    }
}