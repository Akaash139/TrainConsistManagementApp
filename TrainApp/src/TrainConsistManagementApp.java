import java.util.*;
import java.util.stream.*;

/**
 * ============================================================
 * UC12: Safety Compliance Check
 * ============================================================
 */

public class TrainConsistManagementApp {

    // ============ Goods Bogie ============
    static class GoodsBogie {
        String type;
        String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        public void display() {
            System.out.println(type + " -> " + cargo);
        }
    }

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC12 - Safety Compliance ");
        System.out.println("=======================================\n");

        List<GoodsBogie> bogies = new ArrayList<>();

        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));

        // 🔥 allMatch validation
        boolean isSafe = bogies.stream()
                .allMatch(b ->
                        !b.type.equals("Cylindrical") ||
                                b.cargo.equals("Petroleum")
                );

        // Display
        System.out.println("Bogie Details:");
        bogies.forEach(b -> b.display());

        System.out.println("\nTrain Safety Status: " +
                (isSafe ? "SAFE" : "UNSAFE"));

        System.out.println("\nUC12 completed...");
    }
}