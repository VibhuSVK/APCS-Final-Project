package Screens;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.stackoverflowtrio.orbit.Orbit;

public class MainMenuScreen implements Screen {
	private Viewport viewport;
	private Stage stage;
	private Texture texture;
	private Orbit games;
	private SpriteBatch batch;
	public MainMenuScreen(Orbit game) { 
		 this.games = game;
		 stage = new Stage(new ScreenViewport());
		 Gdx.input.setInputProcessor(stage);
		 batch = new SpriteBatch();
		 texture = new Texture(Gdx.files.internal("MainScreenNew.png"));
		 
		 Table table = new Table();
		 table.center();
		 table.setFillParent(true);
		 table.setDebug(false);
		 
		 
		 
		 stage.addActor(table);
		 Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
		 TextButton newGame = new TextButton("", skin);
		 TextButton tutorial = new TextButton("", skin);
		 TextButton settings = new TextButton("", skin);
		 TextButton exit = new TextButton("", skin);
		 table.row().pad(50, -750, 10, 800);
		 table.add(newGame).fillX().uniform();
		 table.row().pad(10, -750, 10, 600);;
		 table.add(tutorial).fillX().uniform();
		 table.row().pad(10, -750, 10, 600);;
		 table.add(settings).fillX().uniform();
		 table.row().pad(10, -750, 10, 800);;
		 table.add(exit).fillX().uniform();
		 
		 exit.addListener(new ChangeListener() {
			 @Override
			 public void changed(ChangeEvent event, Actor actor) {
				 Gdx.app.exit();
			 }
		 });
		 
		 newGame.addListener(new ChangeListener() {
			 @Override
			 public void changed(ChangeEvent event, Actor actor) {
				games.changeScreen(1);
			 }
		 });
		 //settings.addListener
		 
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(texture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();
		stage.draw();
		
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
		batch.getProjectionMatrix().setToOrtho2D(0, 0, width, height);
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		stage.dispose();
		
	}

}
