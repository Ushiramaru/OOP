package buttonMouseListener;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import pen.Pen;
import shape.Shape;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Scanner;

public class DeserButtonMouseListener implements MouseListener {

    public DeserButtonMouseListener() {

    }

    private String ReadInStr(String name) throws FileNotFoundException {
        String s = "";
        File f = new File(name);
        if (!(f.exists() && ! f.isDirectory())) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                FileWriter fileWriter = new FileWriter(f);
                fileWriter.write("[]");
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Scanner in = new Scanner(f);
        while(in.hasNext())
            s += in.nextLine() + "\r\n";
        in.close();
        return s;
    }

    public void mouseClicked(MouseEvent e) {
        Pen.clearCanvas();

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Shape.class, new JsonDeserializerWithInheritance<Shape>());
        Gson gson = builder.setPrettyPrinting().create();

        String json= null;
        try {
            json = ReadInStr("test.json");
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        Type itemsArrType = new TypeToken<Shape[]>() {}.getType();
        try {
            Shape[] arrItemsDes = gson.fromJson(json, itemsArrType);

            assert arrItemsDes != null;
            for (Shape arrItemsDe : arrItemsDes) {
                if (arrItemsDe != null) {
//                    System.out.println(arrItemsDe.getClass().getSimpleName());
                    Pen.setSelectedShape(arrItemsDe);
                    Pen.drawShape();
                }
            }
        } catch (Exception el){
            el.printStackTrace();
        }
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }
}