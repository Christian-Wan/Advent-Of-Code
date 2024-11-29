import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Year18_Day03 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("18/3");
        Scanner s = new Scanner(f);

        Set<String> cords = new HashSet<String>();
        Set<String> dupes = new HashSet<String>();
        ArrayList<String> potential = new ArrayList<String>();
        for (int a = 0; a < 2; a++) {
            while (s.hasNext()) {
                boolean claimed = false;
                String line = s.nextLine();
                int startX = Integer.parseInt(line.substring(line.indexOf('@') + 2, line.indexOf(',')));
                int startY = Integer.parseInt(line.substring(line.indexOf(',') + 1, line.indexOf(':')));
                int length = Integer.parseInt(line.substring(line.indexOf(':') + 2, line.indexOf('x')));
                int height = Integer.parseInt(line.substring(line.indexOf('x') + 1));
                for (int i = 0; i < length; i++) {
                    for (int x = 0; x < height; x++) {
                        String cord = (startX + i) + "," + (startY + x);
                        if (a == 0) {
                            if (!cords.add(cord)) {
                                dupes.add(cord);
                            }
                            claimed = true;
                        } else {
                            if (dupes.contains(cord)) {
                                claimed = true;
                            }
                        }
                    }
                }

                if (!claimed && a == 1) {
                    System.out.println("Part 2:" + line.substring(1, line.indexOf(" ")));
                }
            }
            f = new File("18/3");
            s = new Scanner(f);
        }



        System.out.println("Part 1:" + dupes.size());

    }
}
