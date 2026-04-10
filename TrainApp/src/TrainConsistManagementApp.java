import java.util.*;

/**
 * ============================================================
 * MAIN CLASS - BookMyTrain
 * ============================================================
 *
 * Use Case 9: Error Handling & Validation
 *
 * @version 9.0
 */

public class TrainConsistManagementApp {

    // ============ Custom Exception ============
    static class InvalidBogieException extends Exception {
        public InvalidBogieException(String message) {
            super(message);
        }
    }

    // ============ Bogie Class ============
    static class Bogie {
        String id;
        String type;
        int capacity;

        public Bogie(String id, String type, int capacity) throws InvalidBogieException {

            // Validation
            if (id == null || id.isEmpty()) {
                throw new InvalidBogieException("Bogie ID cannot be empty");
            }

            if (capacity <= 0) {
                throw new InvalidBogieException("Capacity must be greater than 0");
            }

            this.id = id;
            this.type = type;
            this.capacity = capacity;
        }

        public void display() {
            System.out.println("ID: " + id +
                    " | Type: " + type +
                    " | Capacity: " + capacity);
        }
    }

    // ============ MAIN ============
    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC9 - Error Handling & Validation ");
        System.out.println("=======================================\n");

        List<Bogie> train = new ArrayList<>();

        try {
            // Valid bogie
            train.add(new Bogie("BG101", "Sleeper", 72));

            // Invalid bogie (capacity <= 0)
            train.add(new Bogie("BG102", "AC Chair", -10));

        } catch (InvalidBogieException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Program continues safely
        System.out.println("\nValid Train Consist:");
        for (Bogie b : train) {
            b.display();
        }

        System.out.println("\nUC9 operations completed successfully...");
    }
}