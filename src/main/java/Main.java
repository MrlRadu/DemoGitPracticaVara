public class Main {
    public static void main(String[] args) {
        FactoryPatern factoryPatern =new FactoryPatern();
        Shape cerc=factoryPatern.getShape("CIRCLE");
        Shape patrat=factoryPatern.getShape("SQUARE");
        Shape dreptunghi=factoryPatern.getShape("RECTANGLE");
        cerc.draw();
        patrat.draw();
        dreptunghi.draw();

    }
}
