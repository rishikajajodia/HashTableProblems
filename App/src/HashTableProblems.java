// Problem 8: Parking Lot Management (Open Addressing)
import java.util.*;

class ParkingLot {
    String[] spots = new String[500];

    int hash(String plate) {
        return Math.abs(plate.hashCode()) % spots.length;
    }

    public int park(String plate) {
        int index = hash(plate);

        for (int i = 0; i < spots.length; i++) {
            int pos = (index + i) % spots.length;
            if (spots[pos] == null) {
                spots[pos] = plate;
                return pos;
            }
        }
        return -1;
    }

    public void exit(String plate) {
        for (int i = 0; i < spots.length; i++) {
            if (plate.equals(spots[i])) {
                spots[i] = null;
                System.out.println("Spot freed: " + i);
                return;
            }
        }
    }

    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot();
        int spot = pl.park("ABC1234");
        System.out.println("Parked at " + spot);
        pl.exit("ABC1234");
    }
}