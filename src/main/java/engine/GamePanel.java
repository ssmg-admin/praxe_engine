package engine;

import engine.entity.Enemy;
import engine.entity.Entity;
import engine.entity.Player;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;

public class GamePanel extends JPanel {

    private World world = new World();
    private Player player = new Player(100,64,64,100);

    public GamePanel(){
        setPreferredSize(new Dimension(800, 600));

        world.addEntity(player);
        world.addEntity(new Enemy(250,64,64,320));
        world.addEntity(new Enemy(550,64,64,150));
        world.addEntity(new Enemy(550,64,64,300));

        new Timer(16, e -> {
            world.updateWorld();
            repaint();
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        world.drawWorld(g);
    }
}
