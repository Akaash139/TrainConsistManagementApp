import java.util.*;
import java.util.stream.*;

public class TrainConsistManagementAppTest {

    static class GoodsBogie {
        String type;
        String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    // Method to test
    static boolean isTrainSafe(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b ->
                        !b.type.equals("Cylindrical") ||
                                b.cargo.equals("Petroleum")
                );
    }

    public static void main(String[] args) {

        // ✅ Test 1: All valid
        List<GoodsBogie> t1 = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal")
        );
        System.out.println("Test1: " + isTrainSafe(t1)); // true

        // ❌ Test 2: Invalid cylindrical
        List<GoodsBogie> t2 = Arrays.asList(
                new GoodsBogie("Cylindrical", "Coal")
        );
        System.out.println("Test2: " + isTrainSafe(t2)); // false

        // ✅ Test 3: Non-cylindrical allowed
        List<GoodsBogie> t3 = Arrays.asList(
                new GoodsBogie("Box", "Grain")
        );
        System.out.println("Test3: " + isTrainSafe(t3)); // true

        // ❌ Test 4: Mixed violation
        List<GoodsBogie> t4 = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Cylindrical", "Coal")
        );
        System.out.println("Test4: " + isTrainSafe(t4)); // false

        // ✅ Test 5: Empty list
        List<GoodsBogie> t5 = new ArrayList<>();
        System.out.println("Test5: " + isTrainSafe(t5)); // true
    }
}