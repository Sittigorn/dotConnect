package com.wispoz.dotconnect;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

/**
 * Created by wispoz on 06.11.14.
 */
public class Jet extends Actor {

    Texture texture = new Texture(Gdx.files.internal("circle.png"));
    InputListener inputListener = new ActorInputListener(this);
       public Jet(){
           setBounds(getX(),getY(),texture.getWidth(),texture.getHeight());
           this.addListener(inputListener);
       }
    @Override
    public void draw(Batch batch, float alpha){
        batch.draw(texture, getX(), getY());
    }

}