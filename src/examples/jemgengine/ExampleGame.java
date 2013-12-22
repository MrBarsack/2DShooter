package examples.jemgengine;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.jemge.core.JGame;
import com.jemge.core.Jemge;
import com.jemge.core.system.UpdateListener;
import com.jemge.core.system.predefined.FollowMouse;
import com.jemge.input.InputManager;
import com.jemge.j2d.Entity;
import com.jemge.j2d.JSprite;
import com.jemge.j2d.RendererObject;

import java.util.Random;

public class ExampleGame extends JGame {
    private JSprite player_ship;

    private float time;
    private float  new_enemy = 175;
    private Random random;

    @Override
    public void create() {
        super.create();
        player_ship = new JSprite(new Texture(Gdx.files.internal("bitmaps/ship.png")), 0, 0, 128, 128);
        player_ship.setTransparent(true);
        player_ship.listener = new FollowMouse();

        random = new Random();

        Jemge.renderer2D.add(2, player_ship);
        Jemge.renderer2D.getBackground().setColor(Color.LIGHT_GRAY);
    }

    @Override
    public void render() {
        super.render();

        if (Gdx.input.justTouched()) {
            Jemge.renderer2D.add(1, new Ball(player_ship.getX() + 48
                    , player_ship.getY() + 48));
        }

        time++;

        if(time >= new_enemy){
            Jemge.renderer2D.add(1, new Enemy(30 + random.nextInt((int) getCamera().viewportWidth - 60)
                    , getCamera().viewportHeight));

            time = 0;
            new_enemy-= (new_enemy / 100 * 0.5f);
        }


    }
}
