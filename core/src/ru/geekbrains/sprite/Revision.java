package ru.geekbrains.sprite;

import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;
import ru.geekbrains.pool.BulletPool;
import ru.geekbrains.pool.RevisionPool;

public class Revision extends Sprite {

    protected RevisionPool revisionPool;

    protected Vector2 v;
    protected Vector2 v0;

    protected Rect worldBounds;

    protected float reloadInterval;
    protected float reloadTimer;

    protected int damage;
    protected int hp;

    private MainShip mainShip;
    private Revision revision;

    public Revision(RevisionPool revisionPool, Rect worldBounds, Revision revision, MainShip mainShip) {
        this.revisionPool = revisionPool;
        this.worldBounds = worldBounds;
        this.v = new Vector2();
        this.v0 = new Vector2();
        this.revision = revision;
        this.mainShip = mainShip;
    }

}
