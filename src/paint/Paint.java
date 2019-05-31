package paint;

import buttonMouseListener.*;
import pen.Pen;
import shape.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Paint extends JFrame {

    private JPanel panelDraw;
    private ArrayList<shape.Shape> shapes;
    private Canvas canvas;

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

    public void setShapes(ArrayList<shape.Shape> shapes) {
        this.shapes = shapes;
    }

    public void setPaintConfiguration() {
        JPanel panelButton = new JPanel();
        panelButton.setBackground(Color.GRAY);
        panelButton.setSize(this.getWidth(), 200);
        panelButton.setVisible(true);
        panelButton.setLayout(new FlowLayout());
        this.add(panelButton, BorderLayout.BEFORE_FIRST_LINE);

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
