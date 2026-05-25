package engine;

import engine.entity.Entity;
import engine.physics.Collidable;
import engine.physics.Drawable;
import engine.physics.Updatable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class World {

    private List<Entity> entities = new ArrayList<>();
    private List<Drawable> drawables = new ArrayList<>();
    private List<Collidable> collidables = new ArrayList<>();
    private List<Updatable> updatables = new ArrayList<>();

    public void drawWorld(Graphics g){
        drawables.forEach(x -> x.draw(g));
    }

    public void updateWorld(){
        updatables.forEach(x -> x.update());
    }

    public void checkCollision() {

        for (int i = 0; i < collidables.size(); i++) {
            Collidable first = collidables.get(i);
            for (int j = i + 1; j < collidables.size(); j++) {
                Collidable second = collidables.get(j);

                if (first.collide(second)) {
                    first.onCollision(second);
                    second.onCollision(first);
                }
            }
        }
    }

    public void addEntity(Entity entity){
        entities.add(entity);
        if (entity instanceof Drawable drawable){drawables.add(drawable);}
        if (entity instanceof Collidable collidable){collidables.add(collidable);}
        if (entity instanceof Updatable updatable){updatables.add(updatable);}
    }

}
