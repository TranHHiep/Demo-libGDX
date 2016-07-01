package com.mygdx.tranhoanghiep2.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.tranhoanghiep2.Sprites.Bird;
import com.mygdx.tranhoanghiep2.Sprites.Cactus;
import com.mygdx.tranhoanghiep2.TranHHiep;


import java.util.Random;

/**
 * Created by TranHiep on 6/29/2016.
 */
public class PlayState extends State{
    private static final int CACTUS_NUMBER=5;
    private static final int CACTSUS_MIN_SPACING=280;
    private Bird bird;
    private Texture bg;
    private Texture ground;
    private Vector2 groundPos1,groundPos2,groundPos3,groundPos4;
    private Array<Cactus> cactuses = new Array<Cactus>();
    public Random random;

    public PlayState(StateManager stateManager)
    {

        super(stateManager);
        random=new Random();
        bird=new Bird(50,300);//Vi tri bat dau cua bird

        orthographicCamera.setToOrtho(false, TranHHiep.WIDTH/2,TranHHiep.HEIGHT/2);
        bg=new Texture("background.jpg");
        ground=new Texture("ground.png");
        groundPos1=new Vector2(0,-50);
        groundPos2=new Vector2(ground.getWidth(),-50);
        groundPos3=new Vector2(ground.getWidth()*2,-50);
        groundPos4=new Vector2(ground.getWidth()*3,-50);

        for(int i=1;i<CACTUS_NUMBER;i++)
        {
            cactuses.add(new Cactus(i*CACTSUS_MIN_SPACING+random.nextInt(60)));
        }

    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched())
            bird.jump();
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
        //Them update ground
        updateGround();
        bird.update(deltaTime);
        orthographicCamera.position.x=bird.getPosition().x+80;

        for (Cactus cactus:cactuses)
        {
            if (orthographicCamera.position.x-(orthographicCamera.viewportWidth/2)>
                    cactus.getPosCactus().x+cactus.getCactus().getWidth())
                cactus.reposition(cactus.getPosCactus().x+1200);
            if (cactus.collides(bird.getBounds()))
                stateManager.set(new MenuState(stateManager));
        }
        orthographicCamera.update();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(orthographicCamera.combined);
        spriteBatch.begin();
        spriteBatch.draw(bg,orthographicCamera.position.x-(orthographicCamera.viewportWidth/2),0);
        spriteBatch.draw(bird.getBird(),bird.getPosition().x,bird.getPosition().y);

        for (Cactus cactus:cactuses)
        {
            spriteBatch.draw(cactus.getCactus(),cactus.getPosCactus().x,cactus.getPosCactus().y);
        }
        spriteBatch.draw(ground,groundPos1.x,groundPos1.y);
        spriteBatch.draw(ground,groundPos2.x,groundPos2.y);
        spriteBatch.draw(ground,groundPos3.x,groundPos3.y);
        spriteBatch.draw(ground,groundPos4.x,groundPos4.y);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        bird.dispose();
        ground.dispose();
        for (Cactus cactus:cactuses)
            cactus.dispose();

    }
    private void updateGround()
    {
        if (orthographicCamera.position.x-(orthographicCamera.viewportWidth/2)>groundPos1.x+ground.getWidth())
            groundPos1.add(ground.getWidth()*4,0);
        if (orthographicCamera.position.x-(orthographicCamera.viewportWidth/2)>groundPos2.x+ground.getWidth())
            groundPos2.add(ground.getWidth()*4,0);
        if (orthographicCamera.position.x-(orthographicCamera.viewportWidth/2)>groundPos3.x+ground.getWidth())
            groundPos3.add(ground.getWidth()*4,0);
        if (orthographicCamera.position.x-(orthographicCamera.viewportWidth/2)>groundPos4.x+ground.getWidth())
            groundPos4.add(ground.getWidth()*4,0);
    }

}
