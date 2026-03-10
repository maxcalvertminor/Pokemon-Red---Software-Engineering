import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Main {

    static class GameFrame extends JFrame {
        public GameFrame() {
            setTitle("Pokemon Game");
            setSize(600, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            add(new GamePanel());
            setVisible(true);
        }
    }

    static class GamePanel extends JPanel implements KeyListener {
        BufferedImage viridianImage;
        BufferedImage currentMapImage;

        private void loadMaps() {
            try {
                viridianImage = ImageIO.read(getClass().getResource("Forest.jpeg"));
                System.out.println(viridianImage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Image playerImage;

        private int playerX = 260;
        private int playerY = 300;
        private final int SPEED = 7;

        private int currentMap = 0; // 0 = Pallet, 1 = PalletPokecenter, 2 = Pewter, 3 = Viridian, 4 = Pokecenter

        private ArrayList<Rectangle> trails = new ArrayList<>();
        private ArrayList<Rectangle> grass = new ArrayList<>();
        private ArrayList<Rectangle> water = new ArrayList<>();
        private ArrayList<Rectangle> pokecenter = new ArrayList<>();

        public GamePanel() {
            setFocusable(true);
            addKeyListener(this);
            playerImage = new ImageIcon("player.png").getImage();
            loadMaps();
            Pallet();
        }

        // ================= MAP LOADERS =================

        private void Pallet() {
            currentMap = 0;
            currentMapImage = null;
            trails.clear();
            grass.clear();
            water.clear();
            pokecenter.clear();

            trails.add(new Rectangle(260, 0, 40, 1000));
            grass.add(new Rectangle(60, 140, 200, 120));
            grass.add(new Rectangle(300, 180, 200, 120));
            water.add(new Rectangle(400, 210, 120, 100));
            trails.add(new Rectangle(0, 101, 600, 40));
            pokecenter.add(new Rectangle(100, 100, 100, 100));
        }

        private void PokecenterInsidePallet() {
            currentMap = 1;
            currentMapImage = null;
            trails.clear();
            grass.clear();
            water.clear();
            pokecenter.clear();

            trails.add(new Rectangle(0, 300, 600, 40));
        }

        private void PewterCity() {
            currentMap = 2;
            currentMapImage = null;
            trails.clear();
            grass.clear();
            water.clear();
            pokecenter.clear();

            pokecenter.add(new Rectangle(100, 100, 100, 100));
            trails.add(new Rectangle(260, 0, 40, 1000));
            pokecenter.add(new Rectangle(350, 120, 120, 120));
            trails.add(new Rectangle(0, 260, 600, 40));
        }

        private void Viridian() {
            currentMap = 3;
            currentMapImage = viridianImage;
            trails.clear();
            grass.clear();
            water.clear();
            pokecenter.clear();

            pokecenter.add(new Rectangle(100, 100, 100, 100));
            trails.add(new Rectangle(260, 0, 40, 1000));
            pokecenter.add(new Rectangle(350, 120, 120, 120));
            trails.add(new Rectangle(0, 260, 600, 40));
        }

        private void PokecenterInside() {
            currentMap = 4;
            currentMapImage = null;
            trails.clear();
            grass.clear();
            water.clear();
            pokecenter.clear();

            trails.add(new Rectangle(0, 300, 600, 40));
        }

        private void enterPokecenter() {
            PokecenterInside();
            playerX = 280;
            playerY = 260;
        }

        // ================= DRAW =================

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (currentMapImage != null) {
                g.drawImage(currentMapImage, 0, 0, getWidth(), getHeight(), this);
            } else {
                if (currentMap == 0)
                    g.setColor(new Color(120, 200, 120));
                else if (currentMap == 1)
                    g.setColor(new Color(180, 200, 220));
                else
                    g.setColor(new Color(220, 220, 220));

                g.fillRect(0, 0, getWidth(), getHeight());
            }

            g.setColor(new Color(170, 140, 90));
            for (Rectangle r : trails)
                g.fillRect(r.x, r.y, r.width, r.height);

            g.setColor(new Color(40, 150, 60));
            for (Rectangle r : grass)
                g.fillRect(r.x, r.y, r.width, r.height);

            g.setColor(new Color(60, 120, 200));
            for (Rectangle r : water)
                g.fillRect(r.x, r.y, r.width, r.height);

            g.setColor(Color.GRAY);
            for (Rectangle r : pokecenter)
                g.fillRect(r.x, r.y, r.width, r.height);

            g.drawImage(playerImage, playerX, playerY, 32, 32, this);
        }

        // ================= INPUT =================

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP    -> playerY -= SPEED;
                case KeyEvent.VK_DOWN  -> playerY += SPEED;
                case KeyEvent.VK_LEFT  -> playerX -= SPEED;
                case KeyEvent.VK_RIGHT -> playerX += SPEED;
            }

            Rectangle playerRect = new Rectangle(playerX, playerY, 32, 32);
        // RANDOM GRASS ENCOUNTER
        for (Rectangle g : grass) {
            if (playerRect.intersects(g)) {

        int chance = (int)(Math.random() * 10);

        if (chance == 0) {   // 10% chance
            //DepBattle.startBattle();
        }
    }
}
            // Enter Pokecenter (Pallet)
            if (currentMap == 0) {
                for (Rectangle building : pokecenter) {
                    if (playerRect.intersects(building)) {
                        PokecenterInsidePallet();
                        playerX = 280;
                        playerY = 260;
                    }
                }
            }

            // Enter Pokecenter (Viridian)
            if (currentMap == 3) {
                for (Rectangle building : pokecenter) {
                    if (playerRect.intersects(building)) {
                        enterPokecenter();
                    }
                }
            }

            // Enter Pokecenter (Pewter)
            if (currentMap == 2) {
                for (Rectangle building : pokecenter) {
                    if (playerRect.intersects(building)) {
                        enterPokecenter();
                    }
                }
            }

            // Exit Pokecenter (map 1 = Pallet's pokecenter)
            if (currentMap == 1 && playerY > getHeight() - 32) {
                Pallet();
                playerX = 130;
                playerY = 220;
            }

            // Exit Pokecenter (map 4 = Viridian/Pewter pokecenter)
            if (currentMap == 4 && playerY > getHeight() - 32) {
                Viridian();
                playerX = 130;
                playerY = 220;
            }

            // Pallet → Viridian (go north)
            if (currentMap == 0 && playerY < 0) {
                PewterCity();
                playerY = getHeight() - 40;
            }

            // Viridian → Pewter (go north)
            if (currentMap == 2 && playerY < 0) {
                Viridian();
                playerY = getHeight() - 40;
            }

            // Pewter → Viridian (go south)
            if (currentMap == 3 && playerY > getHeight() - 32) {
                PewterCity();
                playerY = 10;
            }

            // Viridian → Pallet (go south)
            if (currentMap == 2 && playerY > getHeight() - 32) {
                Pallet();
                playerY = 10;
            }

            // Clamp to screen
            playerX = Math.max(0, Math.min(playerX, getWidth() - 32));
            playerY = Math.max(-10, Math.min(playerY, getHeight()));

            repaint();
        }

        @Override public void keyReleased(KeyEvent e) {}
        @Override public void keyTyped(KeyEvent e) {}

    }  // closes GamePanel

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameFrame::new);
    }

}  // closes Main

 
