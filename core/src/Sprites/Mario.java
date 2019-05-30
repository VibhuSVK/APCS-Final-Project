package Sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.stackoverflowtrio.orbit.Orbit;

public class Mario extends Sprite {
	public World world;
	public Body b2body;
	
	public Mario(World world) {
		this.world = world;
		defineMario();
	}
	
	public void defineMario() {
		BodyDef bdef = new BodyDef();
		bdef.position.set(32 / Orbit.PPM, 32 / Orbit.PPM);
		bdef.type = BodyDef.BodyType.DynamicBody;
		b2body = world.createBody(bdef);
		
		FixtureDef fdef = new FixtureDef();
		CircleShape shape = new CircleShape();
		shape.setRadius(5 / Orbit.PPM);
		
		fdef.shape = shape;
		b2body.createFixture(fdef);
	}
}
