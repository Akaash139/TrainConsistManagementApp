import java.util.*;

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    void display() {
        System.out.println(name + " -> Capacity: " + capacity);
    }
}

public class TrainConsistManagementApp {

    // Bubble Sort based on capacity
    public static void bubbleSort(List<Bogie> bogies) {
        int n = bogies.size();

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (bogies.get(j).capacity > bogies.get(j + 1).capacity) {

                    // swap objects
                    Bogie temp = bogies.get(j);
                    bogies.set(j, bogies.get(j + 1));
                    bogies.set(j + 1, temp);

                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }

    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("General", 24));
        bogies.add(new Bogie("First Class", 70));
        bogies.add(new Bogie("Second Sitting", 60));

        System.out.println("Before Sorting:");
        for (Bogie b : bogies) b.display();

        bubbleSort(bogies);

        System.out.println("\nAfter Sorting (By Capacity):");
        for (Bogie b : bogies) b.display();
    }
}