package engine.physics;

import java.awt.*;

public interface Collidable {
    boolean collide(Collidable other);
    void onCollision(Collidable other);
    Rectangle getBounds();
}
