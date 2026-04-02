import java.util.*;

/**
 * ============================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ============================================================
 *
 * Use Case 3: Track Unique Bogie IDs (HashSet)
 *
 * @version 3.0
 */

public class TrainConsistManagementApp{

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC3 - Track Unique Bogie IDs ");
        System.out.println("=======================================\n");

        // Create HashSet
        Set<String> bogieIds = new HashSet<>();

        // Add bogie IDs (with duplicates)
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        // Display all bogie IDs
        System.out.println("Bogie IDs after adding (duplicates ignored):");
        System.out.println(bogieIds + "\n");

        // Show total unique count
        System.out.println("Total Unique Bogies : " + bogieIds.size() + "\n");

        System.out.println("UC3 operations completed successfully...");
    }
}