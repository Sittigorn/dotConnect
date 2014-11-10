package com.wispoz.dotconnect;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by wispoz on 10.11.14.
 */
public class Buttons extends Actor {
    private Texture backgroundTexture;
    TextureRegion    regions;
    public Buttons() {
        backgroundTexture = new Texture("Buttons2.png");
        regions = new TextureRegion(backgroundTexture, 20, 20, 50, 50);
    }
    public void draw(Batch batch, float alpha) {
        batch.draw(regions,7,10);
    }

}