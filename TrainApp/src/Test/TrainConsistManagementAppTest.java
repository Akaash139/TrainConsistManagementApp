import java.util.*;

/**
 * ============================================================
 * MAIN CLASS - BookMyTrain
 * ============================================================
 *
 * Use Case 10: Cancellation & Rollback (Stack)
 *
 * @version 10.0
 */

public class TrainConsistManagementAppTest {

    // ============ Allocation System ============
    static class TrainService {

        // Inventory (bogie type -> count)
        Map<String, Integer> inventory = new HashMap<>();

        // Allocated bogies
        Set<String> allocated = new HashSet<>();

        // Rollback stack (LIFO)
        Stack<String> rollbackStack = new Stack<>();

        public TrainService() {
            inventory.put("Sleeper", 2);
            inventory.put("AC", 1);
        }

        // Allocate bogie
        public void allocate(String id, String type) {
            if (!inventory.containsKey(type) || inventory.get(type) <= 0) {
                System.out.println("Allocation failed for " + id);
                return;
            }

            inventory.put(type, inventory.get(type) - 1);
            allocated.add(id);

            System.out.println("Allocated " + id + " (" + type + ")");
        }

        // Cancel (Rollback)
        public void cancel(String id, String type) {

            if (!allocated.contains(id)) {
                System.out.println("Invalid cancellation for " + id);
                return;
            }

            // Push to stack
            rollbackStack.push(id);

            // Remove allocation
            allocated.remove(id);

            // Restore inventory
            inventory.put(type, inventory.get(type) + 1);

            System.out.println("Cancelled " + id + " -> rolled back");
        }

        public void showStatus() {
            System.out.println("\nInventory: " + inventory);
            System.out.println("Allocated: " + allocated);
            System.out.println("Rollback Stack: " + rollbackStack);
        }
    }

    // ============ MAIN ============
    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC10 - Cancellation & Rollback ");
        System.out.println("=======================================\n");

        TrainService ts = new TrainService();

        // Allocate
        ts.allocate("BG101", "Sleeper");
        ts.allocate("BG102", "AC");

        // Cancel latest
        ts.cancel("BG102", "AC");

        // Invalid cancel
        ts.cancel("BG999", "Sleeper");

        // Show final state
        ts.showStatus();

        System.out.println("\nUC10 completed...");
    }
}