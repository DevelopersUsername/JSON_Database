import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        System.out.println(validPassword(password) ? "YES" : "NO");
    }

    static boolean validPassword(String password) {
        Pattern patternHeightCase = Pattern.compile("[A-Z]+");
        Matcher matcherHeightCase = patternHeightCase.matcher(password);

        Pattern patternLowerCase = Pattern.compile("[a-z]+");
        Matcher matcherLowerCase = patternLowerCase.matcher(password);

        Pattern patternDigit = Pattern.compile("[0-9]+");
        Matcher matcherDigit = patternDigit.matcher(password);

        return matcherHeightCase.find() && matcherLowerCase.find() && matcherDigit.find() && password.length() >= 12;
    }
}