public class Main {
    public static void main(String[] args) {
        FactoryPatern factoryPatern =new FactoryPatern();
        Shape cerc=factoryPatern.getShape("Cerc");
        Shape patrat=factoryPatern.getShape("patrat");
        Shape dreptunghi=factoryPatern.getShape("dreptunghi");
        cerc.draw();
        patrat.draw();
        dreptunghi.draw();

    }
}
