class LandVehicle extends Vehicle{

    private static int numberOfLandVehicles = 0;

    LandVehicle(){
        super();
        numberOfLandVehicles++;
        System.out.println("LandVehicle Constructor called");
    }

    LandVehicle(String name){
        super(name);
        numberOfLandVehicles++;
        System.out.println("LandVehicle Constructor with name called");
    }

    @Override
    public void move() {
        System.out.println("Rolling on land");
    }

    @Override
    String getVehicleType() {return "Land Vehicle";}

    int getNumberOfLandVehicles(){return numberOfLandVehicles;}

    
    
}