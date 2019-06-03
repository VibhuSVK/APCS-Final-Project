package Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
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
	Label worldLabel;
	Label characterLabel;
	Label characterNameLabel;
	Label timeLabel;
	Label countdownLabel;
	Image weapon1Label;
	Image weapon2Label;
	Image inventory1Label;
	Image inventory2Label;
	Image inventory3Label;
	Image inventory4Label;
	Image inventory5Label;
	Image inventory6Label;
	Image inventory7Label;
	Image inventory8Label;
	
	public HUD(SpriteBatch sb) {
		worldTimer = 900;
		health = 0;
		fuel = 0;
	
		viewport = new FitViewport(Orbit.V_WIDTH, Orbit.V_HEIGHT, new OrthographicCamera());
		stage = new Stage(viewport, sb);
	
		Table table = new Table();
		table.top();
		table.setFillParent(true);
		
		//Top bar labels
		levelLabel = new Label("Level", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		characterLabel = new Label("Character", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		timeLabel = new Label("Timer", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		
		//Top bar actual numbers/text
		worldLabel = new Label("Mars", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		characterNameLabel = new Label("Unknown", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		countdownLabel = new Label(String.format("%03d", worldTimer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		
		//Weapon Labels
		weapon1Label = new Image();
		weapon2Label = new Image();
		
		//Inventory Labels
		inventory1Label = new Image();
		inventory2Label = new Image();
		inventory3Label = new Image();
		inventory4Label = new Image();
		inventory5Label = new Image();
		inventory6Label = new Image();
		inventory7Label = new Image();
		inventory8Label = new Image();
		
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
