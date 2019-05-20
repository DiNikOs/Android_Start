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
    private Vector2 v;
    private Vector2 v2;
    private Vector2 v3;
    private Vector2 pos;
    private float topBorder;
    private float rightBorder;
    private float bottomBorder;
    private float leftBorder;
    private float w;
    private float h;

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        touch = new Vector2();
        v = new Vector2(0,0); //0.8f,0.8f
        v2 = new Vector2();
        v3 = new Vector2(0, 0);
        pos = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.4f, 0.3f, 0.9f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
        topBorder = pos.x + img.getWidth();
        rightBorder = pos.y + img.getHeight();
        if (!touch.isZero()) {
            if (pos.x != touch.x && pos.y != touch.y) {
                pos.add(v3);
           }
            else pos.add(pos.x,pos.y);
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
        v.set(pos.x, pos.y);
        System.out.println("pos.x= " + pos.x + "pos.y= " + pos.y);
        System.out.println("v = " + v);
        v2.set(touch.x, touch.y);
        System.out.println("v2 = " + v2);
            v3 = v2.sub(v);
        v.nor();
        v2.nor();
        System.out.println("v_dot = " + v.dot(v2));

        System.out.println("v3 = " + v3);
        v3.nor();
        System.out.println("v3_nor = " + v3);
        System.out.println("touch.x = " + touch.x + " touch.y = " + touch.y);


        return false;
    }

}
