import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Year15_Day05 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("15/5");
        Scanner s = new Scanner(f);
        int count = 0;

        while (s.hasNext()) {
            String line = s.nextLine();
            if (skipCheck(line) && pairCheck(line)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean vowelCheck(String input) {
        int count = 0;
        String vowels = "aeiou";
        for (int i = 0; i < input.length(); i++) {
            if (vowels.contains(input.substring(i, i + 1))) {
                count++;
            }
        }
        return count >= 3;
    }

    public static boolean twiceCheck(String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.substring(i, i + 1).equals(input.substring(i + 1, i + 2))) {
                return true;
            }
        }
        return false;
    }



    public static boolean exceptionCheck(String input) {
        String[] exceptions = {"ab", "cd", "pq", "xy"};
        for (int i = 0; i < input.length() - 1; i++) {
            for (int x = 0; x < 4; x++) {
                if (input.substring(i, i + 2).equals(exceptions[x])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean skipCheck(String input) {
        for (int i = 0; i < input.length() - 2; i++) {
            for (int x = 0; x < 4; x++) {
                String group = input.substring(i, i + 3);
                if (group.charAt(0) == group.charAt(2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean pairCheck(String input) {
        ArrayList<String> pairs = new ArrayList<>();
        for (int i = 0; i < input.length() - 1; i++) {
            String currentPair = input.substring(i, i + 2);
            for (int x = 0; x < pairs.size() - 1; x++) {
                if (currentPair.equals(pairs.get(x))) {
                    return true;
                }
            }
            pairs.add(currentPair);
        }
        return false;
    }
}
