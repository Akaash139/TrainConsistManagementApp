import java.util.Arrays;

public class BookMyTrain {

    public static boolean safeBinarySearch(String[] bogies, String key) {

        // 🔴 Fail-Fast Check
        if (bogies == null || bogies.length == 0) {
            throw new IllegalStateException("Cannot perform search: Train has no bogies.");
        }

        // Ensure sorted before binary search
        Arrays.sort(bogies);

        int low = 0;
        int high = bogies.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int cmp = key.compareTo(bogies[mid]);

            if (cmp == 0) return true;
            else if (cmp < 0) high = mid - 1;
            else low = mid + 1;
        }

        return false;
    }

    public static void main(String[] args) {

        String[] bogies = {}; // Try changing this

        try {
            boolean found = safeBinarySearch(bogies, "BG101");

            if (found) {
                System.out.println("Bogie FOUND.");
            } else {
                System.out.println("Bogie NOT FOUND.");
            }

        } catch (IllegalStateException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}