import java.util.Arrays;

public class UC19Test {

    public static boolean binarySearch(String[] arr, String key) {

        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int cmp = key.compareTo(arr[mid]);

            if (cmp == 0) return true;
            else if (cmp < 0) high = mid - 1;
            else low = mid + 1;
        }

        return false;
    }

    static void assertResult(boolean result, boolean expected, String testName) {
        if (result == expected) {
            System.out.println(testName + " PASSED");
        } else {
            System.out.println(testName + " FAILED");
        }
    }

    public static void main(String[] args) {

        String[] data = {"BG101","BG205","BG309","BG412","BG550"};

        // Test 1: Found
        assertResult(binarySearch(data, "BG309"), true,
                "testBinarySearch_BogieFound");

        // Test 2: Not Found
        assertResult(binarySearch(data, "BG999"), false,
                "testBinarySearch_BogieNotFound");

        // Test 3: First Element
        assertResult(binarySearch(data, "BG101"), true,
                "testBinarySearch_FirstElementMatch");

        // Test 4: Last Element
        assertResult(binarySearch(data, "BG550"), true,
                "testBinarySearch_LastElementMatch");

        // Test 5: Single Element
        String[] single = {"BG101"};
        assertResult(binarySearch(single, "BG101"), true,
                "testBinarySearch_SingleElementArray");

        // Test 6: Empty Array
        String[] empty = {};
        assertResult(binarySearch(empty, "BG101"), false,
                "testBinarySearch_EmptyArray");

        // Test 7: Unsorted Input (Handled)
        String[] unsorted = {"BG309","BG101","BG550","BG205","BG412"};
        Arrays.sort(unsorted);
        assertResult(binarySearch(unsorted, "BG205"), true,
                "testBinarySearch_UnsortedInputHandled");
    }
}