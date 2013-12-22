package examples.jemgengine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jemge.core.Jemge;
import com.jemge.j2d.Entity;
import com.jemge.j2d.JSprite;

public class Enemy extends JSprite {

    public Enemy(float x, float y){
        super(new Texture(Gdx.files.internal("bitmaps/enemy.png")), x, y, 64, 64);

    }

    @Override
    public void render(SpriteBatch batch){
        super.render(batch);
        setPosition(getX(), getY() - 4f);
        for(Ball ball : Ball.balls){
            if(ball.getRectangle().overlaps(getRectangle())){
                Jemge.renderer2D.remove(1, this);
            }
        }

        if(!needRender()){
            Jemge.renderer2D.remove(1, this);
        }
    }

    @Override
    public boolean hasTransparent(){
        return true;
    }
}
