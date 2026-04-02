import java.util.*;

/**
 * ============================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ============================================================
 *
 * Use Case 4: Maintain Ordered Bogie IDs (LinkedList)
 *
 * @version 4.0
 */

public class TrainConsistManagementApp{

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC4 - Maintain Ordered Train Consist ");
        System.out.println("=======================================\n");

        // Create LinkedList
        LinkedList<String> train = new LinkedList<>();

        // Add bogies
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(train + "\n");

        // Insert Pantry Car at position 2
        train.add(2, "Pantry");

        System.out.println("After Adding Pantry Car at position 2:");
        System.out.println(train + "\n");

        // Remove first and last
        train.removeFirst();
        train.removeLast();

        System.out.println("After Removing First and Last Bogie:");
        System.out.println(train + "\n");

        // Final consist
        System.out.println("Final Ordered Train Consist:");
        System.out.println(train + "\n");

        System.out.println("UC4 operations completed successfully...");
    }
}