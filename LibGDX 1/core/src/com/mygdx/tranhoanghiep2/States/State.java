package com.mygdx.tranhoanghiep2.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by TranHiep on 6/28/2016.
 */
public abstract class State {
    protected OrthographicCamera orthographicCamera;
    protected Vector3 vector3;
    protected StateManager stateManager;
    protected State(StateManager stateManager)
    {
        this.stateManager=stateManager;
        orthographicCamera=new OrthographicCamera();
        vector3=new Vector3();
    }
    protected abstract void handleInput();
    public abstract void update(float deltaTime);
    public abstract void render(SpriteBatch spriteBatch);
    public abstract void dispose();
}
