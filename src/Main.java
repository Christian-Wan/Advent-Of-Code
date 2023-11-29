import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.security.MessageDigest;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("map/thing");
        Scanner s = new Scanner(f);
        for (int i = 0; i < 6; i++) {
            Map<String, Integer> check = new TreeMap<>();
            while (s.hasNext()) {
                String line = s.nextLine();
                String letter = line.substring(i, i + 1);
                check.putIfAbsent(letter, 0);
                check.replace(letter, check.get(letter) + 1);
            }
            String keys = Arrays.toString(check.keySet().toArray()).substring(1, check.keySet().toArray().toString().length() - 2);
            System.out.println(keys);
            for (int x = 0; x < check.size(); x++){
                System.out.println(x);

            }

        }
    }
}