package engine.entity;

import engine.inputs.KeyInput;
import engine.physics.Collidable;
import engine.physics.Drawable;
import engine.physics.Updatable;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;

public class Player extends Entity implements Collidable, Drawable, Updatable {

    private KeyInput keyInput;

    public Player(int x, int height, int width, int y, KeyInput keyInput) {
        super(x, height, width, y);
        this.keyInput = keyInput;

    }

    @Override
    public boolean collide(Collidable other) {
        boolean collided = false;
        collided = this.getBounds().intersects(other.getBounds());
        return collided;
    }

    @Override
    public void onCollision(Collidable other) {

        if (other instanceof Enemy) {
            System.out.println("Player damaged");
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(getX(),getY(),getWidth(),getHeight());
    }

    @Override
    public void update() {

        if (keyInput.isKeyPressed(KeyEvent.VK_A))setX(getX() - 2);
        if (keyInput.isKeyPressed(KeyEvent.VK_D)) setX(getX() + 2);
        if (keyInput.isKeyPressed(KeyEvent.VK_W)) setY(getY() - 2);
        if (keyInput.isKeyPressed(KeyEvent.VK_S)) setY(getY() + 2);

    }
}
