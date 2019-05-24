package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class BadLogic extends Sprite {

    public BadLogic(TextureRegion region) {
        super(region);
        regions[frame].getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    @Override
    public void resize(Rect wordBounds) {
        setHeightProportion(0.2f);
    }
}
