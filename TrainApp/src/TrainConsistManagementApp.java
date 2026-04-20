import java.util.Arrays;

public class BookMyTrain {

    // Binary Search Method
    public static boolean binarySearch(String[] bogies, String key) {

        int low = 0;
        int high = bogies.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int cmp = key.compareTo(bogies[mid]);

            if (cmp == 0) {
                return true; // Found
            }
            else if (cmp < 0) {
                high = mid - 1; // Search left
            }
            else {
                low = mid + 1; // Search right
            }
        }

        return false; // Not found
    }

    public static void main(String[] args) {

        String[] bogieIds = {
                "BG309", "BG101", "BG550", "BG205", "BG412"
        };

        // IMPORTANT: Sort before Binary Search
        Arrays.sort(bogieIds);

        String searchKey = "BG309";

        boolean found = binarySearch(bogieIds, searchKey);

        if (found) {
            System.out.println("Bogie " + searchKey + " FOUND.");
        } else {
            System.out.println("Bogie " + searchKey + " NOT FOUND.");
        }
    }
}