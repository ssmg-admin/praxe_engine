package engine;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;

public class GamePanel extends JPanel {


    public GamePanel(){
        setPreferredSize(new Dimension(800, 600));


        new Timer(16, e -> {
            repaint();
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
