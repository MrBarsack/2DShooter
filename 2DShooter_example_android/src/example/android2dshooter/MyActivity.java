package example.android2dshooter;

import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import examples.jemgengine.ExampleGame;


public class MyActivity extends AndroidApplication {
     public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        cfg.useGL20 = true;

        initialize(new ExampleGame(), cfg);
    }

    @Override
    public void log(String s, String s2, Throwable throwable) {

    }
}
