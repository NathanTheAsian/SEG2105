public abstract class Vehicle implements Movable{

    private static int numberOfVehicles = 0;

    private String name;

    Vehicle(){
        numberOfVehicles++;
        System.out.println("Vehicle Constructor called");
        name = "Unnamed Vehicle";
    }
    
    Vehicle(String name){
        numberOfVehicles++;
        System.out.println("Vehicle Constructor with name called");        
        this.name = name;
    }

    abstract String getVehicleType();

    void describe(){
        System.out.println(name + " is a " + getVehicleType());
    }

    static int getNumberOfVehicles(){return numberOfVehicles;}

}