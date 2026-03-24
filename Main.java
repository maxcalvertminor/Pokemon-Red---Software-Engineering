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
        BufferedImage houseImage;
        BufferedImage pokecenterInteriorImage;


        private void loadMaps() {
            try {
                houseImage = ImageIO.read(getClass().getResource("House.png")); 
                pokecenterInteriorImage = ImageIO.read(getClass().getResource("PokecenterInside.png"));

                System.out.println(viridianImage);
                System.out.println(pokecenterInteriorImage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Image playerImage;

        private int playerX = 260;
        private int playerY = 300;
        private final int SPEED = 7;

        private int currentMap = 0; // 0 = Pallet, 1 = PalletPokecenter, 2 = Pewter, 3 = Viridian, 4 = Pokecenter
        private int previousMap = 0;

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

        private void MyNewCity() {
        currentMap = 8;  // pick the next unused number
        currentMapImage = null;
        trails.clear(); grass.clear(); water.clear(); pokecenter.clear();

        // add your rectangles here
        trails.add(new Rectangle(260, 0, 40, 1000));
        grass.add(new Rectangle(50, 100, 150, 100));
        pokecenter.add(new Rectangle(100, 100, 110, 110));
}

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
        private void CeruleanCity() {
    currentMap = 5;
    currentMapImage = null;  // or load a new image like viridianImage
    trails.clear();
    grass.clear();
    water.clear();
    pokecenter.clear();

    // Main vertical road
    trails.add(new Rectangle(260, 0, 40, 1000));

    // Horizontal road
    trails.add(new Rectangle(0, 200, 600, 40));

    // Water area (Cerulean theme)
    water.add(new Rectangle(400, 50, 150, 120));

    // Grass patches
    grass.add(new Rectangle(50, 80, 120, 100));
    grass.add(new Rectangle(80, 250, 150, 100));

    // Pokecenter building
    pokecenter.add(new Rectangle(100, 100, 120, 120));
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
            grass.add(new Rectangle(60, 140, 200, 120));

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
            grass.add(new Rectangle(60, 140, 200, 140));
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
            previousMap = currentMap;
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
            for (Rectangle r : pokecenter) {
                if (houseImage != null) {
                    g.drawImage(houseImage, r.x, r.y, r.width, r.height, this);
                } else {
                    g.setColor(Color.GRAY);
                g.fillRect(r.x, r.y, r.width, r.height);
                }
            }
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
            Battle.startBattle();
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

        // Pallet → Pewter (go north)
        if (currentMap == 0 && playerY < 0) {
            PewterCity();
            playerY = getHeight() - 40;
        }

        // Pewter → Viridian (go north)
        if (currentMap == 2 && playerY < 0) {
            Viridian();
            playerY = getHeight() - 40;
        }

        // Pewter → Pallet (go south)
        if (currentMap == 2 && playerY > getHeight() - 32) {
            Pallet();
            playerY = 10;
        }

        // Viridian → Pewter (go south)
        if (currentMap == 3 && playerY > getHeight() - 32) {
            PewterCity();
            playerY = 10;
        }

        // Viridian → Cerulean (go north)
        if (currentMap == 3 && playerY < 0) {
            CeruleanCity();
            playerY = getHeight() - 40;
        }

        // Cerulean → MyNewCity (go north)
        if (currentMap == 5 && playerY < 0) {
            MyNewCity();
            playerY = getHeight() - 40;
        }

        // MyNewCity → Cerulean (go south)
        if (currentMap == 8 && playerY > getHeight() - 32) {
            CeruleanCity();
            playerY = 10;
        }

        // Cerulean → Viridian (go south)
        if (currentMap == 5 && playerY > getHeight() - 32) {
            Viridian();
            playerY = 10;

            // Enter Pokecenter (MyNewCity)
if (currentMap == 8) {
    for (Rectangle building : pokecenter) {
        if (playerRect.intersects(building)) {
            enterPokecenter();
        }
    }
}
// Enter Pokecenter (MyNewCity)
if (currentMap == 8) {
    for (Rectangle building : pokecenter) {
        if (playerRect.intersects(building)) {
            enterPokecenter();
        }
    }
}

        // Clamp to screen
        playerX = Math.max(0, Math.min(playerX, getWidth() - 32));
        playerY = Math.max(-10, Math.min(playerY, getHeight()));

        repaint();
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

 
