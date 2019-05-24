package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class BadLogic extends Sprite {

    private Vector2 pos;


    public BadLogic(TextureRegion region) {
        super(region);
        regions[frame].getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        pos = new Vector2();
    }

    @Override
    public void resize(Rect wordBounds) {
        setHeightProportion(0.2f);
    }

    public void updater (Vector2 pos) {
        this.pos = pos;

    }


    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(
                regions[frame],
                getLeft() + pos.x, getBottom() + pos.y,
                halfWidth, halfHeight,
                getWidth(), getHeight(),
                scale, scale,
                angle
        );
    }
}
