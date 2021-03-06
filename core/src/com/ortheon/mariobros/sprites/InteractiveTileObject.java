package com.ortheon.mariobros.sprites;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.ortheon.mariobros.MarioBros;
import com.ortheon.mariobros.screens.PlayScreen;


public abstract class InteractiveTileObject {

    protected World world;
    protected TiledMap map;
    protected Rectangle bounds;
    protected Body body;
    protected Fixture fixture;

    public InteractiveTileObject(PlayScreen screen, Rectangle bounds) {
        this.world = screen.getWorld();
        this.map = screen.getMap();
        this.bounds = bounds;

        BodyDef bdef = new BodyDef();
        FixtureDef fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();

        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set(((bounds.getX() + bounds.getWidth() /2)/ MarioBros.PPM), ((bounds.getY() + bounds.getHeight() /2)/MarioBros.PPM));

        body = world.createBody(bdef);
        shape.setAsBox( bounds.getWidth() /2/ MarioBros.PPM,  bounds.getHeight() /2/MarioBros.PPM);
        fdef.shape = shape;
        fixture = body.createFixture(fdef);
    }

    public abstract void onHeadHit();
    public void setCategoryFilter(short filterBit) {
        Filter filter = new Filter();
        filter.categoryBits = filterBit;
        fixture.setFilterData(filter);
    }

    public TiledMapTileLayer.Cell getCell(){
        TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(1);
        //tu jest kurwa blad
        int x = (int) (this.body.getPosition().x * MarioBros.PPM / 16);
        int y = (int)(this.body.getPosition().y * MarioBros.PPM / 16);
        Gdx.app.log("X", String.valueOf(x));
        Gdx.app.log("Y", String.valueOf(y));
        TiledMapTileLayer.Cell cell = layer.getCell(x,y);
        Gdx.app.log(String.valueOf(cell.getTile().getId()), "");
        return cell;
    }


}
