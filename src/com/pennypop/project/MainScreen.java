package com.pennypop.project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * This is where you screen code will go, any UI should be in here
 * 
 * @author Richard Taylor
 */
public class MainScreen implements Screen {
	
	private final Stage stage;
	private final SpriteBatch spriteBatch;
	private final BitmapFont font;
	
	public MainScreen() {
		spriteBatch = new SpriteBatch();
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false, spriteBatch);
		font = new BitmapFont(Gdx.files.internal("assets/font.fnt"),
		         Gdx.files.internal("assets/font.png"), false);
		
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
		font.draw(spriteBatch, "PennyPop", 640 - font.getBounds("PennpyPop").width/2, 
				360 + font.getBounds("PennyPop").height/2);
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
