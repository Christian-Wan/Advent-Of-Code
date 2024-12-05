import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Year24_Day05 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("24/5");
        Scanner s = new Scanner(f);

        ArrayList<String> rules = new ArrayList<String>();
        ArrayList<ArrayList<String>> pages = new ArrayList<>();
        boolean swap = false;
        String line = "";
        int total = 0;
        int total2 = 0;

        while (s.hasNext()) {
            line = s.nextLine();
            if (line.isEmpty()) {
                swap = true;
            }
            if (!swap) {
                rules.add(line);
            }
            else {
                pages.add(new ArrayList<>(Arrays.asList(line.split(","))));
            }
        }
        pages.remove(0);
        System.out.println(rules);
        System.out.println(pages);

        for (int i = 0; i < pages.size(); i++) {
            boolean works = true;
            ArrayList<String> current = pages.get(i);
            for (int x = 0; x < current.size(); x++) {
                for (int y = 0; y < current.size() - 1; y++) {
                    String correctRule = "";
                    if (y >= x) {
                        correctRule = current.get(x) + "|" + current.get(y + 1);
                    }
                    else {
                        correctRule = current.get(y) + "|" + current.get(x);
                    }
                    if (!rules.contains(correctRule)) {
                        works = false;
                        break;
                    }
                }
                if (!works) {
                    break;
                }
            }
            if (works) {
                total += Integer.parseInt(current.get(current.size() / 2));
            }
            else { //part2
                boolean sorted = false;
                while (!sorted) {
                    for (int x = 0; x < current.size() - 1; x++) {
                        sorted = true;
                        String store = "";
                        String currentRule = current.get(x) + "|" + current.get(x + 1);
                        if (!rules.contains(currentRule)) {
                            store = current.get(x);
                            current.set(x, current.get(x + 1));
                            current.set(x + 1, store);
                            sorted = false;
                            break;
                        }
                    }
                }
                total2 += Integer.parseInt(current.get(current.size() / 2));
            }
        }
        System.out.println(total);
        System.out.println(total2);
    }
    //4578

    //6179
}
