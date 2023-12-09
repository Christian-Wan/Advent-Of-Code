import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Year23_Day5 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("23/5");
        Scanner s = new Scanner(f);
        String line = s.nextLine();
        String[] seeds = line.substring(line.indexOf(":") + 2).split(" ");
        long smallest = 0;
        String file = line;
        while (s.hasNext()) {
            file += "\n" + s.nextLine();
        }
        file += "\n";
        ArrayList<long[]> seedsToSoil = conversionFinder("seed", file);
        ArrayList<long[]> soilToFertilizer = conversionFinder("soil",file);
        ArrayList<long[]> fertilizerToWater = conversionFinder("fertilizer",file);
        ArrayList<long[]> waterToLight = conversionFinder("water",file);
        ArrayList<long[]> lightToTemperature = conversionFinder("light",file);
        ArrayList<long[]> TemperatureToHumidity = conversionFinder("temperature",file);
        ArrayList<long[]> humidityToLocation = conversionFinder("humidity",file);
        ArrayList[] conversionSequence = {seedsToSoil, soilToFertilizer, fertilizerToWater, waterToLight, lightToTemperature, TemperatureToHumidity, humidityToLocation};


        s.close();

        for (int i = 0; i < seeds.length; i += 2) {
            System.out.println("next" + i);
            for (int x = 0; x < Long.parseLong(seeds[i + 1]); x++) {
                long before = Long.parseLong(seeds[i]) + x;
                for (ArrayList converting : conversionSequence) {
                    before = findConversion(converting, before);
                }
                if (smallest == 0 || smallest > before) {
                    smallest = before;
                    System.out.println("new:" + before);

                }
            }
        }
        System.out.println(smallest);
    }



    public static ArrayList<long[]> conversionFinder(String input, String file) {
        int counter = 0;
        ArrayList<long[]> big = new ArrayList<>();
        while (file.contains("\n") && counter != 2) {
            String line = file.substring(0, file.indexOf("\n"));
            file = file.substring(file.indexOf("\n") + 1);
            if (line.contains(input)) {
                counter++;
            }
        }
        while (file.contains("\n")) {
            long[] small = new long[3];
            String line = file.substring(0, file.indexOf("\n"));
            file = file.substring(file.indexOf("\n") + 1);
            String[] range = line.split(" ");
            try {
                long test = Long.parseLong(range[0]);
            }
            catch (NumberFormatException e) {
                break;
            }
            for (int i = 0; i < range.length; i++) {
                    small[i] = Long.parseLong(range[i]);
            }
            big.add(small);
        }
        return big;
    }

    public static long findConversion(ArrayList<long[]> type, long input) {

        for (int i = 0; i < type.size(); i++) {
            if (type.get(i)[1] <= input && input < type.get(i)[1] + type.get(i)[2]) {

                return input - type.get(i)[1] + type.get(i)[0];
            }
        }
        return input;
    }
}
