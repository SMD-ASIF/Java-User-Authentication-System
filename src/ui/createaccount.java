package ui;

import dao.UserDAO;
import model.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class createaccount implements ActionListener {
    
    JFrame frame = new JFrame("Create Account");
    JPanel panel = new JPanel();
    JPanel mainPanel = new JPanel();
    JLabel Title = new JLabel("Create Account");
    JLabel signinJLabel = new JLabel("Already have an account?");
    JButton signButton = new JButton("Sign in");
    JTextField userField = new JTextField();
    JTextField firstname = new JTextField();
    JTextField lastname = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JTextField email = new JTextField();
    JButton button = new JButton("Sign up");

    public createaccount() {

        frame.setSize(450, 650);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Main panel with animated gradient background
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setOpaque(false);
        
        // Create animated background panel
        AnimatedBackgroundPanel backgroundPanel = new AnimatedBackgroundPanel();
        backgroundPanel.setLayout(new BorderLayout());

        panel.setLayout(new GridBagLayout());
        panel.setOpaque(false);
        panel.setBorder(new EmptyBorder(30, 50, 30, 50));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 0, 8, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridwidth = 2;

        Title.setForeground(Color.WHITE);
        Title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        Title.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 5, 0);
        panel.add(Title, gbc);

        JLabel subtitle = new JLabel("Join us today! Fill in your details");
        subtitle.setForeground(new Color(220, 220, 225));
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 20, 0);
        panel.add(subtitle, gbc);

        gbc.insets = new Insets(5, 0, 3, 0);
        gbc.gridy = 2;
        JLabel userLabel = new JLabel("Username");
        userLabel.setForeground(new Color(220, 220, 225));
        userLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        userLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(userLabel, gbc);

        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 8, 0);
        userField.setBackground(new Color(255, 255, 255, 20));
        userField.setForeground(Color.WHITE);
        userField.setCaretColor(Color.WHITE);
        userField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(255, 255, 255, 30), 1),
            new EmptyBorder(10, 15, 10, 15)
        ));
        userField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(userField, gbc);

        JPanel namePanel = new JPanel(new GridLayout(1, 2, 10, 0));
        namePanel.setOpaque(false);

        firstname.setBackground(new Color(255, 255, 255, 20));
        firstname.setForeground(Color.WHITE);
        firstname.setCaretColor(Color.WHITE);
        firstname.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(255, 255, 255, 30), 1),
            new EmptyBorder(10, 15, 10, 15)
        ));
        firstname.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        namePanel.add(firstname);

        lastname.setBackground(new Color(255, 255, 255, 20));
        lastname.setForeground(Color.WHITE);
        lastname.setCaretColor(Color.WHITE);
        lastname.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(255, 255, 255, 30), 1),
            new EmptyBorder(10, 15, 10, 15)
        ));
        lastname.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        namePanel.add(lastname);

        gbc.gridy = 4;
        gbc.insets = new Insets(5, 0, 3, 0);
        JLabel nameLabel = new JLabel("Full Name");
        nameLabel.setForeground(new Color(220, 220, 225));
        nameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(nameLabel, gbc);

        gbc.gridy = 5;
        gbc.insets = new Insets(0, 0, 8, 0);
        panel.add(namePanel, gbc);

        gbc.gridy = 6;
        gbc.insets = new Insets(5, 0, 3, 0);
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setForeground(new Color(220, 220, 225));
        emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(emailLabel, gbc);

        gbc.gridy = 7;
        gbc.insets = new Insets(0, 0, 8, 0);
        email.setBackground(new Color(255, 255, 255, 20));
        email.setForeground(Color.WHITE);
        email.setCaretColor(Color.WHITE);
        email.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(255, 255, 255, 30), 1),
            new EmptyBorder(10, 15, 10, 15)
        ));
        email.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(email, gbc);

        gbc.gridy = 8;
        gbc.insets = new Insets(5, 0, 3, 0);
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(new Color(220, 220, 225));
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(passwordLabel, gbc);

        gbc.gridy = 9;
        gbc.insets = new Insets(0, 0, 15, 0);
        passwordField.setBackground(new Color(255, 255, 255, 20));
        passwordField.setForeground(Color.WHITE);
        passwordField.setCaretColor(Color.WHITE);
        passwordField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(255, 255, 255, 30), 1),
            new EmptyBorder(10, 15, 10, 15)
        ));
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(passwordField, gbc);

        gbc.insets = new Insets(10, 0, 15, 0);
        gbc.gridy = 10;
        button.setBackground(new Color(0, 122, 255));
        button.setForeground(Color.WHITE);
        button.setBorder(new EmptyBorder(12, 0, 12, 0));
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setFocusable(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(button, gbc);

        JPanel signInPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        signInPanel.setOpaque(false);

        signinJLabel.setForeground(new Color(220, 220, 225));
        signinJLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        signInPanel.add(signinJLabel);

        signButton.setForeground(new Color(0, 122, 255));
        signButton.setBackground(new Color(45, 45, 48));
        signButton.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        signButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        signButton.setFocusable(false);
        signButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signInPanel.add(signButton);

        gbc.gridy = 11;
        gbc.insets = new Insets(0, 0, 0, 0);
        panel.add(signInPanel, gbc);

        button.addActionListener(this);
        signButton.addActionListener(this);
        backgroundPanel.add(panel, BorderLayout.CENTER);
        frame.setContentPane(backgroundPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String userId = userField.getText().trim();
            String password = String.valueOf(passwordField.getPassword());
            String firstName = firstname.getText().trim();
            String lastName = lastname.getText().trim();
            String userEmail = email.getText().trim();

            String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            Pattern specialCharPattern = Pattern.compile("\\W");
            Matcher usernameSpecialCharMatcher = specialCharPattern.matcher(userId);
            Matcher passwordSpecialCharMatcher = specialCharPattern.matcher(password);
            Pattern specialPattern = Pattern.compile(emailRegex);
            Matcher emailspecialCharMatcher = specialPattern.matcher(userEmail);

            UserDAO dao = new UserDAO();

            if (userId.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || userEmail.isEmpty() || password.isEmpty()) {
                ModernDialog.showDialog(frame, "Information", "Please fill in all fields", ModernDialog.Type.INFO);
            } else if (usernameSpecialCharMatcher.find()) {
                ModernDialog.showDialog(frame, "Error", "Username should not contain any special symbols", ModernDialog.Type.ERROR);
            } else if (userId.length() > 10) {
                ModernDialog.showDialog(frame, "Error", "Username must contain 10 or fewer characters", ModernDialog.Type.ERROR);
            } else if (passwordSpecialCharMatcher.find()) {
                ModernDialog.showDialog(frame, "Error", "Password should not contain any special symbols", ModernDialog.Type.ERROR);
            } else if (password.length() < 8) {
                ModernDialog.showDialog(frame, "Error", "Password must contain at least 8 characters", ModernDialog.Type.ERROR);
            } else if (!emailspecialCharMatcher.matches()) {
                ModernDialog.showDialog(frame, "Error", "Invalid email address", ModernDialog.Type.ERROR);
            }else if (dao.emailExists(userEmail)) {
                    ModernDialog.showDialog(frame, "Error", "Email already Exists", ModernDialog.Type.ERROR);
            } else {

                User user = new User(userId,userEmail,password);

                boolean result = dao.registerUser(user);
                if (result) {
                    ModernDialog.showDialog(frame, "Success", "Account created successfully!", ModernDialog.Type.SUCCESS);
                    frame.dispose();
                    new Login();
                } else {
                    ModernDialog.showDialog(frame, "Error", "username already exists!", ModernDialog.Type.ERROR);
                }
            }
        } else if (e.getSource() == signButton) {
            frame.dispose();
            new Login();
        }
    }
}

// Modern Dialog Class
class ModernDialog {
    public enum Type {
        SUCCESS, ERROR, INFO, WARNING
    }
    
    public static void showDialog(JFrame parent, String title, String message, Type type) {
        JDialog dialog = new JDialog(parent, title, true);
        dialog.setSize(400, 200);
        dialog.setLocationRelativeTo(parent);
        dialog.setUndecorated(true);
        
        // Create animated background panel for dialog
        AnimatedBackgroundPanel backgroundPanel = new AnimatedBackgroundPanel();
        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(255, 255, 255, 40), 1),
            BorderFactory.createLineBorder(new Color(255, 255, 255, 20), 1)
        ));
        
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Icon based on type
        JLabel iconLabel = new JLabel();
        iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 48));
        switch (type) {
            case SUCCESS:
                iconLabel.setText("✅");
                iconLabel.setForeground(new Color(52, 199, 89));
                break;
            case ERROR:
                iconLabel.setText("❌");
                iconLabel.setForeground(new Color(255, 59, 48));
                break;
            case INFO:
                iconLabel.setText("ℹ️");
                iconLabel.setForeground(new Color(0, 122, 255));
                break;
            case WARNING:
                iconLabel.setText("⚠️");
                iconLabel.setForeground(new Color(255, 149, 0));
                break;
        }
        
        // Title
        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        
        // Message
        JTextArea messageArea = new JTextArea(message);
        messageArea.setForeground(new Color(220, 220, 225));
        messageArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        messageArea.setOpaque(false);
        messageArea.setEditable(false);
        messageArea.setWrapStyleWord(true);
        messageArea.setLineWrap(true);
        messageArea.setBorder(new EmptyBorder(10, 0, 10, 0));
        
        // OK Button
        JButton okButton = new JButton("OK");
        okButton.setBackground(new Color(0, 122, 255));
        okButton.setForeground(Color.WHITE);
        okButton.setBorder(new EmptyBorder(10, 25, 10, 25));
        okButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        okButton.setFocusable(false);
        okButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        okButton.addActionListener(e -> dialog.dispose());
        
        // Layout components
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.insets = new Insets(20, 20, 20, 10);
        contentPanel.add(iconLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(20, 0, 5, 20);
        contentPanel.add(titleLabel, gbc);
        
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 0, 20, 20);
        contentPanel.add(messageArea, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 20, 0);
        contentPanel.add(okButton, gbc);
        
        backgroundPanel.add(contentPanel, BorderLayout.CENTER);
        dialog.setContentPane(backgroundPanel);
        dialog.setVisible(true);
    }
}

// Animated Background Panel Class
class AnimatedBackgroundPanel extends JPanel {
    private float hue = 0.0f;
    private Timer animationTimer;
    
    public AnimatedBackgroundPanel() {
        setOpaque(false);
        startAnimation();
    }
    
    private void startAnimation() {
        animationTimer = new Timer(50, e -> {
            hue += 0.002f;
            if (hue > 1.0f) hue = 0.0f;
            repaint();
        });
        animationTimer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        
        // Create animated gradient
        Color color1 = Color.getHSBColor(hue, 0.7f, 0.3f);
        Color color2 = Color.getHSBColor((hue + 0.3f) % 1.0f, 0.7f, 0.2f);
        Color color3 = Color.getHSBColor((hue + 0.6f) % 1.0f, 0.7f, 0.4f);
        
        // Create gradient paint
        GradientPaint gradient1 = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
        GradientPaint gradient2 = new GradientPaint(getWidth(), 0, color3, 0, getHeight(), color1);
        
        // Paint first gradient
        g2d.setPaint(gradient1);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        
        // Paint second gradient with transparency for depth
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        g2d.setPaint(gradient2);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        
        // Add subtle radial gradient overlay for center focus
        Point2D center = new Point2D.Float(getWidth() / 2f, getHeight() / 2f);
        float radius = Math.max(getWidth(), getHeight()) / 2f;
        float[] dist = {0.0f, 0.7f, 1.0f};
        Color[] colors = {new Color(255, 255, 255, 20), new Color(255, 255, 255, 5), new Color(0, 0, 0, 40)};
        RadialGradientPaint radialGradient = new RadialGradientPaint(center, radius, dist, colors);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
        g2d.setPaint(radialGradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        
        g2d.dispose();
    }
    
    @Override
    public void removeNotify() {
        super.removeNotify();
        if (animationTimer != null && animationTimer.isRunning()) {
            animationTimer.stop();
        }
    }
}
