package com.mygdx.birdylife;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;


public class Plane {
    public Vector2 position;
    public Sprite sprite;
    public Plane(Vector2 positionVal, Texture img)
    {
        position = positionVal;
        sprite = new Sprite(img);
        sprite.setScale(4);
    }
    public void Draw(Sprite batch)
    {
        sprite.setPosition(position.x, position.y);
    }

}
