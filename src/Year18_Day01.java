import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Year18_Day01 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("18/1");
        Scanner s = new Scanner(f);

        int frequency = 0;
        ArrayList<Integer> seen = new ArrayList<Integer>();
        ArrayList<String> lines = new ArrayList<String>();


        while (s.hasNext()) {
            lines.add(s.nextLine());
        }

        int i = 0;
        while (!seen.contains(frequency)) {
            seen.add(frequency);
            if (lines.get(i).charAt(0) == '-') {
                frequency -= Integer.parseInt(lines.get(i).substring(1));
            }
            else {
                frequency += Integer.parseInt(lines.get(i).substring(1));
            }
            i++;
            if (i == lines.size()) {
                i = 0;
            }
        }
        System.out.println(frequency);
    }
}
