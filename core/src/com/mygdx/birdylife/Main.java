package com.mygdx.birdylife;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
	// long elapsedTime = TimeUtils.timeSinceMillis(startTime);
	SpriteBatch batch;
	Texture img;
	Texture imgPlane;
	Player player;
	Plane[] planes;
	int spacingPlanes;
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("bird.png");
		imgPlane = new Texture("plane.png");
		player = new Player(img);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		player.Draw(batch);
		batch.end();
		// System.out.println(elapsedTime);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
