package com.wispoz.dotconnect;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.utils.Pool;


/**
 * Created by wispoz on 06.11.14.
 */
public class ActorInputListener extends InputListener implements InputProcessor {
    Actor jet;
    MoveToAction prev;
    Pool<MoveToAction> pool = new Pool<MoveToAction>() {
        protected MoveToAction newObject () {
            return new MoveToAction();
        }
    };
    public ActorInputListener(Actor jet){
        this.jet = jet;
    }

    @Override
    public boolean keyDown(int keycode) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Gdx.app.log("ACTOR","TOUCH!!");
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        Gdx.app.log("ACTOR","TOUCH!! UP");
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        Gdx.app.log("BUBBLE", "touchdown");

        return true;  // must return true for touchUp event to occur
    }
    @Override
    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
        this.jet.removeAction(prev);
         MoveToAction moveAction = pool.obtain();
         moveAction.setPool(pool);
         moveAction.setPosition(x, y);
         moveAction.setDuration(2f);
         moveAction.setInterpolation(Interpolation.pow2Out);
         this.jet.addAction(moveAction);
         this.prev = moveAction;

    }


}
