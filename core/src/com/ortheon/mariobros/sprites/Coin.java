package com.ortheon.mariobros.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.ortheon.mariobros.MarioBros;
import com.ortheon.mariobros.scenes.Hud;
import com.ortheon.mariobros.screens.PlayScreen;


public class Coin extends InteractiveTileObject {

    private static TiledMapTileSet set;
    private final int BLANK_COIN = 28;

    public Coin(PlayScreen screen, Rectangle bounds) {
        super(screen, bounds);
        set = screen.getMap().getTileSets().getTileSet("tileset_gutter");
        fixture.setUserData(this);
        setCategoryFilter(MarioBros.COIN_BIT);

    }

    @Override
    public void onHeadHit() {
        Gdx.app.log("Coin hit", "");
        if(getCell().getTile().getId() != BLANK_COIN) {
            MarioBros.manager.get("audio/sounds/coin.wav", Sound.class).play();
            getCell().setTile(set.getTile(BLANK_COIN));
            Hud.addScore(150);
        }
        else MarioBros.manager.get("audio/sounds/bump.wav", Sound.class).play();



    }

}
