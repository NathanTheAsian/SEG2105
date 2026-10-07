/**
 * Travis Zhang 300488899
 * 
 * Sailboat
 */

public class Sailboat extends WaterVehicle{
    /**
     * Creates an unnamed Sailboat
     */
    Sailboat(){
        super();
        System.out.println("Sailboat Constructor called");
    }
    /**
     * Creates a nammed Sailboat
     * 
     * @param name
     */
    Sailboat(String name){
        super(name);
        System.out.println("Sailboat Constructor with name called");
    }
    /**    
     * Prints Sailboat movement sound 
     */
       @Override 
    public void move(){
        System.out.println("Whoosh! Sailing with the wind");
    }
    /**
     * Returns the type of Vehicle
     * 
     * @return Sailboat
     */
    @Override 
    String getVehicleType(){return "Sailboat"; }
}
