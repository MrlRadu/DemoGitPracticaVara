public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape newShape = shapeFactory.getShape();
        newShape.draw();
    }
}
