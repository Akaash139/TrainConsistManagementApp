import java.util.*;

public class TrainConsistManagementAppTest {

    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String msg) {
            super(msg);
        }
    }

    static class GoodsBogie {
        String shape;
        String cargo;

        public GoodsBogie(String shape) {
            this.shape = shape;
        }

        public void assignCargo(String cargo) {
            try {
                if (shape.equalsIgnoreCase("Rectangular") &&
                        cargo.equalsIgnoreCase("Petroleum")) {

                    throw new CargoSafetyException("Unsafe assignment");
                }
                this.cargo = cargo;

            } catch (CargoSafetyException e) {
                // handled

            } finally {
                System.out.println("Finally executed");
            }
        }
    }

    public static void main(String[] args) {

        // ✅ Test 1: Safe assignment
        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        b1.assignCargo("Petroleum");
        System.out.println("Safe Assignment: " + ("Petroleum".equals(b1.cargo)));

        // ✅ Test 2: Unsafe handled
        GoodsBogie b2 = new GoodsBogie("Rectangular");
        b2.assignCargo("Petroleum");
        System.out.println("Unsafe Handled: " + (b2.cargo == null));

        // ✅ Test 3: Cargo not assigned after failure
        System.out.println("No Assignment After Fail: " + (b2.cargo == null));

        // ✅ Test 4: Program continues
        GoodsBogie b3 = new GoodsBogie("Rectangular");
        b3.assignCargo("Coal");
        System.out.println("Program Continues: " + ("Coal".equals(b3.cargo)));

        // ✅ Test 5: Finally block (visual check)
        System.out.println("Check above -> 'Finally executed' printed every time");
    }
}