package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Background;
import ru.geekbrains.sprite.BadLogic;

public class MenuScreen extends BaseScreen {

//    private SpriteBatch batch;
//    private Texture img;

    private Texture bg;
    private Texture badLogicTexture;
    private Background background;
    private BadLogic badLogic;

    private static float LEN = 2f;


    private Vector2 touch;
    private Vector2 v0;
    private Vector2 v;
    private Vector2 pos;

    @Override
    public void show() {
        super.show();
//        batch = new SpriteBatch();
//        img = new Texture("badlogic.jpg");
        bg = new Texture("bg.jpg");
        background = new Background(new TextureRegion(bg));
        badLogicTexture = new Texture("badlogic.jpg");
        badLogic = new BadLogic(new TextureRegion(badLogicTexture));

        touch = new Vector2();
        v0 = new Vector2();
        v = new Vector2();
        pos = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.4f, 0.3f, 0.9f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        //batch.draw(img, pos.x, pos.y);
        background.draw(batch);
        badLogic.draw(batch);
        batch.end();
        v0.set(touch);
        if (v0.sub(pos).len() <= LEN) {
            pos.set(touch);
        }
        else {
            pos.add(v);
        }
    }

    @Override
    public void dispose() {
        //batch.dispose();
        //img.dispose();
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
        return super.touchDown(touch, pointer);
    }

}
