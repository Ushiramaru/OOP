package paint;

import buttonMouseListener.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import buttonMouseListener.JsonDeserializerWithInheritance;
import com.google.gson.reflect.TypeToken;
import pen.Pen;
import shape.Shape;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

public class Paint extends JFrame {

    private JPanel panelDraw;
    private ArrayList<Shape> shapes;
    private Canvas canvas;
    private JPanel panelUserShape;

    public Paint(String name) {
        super(name);
    }

    public void setDefaultConfiguration() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.WHITE);
        this.setBounds(100, 100, 900, 500);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
    }

    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    public void addUserShapeButton(Shape shape) {
        JButton button = new JButton(panelUserShape.getComponentCount()+1+"");
        panelUserShape.add(button);
        button.setBackground(Color.MAGENTA);
        button.setSize(50, 25);
        button.setLocation(10,(panelUserShape.getComponentCount()+1)*(40));
        button.setVisible(true);
        button.addMouseListener(new ShapeButtonMouseListener(shape));

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Shape.class, new JsonDeserializerWithInheritance<Shape>());
        Gson gson = builder.setPrettyPrinting().create();

        String derivedClass1Json = gson.toJson(shape);

        try(FileWriter writer = new FileWriter("D:\\OOP\\src\\shape\\userShape\\shapes\\"+panelUserShape.getComponentCount()+".json", false)) {
            writer.write(derivedClass1Json);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void deserUserShape() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Shape.class, new JsonDeserializerWithInheritance<Shape>());
        Gson gson = builder.setPrettyPrinting().create();

        File file = new File("D:\\OOP\\src\\shape\\userShape\\shapes");
        String[] files = file.list();
        if (files == null) {
            return;
        }
        for (String jsonFileName : files) {
//            System.out.println(jsonFileName);
            String json= null;
            try {
                String s = "";
                File f = new File("D:\\OOP\\src\\shape\\userShape\\shapes\\"+jsonFileName);
                Scanner in = new Scanner(f);
                while(in.hasNext())
                    s += in.nextLine() + "\r\n";
                in.close();
                json = s;
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }

            java.lang.reflect.Type itemsArrType = new TypeToken<Shape>() {}.getType();
            try {
                Shape arrItemsDes = gson.fromJson(json, itemsArrType);

                if (arrItemsDes != null) {
                    addUserShapeButton(arrItemsDes);
                }
            } catch (Exception el){
                el.printStackTrace();
            }
        }
    }

    public void setPaintConfiguration() {
        JPanel panelButton = new JPanel();
        panelButton.setBackground(Color.GRAY);
        panelButton.setSize(this.getWidth(), 200);
        panelButton.setVisible(true);
        panelButton.setLayout(new FlowLayout());
        this.add(panelButton, BorderLayout.BEFORE_FIRST_LINE);

        panelUserShape = new JPanel();
        panelUserShape.setBackground(Color.GRAY);
        panelUserShape.setSize(100, this.getHeight());
        panelUserShape.setVisible(true);
        panelUserShape.setLayout(null);
        this.add(panelUserShape, BorderLayout.NORTH);

        deserUserShape();

        JButton buttonDeser = new JButton();
        buttonDeser.setBackground(Color.MAGENTA);
        buttonDeser.setText("Deser");
        buttonDeser.setSize(50,panelButton.getHeight()-100);
        buttonDeser.setVisible(true);
        buttonDeser.addMouseListener(new DeserButtonMouseListener());
        panelButton.add(buttonDeser);

        JButton buttonSer = new JButton();
        buttonSer.setBackground(Color.MAGENTA);
        buttonSer.setText("Ser");
        buttonSer.setSize(50,panelButton.getHeight()-100);
        buttonSer.setVisible(true);
        buttonSer.addMouseListener(new SerButtonMouseListener());
        panelButton.add(buttonSer);

        for (Shape shape : shapes) {
            JButton newShape  = new JButton();
            newShape.setBackground(Color.MAGENTA);
            newShape.setText(shape.getClass().getSimpleName());
            newShape.setSize(50, panelButton.getHeight()-10);
            newShape.setVisible(true);
            newShape.addMouseListener(new ShapeButtonMouseListener(shape));
            panelButton.add(newShape);
        }

        JButton button  = new JButton();
        button.setBackground(Color.MAGENTA);
        button.setText("CreateShape");
        button.setSize(50, panelButton.getHeight()-10);
        button.setVisible(true);
        button.addMouseListener(new UserShapeCreatorMouseListener());
        panelButton.add(button);

//        newShape  = new JButton();
//        newShape.setBackground(Color.MAGENTA);
//        newShape.setText("UserShape");
//        newShape.setSize(50, panelButton.getHeight()-10);
//        newShape.setVisible(true);
//        UserShapeCreator s = new UserShapeCreator();
//        Shape line = new Rectangle();
//        line.setFPoints(new Point(2,4));
//        line.setSPoints(new Point(4,2));
//        s.addSubShape(line);
//        line = new Rectangle();
//        line.setFPoints(new Point(4,4));
//        line.setSPoints(new Point(3,3));
//        s.addSubShape(line);
//        newShape.addMouseListener(new ShapeButtonMouseListener(s.getUserShape()));
//        panelButton.add(newShape);

        JButton buttonClear = new JButton();
        buttonClear.setBackground(Color.MAGENTA);
        buttonClear.setText("Clear");
        buttonClear.setSize(50,panelButton.getHeight()-10);
        buttonClear.setVisible(true);
        buttonClear.addMouseListener(new ShapeButtonMouseListener(null));
        panelButton.add(buttonClear);

        panelDraw = new JPanel();
        panelDraw.setBackground(Color.WHITE);
        panelDraw.setSize(this.getWidth(), this.getHeight() - panelButton.getHeight());
        panelDraw.setVisible(true);
        this.add(panelDraw);
    }

    public void setGraphics() {
        Canvas canvas = new Canvas();
        this.canvas = canvas;
        canvas.setSize(panelDraw.getWidth(),panelDraw.getHeight());
        canvas.setBackground(Color.WHITE);
        canvas.addMouseListener(new DrawPanelMouseListener());
        panelDraw.add(canvas);
        Pen.setGraphics(canvas.getGraphics());
    }

    public Canvas getCanvas() {
        return canvas;
    }

}
