/*import javax.swing.*;

public class DepBattle {

    public static void startBattle() {

        pokemon player = new pokemon("Charmander", 20);
        pokemon enemy = new pokemon("Wild Pidgey", 15);

        JOptionPane.showMessageDialog(null,
                "A wild " + enemy.getName() + " appeared!");

        while (player.getHealth() > 0 && enemy.getHealth() > 0) {

            enemy.setHealth(enemy.getHealth() - 5);

            if (enemy.getHealth() <= 0) break;

            player.setHealth(player.getHealth() - 3);
        }

        if (player.getHealth() <= 0)
            JOptionPane.showMessageDialog(null, "You lost!");
        else
            JOptionPane.showMessageDialog(null, "You won!");
    }
}*/