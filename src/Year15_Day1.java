import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Year15_Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("15/1");
        Scanner s = new Scanner(f);

        int floor = 0;
        int count = 0;
        String line = s.nextLine();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(') {
                floor++;
            }
            else {
                floor--;
            }
            count++;
            if (floor == -1) {
                System.out.println(count);
                break;
            }
        }
    }
}
