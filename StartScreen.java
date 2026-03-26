import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartScreen extends JFrame {

    public StartScreen() {
        setTitle("Pokemon Game - Start");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Background panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(100, 180, 255));

        // Title
        JLabel title = new JLabel("Pokemon Game");
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setBounds(150, 80, 300, 50);
        panel.add(title);

        // Start Button
        JButton startButton = new JButton("Start Game");
        startButton.setBounds(220, 180, 150, 40);
        panel.add(startButton);

        // Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(220, 240, 150, 40);
        panel.add(exitButton);

        // Button Actions
        startButton.addActionListener(e -> {
            dispose(); // close start screen
            new Main.GameFrame(); // launch your game
        });

        exitButton.addActionListener(e -> System.exit(0));

        add(panel);
        setVisible(true);
    }
}