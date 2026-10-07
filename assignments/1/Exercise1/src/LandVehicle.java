/**
 * Travis Zhang 300488899
 * 
 * LandVehicle
 */
class LandVehicle extends Vehicle {

    /** Global counter of all LandVechicles Created */
    private static int numberOfLandVehicles = 0;

    /**
     * Creates an unnamed Land Vehicle
     */
    LandVehicle() {
        super();
        numberOfLandVehicles++;
        System.out.println("LandVehicle Constructor called");
    }

    /**
     * Creates a nammed Land Vehicle
     * 
     * @param name
     */
    LandVehicle(String name) {
        super(name);
        numberOfLandVehicles++;
        System.out.println("LandVehicle Constructor with name called");
    }

    /**
     * Prints how a Land Vehicle would sound if it moved
     */
    @Override
    public void move() {
        System.out.println("Rolling on land");
    }

    /**
     * Returns the type of Vehicle
     * 
     * @return Land Vehicle 
     */
    @Override
    String getVehicleType() {
        return "Land Vehicle";
    }

    /**
     * Returns the number of Land Vehicles made
     * 
     * @return the number of Land Vehicles
     */
    int getNumberOfLandVehicles() {
        return numberOfLandVehicles;
    }

}