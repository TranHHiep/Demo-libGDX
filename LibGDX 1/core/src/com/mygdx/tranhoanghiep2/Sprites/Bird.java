package com.mygdx.tranhoanghiep2.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by TranHiep on 6/29/2016.
 */
public class Bird {
    public static final int GRAVITY=-15;
    private static final int MOVEMENT=200;
    private Vector3 position;
    private Vector3 velocity;
    private Rectangle bounds;
    private Texture texture;
    private Texture bird;
    public Vector3 getPosition()
    {
        return position;
    }
    public Texture getBird()
    {
        return bird;
    }
    public Bird(int x,int y)
    {
        position=new Vector3(x,y,0);
        velocity=new Vector3(0,0,0);
        bird=new Texture("bird.png");
        bounds=new Rectangle(x,y,bird.getWidth(),bird.getHeight());
    }

    public void update(float deltaTime)
    {
        if (position.y>0)
            velocity.add(0,GRAVITY,0);
        velocity.scl(deltaTime);
        position.add(MOVEMENT*deltaTime,velocity.y,0);
        if (position.y<62)
            position.y=62;

        velocity.scl(1/deltaTime);
        bounds.setPosition(position.x,position.y);
    }
    public void jump()
    {
        if (position.y==62)
            velocity.y=400;//nhay len 400
    }
    public Rectangle getBounds()
    {
        return bounds;
    }
    public void dispose()
    {
        texture.dispose();
    }
}
