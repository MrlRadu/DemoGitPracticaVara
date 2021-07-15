public class FactoryPatern {

    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("Cerc")){
            return new Circle();

        } else if(shapeType.equalsIgnoreCase("dreptunghi")){
            return new Rectangle();

        } else if(shapeType.equalsIgnoreCase("patrat")){
            return new Square();
        }

        return null;
    }
}
