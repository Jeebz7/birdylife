package com.mygdx.birdylife;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class Plane {
    public Vector2 position;
    public Sprite sprite;
    public float speed;
    public boolean active;
    public boolean touching;

    public Plane(Texture img, double speedVal)
    {
        float f = (float) Math.random();
        position = new Vector2(Gdx.graphics.getWidth() - 100, f * (Gdx.graphics.getHeight()-10));
        sprite = new Sprite(img);
        sprite.setScale(1);
        active = true;
        speed = (float) speedVal;
    }
    // public void changeSpeed(float spd)
    // {
    //     speed = spd;
    // }
    public void Draw(SpriteBatch batch)
    {
        Update(Gdx.graphics.getDeltaTime());
        sprite.setPosition(position.x, position.y);
        sprite.draw(batch);
    }
    public boolean preUpdate(SpriteBatch batch)
    {
        if (position.x < -20)
        {
            return false;
        }
        return true;
    }
    public void Update(float deltaTime)
    {
        position.x -= deltaTime*speed;
    }
}
