import java.util.*;

public class TrainConsistManagementAppTest {

    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String msg) {
            super(msg);
        }
    }

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
    }

    public static void main(String[] args) {

        // ✅ Test 1: Valid capacity
        try {
            Bogie b = new Bogie("Sleeper", 72);
            System.out.println("Valid Creation: PASS");
        } catch (Exception e) {
            System.out.println("Valid Creation: FAIL");
        }

        // ✅ Test 2: Negative capacity
        try {
            new Bogie("AC", -10);
            System.out.println("Negative Test: FAIL");
        } catch (InvalidCapacityException e) {
            System.out.println("Negative Test: PASS");
        }

        // ✅ Test 3: Zero capacity
        try {
            new Bogie("First Class", 0);
            System.out.println("Zero Test: FAIL");
        } catch (InvalidCapacityException e) {
            System.out.println("Zero Test: PASS");
        }

        // ✅ Test 4: Exception message
        try {
            new Bogie("Test", 0);
        } catch (InvalidCapacityException e) {
            System.out.println("Message Check: " +
                    e.getMessage().equals("Capacity must be greater than zero"));
        }

        // ✅ Test 5: Object integrity
        try {
            Bogie b = new Bogie("Sleeper", 72);
            System.out.println("Integrity Check: " +
                    (b.type.equals("Sleeper") && b.capacity == 72));
        } catch (Exception e) {
            System.out.println("Integrity Check: FAIL");
        }

        // ✅ Test 6: Multiple valid bogies
        try {
            List<Bogie> list = new ArrayList<>();
            list.add(new Bogie("S1", 50));
            list.add(new Bogie("S2", 60));
            System.out.println("Multiple Creation: PASS");
        } catch (Exception e) {
            System.out.println("Multiple Creation: FAIL");
        }
    }
}