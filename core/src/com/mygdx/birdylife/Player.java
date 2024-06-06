package com.mygdx.birdylife;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position;
    public Sprite sprite;
    public float speed = 300;
    public Player(Texture img)
    {
        sprite = new Sprite(img);
        position = new Vector2(0,sprite.getScaleY()*sprite.getHeight());
        sprite.setScale(1);
    }
    public void Update(float deltaTime)
    {
        if (Gdx.input.isKeyPressed(Input.Keys.W) && position.y <= Gdx.graphics.getHeight() - sprite.getHeight()) 
        {
            position.y+=deltaTime*speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) && position.y>0) position.y-=deltaTime*speed;
        if (Gdx.input.isKeyPressed(Input.Keys.A) && position.x>0) position.x-=deltaTime*speed;
        if (Gdx.input.isKeyPressed(Input.Keys.D) && position.x <= Gdx.graphics.getWidth() - sprite.getWidth()) position.x+=deltaTime*speed;
    }
    public void Draw(SpriteBatch batch)
    {
        Update(Gdx.graphics.getDeltaTime());
        sprite.setPosition(position.x, position.y);
        sprite.draw(batch);
    }
}
