package ui;
import dao.UserDAO;
import ui.createaccount;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Login implements ActionListener
{

   JFrame frame = new JFrame("Login page");
   JLabel Title = new JLabel("Welcome Back");
   JLabel username = new JLabel("Username");
   JLabel password = new JLabel("Password");
   JTextField text = new JTextField();
   JPasswordField text1 = new JPasswordField();
   JButton button = new JButton("Login");
   JPanel panel = new JPanel();
   JPanel mainPanel = new JPanel();

   public Login()
   {
      frame.setVisible(true);
      frame.setSize(450, 550);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);
      
      // Main panel with animated gradient background
      mainPanel.setLayout(new BorderLayout());
      mainPanel.setOpaque(false);
      
      // Create animated background panel
      AnimatedBackgroundPanel backgroundPanel = new AnimatedBackgroundPanel();
      backgroundPanel.setLayout(new BorderLayout());
      
      // Login form panel with transparency
      panel.setLayout(new GridBagLayout());
      panel.setOpaque(false);
      panel.setBorder(new EmptyBorder(40, 60, 40, 60));
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.insets = new Insets(15, 0, 15, 0);
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.gridx = 0;
      gbc.gridwidth = 2;
      
      // Title
      Title.setForeground(Color.WHITE);
      Title.setFont(new Font("Segoe UI", Font.BOLD, 32));
      Title.setHorizontalAlignment(SwingConstants.CENTER);
      gbc.gridy = 0;
      panel.add(Title, gbc);
      
      // Subtitle
      JLabel subtitle = new JLabel("Sign in to continue");
      subtitle.setForeground(new Color(220, 220, 225));
      subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
      subtitle.setHorizontalAlignment(SwingConstants.CENTER);
      gbc.insets = new Insets(0, 0, 25, 0);
      gbc.gridy = 1;
      panel.add(subtitle, gbc);
      
      // Username label and field
      gbc.insets = new Insets(5, 0, 5, 0);
      gbc.gridwidth = 2;
      gbc.gridy = 2;
      username.setForeground(new Color(220, 220, 225));
      username.setFont(new Font("Segoe UI", Font.PLAIN, 12));
      username.setHorizontalAlignment(SwingConstants.LEFT);
      panel.add(username, gbc);
      
      gbc.gridy = 3;
      text.setBackground(new Color(255, 255, 255, 20));
      text.setForeground(Color.WHITE);
      text.setCaretColor(Color.WHITE);
      text.setBorder(BorderFactory.createCompoundBorder(
          BorderFactory.createLineBorder(new Color(255, 255, 255, 30), 1),
          new EmptyBorder(12, 15, 12, 15)
      ));
      text.setFont(new Font("Segoe UI", Font.PLAIN, 14));
      panel.add(text, gbc);
      
      // Password label and field
      gbc.gridy = 4;
      password.setForeground(new Color(220, 220, 225));
      password.setFont(new Font("Segoe UI", Font.PLAIN, 12));
      password.setHorizontalAlignment(SwingConstants.LEFT);
      panel.add(password, gbc);
      
      gbc.gridy = 5;
      text1.setBackground(new Color(255, 255, 255, 20));
      text1.setForeground(Color.WHITE);
      text1.setCaretColor(Color.WHITE);
      text1.setBorder(BorderFactory.createCompoundBorder(
          BorderFactory.createLineBorder(new Color(255, 255, 255, 30), 1),
          new EmptyBorder(12, 15, 12, 15)
      ));
      text1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
      panel.add(text1, gbc);
      
      // Login button
      gbc.insets = new Insets(25, 0, 15, 0);
      gbc.gridy = 6;
      button.setBackground(new Color(0, 122, 255));
      button.setForeground(Color.WHITE);
      button.setFocusable(false);
      button.setBorder(new EmptyBorder(12, 0, 12, 0));
      button.setFont(new Font("Segoe UI", Font.BOLD, 14));
      button.setCursor(new Cursor(Cursor.HAND_CURSOR));
      panel.add(button, gbc);
      
      // Create account link
      JLabel createAccountLabel = new JLabel("Don't have an account? Sign up");
      createAccountLabel.setForeground(new Color(0, 122, 255));
      createAccountLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
      createAccountLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
      createAccountLabel.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
              frame.dispose();
              new createaccount();
          }
      });
      
      gbc.insets = new Insets(5, 0, 0, 0);
      gbc.gridy = 7;
      panel.add(createAccountLabel, gbc);

      button.addActionListener(this);
      backgroundPanel.add(panel, BorderLayout.CENTER);
      frame.setContentPane(backgroundPanel);
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      if(e.getSource() == button)
      {
      String userId=text.getText();
      String password=String.valueOf(text1.getPassword());

          UserDAO dao = new UserDAO();

          boolean result = dao.loginUser(userId,password);
      
         if(result)
         {
          JOptionPane.showMessageDialog(frame, "Login Successful");
          frame.dispose();
          new Welcomepage(userId);
         } 
         else 
         {
            JOptionPane.showMessageDialog(frame,"Login Failed" );
         }
      } 
     

   }
    
}

// Animated Background Panel Class
class AnimatedBackgroundPanels extends JPanel {
    private float hue = 0.0f;
    private Timer animationTimer;
    
    public AnimatedBackgroundPanels() {
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
