package examples.jemgengine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jemge.core.Jemge;
import com.jemge.input.InputManager;
import com.jemge.j2d.JSprite;

import java.util.ArrayList;
import java.util.List;

public class Ball extends JSprite {
    public static List<Ball> balls;

    static{
        balls = new ArrayList<Ball>();
    }

    public Ball(float x, float y){
        super(new Texture(Gdx.files.internal("bitmaps/ball.png")), x, y, 32, 32);

        balls.add(this);
    }

    @Override
    public void render(SpriteBatch batch){
        super.render(batch);
        setPosition(getX(), getY() + 5f);

        if(!needRender()){
            Jemge.renderer2D.remove(1, this);
            balls.remove(this);
        }
    }

    @Override
    public boolean hasTransparent(){
        return true;
    }

}
