package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private SpriteBatch batch;
    private Texture img;

    private Vector2 touch;
    private Vector2 v0;
    private Vector2 v;
    private Vector2 v2;
    private Vector2 v3;
    private Vector2 pos;
    private Vector2 pos2;

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        touch = new Vector2();
        v0 = new Vector2();
        v = new Vector2(0,0);
        v2 = new Vector2();
        v3 = new Vector2(0, 0);
        pos = new Vector2();
        pos2 = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.4f, 0.3f, 0.9f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
        if (!touch.isZero()) {
            v0.add(v3);
            if (v0.len() < pos2.len()) {
                pos.add(v3);
           }
            else {
                touch.setZero();
            }
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        v0.set(0,0);
        pos2.set(0,0);
        v.set(pos.x, pos.y);
        System.out.println("pos.x= " + pos.x + "pos.y= " + pos.y);
        v2.set(touch.x, touch.y);
        v3 = v2.sub(v);
        pos2.add(v3);
        v.nor();
        v2.nor();
        return false;
    }

}
