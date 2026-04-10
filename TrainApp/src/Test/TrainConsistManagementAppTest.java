import java.util.*;
import java.util.stream.*;

/**
 * ============================================================
 * MAIN CLASS - BookMyTrain
 * ============================================================
 *
 * Use Case 8: Stream API Filtering
 *
 * @version 8.0
 */

public class TrainConsistManagementAppTest {

    // ============ Bogie Class ============
    static class Bogie {
        String name;
        int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public void display() {
            System.out.println(name + " -> Capacity: " + capacity);
        }
    }

    // ============ MAIN ============
    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC8 - Stream Filtering ");
        System.out.println("=======================================\n");

        // UC7 list reused
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 54));
        bogies.add(new Bogie("First Class", 40));
        bogies.add(new Bogie("Cargo", 100));

        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            b.display();
        }

        // 🔥 Stream + Filter
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        System.out.println("\nFiltered Bogies (Capacity > 60):");
        for (Bogie b : filtered) {
            b.display();
        }

        System.out.println("\nUC8 completed...");
    }
}