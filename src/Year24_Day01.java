import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Year24_Day01 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("24/1");
        Scanner s = new Scanner(f);

        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        int total = 0;
        int total2 = 0;

        while (s.hasNext()) {
            String line = s.nextLine();
            left.add(Integer.parseInt(line.substring(0, line.indexOf(" "))));
            right.add(Integer.parseInt(line.substring(line.indexOf(" ") + 3)));
        }
        Collections.sort(right);
        Collections.sort(left);


        for (int i = 0; i < right.size(); i++) {
            total += Math.abs(right.get(i) - left.get(i));
        }
        System.out.println(total);
        for (int i = 0; i < left.size(); i++) {
            ArrayList<Integer> duplicate = new ArrayList<>(right);
            duplicate.removeAll(Arrays.asList(left.get(i)));
            total2 += (right.size() - duplicate.size()) * left.get(i);
        }
        System.out.println(total2);
    }
}
