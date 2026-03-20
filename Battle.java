import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Battle {

    static JFrame battleFrame;

    public static void startBattle() {
        battleFrame = new JFrame("Battle!");
        battleFrame.setSize(600, 400);
        battleFrame.setLocationRelativeTo(null);
        battleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        battleFrame.add(new BattlePanel());

        battleFrame.setVisible(true);
    }

    static class BattlePanel extends JPanel {

        int playerHP = 100;
        int enemyHP = 100;

        JTextArea battleLog;

        public BattlePanel() {
            setLayout(null);

            // Battle text log
            battleLog = new JTextArea();
            battleLog.setBounds(20, 200, 560, 80);
            battleLog.setEditable(false);
            add(battleLog);

            // Buttons
            JButton attackBtn = new JButton("Attack");
            attackBtn.setBounds(50, 300, 100, 40);
            add(attackBtn);

            JButton runBtn = new JButton("Run");
            runBtn.setBounds(200, 300, 100, 40);
            add(runBtn);

            // Button logic
            attackBtn.addActionListener(e -> attack());
            runBtn.addActionListener(e -> endBattle("You ran away!"));
        }

        private void attack() {
            int playerDamage = (int)(Math.random() * 20) + 5;
            int enemyDamage = (int)(Math.random() * 15) + 3;

            enemyHP -= playerDamage;
            playerHP -= enemyDamage;

            battleLog.setText(
                "You dealt " + playerDamage + " damage!\n" +
                "Enemy dealt " + enemyDamage + " damage!"
            );

            if (enemyHP <= 0) {
                endBattle("You win!");
            } else if (playerHP <= 0) {
                endBattle("You lost...");
            }

            repaint();
        }

        private void endBattle(String message) {
            JOptionPane.showMessageDialog(this, message);
            battleFrame.dispose();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Background
            g.setColor(new Color(200, 230, 255));
            g.fillRect(0, 0, getWidth(), getHeight());

            // Enemy
            g.setColor(Color.RED);
            g.fillRect(400, 80, 80, 80);
            g.drawString("Enemy HP: " + enemyHP, 380, 70);

            // Player
            g.setColor(Color.BLUE);
            g.fillRect(100, 150, 80, 80);
            g.drawString("Your HP: " + playerHP, 80, 140);
        }
    }
}