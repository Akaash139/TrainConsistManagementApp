import java.util.Arrays;

public class UC20Test {

    public static boolean safeBinarySearch(String[] bogies, String key) {

        if (bogies == null || bogies.length == 0) {
            throw new IllegalStateException("Empty train - cannot search");
        }

        Arrays.sort(bogies);

        int low = 0, high = bogies.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = key.compareTo(bogies[mid]);

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

        // Test 1: Exception when empty
        try {
            String[] empty = {};
            safeBinarySearch(empty, "BG101");
            System.out.println("testSearch_ThrowsExceptionWhenEmpty FAILED");
        } catch (IllegalStateException e) {
            System.out.println("testSearch_ThrowsExceptionWhenEmpty PASSED");
        }

        // Test 2: Valid search allowed
        String[] data = {"BG101","BG205"};
        assertResult(safeBinarySearch(data, "BG101"), true,
                "testSearch_AllowsSearchWhenDataExists");

        // Test 3: Found after validation
        String[] data2 = {"BG101","BG205","BG309"};
        assertResult(safeBinarySearch(data2, "BG205"), true,
                "testSearch_BogieFoundAfterValidation");

        // Test 4: Not found after validation
        assertResult(safeBinarySearch(data2, "BG999"), false,
                "testSearch_BogieNotFoundAfterValidation");

        // Test 5: Single element
        String[] single = {"BG101"};
        assertResult(safeBinarySearch(single, "BG101"), true,
                "testSearch_SingleElementValidCase");
    }
}