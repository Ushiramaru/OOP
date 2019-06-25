package main;

import Configuration.CallBackHandler;
import Configuration.ConfigRedactor;
import Configuration.Configurator;
import shapeLoader.ShapesLoader;
import org.xml.sax.SAXException;
import paint.Paint;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MainClass implements Runnable {

    private static boolean flag = false;
    private static ConfigRedactor configRedactor;
    private static Paint paint;

    public static void main(String[] args) {
        Configurator configurator = new Configurator();
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            CallBackHandler callBackHandler = new CallBackHandler();
            callBackHandler.setConfigurator(configurator);
            saxParser.parse(new File("config.xml"), callBackHandler);
        } catch (ParserConfigurationException | SAXException e) {
            System.out.println("Incorrect config.xml. More part of config set in default value");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        String pathLoad = new File(URLDecoder.decode(MainClass.class.getProtectionDomain().getCodeSource().getLocation().getPath(), StandardCharsets.UTF_8)).getPath();
//        pathLoad = pathLoad.substring(0,pathLoad.lastIndexOf("\\"));
//        ShapesLoader loader = new ShapesLoader(pathLoad + "\\shape\\modules\\", "shape.modules",ClassLoader.getSystemClassLoader());
        ShapesLoader loader = new ShapesLoader("D:\\OOP\\out\\production\\OOP\\shape\\modules\\", "shape.modules",ClassLoader.getSystemClassLoader());
        loader.startLoad();

        paint = new Paint(configurator);
        paint.setDefaultConfiguration();
        paint.setShapes(loader.getShapes());
        paint.setPaintConfiguration();
        paint.setGraphics();
        paint.setSize(paint.getCanvas().getWidth(),paint.getCanvas().getHeight());
        paint.setResizable(false);

        Scanner scanner = new Scanner(System.in);
        String s = "";
        while (!s.equals("exit")) {
            if (scanner.hasNextLine() || flag) {
                if (flag) {
                    break;
                }
                s = scanner.nextLine();
                if (s.equals("config")) {
                    configRedactor = new ConfigRedactor("ConfigRedactor", paint);
                    configRedactor.setDefaultConfig();
                }
                if (s.equals("exit")) {
                    scanner.close();
                    paint.dispatchEvent(new WindowEvent(paint, WindowEvent.WINDOW_CLOSING));
                    return;
                }
            }
        }
    }

    @Override
    public void run() {
        flag = true;
        paint.dispatchEvent(new WindowEvent(paint, WindowEvent.WINDOW_CLOSING));
        configRedactor.dispatchEvent(new WindowEvent(configRedactor, WindowEvent.WINDOW_CLOSING));
        try {
            Thread.sleep(100*60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = false;
        main(null);
    }

}