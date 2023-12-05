import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TwentythreeFive {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("Twentythree/five");
        Scanner s = new Scanner(f);
        String[] conversionSequence = {"seed", "soil", "fertilizer", "water", "light", "temperature", "humidity"};
        String line = s.nextLine();
        String[] seeds = line.substring(line.indexOf(":") + 2).split(" ");
        ArrayList<String> realSeeds = new ArrayList<>();
        long smallest = 0;


        for (int i = 0; i < seeds.length; i++) {
            for (int x = 0; x < Long.parseLong(seeds[i + 1]); x++) {
                String before = Long.toString(Long.parseLong(seeds[i]) + x);
                System.out.println(before);
                for (String converting : conversionSequence) {
                    before = conversionFinder(converting, before);
                }
                if (smallest == 0 || smallest > Long.parseLong(before)) {
                    smallest = Long.parseLong(before);
                    System.out.println("----");

                }
            }
        }
        System.out.println(smallest);
    }

    public static String conversionFinder(String input, String converting) throws FileNotFoundException {
        File f = new File("Twentythree/five");
        Scanner s = new Scanner(f);
        int counter = 0;
        String result = "";
        while (s.hasNext() && counter != 2) {
            String line = s.nextLine();
            if (line.contains(input)) {
                counter++;
            }
        }
        while (s.hasNext()) {
            String line = s.nextLine();
            String[] range = line.split(" ");
            long conversion;
            try {
                conversion = Long.parseLong(range[0]);
            }
            catch (NumberFormatException e) {
                break;
            }
            long start = Long.parseLong(range[1]);
            long distance = Long.parseLong(range[2]);
            if (Long.parseLong(converting) >= start && Long.parseLong(converting) < start + distance) {
                result = Long.toString((Long.parseLong(converting) - start) + conversion);
            }
        }
        if (result.equals("")) {
            result = converting;
        }
        return result;
    }
}
