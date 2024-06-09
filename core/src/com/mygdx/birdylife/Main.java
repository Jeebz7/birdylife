package com.mygdx.birdylife;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
	long start = System.currentTimeMillis();
	SpriteBatch batch;
	Texture img;
	Texture imgPlane;
	Player player;
	ArrayList<Plane> planes = new ArrayList<>();
	//Plane[] planes = new Plane[8];
	double clock;
	double diffClock;
	double diffTimer = 8;
	double diffVal = 100;
	double planeRate = 4.0;
	int activeCount = 0;
	//int diffValue = 100;
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("bird.png");
		player = new Player(img);
		imgPlane = new Texture("plane.png");
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		//System.out.println(System.currentTimeMillis() - start);
		batch.begin();
		player.Draw(batch);
		clock += Gdx.graphics.getDeltaTime();
		diffClock += Gdx.graphics.getDeltaTime();
		//diffTimer += Gdx.graphics.getDeltaTime();
		for (int i = 0; i < planes.size(); i++)
		{
			// if (!(planes.get(i).preUpdate(batch)))
			// {
			// 	planes.remove(i);
			// }
			// else
			// {
				planes.get(i).Draw(batch);
			// }
		}
		if (clock > planeRate)
		{
			double speed = Math.random() * diffVal + 150;
			Plane temp = new Plane(imgPlane, speed);
			planes.add(temp);
			System.out.println(clock);
			clock = 0;
		}
		if ((diffTimer < diffClock) && (diffVal <= 2000))
		{
			diffVal += 80;
			planeRate *= .8;
			diffClock = 0;
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
