import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwentythreeFour {
    public static void main(String[] args) throws FileNotFoundException {

        File f = new File("Twentythree/four");
        Scanner s = new Scanner(f);
        String[] winning;
        String[] yours;
        ArrayList<Integer> copies = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            copies.add(0);
        }
        int total = 0;
        while (s.hasNext()) {
            copies.remove(0);
            copies.add(0);
            System.out.println(copies);
            int count = 0;
            String line = s.nextLine();
            line = line.substring(line.indexOf(": ") + 2);
            winning = line.substring(0, line.indexOf(" |")).split(" ");
            yours = line.substring(line.indexOf("| ") + 2).split(" ");
            for (int i = 0; i < yours.length; i++) {
                for (int x = 0; x < winning.length; x++) {
                    if (yours[i].equals(winning[x]) && !yours[i].equals("")) {
                        count++;
                    }
                }
            }
            System.out.println( count);
            for (int x = 0; x <= copies.get(0); x++) {
                for (int i = 0; i < count; i++) {
                    copies.set(i + 1, copies.get(i + 1) + 1);
                }
            }

            total += copies.get(0) + 1;
        }
        System.out.println(total);
    }
}
