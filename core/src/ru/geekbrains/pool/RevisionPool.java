package ru.geekbrains.pool;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.base.SpritesPool;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.MainShip;
import ru.geekbrains.sprite.Revision;

public class RevisionPool extends SpritesPool <Revision> {

    private Revision revision;
    private MainShip mainShip;
    private Rect worldBounds;

    public RevisionPool(Rect worldBounds, MainShip mainShip) {
      this.worldBounds = worldBounds;
      this.mainShip = mainShip;
    }

    @Override
    protected Revision newObject() {
        return new Revision(revision, mainShip);
    }
}
