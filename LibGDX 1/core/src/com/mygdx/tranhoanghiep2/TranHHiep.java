package com.mygdx.tranhoanghiep2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.tranhoanghiep2.States.MenuState;
import com.mygdx.tranhoanghiep2.States.StateManager;
import com.sun.org.apache.xpath.internal.operations.String;

public class TranHHiep extends ApplicationAdapter {
	public static final int WIDTH=800;
	public static final int HEIGHT=480;
	public static final java.lang.String TITLE="Jumping";
	private StateManager stateManager;
	private SpriteBatch batch;


//	Texture img;
	
	@Override
	public void create () {
		stateManager=new StateManager();
		batch = new SpriteBatch();
		/*img = new Texture("badlogic.jpg");*/
		stateManager.push(new MenuState(stateManager));
	}

	@Override
	public void render () {
		/*Gdx.gl.glClearColor(1, 0, 0, 1);*/
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		/*batch.begin();
		batch.draw(img, 0, 0);
		batch.end();*/
		stateManager.update(Gdx.graphics.getDeltaTime());
		stateManager.render(batch);
	}
	
	@Override
	public void dispose () {
		super.dispose();
		/*img.dispose();*/
	}
}
