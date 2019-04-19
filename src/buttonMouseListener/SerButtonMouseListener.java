package buttonMouseListener;

import com.google.gson.*;
import shape.Shape;
import shapeArray.ShapeArray;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;
import java.io.IOException;

public class SerButtonMouseListener implements MouseListener {

    public SerButtonMouseListener() {

    }

    private void WriteInFile(String name, String content) {
        try(FileWriter writer = new FileWriter(name, false)) {
            writer.write(content);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void mouseClicked(MouseEvent e) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Shape.class, new JsonDeserializerWithInheritance<Shape>());
        Gson gson = builder.setPrettyPrinting().create();

        String derivedClass1Json = gson.toJson(ShapeArray.getShapeArray().toArray());

        WriteInFile("test.json",derivedClass1Json);
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