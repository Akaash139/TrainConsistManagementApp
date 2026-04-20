
import java.util.Arrays;

public class UC17Test {

    static void assertArray(String[] result, String[] expected, String testName) {
        if (Arrays.equals(result, expected)) {
            System.out.println(testName + " PASSED");
        } else {
            System.out.println(testName + " FAILED");
        }
    }

    public static void main(String[] args) {

        // Test 1: Basic Sorting
        String[] t1 = {"Sleeper","AC Chair","First Class","General","Luxury"};
        Arrays.sort(t1);
        assertArray(t1,
                new String[]{"AC Chair","First Class","General","Luxury","Sleeper"},
                "testSort_BasicAlphabeticalSorting");

        // Test 2: Unsorted Input
        String[] t2 = {"Luxury","General","Sleeper","AC Chair"};
        Arrays.sort(t2);
        assertArray(t2,
                new String[]{"AC Chair","General","Luxury","Sleeper"},
                "testSort_UnsortedInput");

        // Test 3: Already Sorted
        String[] t3 = {"AC Chair","First Class","General"};
        Arrays.sort(t3);
        assertArray(t3,
                new String[]{"AC Chair","First Class","General"},
                "testSort_AlreadySortedArray");

        // Test 4: Duplicates
        String[] t4 = {"Sleeper","AC Chair","Sleeper","General"};
        Arrays.sort(t4);
        assertArray(t4,
                new String[]{"AC Chair","General","Sleeper","Sleeper"},
                "testSort_Duplicates");

        // Test 5: Single Element
        String[] t5 = {"Sleeper"};
        Arrays.sort(t5);
        assertArray(t5,
                new String[]{"Sleeper"},
                "testSort_SingleElement");
    }
}