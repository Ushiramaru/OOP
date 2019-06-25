package paint;

import Configuration.Configurator;
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
import java.util.ArrayList;
import java.util.Scanner;

public class Paint extends JFrame {

    private JPanel panelDraw;
    private ArrayList<Shape> shapes;
    private Canvas canvas;
    private JPanel panelUserShape;
    private Configurator configurator;

    public Paint(Configurator configurator) {
        super(configurator.getPaintTitle());
        this.configurator = configurator;
    }

    public void setDefaultConfiguration() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBackground(configurator.getPaintColor());
        this.setBounds(100, 100, configurator.getPaintWidth(), configurator.getPaintHeight());
        this.setVisible(true);
        this.setLayout(null);
    }

    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    public void addUserShapeButton(Shape shape) {
        JButton button = new JButton(panelUserShape.getComponentCount()+1+"");
        panelUserShape.add(button);
        button.setBackground(configurator.getButtonUserShapeColor());
        button.setSize(configurator.getButtonUserShapeWidth(), configurator.getButtonUserShapeHeight());
        button.setLocation(5, (button.getHeight()+configurator.getPanelUserShapeGapY())*panelUserShape.getComponentCount()+configurator.getPanelUserShapeGapY());
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

    public void deserializeUserShape() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Shape.class, new JsonDeserializerWithInheritance<Shape>());
        Gson gson = builder.setPrettyPrinting().create();

        File file = new File("D:\\OOP\\src\\shape\\userShape\\shapes");
        String[] files = file.list();
        if (files == null) {
            return;
        }
        for (String jsonFileName : files) {
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
        JPanel panelShape = new JPanel();
        this.add(panelShape);
        panelShape.setBackground(configurator.getPanelShapeColor());
        panelShape.setSize(this.getWidth(), configurator.getPanelShapeHeight());
        panelShape.setLocation(0,0);
        panelShape.setVisible(true);
        panelShape.setLayout(null);

        panelUserShape = new JPanel();
        this.add(panelUserShape);
        panelUserShape.setBackground(configurator.getPanelUserShapeColor());
        panelUserShape.setSize(configurator.getPanelUserShapeWidth(), this.getHeight()-panelShape.getHeight());
        panelUserShape.setLocation(0, panelShape.getHeight());
        panelUserShape.setVisible(true);
        panelUserShape.setLayout(null);

        deserializeUserShape();

        int buttonShapeCount = 0;

        JButton buttonDeserialize = new JButton();
        panelShape.add(buttonDeserialize);
        buttonDeserialize.setBackground(configurator.getButtonShapeColor());
        buttonDeserialize.setText("Deserialize");
        buttonDeserialize.setSize(configurator.getButtonShapeWidth(), configurator.getButtonShapeHeight());
        buttonDeserialize.setLocation(configurator.getPanelShapeGapX()*(buttonShapeCount+1)+buttonShapeCount*configurator.getButtonShapeWidth(), (configurator.getPanelShapeHeight()-configurator.getButtonShapeHeight())/2);
        buttonDeserialize.setVisible(true);
        buttonDeserialize.addMouseListener(new DeserButtonMouseListener());
        buttonShapeCount++;

        JButton buttonSerialize = new JButton();
        panelShape.add(buttonSerialize);
        buttonSerialize.setBackground(configurator.getButtonShapeColor());
        buttonSerialize.setText("Serialize");
        buttonSerialize.setSize(configurator.getButtonShapeWidth(), configurator.getButtonShapeHeight());
        buttonSerialize.setLocation(configurator.getPanelShapeGapX()*(buttonShapeCount+1)+buttonShapeCount*configurator.getButtonShapeWidth(), (configurator.getPanelShapeHeight()-configurator.getButtonShapeHeight())/2);
        buttonSerialize.setVisible(true);
        buttonSerialize.addMouseListener(new SerButtonMouseListener());
        buttonShapeCount++;

        for (Shape shape : shapes) {
            JButton newShape  = new JButton();
            panelShape.add(newShape);
            newShape.setBackground(configurator.getButtonShapeColor());
            newShape.setText(shape.getClass().getSimpleName());
            newShape.setSize(configurator.getButtonShapeWidth(), configurator.getButtonShapeHeight());
            newShape.setLocation(configurator.getPanelShapeGapX()*(buttonShapeCount+1)+buttonShapeCount*configurator.getButtonShapeWidth(), (configurator.getPanelShapeHeight()-configurator.getButtonShapeHeight())/2);
            newShape.setVisible(true);
            newShape.addMouseListener(new ShapeButtonMouseListener(shape));
            buttonShapeCount++;
        }

        JButton button  = new JButton();
        panelShape.add(button);
        button.setBackground(configurator.getButtonShapeColor());
        button.setText("CreateShape");
        button.setSize(configurator.getButtonShapeWidth(), configurator.getButtonShapeHeight());
        button.setLocation(configurator.getPanelShapeGapX()*(buttonShapeCount+1)+buttonShapeCount*configurator.getButtonShapeWidth(), (configurator.getPanelShapeHeight()-configurator.getButtonShapeHeight())/2);
        button.setVisible(true);
        button.addMouseListener(new UserShapeCreatorMouseListener());
        buttonShapeCount++;

        JButton buttonClear = new JButton();
        panelShape.add(buttonClear);
        buttonClear.setBackground(configurator.getButtonShapeColor());
        buttonClear.setText("Clear");
        buttonClear.setSize(configurator.getButtonShapeWidth(), configurator.getButtonShapeHeight());
        buttonClear.setLocation(configurator.getPanelShapeGapX()*(buttonShapeCount+1)+buttonShapeCount*configurator.getButtonShapeWidth(), (configurator.getPanelShapeHeight()-configurator.getButtonShapeHeight())/2);
        buttonClear.setVisible(true);
        buttonClear.addMouseListener(new ShapeButtonMouseListener(null));


        panelDraw = new JPanel();
        this.add(panelDraw);
        panelDraw.setBackground(configurator.getPaintColor());
        panelDraw.setSize(this.getWidth()-panelUserShape.getWidth(), this.getHeight()-panelShape.getHeight());
        panelDraw.setLocation(panelUserShape.getWidth(), panelShape.getHeight());
        panelDraw.setVisible(true);
    }

    public void setGraphics() {
        Canvas canvas = new Canvas();
        this.canvas = canvas;
        panelDraw.add(canvas);
        canvas.setBackground(configurator.getPaintColor());
        canvas.setSize(panelDraw.getWidth(),panelDraw.getHeight());
        canvas.setLocation(0,0);
        canvas.addMouseListener(new DrawPanelMouseListener());
        Pen.setGraphics(canvas.getGraphics());
    }

    public Canvas getCanvas() {
        return canvas;
    }

}
