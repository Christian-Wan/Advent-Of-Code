import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Year23_Day9 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("23/9");
        Scanner s = new Scanner(f);
        ArrayList<String[]> reports = new ArrayList<>();
        int total = 0;
        while (s.hasNext()) {
            reports = new ArrayList<>();
            String thing = s.nextLine();
            reports.add(thing.split(" "));
            System.out.println("-----------");
            while (!allZero(reports.get(reports.size() - 1))) {
                String[] holdValues = new String[reports.get(reports.size() - 1).length - 1];
                for (int i = 0; i < reports.get(reports.size() - 1).length - 1; i++) {
                    holdValues[i] = Integer.toString(Integer.parseInt(reports.get(reports.size() - 1)[i + 1]) - Integer.parseInt(reports.get(reports.size() - 1)[i]));
                }
                System.out.println(Arrays.toString(holdValues));
                reports.add(holdValues);
            }
            int holder = 0;
            for (int i = reports.size() - 2; i >= 0; i--) {
                System.out.println(Arrays.toString(reports.get(i)));
                holder = Integer.parseInt(reports.get(i)[0]) - holder;
                System.out.println(holder);

            }
            total += holder;
        }
        System.out.println(total);

    }

    public static boolean allZero(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals("0")) {
                return false;
            }
        }
        return true;
    }
}
