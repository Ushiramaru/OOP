import buttonMouseListener.*;
import pen.Pen;
import shape.*;
import shape.Rectangle;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    private JPanel panelButton,panelDraw;
    private JButton buttonNDraw,buttonLine,buttonRectangle,buttonSquare,buttonCircle, buttonSer, buttonDeser;//,buttonEllipse,buttonTriangle;

    public MyFrame(String name) {
        super(name);
    }

    public void setDefaultConfiguration() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.WHITE);
        this.setBounds(100, 100, 900, 500);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
    }

    public void setPaintConfiguration() {
        panelButton = new JPanel();
        panelButton.setBackground(Color.GRAY);
        panelButton.setSize(this.getWidth(), 200);
        panelButton.setVisible(true);
        panelButton.setLayout(new FlowLayout());
        this.add(panelButton, BorderLayout.BEFORE_FIRST_LINE);

        buttonDeser = new JButton();
        buttonDeser.setBackground(Color.MAGENTA);
        buttonDeser.setText("Deser");
        buttonDeser.setSize(50,panelButton.getHeight()-100);
        buttonDeser.setVisible(true);
        buttonDeser.addMouseListener(new DeserButtonMouseListener());
        panelButton.add(buttonDeser);

        buttonSer = new JButton();
        buttonSer.setBackground(Color.MAGENTA);
        buttonSer.setText("Ser");
        buttonSer.setSize(50,panelButton.getHeight()-100);
        buttonSer.setVisible(true);
        buttonSer.addMouseListener(new SerButtonMouseListener());
        panelButton.add(buttonSer);

        buttonLine = new JButton();

        buttonLine.setBackground(Color.MAGENTA);
        buttonLine.setText("Line");
        buttonLine.setSize(50,panelButton.getHeight()-100);
        buttonLine.setVisible(true);
        buttonLine.addMouseListener(new ShapeButtonMouseListener(new Line()));
        panelButton.add(buttonLine);


        buttonRectangle = new JButton();
        buttonRectangle.setBackground(Color.MAGENTA);
        buttonRectangle.setText("Rectangle");
        buttonRectangle.setSize(50,panelButton.getHeight()-10);
        buttonRectangle.setVisible(true);
        buttonRectangle.addMouseListener(new ShapeButtonMouseListener(new Rectangle()));
        panelButton.add(buttonRectangle);

        buttonSquare = new JButton();
        buttonSquare.setBackground(Color.MAGENTA);
        buttonSquare.setText("Square");
        buttonSquare.setSize(50,panelButton.getHeight()-10);
        buttonSquare.setVisible(true);
        buttonSquare.addMouseListener(new ShapeButtonMouseListener(new Square()));
        panelButton.add(buttonSquare);

        buttonCircle = new JButton();
        buttonCircle.setBackground(Color.MAGENTA);
        buttonCircle.setText("Circle");
        buttonCircle.setSize(50,panelButton.getHeight()-10);
        buttonCircle.setVisible(true);
        buttonCircle.addMouseListener(new ShapeButtonMouseListener(new Circle()));
        panelButton.add(buttonCircle);

        /*buttonEllipse = new JButton();
        buttonEllipse.setBackground(Color.MAGENTA);
        buttonEllipse.setText("Ellipse");
        buttonEllipse.setSize(50,panelButton.getHeight()-10);
        buttonEllipse.setVisible(true);
        buttonEllipse.addMouseListener(new ShapeButtonMouseListener(new Ellipse()));
        panelButton.add(buttonEllipse);

        buttonTriangle = new JButton();
        buttonTriangle.setBackground(Color.MAGENTA);
        buttonTriangle.setText("Triangle");
        buttonTriangle.setSize(50,panelButton.getHeight()-10);
        buttonTriangle.setVisible(true);
        buttonTriangle.addMouseListener(new ShapeButtonMouseListener(new Triangle()));
        panelButton.add(buttonTriangle);*/

        buttonNDraw = new JButton();
        buttonNDraw.setBackground(Color.MAGENTA);
        buttonNDraw.setText("NDraw");
        buttonNDraw.setSize(50,panelButton.getHeight()-10);
        buttonNDraw.setVisible(true);
        buttonNDraw.addMouseListener(new ShapeButtonMouseListener(null));
        panelButton.add(buttonNDraw);

        panelDraw = new JPanel();
        panelDraw.setBackground(Color.WHITE);
        panelDraw.setSize(this.getWidth(), this.getHeight() - panelButton.getHeight());
        panelDraw.setVisible(true);
        this.add(panelDraw);
    }

    public void setGraphics() {
        Canvas canvas = new Canvas();
        canvas.setSize(panelDraw.getWidth(),panelDraw.getHeight());
        canvas.setBackground(Color.WHITE);
        canvas.addMouseListener(new DrawPanelMouseListener());
        panelDraw.add(canvas);
        Pen.setGraphics(canvas.getGraphics());
    }
}
