package engine.physics;

import java.awt.*;

public interface Collidable {
    boolean collide(Collidable other);
    Rectangle getBounds();
}
