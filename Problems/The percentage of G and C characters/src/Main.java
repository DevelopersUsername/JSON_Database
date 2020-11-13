import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.nextLine().toLowerCase();

        System.out.println((double) (sequence.replaceAll("[^cg]", "").length()) / sequence.length() * 100);
    }
}