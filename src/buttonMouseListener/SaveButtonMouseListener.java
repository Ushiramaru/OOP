package buttonMouseListener;

import main.MainClass;
import paint.Paint;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SaveButtonMouseListener implements MouseListener {

    private TextArea textArea;
    private Paint paint;

    public SaveButtonMouseListener(TextArea textArea, Paint paint) {
        this.textArea = textArea;
        this.paint = paint;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        byte[] s = textArea.getText().getBytes();
        File file = new File("config.xml");
        try {
            Files.write(file.toPath(), s);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Thread thread = new Thread(new MainClass());
        thread.start();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
