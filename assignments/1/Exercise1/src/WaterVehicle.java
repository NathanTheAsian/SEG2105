public class WaterVehicle extends Vehicle{
    public static int numberOfWaterVehicles = 0;

    WaterVehicle(){
        super();
        numberOfWaterVehicles++;
        System.out.println("WaterVehicle Constructor called");
    }

    WaterVehicle(String name){
        super(name);
        numberOfWaterVehicles++;
        System.out.println("WaterVehicle Constructor with name called");
    }




    @Override
    public void move() {
        System.out.println("Floating on water");
    }

    @Override
    String getVehicleType() { return "Water Vehicle"; }

    static int getNumberOfWaterVehicles(){return numberOfWaterVehicles;}

}
