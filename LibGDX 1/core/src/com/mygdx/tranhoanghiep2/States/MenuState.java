package com.mygdx.tranhoanghiep2.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.tranhoanghiep2.TranHHiep;

/**
 * Created by TranHiep on 6/28/2016.
 */
public class MenuState extends State{
    private Texture background;
    private Texture playBtn;
    public MenuState(StateManager stateManager)
    {
        super(stateManager);
        orthographicCamera.setToOrtho(false, TranHHiep.WIDTH/2,TranHHiep.HEIGHT/2);
        background=new Texture("background.jpg");
        playBtn=new Texture("playbtn.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.isTouched())
        {
            //Chuyen sang Play state
            stateManager.set(new PlayState(stateManager));
        }

    }

    @Override
    public void update(float deltaTime) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.setProjectionMatrix(orthographicCamera.combined);
        spriteBatch.draw(background,0,0);
        spriteBatch.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
