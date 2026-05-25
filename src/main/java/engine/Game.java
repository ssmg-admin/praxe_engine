package engine;

import javax.swing.*;


public class Game extends JFrame {

    public Game() {
        setTitle("Game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        GamePanel gamePanel = new GamePanel();
        add(gamePanel);
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Game::new);
    }

}
