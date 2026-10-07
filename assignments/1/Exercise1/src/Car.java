public class Car extends LandVehicle{
    
    Car(){
        super();
        System.out.println("Car Constructor called");
    }

    Car(String name){
        super(name);
        System.out.println("Car Constructor with name called");
    }


    @Override 
    public void move(){
        System.out.println("Vroom! Driving on the road");
    }

    @Override 
    String getVehicleType(){return "Car"; }
}
