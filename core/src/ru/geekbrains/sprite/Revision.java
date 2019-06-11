package ru.geekbrains.sprite;

import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;
import ru.geekbrains.pool.BulletPool;
import ru.geekbrains.pool.RevisionPool;

public class Revision extends Sprite {

    protected Rect worldBounds;

    private MainShip mainShip;

    public Revision(Rect worldBounds, MainShip mainShip) {
        this.worldBounds = worldBounds;
        this.mainShip = mainShip;
    }

}
