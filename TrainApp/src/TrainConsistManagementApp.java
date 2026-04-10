import java.util.*;
import java.util.stream.*;

/**
 * ============================================================
 * UC13: Performance Comparison (Loop vs Stream)
 * ============================================================
 */

public class TrainConsistManagementApp {

    static class Bogie {
        String type;
        int capacity;

        public Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC13 - Performance Comparison ");
        System.out.println("=======================================\n");

        // Large dataset
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Type" + i, (i % 100) + 1));
        }

        // 🔥 Loop-based filtering
        long startLoop = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();

        // 🔥 Stream-based filtering
        long startStream = System.nanoTime();

        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        long endStream = System.nanoTime();

        // Results
        System.out.println("Loop Time (ns): " + (endLoop - startLoop));
        System.out.println("Stream Time (ns): " + (endStream - startStream));

        System.out.println("\nLoop Result Size: " + loopResult.size());
        System.out.println("Stream Result Size: " + streamResult.size());

        System.out.println("\nUC13 completed...");
    }
}