import java.util.*;

/**
 * ============================================================
 * UC14: Handle Invalid Bogie Capacity (Custom Exception)
 * ============================================================
 */

public class TrainConsistManagementApp {

    // 🔴 Custom Exception
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // 🚆 Bogie Class
    static class Bogie {
        String type;
        int capacity;

        public Bogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        public void display() {
            System.out.println(type + " -> Capacity: " + capacity);
        }
    }

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC14 - Custom Exception Handling ");
        System.out.println("=======================================\n");

        List<Bogie> train = new ArrayList<>();

        try {
            // ✅ Valid bogies
            train.add(new Bogie("Sleeper", 72));
            train.add(new Bogie("AC Chair", 60));

            // ❌ Invalid bogie (will throw exception)
            train.add(new Bogie("First Class", 0));

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Display valid bogies only
        System.out.println("\nFinal Train Consist:");
        for (Bogie b : train) {
            b.display();
        }

        System.out.println("\nUC14 completed...");
    }
}