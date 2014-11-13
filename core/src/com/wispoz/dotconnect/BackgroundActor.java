package com.wispoz.dotconnect;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by wispoz on 10.11.14.
 */
public class BackgroundActor extends Actor {
    private Texture backgroundTexture;
    private Sprite backgroundSprite;

    public BackgroundActor() {
        backgroundTexture = new Texture("Levels01night.png");
        backgroundSprite = new Sprite(backgroundTexture);
        backgroundSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void draw(Batch batch, float alpha) {
        backgroundSprite.draw(batch);
    }
}