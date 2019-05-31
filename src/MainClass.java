import paint.Paint;

import java.io.File;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class MainClass {

    public static void main(String[] args) {
        String pathLoad = new File(URLDecoder.decode(MainClass.class.getProtectionDomain().getCodeSource().getLocation().getPath(), StandardCharsets.UTF_8)).getPath();
        ShapesLoader loader = new ShapesLoader(pathLoad + "\\shape\\modules\\", "shape.modules",ClassLoader.getSystemClassLoader());
        loader.startLoad();

        Paint mainFrame = new Paint("недоPaint");
        mainFrame.setDefaultConfiguration();
        mainFrame.setShapes(loader.getShapes());
        mainFrame.setPaintConfiguration();
        mainFrame.setGraphics();
        mainFrame.setSize(mainFrame.getCanvas().getWidth(),mainFrame.getCanvas().getHeight());
        mainFrame.setResizable(false);
    }

}
