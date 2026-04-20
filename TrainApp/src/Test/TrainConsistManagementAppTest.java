public class UC18Test {

    public static boolean linearSearch(String[] bogies, String key) {
        for (String b : bogies) {
            if (b.equals(key)) {
                return true;
            }
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
        assertResult(linearSearch(data, "BG309"), true,
                "testSearch_BogieFound");

        // Test 2: Not Found
        assertResult(linearSearch(data, "BG999"), false,
                "testSearch_BogieNotFound");

        // Test 3: First Element
        assertResult(linearSearch(data, "BG101"), true,
                "testSearch_FirstElementMatch");

        // Test 4: Last Element
        assertResult(linearSearch(data, "BG550"), true,
                "testSearch_LastElementMatch");

        // Test 5: Single Element
        String[] single = {"BG101"};
        assertResult(linearSearch(single, "BG101"), true,
                "testSearch_SingleElementArray");
    }
}