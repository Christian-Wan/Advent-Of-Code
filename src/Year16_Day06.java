import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Year16_Day06 {
    public static void main(String[] args) throws FileNotFoundException {
        String finalWord = "";
        File f = new File("16/6");
        for (int i = 0; i < 8; i++) {
            Scanner s = new Scanner(f);
            Map<String, Integer> check = new TreeMap<>();
            while (s.hasNext()) {
                String line = s.nextLine();
                String letter = line.substring(i, i + 1);
                check.putIfAbsent(letter, 0);
                check.replace(letter, check.get(letter) + 1);
            }
            String keys = Arrays.toString(check.keySet().toArray()).substring(1, Arrays.toString(check.keySet().toArray()).length() - 1);
            int min = 599;
            String letter = "";
            for (int x = 0; x < keys.length(); x += 3){
                if (check.get(keys.substring(x, x + 1)) < min) {
                    letter = keys.substring(x, x + 1);
                    min = check.get(keys.substring(x, x + 1));
                }

            }
            System.out.println(check);
            finalWord += letter;

        }
        System.out.println(finalWord);
    }
}