package FactoryPattern;

public class ShapeFactory {

    // 팩토리 메소드 - 객체 생성 후 반환
    public Shape createShape(String type) {
        if(type.equals("동그라미")){
            return new Circle();
        }
        else if(type.equals("네모")) {
            return new Square();
        }
        else {
            System.out.println("유효하지 않음");
        }

        return null;
    }
}
