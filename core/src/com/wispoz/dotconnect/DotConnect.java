package com.wispoz.dotconnect;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.viewport.FillViewport;

public class DotConnect implements ApplicationListener {


    OrthographicCamera camera;
    private Stage stage;
    Pool<MoveToAction> pool = new Pool<MoveToAction>() {
        protected MoveToAction newObject () {
            return new MoveToAction();
        }
    };
    @Override
    public void create() {
        Gdx.app.log("SCREEN",Gdx.graphics.getWidth()+":WH:"+ Gdx.graphics.getHeight());
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
        stage = new MainStage();
        stage.setViewport(new FillViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),camera));

        Group background = new Group();
        background.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Group foreground = new Group();
        foreground.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage.addActor(background);
        stage.addActor(foreground);
        foreground.addActor(new Buttons());
        background.addActor(new BackgroundActor());

        stage.addListener(new StageInputListener());
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling?GL20.GL_COVERAGE_BUFFER_BIT_NV:0));
        if(Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), Gdx.input.getY());
            camera.unproject(touchPos);
            MoveToAction moveAction = pool.obtain();
            moveAction.setPool(pool);
            moveAction.setPosition(touchPos.x, touchPos.y);
            moveAction.setDuration(1f);
            stage.getRoot().findActor("menu_button").addAction(moveAction);

        }
        camera.update();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
    //    stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}
