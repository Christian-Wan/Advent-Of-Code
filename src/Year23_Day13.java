import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Year23_Day13 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("23/13");
        Scanner s = new Scanner(f);
        ArrayList<ArrayList<String>> grid = new ArrayList<>();
        ArrayList<Year23_Day13_Object> maps = new ArrayList<>();
        int index = 0;
        int total = 0;

        while (s.hasNext()) {
            String line = s.nextLine();
            if (line.isEmpty()) {
                maps.add(new Year23_Day13_Object(grid));
                grid = new ArrayList<>();
                index = -1;
            }
            ArrayList<String> inLine = new ArrayList<String>();
            for (int i = 0; i < line.length(); i++) {
                if (grid.size() <= index) {
                    grid.add(inLine);
                }
                try {
                    inLine.add(line.substring(i, i + 1));
                }
                catch (IndexOutOfBoundsException e) {

                    }
            }
            index++;
        }
        for (Year23_Day13_Object individual: maps) {
            for (int x = 0; x < individual.getGrid().size(); x++) {
                System.out.println(individual.getGrid().get(x));
            }
            System.out.println();
        }
        for (Year23_Day13_Object individual: maps) {
            for (int x = 0; x < individual.getFlip().size(); x++) {
                System.out.println(individual.getFlip().get(x));
            }
            System.out.println();
        }
        System.out.println(maps);
        System.out.println(total);
        for (Year23_Day13_Object individual: maps) {
            System.out.println("Bad: " + individual.getBad());
            int thing = individual.specialFindMirror();
            System.out.println("Adding: " + thing);
            total += thing;
        }
        System.out.println(total);
    }
}
