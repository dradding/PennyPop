package com.pennypop.project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


/**
 * This is where you screen code will go, any UI should be in here
 * 
 * @author Richard Taylor
 */
public class MainScreen implements Screen {
	
	private final Stage stage;
	private final SpriteBatch spriteBatch;
	private final BitmapFont font;
	private final TextureAtlas buttons; //Image of all buttons
	private final TextureRegion SFX;
	private final TextureRegion API;
	private final TextureRegion Game;
	
	
	public MainScreen() {
		spriteBatch = new SpriteBatch();
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false, spriteBatch);
		font = new BitmapFont(Gdx.files.internal("assets/font.fnt"),
		         Gdx.files.internal("assets/font.png"), false);
		buttons = new TextureAtlas("assets/PPButtons.pack");
		SFX = buttons.findRegion("sfxButton");
		API = buttons.findRegion("apiButton");
		Game = buttons.findRegion("gameButton");
		
	}

	@Override
	public void dispose() {
		spriteBatch.dispose();
		stage.dispose();
	}

	@Override
	public void render(float delta) {
		stage.act(delta);
		stage.draw();
		spriteBatch.begin();
		font.setColor(Color.RED);
		font.draw(spriteBatch, "PennyPop", 455 - font.getBounds("PennpyPop").width/2, 
				460 + font.getBounds("PennyPop").height/2);
		spriteBatch.draw(SFX, 295, 310);
		spriteBatch.draw(API, 405, 310);
		spriteBatch.draw(Game, 515, 310);
		spriteBatch.end();
	}

	@Override
	public void resize(int width, int height) {
		stage.setViewport(width, height, false);
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void pause() {
		// Irrelevant on desktop, ignore this
	}

	@Override
	public void resume() {
		// Irrelevant on desktop, ignore this
	}
	

}
