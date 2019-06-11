package ru.geekbrains.utils;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.math.Rect;
import ru.geekbrains.math.Rnd;
import ru.geekbrains.pool.RevisionPool;
import ru.geekbrains.sprite.Revision;

public class RevisionGenerator {

    private static final float REVISION_HEIGHT = 0.1f;

    private static final int REVISION_GIFT_DAMAGE = 1;
    private static final float REVISION_GIFT_RELOAD_INTERVAL = 3f;
    private static final int REVISION_GIFT_HP = 1;

    private static final int REVISION_LEVELUP_DAMAGE = 1;
    private static final float REVISION_LEVELUP_RELOAD_INTERVAL = 3f;
    private static final int REVISION_LEVELUP_HP = 1;

    private static final int REVISION_MAGNETO_DAMAGE = 1;
    private static final float REVISION_MAGNETO_RELOAD_INTERVAL = 3f;
    private static final int REVISION_MAGNETO_HP = 1;

    private static final int REVISION_REPAIR_DAMAGE = 1;
    private static final float REVISION_REPAIR_RELOAD_INTERVAL = 3f;
    private static final int REVISION_REPAIR_HP = 1;

    private static final int REVISION_SHIELD_DAMAGE = 1;
    private static final float REVISION_SHIELD_RELOAD_INTERVAL = 3f;
    private static final int REVISION_SHIELD_HP = 1;

    private static final int REVISION_SLOW_DAMAGE = 1;
    private static final float REVISION_SLOW_RELOAD_INTERVAL = 3f;
    private static final int REVISION_SLOW_HP = 1;

    private static final int REVISION_UPGRADE_DAMAGE = 1;
    private static final float REVISION_UPGRADE_RELOAD_INTERVAL = 3f;
    private static final int REVISION_UPGRADE_HP = 1;

    private static final int REVISION_MEDAL_DAMAGE = 1;
    private static final float REVISION_MEDAL_RELOAD_INTERVAL = 3f;
    private static final int REVISION_MEDAL_HP = 1;

    private Rect worldBounds;

    private float generateInterval = 4f;
    private float generateTimer;

    private final TextureRegion[] gift;
    private final TextureRegion[] levelUp;
    private final TextureRegion[] magneto;
    private final TextureRegion[] repair;
    private final TextureRegion[] shield;
    private final TextureRegion[] slow;
    private final TextureRegion[] upgrade;
    private final TextureRegion[] medal;


    private final Vector2 revisionV = new Vector2(0f, -0.1f);
    private final Vector2 revisionV2 = new Vector2(0f, -0.2f);
    private final Vector2 revisionV3 = new Vector2(0f, -0.3f);

    private RevisionPool revisionPool;

    private int level;

    public RevisionGenerator(Rect worldBounds, RevisionPool revisionPool, TextureAtlas revision) {
        this.worldBounds = worldBounds;
        this.revisionPool = revisionPool;
        TextureRegion textureRegion0 = revision.findRegion("Gift");
        this.gift =  Regions.split(textureRegion0, 1, 2, 2);
        TextureRegion textureRegion1 = revision.findRegion("LevelUp");
        this.levelUp = Regions.split(textureRegion0, 1, 2, 2);
        TextureRegion textureRegion2 = revision.findRegion("Magneto");
        this.magneto = Regions.split(textureRegion0, 1, 2, 2);
        TextureRegion textureRegion3 = revision.findRegion("repair");
        this.repair = Regions.split(textureRegion0, 1, 2, 2);
        TextureRegion textureRegion4 = revision.findRegion("Shield");
        this.shield = Regions.split(textureRegion0, 1, 2, 2);
        TextureRegion textureRegion5 = revision.findRegion("Slow");
        this.slow = Regions.split(textureRegion0, 1, 2, 2);
        TextureRegion textureRegion6 = revision.findRegion("Upgrade");
        this.upgrade = Regions.split(textureRegion0, 1, 2, 2);
        TextureRegion textureRegion7 = revision.findRegion("Medal");
        this.medal = Regions.split(textureRegion0, 1, 2, 2);
    }

    public void generate(float delta, int frags) {
        level = frags / 10 + 1;
        generateTimer += delta;
        if (generateTimer >= generateInterval) {
            generateTimer = 0f;
            //Enemy enemy = enemyPool.obtain();
            Revision revision = revisionPool.obtain();

            float type = (float) Math.random();
            if (type < 0.05f) {
                revision.set(
                        gift,
                        revisionV,
                        REVISION_GIFT_DAMAGE,
                        REVISION_GIFT_RELOAD_INTERVAL,
                        REVISION_HEIGHT,
                        REVISION_GIFT_HP
                );
            } else if (type < 0.10f) {
                revision.set(
                        levelUp,
                        revisionV,
                        REVISION_LEVELUP_DAMAGE,
                        REVISION_LEVELUP_RELOAD_INTERVAL,
                        REVISION_HEIGHT,
                        REVISION_LEVELUP_HP
                );

            } else if (type < 0.15f) {
                revision.set(
                        magneto,
                        revisionV,
                        REVISION_MAGNETO_DAMAGE,
                        REVISION_MAGNETO_RELOAD_INTERVAL,
                        REVISION_HEIGHT,
                        REVISION_MAGNETO_HP
                );
            } else if (type < 0.20f) {
                revision.set(
                        repair,
                        revisionV,
                        REVISION_REPAIR_DAMAGE,
                        REVISION_REPAIR_RELOAD_INTERVAL,
                        REVISION_HEIGHT,
                        REVISION_REPAIR_HP
                );
            } else if (type < 0.25f) {
                revision.set(
                        shield,
                        revisionV,
                        REVISION_SHIELD_DAMAGE,
                        REVISION_SHIELD_RELOAD_INTERVAL,
                        REVISION_HEIGHT,
                        REVISION_SHIELD_HP
                );
            } else if (type < 0.30f) {
                revision.set(
                        slow,
                        revisionV,
                        REVISION_SLOW_DAMAGE,
                        REVISION_SLOW_RELOAD_INTERVAL,
                        REVISION_HEIGHT,
                        REVISION_SLOW_HP
                );
            } else if (type < 0.35f) {
                revision.set(
                        upgrade,
                        revisionV,
                        REVISION_UPGRADE_DAMAGE,
                        REVISION_UPGRADE_RELOAD_INTERVAL,
                        REVISION_HEIGHT,
                        REVISION_UPGRADE_HP
                );
            }else if (type < 0.40f) {
                revision.set(
                        medal,
                        revisionV,
                        REVISION_MEDAL_DAMAGE,
                        REVISION_MEDAL_RELOAD_INTERVAL,
                        REVISION_HEIGHT,
                        REVISION_MEDAL_HP
                );
            }
            revision.pos.x = Rnd.nextFloat(worldBounds.getLeft() + revision.getHalfWidth(), worldBounds.getRight() - revision.getHalfWidth());
            revision.setBottom(worldBounds.getTop());
        }
    }

    public int getLevel() {
        return level;
    }
}
