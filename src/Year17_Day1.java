import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Year17_Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("17/1");
        Scanner s = new Scanner(f);
        String line = s.nextLine();
        String line2 = line.substring(line.length() / 2) + line.substring(0, line.length() / 2);
        int total = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == line2.charAt(i)) {
                total += Integer.parseInt(line.substring(i, i + 1));
            }
        }
        System.out.println(total);
    }
}
