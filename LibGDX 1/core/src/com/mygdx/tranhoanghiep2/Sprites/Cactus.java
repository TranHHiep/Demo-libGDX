package com.mygdx.tranhoanghiep2.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by TranHiep on 6/29/2016.
 */
public class Cactus {
    //public static final int DINO_WIDTH=34;
    private Texture cactus;
    private Rectangle boundCactus;
    private Vector2 posCactus;
    private Random rand;
    public Cactus(float x)
    {
        cactus=new Texture("bird.png");
        rand=new Random();
        posCactus=new Vector2(x,rand.nextInt(150)+62);//Xac dinh do cao vat can
        boundCactus=new Rectangle(posCactus.x,posCactus.y,cactus.getWidth(),cactus.getHeight());
    }
    public Texture getCactus()
    {
        return cactus;
    }

    public Vector2 getPosCactus() {
        return posCactus;
    }
    public void reposition(float x)
    {
        posCactus.set(x,rand.nextInt(150)+62);
        boundCactus.setPosition(posCactus.x,posCactus.y);
    }
    public boolean collides(Rectangle players)
    {
        return players.overlaps(boundCactus);
    }
    public void dispose()
    {
        cactus.dispose();
    }
}
