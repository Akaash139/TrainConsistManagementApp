import java.util.Arrays;

public class BookMyTrain {

    public static void main(String[] args) {

        // Bogie type names
        String[] bogies = {
                "Sleeper",
                "AC Chair",
                "First Class",
                "General",
                "Luxury"
        };

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(bogies));

        // Built-in sorting
        Arrays.sort(bogies);

        System.out.println("\nAfter Sorting (Alphabetical):");
        System.out.println(Arrays.toString(bogies));
    }
}