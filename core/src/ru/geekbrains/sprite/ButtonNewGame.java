package ru.geekbrains.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.base.ScaledTouchUpButton;
import ru.geekbrains.math.Rect;
import ru.geekbrains.screen.GameScreen;

public class ButtonNewGame extends ScaledTouchUpButton {
    private Rect wordBounds;

    // private Game game;

    public ButtonNewGame(TextureAtlas atlas) {
        super(atlas.findRegion("button_new_game"));
       // this.game = game;
        setHeightProportion(0.2f);
    }

    @Override
    public void resize(Rect worldBounds) {
        //super.resize(worldBounds);
        setBottom(wordBounds.getBottom() + 0.03f);
    }

    @Override
    public void action() {
        new GameScreen();
    }
}
