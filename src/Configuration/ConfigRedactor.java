package Configuration;

import buttonMouseListener.SaveButtonMouseListener;
import paint.Paint;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConfigRedactor extends JFrame {

    private Paint paint;

    public ConfigRedactor(String name, Paint paint) {
        super(name);
        this.paint = paint;
    }

    public void setDefaultConfig() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setSize(600, 600);
        setLocation(100, 100);

        String s = "";
        File configFile = new File("config.xml");
        try {
            Scanner scanner = new Scanner(configFile);
            while (scanner.hasNextLine()) {
                s += scanner.nextLine()+"\n";
                if (s.contains("</document>")) {
                    s = s.substring(0, s.length()-1);
                    break;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        TextArea textArea = new TextArea(s);
        add(textArea);
        textArea.setSize(400,400);
        setLocation((getWidth()-textArea.getWidth())/2, (getHeight()-textArea.getHeight())/2);
        setVisible(true);
        textArea.setVisible(true);

        Button button = new Button("save");
        add(button);
        button.setSize(70,20);
        button.setLocation(textArea.getX()+textArea.getWidth()+10, textArea.getY()+textArea.getHeight()+10);
        button.addMouseListener(new SaveButtonMouseListener(textArea, paint));
    }

}
