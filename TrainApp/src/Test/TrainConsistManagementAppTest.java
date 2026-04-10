import java.util.*;
import java.util.stream.*;

/**
 * ============================================================
 * MAIN CLASS - BookMyTrain
 * ============================================================
 *
 * Use Case 9: Group Bogies by Type
 *
 * @version 9.0
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

        public void display() {
            System.out.println(type + " -> " + capacity);
        }
    }

    // ============ MAIN ============
    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC9 - Grouping Bogies ");
        System.out.println("=======================================\n");

        // Reuse list
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 54));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("First Class", 40));
        bogies.add(new Bogie("AC Chair", 54));

        // 🔥 groupingBy
        Map<String, List<Bogie>> grouped =
                bogies.stream()
                        .collect(Collectors.groupingBy(b -> b.type));

        // Display grouped result
        System.out.println("Grouped Bogies:");
        for (String key : grouped.keySet()) {
            System.out.println("\nType: " + key);

            for (Bogie b : grouped.get(key)) {
                b.display();
            }
        }

        System.out.println("\nUC9 completed...");
    }
}