package ru.geekbrains.pool;

import ru.geekbrains.base.SpritesPool;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.MainShip;
import ru.geekbrains.sprite.Revision;

public class RevisionPool extends SpritesPool <Revision> {

    private Rect worldBounds;
    private MainShip mainShip;

    public RevisionPool(Rect worldBounds, MainShip mainShip) {
        this.worldBounds = worldBounds;
        this.mainShip = mainShip;
    }
    @Override
    protected Revision newObject() {
        return new Revision(worldBounds, mainShip);
    }
}
