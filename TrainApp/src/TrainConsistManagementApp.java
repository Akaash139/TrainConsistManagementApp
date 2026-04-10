import java.util.*;

/**
 * ============================================================
 * UC15: Safe Cargo Assignment using try-catch-finally
 * ============================================================
 */

public class TrainConsistManagementApp {

    // 🔴 Custom Runtime Exception
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // 🚆 Goods Bogie Class
    static class GoodsBogie {
        String shape;   // Cylindrical / Rectangular
        String cargo;

        public GoodsBogie(String shape) {
            this.shape = shape;
        }

        // 🚨 Assign Cargo with Safety Check
        public void assignCargo(String cargo) {
            try {
                // Rule: Rectangular cannot carry Petroleum
                if (shape.equalsIgnoreCase("Rectangular") &&
                        cargo.equalsIgnoreCase("Petroleum")) {

                    throw new CargoSafetyException(
                            "Unsafe: Rectangular bogie cannot carry Petroleum");
                }

                // Safe assignment
                this.cargo = cargo;
                System.out.println("Cargo assigned successfully: " + cargo);

            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());

            } finally {
                System.out.println("Validation completed for " + shape + " bogie\n");
            }
        }

        public void display() {
            System.out.println(shape + " Bogie -> Cargo: " + cargo);
        }
    }

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC15 - Safe Cargo Assignment ");
        System.out.println("=======================================\n");

        // ✅ Safe case
        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        b1.assignCargo("Petroleum");

        // ❌ Unsafe case
        GoodsBogie b2 = new GoodsBogie("Rectangular");
        b2.assignCargo("Petroleum");

        // ✅ Another safe case (program continues)
        GoodsBogie b3 = new GoodsBogie("Rectangular");
        b3.assignCargo("Coal");

        // Display
        System.out.println("Final Bogie States:");
        b1.display();
        b2.display(); // should be null cargo
        b3.display();

        System.out.println("\nUC15 completed...");
    }
}