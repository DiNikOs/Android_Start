package ru.geekbrains.base;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.math.Rect;

public class SpaceShipS extends Sprite {

    public final int PARTCOUNT = 2;
    public final int LEFTWIDTH;
    public final int REG_X;

    public SpaceShipS(TextureRegion region) {
        super(region);
        this.regions = new TextureRegion[1];
        this.regions[0] = region;
        LEFTWIDTH = region.getRegionWidth()/PARTCOUNT;
        REG_X = region.getRegionX();
        regions[0].setRegionX(REG_X-LEFTWIDTH);
        regions[0].setRegionWidth(LEFTWIDTH);
    }

    public void setLeftHalf() {
        regions[0].setRegionX(REG_X);
        regions[0].setRegionWidth(LEFTWIDTH);
    }

    public void setRightHalf() {
        regions[0].setRegionWidth(LEFTWIDTH);
        regions[0].setRegionX(REG_X + LEFTWIDTH);
    }

    @Override
    public void update(float delta) {
        //super.update(delta);
    }

    @Override
    public void resize(Rect wordBounds) {
        //super.resize(wordBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        return false;
    }
}
