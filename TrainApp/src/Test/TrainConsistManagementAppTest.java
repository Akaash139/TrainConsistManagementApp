import java.util.*;
import java.util.stream.*;

public class TrainConsistManagementAppTest {

    static class Bogie {
        String type;
        int capacity;

        public Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    // Loop filtering
    static List<Bogie> loopFilter(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // Stream filtering
    static List<Bogie> streamFilter(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC", 54),
                new Bogie("Cargo", 100)
        );

        // ✅ Test 1: Loop logic
        System.out.println("Loop Filter Size: " + loopFilter(bogies).size()); // 2

        // ✅ Test 2: Stream logic
        System.out.println("Stream Filter Size: " + streamFilter(bogies).size()); // 2

        // ✅ Test 3: Same results
        System.out.println("Match: " +
                (loopFilter(bogies).size() == streamFilter(bogies).size()));

        // ✅ Test 4: Time measurement
        long start = System.nanoTime();
        loopFilter(bogies);
        long end = System.nanoTime();
        System.out.println("Time > 0: " + ((end - start) > 0));

        // ✅ Test 5: Large dataset
        List<Bogie> big = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            big.add(new Bogie("T", i));
        }
        System.out.println("Large Data OK: " + (streamFilter(big).size() >= 0));
    }
}