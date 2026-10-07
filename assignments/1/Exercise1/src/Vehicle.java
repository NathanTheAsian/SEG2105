/**
 * Travis Zhang 300488899
 * 
 * Vehicle
 */

public abstract class Vehicle implements Movable{

    /** Global counter of the number of Vehicles created */
    private static int numberOfVehicles = 0;

    /** name of the vehicle */
    private String name;

    /**
     * Creates a Unnamed Vehicle
     */
    Vehicle(){
        numberOfVehicles++;
        System.out.println("Vehicle Constructor called");
        name = "Unnamed Vehicle";
    }
    
    /**
     * Creates a Nammed Vehicle
     * @param name
     */
    Vehicle(String name){
        numberOfVehicles++;
        System.out.println("Vehicle Constructor with name called");        
        this.name = name;
    }

    /**
     * Returns the type of vehicle
     * 
     * @return type of vehicle 
     */
    abstract String getVehicleType();

    /**
     * Prints the discription of the vehicle
     */
    void describe(){
        System.out.println(name + " is a " + getVehicleType());
    }

    /**
     * Returns the number of vehicles created
     * 
     * @return number of Vehicles
     */
    static int getNumberOfVehicles(){return numberOfVehicles;}

}