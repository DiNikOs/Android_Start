package ru.geekbrains.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.SpaceShipS;
import ru.geekbrains.math.Rect;

public class ShipMain extends SpaceShipS {

    protected static float LEN = 0.05f;
    private Vector2 touch;
    private Vector2 v0;
    private Vector2 v;

    public ShipMain(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship"));
        touch = new Vector2();
        v0 = new Vector2();
        v = new Vector2();
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        v0.set(touch);
        if (v0.sub(pos).len() <= LEN) {
            pos.set(touch);
        } else {
            pos.add(v);
        }
    }

    @Override
    public void resize(Rect wordBounds) {
        setHeightProportion(0.15f);
        setBottom(wordBounds.getBottom() + 0.03f);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        super.touchDown(touch, pointer);
        this.touch = touch;
        v.set(touch.cpy().sub(pos).setLength(LEN));
        return false;
    }



}
