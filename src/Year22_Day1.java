import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Year22_Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("22/1");
        Scanner s = new Scanner(f);

        int[] highest = {0, 0, 0};
        int current = 0;
        while (s.hasNext()) {
            String line = s.nextLine();
            if (!line.isEmpty()) {
                current += Integer.parseInt(line);
            }
            else {
                for (int i = 0; i < 3; i++) {
                    if (current > highest[i]) {
                        System.out.println(current);
                        for (int x = 1 - i; x >= 0; x--) {
                            highest[i + x + 1] = highest[i + x];
                        }
                        highest[i] = current;
                        for (int x = 0; x < 3; x++) {
                            System.out.print(highest[x] + " ");
                        }
                        System.out.println();
                        break;
                    }
                }
                current = 0;
            }
        }
        System.out.println(highest[0] + highest[1] + highest[2]);
    }
}
