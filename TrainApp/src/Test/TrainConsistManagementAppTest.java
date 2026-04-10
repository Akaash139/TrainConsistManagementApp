import java.util.*;
import java.util.stream.*;

/**
 * ============================================================
 * MAIN CLASS - BookMyTrain
 * ============================================================
 *
 * Use Case 10: Total Seat Calculation using reduce()
 *
 * @version 10.0
 */

public class TrainConsistManagementAppTest {

    // ============ Bogie Class ============
    static class Bogie {
        String type;
        int capacity;

        public Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    // ============ MAIN ============
    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC10 - Total Seat Calculation ");
        System.out.println("=======================================\n");

        // Reuse list
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 54));
        bogies.add(new Bogie("First Class", 40));
        bogies.add(new Bogie("Cargo", 100));

        // 🔥 map + reduce
        int totalSeats = bogies.stream()
                .map(b -> b.capacity)          // extract capacity
                .reduce(0, Integer::sum);      // sum all

        System.out.println("Total Seating Capacity: " + totalSeats);

        System.out.println("\nUC10 completed...");
    }
}