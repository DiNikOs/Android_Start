package ru.geekbrains.sprite;

        import com.badlogic.gdx.graphics.g2d.TextureAtlas;
        import com.badlogic.gdx.graphics.g2d.TextureRegion;

        import ru.geekbrains.base.Sprite;

public class NameGame extends Sprite {

    public NameGame(TextureAtlas revision) {
        super(revision.findRegion("spaceBattle"));
        setHeightProportion(0.3f);
        setBottom(-0.1f);
    }
}
