package examples.jemgengine;

import com.jemge.core.JAppLWJGL;
import com.jemge.core.JConfig;

public class Shooter2d {

    public static void main(String[] args){
        JConfig config = new JConfig();
        config.setGL(JConfig.Version.GL_20);
        config.setSize(800, 600);

        new JAppLWJGL(new ExampleGame(), config);   //finally create the lwjgl application.
    }
}
