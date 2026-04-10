import java.util.*;

/**
 * ============================================================
 * MAIN CLASS - BookMyTrain
 * ============================================================
 *
 * Use Case 8: Train Consist History & Reporting
 *
 * @version 8.0
 */

public class TrainConsistManagementAppTest{

    // ============ Bogie Class ============
    static class Bogie {
        String id;
        String type;
        int capacity;

        public Bogie(String id, String type, int capacity) {
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

    // ============ History ============
    static class TrainHistory {
        List<Bogie> history = new ArrayList<>();

        void addBogie(Bogie b) {
            history.add(b);
        }

        void showHistory() {
            System.out.println("\nTrain Consist History:");
            for (Bogie b : history) {
                b.display();
            }
        }
    }

    // ============ Report ============
    static class ReportService {

        static void generateReport(List<Bogie> history) {
            int totalCapacity = 0;

            for (Bogie b : history) {
                totalCapacity += b.capacity;
            }

            System.out.println("\n--- Train Report ---");
            System.out.println("Total Bogies: " + history.size());
            System.out.println("Total Capacity: " + totalCapacity);
        }
    }

    // ============ MAIN ============
    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC8 - Train History & Reporting ");
        System.out.println("=======================================\n");

        TrainHistory th = new TrainHistory();

        // Add bogies (confirmed consist)
        th.addBogie(new Bogie("BG101", "Sleeper", 72));
        th.addBogie(new Bogie("BG102", "AC Chair", 54));
        th.addBogie(new Bogie("BG103", "Cargo", 100));

        // Show history
        th.showHistory();

        // Generate report
        ReportService.generateReport(th.history);

        System.out.println("\nUC8 operations completed successfully...");
    }
}