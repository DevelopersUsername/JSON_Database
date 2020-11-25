import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SortedSet<String> set = new TreeSet<>();

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            set.add(scanner.nextLine());
        }

        set.forEach(System.out::println);
    }
}