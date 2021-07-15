public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory=new ShapeFactory();

        Shape firstShape = shapeFactory.getShape("Circle");
        firstShape.draw();

        Shape secondShape = shapeFactory.getShape("Square");
        secondShape.draw();

        Shape thirdShape = shapeFactory.getShape("Rectangle");
        thirdShape.draw();
    }
}
