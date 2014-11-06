package com.wispoz.dotconnect;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;

/**
 * Created by wispoz on 06.11.14.
 */
public class Jet extends Actor {
    Texture texture = new Texture(Gdx.files.internal("jet.png"));
    @Override
    public void draw(Batch batch, float alpha){
        batch.draw(texture,0,0);
    }
}