import FactoryPattern.Shape;
import FactoryPattern.ShapeFactory;

public class PatternTest {
    public static void main(String[] args) {

        // 팩토리 패턴 TEST
        ShapeFactory factory = new ShapeFactory();

        Shape a = factory.createShape("동그라미");
        a.draw();

        Shape b = factory.createShape("네모");
        b.draw();

        Shape C = factory.createShape("세모");


    }
}
