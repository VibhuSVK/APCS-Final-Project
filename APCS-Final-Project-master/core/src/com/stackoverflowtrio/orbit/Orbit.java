package com.stackoverflowtrio.orbit;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Screens.MainMenuScreen;
import Screens.PlayScreen;

public class Orbit extends Game {
	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 208;
	public static final float PPM = 100;
	public SpriteBatch batch;
	Texture img;
	private float musicVol = (float) 0.5;
	private PlayScreen playScreen;
	private MainMenuScreen menuScreen;
	@Override
	public void create () {
		
		batch = new SpriteBatch();
		menuScreen = new MainMenuScreen(this);
		this.setScreen(menuScreen);
//		Music music = Gdx.audio.newMusic(Gdx.files.internal("data/AmbientSong.mp3"));
//		music.setVolume(musicVol);
//		music.setLooping(true);
//		music.play();
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
	public void changeScreen(int screen){
	switch(screen){
		case 0:
			if(menuScreen == null) menuScreen = new MainMenuScreen(this);
                        this.setScreen(menuScreen);
			break;
		case 1:
			if(playScreen == null) playScreen = new PlayScreen(this);
						this.setScreen(playScreen);
		
	}
}

}
