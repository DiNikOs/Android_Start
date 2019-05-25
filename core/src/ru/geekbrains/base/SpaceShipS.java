package ru.geekbrains.base;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.math.Rect;

public class SpaceShipS extends Sprite {

    public SpaceShipS(TextureRegion region) {
        super(region);
        this.regions = new TextureRegion[1];
        this.regions[0] = region;
        regions[0].setRegionWidth(regions[frame].getRegionWidth()/2);
    }

    public void setLeftHalf() {
        regions[frame].setRegionWidth(regions[frame].getRegionWidth()/2);
    }

    public void setRightHalf() {
        regions[frame].setRegionX(regions[frame].getRegionX() + regions[frame].getRegionWidth()/2);
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
