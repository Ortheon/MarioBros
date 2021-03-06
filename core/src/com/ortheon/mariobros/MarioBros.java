package com.ortheon.mariobros;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ortheon.mariobros.screens.PlayScreen;

public class MarioBros extends Game {
	public SpriteBatch 			batch;
	public final static int 	V_WIDTH 		= 400;
	public final static int 	V_HEIGHT 		= 208;
	public final static float 	PPM 			= 100;

	public static final short GROUND_BIT 		= 1;
	public static final short MARIO_BIT 		= 2;
	public static final short BRICK_BIT 		= 4;
	public static final short COIN_BIT 			= 8;
	public static final short DESTROYED_BIT 	= 16;
	public static final short OBJECT_BIT 		= 32;
	public static final short ENEMY_BIT 		= 64;
	public static final short ENEMY_HEAD_BIT	= 128;


	public static AssetManager manager;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		manager = new AssetManager();
		manager.load("audio/music/mario_music.ogg", Music.class);
		manager.load("audio/sounds/coin.wav", Sound.class);
		manager.load("audio/sounds/bump.wav", Sound.class);
		manager.load("audio/sounds/breakblock.wav", Sound.class);
		manager.finishLoading();
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
		manager.dispose();
	}


}
