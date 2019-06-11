package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;
import ru.geekbrains.math.Rnd;

public class Revision extends Sprite {

    protected Rect worldBounds;

    protected Vector2 v;
    protected Vector2 v0;

    protected float reloadInterval;
    protected float reloadTimer;

    protected int damage;
    protected int hp;

    private MainShip mainShip;

    public Revision(Rect worldBounds, MainShip mainShip) {

        this.worldBounds = worldBounds;
        this.mainShip = mainShip;
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        if (getRight() < worldBounds.getLeft()) {
            setLeft(worldBounds.getRight());
        }
        if (getLeft() > worldBounds.getRight()) {
            setRight(worldBounds.getLeft());
        }
        if (getTop() < worldBounds.getBottom()) {
            setBottom(worldBounds.getTop());
        }
    }

    @Override
    public void resize(Rect wordBounds) {
        this.worldBounds = wordBounds;
        float posX = Rnd.nextFloat(wordBounds.getLeft(), wordBounds.getRight());
        float posY = Rnd.nextFloat(wordBounds.getBottom(), wordBounds.getTop());
        pos.set(posX, posY);
    }

    public void set(
            TextureRegion[] regions,
            Vector2 v0,
            int damage,
            float reloadInterval,
            float height,
            int hp
    ) {
        this.regions = regions;
        this.v0.set(v0);
        this.damage = damage;
        this.reloadInterval = reloadInterval;
        this.reloadTimer = reloadInterval;
        setHeightProportion(height);
        this.hp = hp;
    }

    public boolean isRevisionCollision(Rect revision) {
        return !(
                revision.getRight() < getLeft()
                        || revision.getLeft() > getRight()
                        || revision.getBottom() > getTop()
                        || revision.getTop() < pos.y
        );
    }

}
