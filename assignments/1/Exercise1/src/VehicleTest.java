import java.util.ArrayList;
import java.util.List;

/**
 * Travis Zhang 300488899 
 * 
 * VehicleTest
 */
public class VehicleTest {
    public static void main(String[] args) {
        ArrayList<LandVehicle> landVehicles = new ArrayList<>();
        ArrayList<WaterVehicle> waterVehicles = new ArrayList<>();
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Sailboat> sailboats = new ArrayList<>();


        landVehicles.add(new LandVehicle());
        landVehicles.add(new LandVehicle());
        landVehicles.add(new LandVehicle("Tractor"));
        landVehicles.add(new LandVehicle("Bus"));


        waterVehicles.add(new WaterVehicle());
        waterVehicles.add(new WaterVehicle());
        waterVehicles.add(new WaterVehicle("Ferry"));
        waterVehicles.add(new WaterVehicle("Canoe"));

        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car("Civic"));
        cars.add(new Car("new Corolla"));
        
        sailboats.add(new Sailboat());
        sailboats.add(new Sailboat());
        sailboats.add(new Sailboat("Bluenose"));
        sailboats.add(new Sailboat("Laser"));

        System.out.println();

        System.out.println("Land vehicles moving:");
        for (int i = 0; i < 4; i++) {
            landVehicles.get(i).move();
        }
        System.out.println("\n");

        System.out.println("Water vehicles moving:");
        for (int i = 0; i < 4; i++) {
            waterVehicles.get(i).move();
        }
        System.out.println("\n");

        System.out.println("Cars Moving:");
        for (int i = 0; i < 4; i++) {
            cars.get(i).move();
        }
        System.out.println("\n");


        System.out.println("Sailboats moving:");
        for (int i = 0; i < 4; i++) {
            sailboats.get(i).move();
        }
        System.out.println("\n");
        
        List<Vehicle> fleet = new ArrayList<>();

        System.out.println("Fleet:");
        for (int i = 0; i < 4; i++) {
            fleet.add(landVehicles.get(i));
        }
        for (int i = 0; i < 4; i++) {
            fleet.add(waterVehicles.get(i));
        }
        for (int i = 0; i < 4; i++) {
            fleet.add(cars.get(i));
        }
        for (int i = 0; i < 4; i++) {
            fleet.add(sailboats.get(i));
        }

        for (int i = 0; i < fleet.size(); i++) {
            fleet.get(i).describe();

        }

        System.out.println("\n");

        System.out.println("Total number of vehicles: " + Vehicle.getNumberOfVehicles());
        System.out.println("Total number of land vehicle : " + LandVehicle.getNumberOfVehicles());
        System.out.println("Total number of water vehicle : " + WaterVehicle.getNumberOfWaterVehicles());
        
    }
}
