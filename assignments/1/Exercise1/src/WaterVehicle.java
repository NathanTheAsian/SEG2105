/**
 * Travis Zhang 300488899
 * 
 * WaterVehicle
 */
public class WaterVehicle extends Vehicle{
    /** Global counter of the number of water vehicles created */
    private static int numberOfWaterVehicles = 0;

    /**
     * Creates a unnamed water vehicle
     */
    WaterVehicle(){
        super();
        numberOfWaterVehicles++;
        System.out.println("WaterVehicle Constructor called");
    }

    /**
     * Creates a nammed water vehicle
     * 
     * @param name
     */
    WaterVehicle(String name){
        super(name);
        numberOfWaterVehicles++;
        System.out.println("WaterVehicle Constructor with name called");
    }

    /**    
     *Prints movement based on water vehicle  
     */ 
    @Override
    public void move() {
        System.out.println("Floating on water");
    }

    /**    
     * Returns the type of vehicle 
     * 
     * @return Water Vehicle
     */
    @Override
    String getVehicleType() { return "Water Vehicle"; }

    static int getNumberOfWaterVehicles(){return numberOfWaterVehicles;}

}
