package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class PlayerCharacterMove {
	private static int movement;
	
	private Vector2 position;
	private Vector2 velocity;
	private Animation test;
	
	private int[][] arr;
	
	public PlayerCharacterMove(int x, int y,int m) {
		arr = new int[][]{
			{0,1,2},{3,4,5}
		};
		position = new Vector2(x,y);
		velocity = new Vector2(0,0);
		test = new Animation(new TextureRegion(new Texture("spriteSheetTest.png")),6,0.5f,arr);
		movement = m;
		test.setAnimation(0);
	}
	
	public void update(float dt) {
		velocity.scl(dt);
		position.add(velocity.x,velocity.y);
		test.update(dt);
		velocity.scl(1/dt);
	}
	
	public int getMovement() {
		return movement;
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public Vector2 getVelocity() {
		return velocity;
	}
	public TextureRegion getTexture() {
		return test.getFrame();
	}
	
	public void setAnimation(int index) {
		test.setAnimation(index);
	}
}
