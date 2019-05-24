package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Background;
import ru.geekbrains.sprite.BadLogic;

public class MenuScreen extends BaseScreen {

    //private SpriteBatch batch;
   // private Texture img;

    private Texture bg;
    private Texture badLogicTexture;
    private Background background;
    private BadLogic badLogic;

    protected static float LEN = 0.05f;

    private Vector2 touch;
    private Vector2 v0;
    private Vector2 v;
    private Vector2 v1;
    private Vector2 pos;

    @Override
    public void show() {
        super.show();
        bg = new Texture("bg.jpg");
        background = new Background(new TextureRegion(bg));
        badLogicTexture = new Texture("badlogic.jpg");
        badLogic = new BadLogic(new TextureRegion(badLogicTexture));

        touch = new Vector2();
        v0 = new Vector2();
        v = new Vector2();
        v1 = new Vector2();
        pos = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.4f, 0.3f, 0.9f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        background.draw(batch);
        badLogic.draw(batch);
        batch.end();

        v0.set(v1);
        if (v0.sub(pos).len() <= LEN) {
            pos.set(v1);
        } else {
            pos.add(v);
        }
        badLogic.updater(pos);
    }

    @Override
    public void dispose() {
        bg.dispose();
        badLogicTexture.dispose();
        super.dispose();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        badLogic.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        super.touchDown(touch, pointer);
       // touch.set(touch);
        v1.set(touch);
        System.out.println("pos= " + pos);
        v.set(touch.cpy().sub(pos)).setLength(LEN);
        System.out.println("pos.x= " +pos.x + "pos.y= " + pos.y);
        return super.touchDown(touch, pointer);
    }
}
