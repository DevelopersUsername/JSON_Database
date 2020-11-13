import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        StringBuilder reverse = new StringBuilder(word);

        System.out.println(word.equals(reverse.reverse().toString()) ? "yes" : "no");
    }
}