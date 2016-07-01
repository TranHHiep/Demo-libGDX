package com.mygdx.tranhoanghiep2.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by TranHiep on 6/28/2016.
 */
public class StateManager {
    private Stack<State> states;
    public StateManager()
    {
        states=new Stack<State>();
    }
    public void push(State state)
    {
        states.push(state);
    }
    public void pop()
    {
        states.pop().dispose();
    }
    public void set(State state)
    {
        states.pop();
        states.push(state);
    }
    public void update(float deltaTime)
    {
        states.peek().update(deltaTime);
    }
    public void render(SpriteBatch spriteBatch)
    {
        states.peek().render(spriteBatch);
    }
}
