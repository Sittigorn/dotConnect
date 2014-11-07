package com.wispoz.dotconnect;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class DotConnect implements ApplicationListener {


    OrthographicCamera camera;
    private Stage stage;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        stage = new MainStage();
        stage.setViewport(new ViewPort());
        stage.addListener(new StageInputListener());
        Gdx.input.setInputProcessor(stage);
        Jet myActor = new Jet();
        stage.addActor(myActor);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        if(Gdx.input.isTouched()) {
//            Vector3 touchPos = new Vector3();
//            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
//            camera.unproject(touchPos);
//            stage.getRoot().findActor("circle").setX(touchPos.x - 64 / 2);
//        }
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}
