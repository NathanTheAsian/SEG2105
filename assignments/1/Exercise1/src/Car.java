/**
 * Travis Zhang 300488899
 * 
 * Car 
*/
public class Car extends LandVehicle{

    /**
     * Creates a unnamed Car 
     */
    Car(){
        super();
        System.out.println("Car Constructor called");
    }

    /**
     * Creates a nammed car
     * 
     * @param name
     */
    Car(String name){
        super(name);
        System.out.println("Car Constructor with name called");
    }

    /** 
     * Prints how Car would sound when it moves 
     */
    @Override 
    public void move(){
        System.out.println("Vroom! Driving on the road");
    }

    /**
     * Returns the type of Vehicle
     * 
     * @return Car
     */
    @Override 
    String getVehicleType(){return "Car"; }
}
