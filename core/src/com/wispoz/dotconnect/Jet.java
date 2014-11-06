package com.wispoz.dotconnect;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;

/**
 * Created by wispoz on 06.11.14.
 */
public class Jet extends Actor {

    Texture texture = new Texture(Gdx.files.internal("jet.png"));
    InputListener inputListener = new InputListener();
       public Jet(){
           setBounds(getX(),getY(),texture.getWidth(),texture.getHeight());
       }
    @Override
    public void draw(Batch batch, float alpha){
        batch.draw(texture,this.getX(),getY());
    }

}