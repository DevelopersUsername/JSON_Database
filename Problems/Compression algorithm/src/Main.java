import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sequence = scanner.nextLine();
        String currentChar = String.valueOf(sequence.charAt(0));
        StringBuilder compressedSequence = new StringBuilder();
        int count = 1;
        for (int i = 1; i < sequence.length(); i++) {
            if (currentChar.equals(String.valueOf(sequence.charAt(i)))) {
                count++;
            } else {
                compressedSequence.append(currentChar).append(count);
                currentChar = String.valueOf(sequence.charAt(i));
                count = 1;
            }
        }
        compressedSequence.append(currentChar).append(count);
        System.out.println(compressedSequence);
    }
}