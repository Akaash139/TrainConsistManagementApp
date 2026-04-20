import java.util.*;

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class TrainConsistManagementAppTest {

    static void bubbleSort(List<Bogie> bogies) {
        int n = bogies.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (bogies.get(j).capacity > bogies.get(j + 1).capacity) {
                    Bogie temp = bogies.get(j);
                    bogies.set(j, bogies.get(j + 1));
                    bogies.set(j + 1, temp);
                }
            }
        }
    }

    static boolean isSorted(List<Bogie> bogies) {
        for (int i = 0; i < bogies.size() - 1; i++) {
            if (bogies.get(i).capacity > bogies.get(i + 1).capacity)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        List<Bogie> test = Arrays.asList(
                new Bogie("A", 72),
                new Bogie("B", 56),
                new Bogie("C", 24)
        );

        bubbleSort(test);

        if (isSorted(test))
            System.out.println("testSort_Bogies PASSED");
        else
            System.out.println("testSort_Bogies FAILED");
    }
}