public class BookMyTrain {

    // Linear Search Method
    public static boolean linearSearch(String[] bogies, String key) {
        for (int i = 0; i < bogies.length; i++) {
            if (bogies[i].equals(key)) {
                return true; // Found
            }
        }
        return false; // Not found
    }

    public static void main(String[] args) {

        String[] bogieIds = {
                "BG101", "BG205", "BG309", "BG412", "BG550"
        };

        String searchKey = "BG309";

        boolean found = linearSearch(bogieIds, searchKey);

        if (found) {
            System.out.println("Bogie " + searchKey + " FOUND in train.");
        } else {
            System.out.println("Bogie " + searchKey + " NOT FOUND.");
        }
    }
}