import java.util.*;

/**
 * ============================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ============================================================
 *
 * Use Case 1: Initialize Train and Display Consist Summary
 *
 * @version 1.0
 */

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" === Train Consist Management App === ");
        System.out.println("=======================================");

        // Initialize empty consist
        List<String> trainConsist = new ArrayList<>();

        System.out.println("\nTrain initialized successfully...");
        System.out.println("Initial Bogie Count : " + trainConsist.size());

        // Print empty consist
        System.out.println("Current Train Consist : " + trainConsist);

        System.out.println("\nSystem ready for operations...");
    }
}