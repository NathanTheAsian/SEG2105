public class Sailboat extends WaterVehicle{
    
    Sailboat(){
        super();
        System.out.println("Sailboat Constructor called");
    }

    Sailboat(String name){
        super(name);
        System.out.println("Sailboat Constructor with name called");
    }

    @Override 
    public void move(){
        System.out.println("Whoosh! Sailing with the wind");
    }

    @Override 
    String getVehicleType(){return "Sailboat"; }
}
