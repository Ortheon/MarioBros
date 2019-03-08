package com.ortheon.mariobros;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ortheon.mariobros.screens.PlayScreen;

public class MarioBros extends Game {
	public SpriteBatch batch;
	public final static int V_WIDTH = 400;
	public final static int V_HEIGHT = 208;
	public final static float PPM = 100;

	public static final short DEFAULT_BIT 	= 1;
	public static final short MARIO_BIT 	= 2;
	public static final short BRICK_BIT 	= 4;
	public static final short COIN_BIT 		= 8;
	public static final short DESTROYED_BIT = 16;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {
		//delegetes render to playscreen??
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}