package com.pennypop.project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.backends.openal.Mp3.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

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
	private final Button SFXButton;
	private final Button APIButton;
	private final Button GameButton;
	private final Skin images;
	private final com.badlogic.gdx.audio.Sound SFXClick;
	
	
	public MainScreen() {
		spriteBatch = new SpriteBatch();
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false, spriteBatch);
		font = new BitmapFont(Gdx.files.internal("assets/font.fnt"),
		         Gdx.files.internal("assets/font.png"), false);
		buttons = new TextureAtlas("assets/PPButtons.pack");
		images = new Skin();
		images.addRegions(buttons);
		SFXButton = new Button(images.getDrawable("sfxButton"));
		SFXButton.setPosition(295, 310);
		APIButton = new Button(images.getDrawable("apiButton"));
		APIButton.setPosition(405, 310);
		GameButton = new Button(images.getDrawable("gameButton"));
		GameButton.setPosition(515, 310);
		SFXClick = Gdx.audio.newSound(Gdx.files.internal("assets/button_click.wav"));
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
		stage.addActor(SFXButton);
		stage.addActor(APIButton);
		stage.addActor(GameButton);
		spriteBatch.begin();
		font.setColor(Color.RED);
		font.draw(spriteBatch, "PennyPop", 455 - font.getBounds("PennpyPop").width/2, 
				460 + font.getBounds("PennyPop").height/2);
		if (SFXButton.isPressed())
			SFXClick.play();
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
