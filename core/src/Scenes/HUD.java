package Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.stackoverflowtrio.orbit.Orbit;

public class HUD implements Disposable{
	public Stage stage;
	private Viewport viewport;
	
	private Integer worldTimer;
	private float timerCount;
	private Integer health;
	private Integer fuel; 
	private float weapon1;
	private float weapon2;
	private float inventory1;
	private float inventory2;
	private float inventory3;
	private float inventory4;
	private float inventory5;
	private float inventory6;
	private float inventory7;
	private float inventory8;
	
	Label levelLabel;
	Label characterLabel;
	Label timeLabel;
	Label countdownLabel;
	Label worldLabel;
	Label characterNameLabel;
	Label weapon1Label;
	Label weapon2Label;
	Label inventory1Label;
	Label inventory2Label;
	Label inventory3Label;
	Label inventory4Label;
	Label inventory5Label;
	Label inventory6Label;
	Label inventory7Label;
	Label inventory8Label;
	
	public HUD(SpriteBatch sb) {
		worldTimer = 900;
		health = 0;
		fuel = 0;
	
		viewport = new FitViewport(Orbit.V_WIDTH, Orbit.V_HEIGHT, new OrthographicCamera());
		stage = new Stage(viewport, sb);
	
		Table table = new Table();
		table.top();
		table.setFillParent(true);
		
		levelLabel = new Label("Level", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		characterLabel = new Label("Character", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		timeLabel = new Label("Timer", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		worldLabel = new Label("Mars", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		characterNameLabel = new Label("Unknown", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		countdownLabel = new Label(String.format("%03d", worldTimer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		
		weapon1Label = new Label("Primary", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		weapon2Label = new Label("Secondary", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		
		inventory1Label = new Label("Item 1", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		inventory2Label = new Label("Item 2", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		inventory3Label = new Label("Item 3", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		inventory4Label = new Label("Item 4", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		inventory5Label = new Label("Item 5", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		inventory6Label = new Label("Item 6", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		inventory7Label = new Label("Item 7", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		inventory8Label = new Label("Item 8", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		
		table.add(levelLabel).expandX().padTop(10);
		table.add(characterLabel).expandX().padTop(10);
		table.add(timeLabel).expandX().padTop(10);
		table.row();
		table.add(worldLabel).expandX();
		table.add(characterNameLabel).expandX();
		table.add(countdownLabel).expandX();
		
		stage.addActor(table);
	}
	
	public void update(float dt) {
		timerCount += dt;
		if (timerCount >= 1) {
			worldTimer--;
			countdownLabel.setText(String.format("%03d", worldTimer));
			timerCount = 0;
		}
	}
	
	public void addScore(int value) {
		
	}
	
	public void dispose() {
		stage.dispose();
	}
}
