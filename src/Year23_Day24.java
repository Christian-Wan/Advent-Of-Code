import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Year23_Day24 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("23/24");
        Scanner s = new Scanner(f);
        Year23_Day24_Object[] lines = new Year23_Day24_Object[300];
        long min = Long.parseLong("200000000000000");
        long max = Long.parseLong("400000000000000");
        int index = 0;
        int count = 0;
        while (s.hasNext()) {
            String line = s.nextLine();
            String[] start = line.substring(0, line.indexOf("@") - 1).split(", ");
            String[] slopes = line.substring(line.indexOf("@") + 2).split(", ");
            lines[index] = new Year23_Day24_Object(Long.parseLong(start[0]), Long.parseLong(start[1]), Long.parseLong(start[2]), Integer.parseInt(slopes[0]), Integer.parseInt(slopes[1]), Integer.parseInt(slopes[2]));
            index++;
        }
        for (int i = 0; i < lines.length - 1; i++) {
            for (int x = i + 1; x < lines.length; x++) {
                if (lines[i].solveSystem(lines[x], min, max)) {
                    count++;
                    System.out.println(i + " " + x);
                }
            }
        }
        System.out.println(count);
    }

}
