package com.wispoz.dotconnect;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;

/**
 * Created by wispoz on 10.11.14.
 */
public class Buttons extends Actor {
    private Texture backgroundTexture;
    InputListener inputListener = new MenuListener(this);
    TextureRegion    regions;
    public Buttons() {
        backgroundTexture = new Texture("Buttons.png");
        regions = new TextureRegion(backgroundTexture, 60, 180, 60,60);
        setBounds(getX(), getY(), 60, 60);
        this.addListener(inputListener);
    }
    public void draw(Batch batch, float alpha) {
        batch.draw(regions,getX(), getY());
    }

}