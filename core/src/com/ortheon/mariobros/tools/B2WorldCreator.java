package com.ortheon.mariobros.tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.ortheon.mariobros.MarioBros;
import com.ortheon.mariobros.screens.PlayScreen;
import com.ortheon.mariobros.sprites.Brick;
import com.ortheon.mariobros.sprites.Coin;

public class B2WorldCreator {

    public B2WorldCreator(PlayScreen screen) {
        //for now
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        for (MapObject object : screen.getMap().getLayers().get(2).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2)/ MarioBros.PPM, (rect.getY() + rect.getHeight() / 2)/MarioBros.PPM);

            body = screen.getWorld().createBody(bdef);
            shape.setAsBox((rect.getWidth() / 2)/MarioBros.PPM, (rect.getHeight() / 2)/MarioBros.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }

        ///
        for (MapObject object : screen.getMap().getLayers().get(3).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2)/MarioBros.PPM, (rect.getY() + rect.getHeight() / 2)/MarioBros.PPM);

            body = screen.getWorld().createBody(bdef);
            shape.setAsBox((rect.getWidth() / 2)/MarioBros.PPM, (rect.getHeight() / 2)/MarioBros.PPM);
            fdef.shape = shape;
            fdef.filter.categoryBits = MarioBros.OBJECT_BIT;
            body.createFixture(fdef);
        }

        for (MapObject object : screen.getMap().getLayers().get(5).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            new Brick(screen,rect);
        }

        for (MapObject object : screen.getMap().getLayers().get(4).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            new Coin(screen,rect);
        }

    }
}
