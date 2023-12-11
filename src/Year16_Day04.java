import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Year16_Day04 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("16/4");
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String line = s.nextLine();
            String temp = "";
            int numbers = Integer.parseInt(line.substring(line.indexOf("[") - 3, line.indexOf("[")));
            int increment = numbers % 26;
            for (int i = 0; i < line.indexOf("[") - 4; i++) {
                if (line.charAt(i) == '-') {
                    temp += " ";
                }
                else {
                    char thing = line.charAt(i);
                    for (int x = 0; x < increment; x++) {
                        if ((((int) thing) + 1) > 122) {
                            thing = 'a';
                        }
                        else {
                            thing = (char) (((int) thing) + 1);
                        }
                    }
                    temp += thing;
                }
            }

            if (temp.toLowerCase().contains("northpole")) {
                System.out.println(numbers);
            }
        }
    }
}
