import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Year15_Day02 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("15/2");
        Scanner s = new Scanner(f);

        int first, second, third;
        int total = 0;
        while (s.hasNext()) {
            String line = s.nextLine();
            System.out.println(line);
            first = Integer.parseInt(line.substring(0, line.indexOf("x")));
            line = line.substring(line.indexOf("x") + 1);
            second = Integer.parseInt(line.substring(0, line.indexOf("x")));
            line = line.substring(line.indexOf("x") + 1);
            third = Integer.parseInt(line);
            int s1 = 2 * (first + second);
            int s2 = 2 * (first + third);
            int s3 = 2 * (third + second);
            total += first * second * third;
            if (s1 <= s2 && s1 <= s3) {
                total += s1;
                System.out.println(s1);
            }
            else if (s2 <= s1 && s2 <= s3) {
                total += s2;
                System.out.println(s2);
            }
            else {
                total += s3;
                System.out.println(s3);
            }
        }
        System.out.println(total);
    }
}
