import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Year24_Day07 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("24/7");
        Scanner s = new Scanner(f);

        Long total = 0L;
        boolean worked = false;

        while (s.hasNext()) {
            String line = s.nextLine();
            ArrayList<String> split = new ArrayList<>(List.of(line.substring(line.indexOf(" ") + 1).split(" ")));
            String result = line.substring(0, line.indexOf(":"));
            ArrayList<Integer> binary = new ArrayList<>();
            for (int i = 0; i < split.size() - 1; i++) {
                binary.add(0);
            }
            while (binary.contains(0) || binary.contains(1)) {
                worked = false;
                if (solveEquation(binary, split).equals(result)) {
                    worked = true;
                    total += Long.parseLong(result);
                    System.out.println("Works: " + split);
                    break;
                }
                updateBinary(binary);
            }
            if (!worked) {
                if (solveEquation(binary, split).equals(result)) {
                    total += Long.parseLong(result);
                    System.out.println("Works: " + split);
                }
            }
        }
        System.out.println(total);
    }


    private static void updateBinary(ArrayList<Integer> start) {
        start.set(start.size() - 1, start.get(start.size() - 1) + 1);
        for (int i = start.size() - 1; i > 0; i--) {
            if (start.get(i) == 3) {
                start.set(i, 0);
                start.set(i - 1, start.get(i - 1) + 1);
            }
        }
    }

    private static String solveEquation(ArrayList<Integer> binary, ArrayList<String> split) {
        ArrayList<Integer> binary2 = new ArrayList<>(binary);
        ArrayList<String> split2 = new ArrayList<>(split);


        for (int i = 0; i < binary2.size(); i++) {
            if (binary2.get(i) == 1) {
                split2.set(i, String.valueOf((Long.parseLong(split2.get(i)) * Long.parseLong(split2.get(i + 1)))));
                split2.remove(i + 1);
                binary2.remove(i);
                i--;
            }
            else if (binary2.get(i) == 0){
                split2.set(i, String.valueOf((Long.parseLong(split2.get(i)) + Long.parseLong(split2.get(i + 1)))));
                split2.remove(i + 1);
                binary2.remove(i);
                i--;
            }
            else {
                split2.set(i, split2.get(i) + split2.get(i + 1));
                split2.remove(i + 1);
                binary2.remove(i);
                i--;
            }
        }
        return split2.getFirst();
    }

    //3205255397060
}
