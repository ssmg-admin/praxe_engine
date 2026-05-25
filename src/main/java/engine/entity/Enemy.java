package engine.entity;

import engine.physics.Collidable;
import engine.physics.Drawable;
import engine.physics.Updatable;

import java.awt.*;

public class Enemy extends Entity implements Drawable, Updatable, Collidable {

    public Enemy(int x, int height, int width, int y) {
        super(x, height, width, y);
    }

    @Override
    public boolean collide(Collidable other) {
        boolean collided = false;
        collided = this.getBounds().intersects(other.getBounds());
        return collided;
    }

    @Override
    public void onCollision(Collidable other) {

        if (other instanceof Player) {
            System.out.println("Enemy touched player");
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(getX(),getY(),getWidth(),getHeight());
    }

    @Override
    public void update() {

    }
}
