import shape.Shape;
import shape.modules.Rectangle;
import shape.userShape.UserShape;

public class Test {
    public static void main(String[] args) {
        System.out.println(((Shape)new Rectangle()).getClass().getName());
    }
}
