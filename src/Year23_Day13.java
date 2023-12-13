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

        while (s.hasNext()) {
            String line = s.nextLine();
            if (line.isEmpty()) {
                maps.add(new Year23_Day13_Object(grid));
                grid = new ArrayList<>();
                index = 0;
            }
            else {
                ArrayList<String> inLine = new ArrayList<String>();
                for (int i = 0; i <= line.length(); i++) {
                    if (grid.size() <= index) {
                        grid.add(new ArrayList<String>());
                    }
//                    System.out.println(grid.get(index));
                    try {
                        grid.get(index).add(line.substring(i, i + 1));
                    }
                    catch (IndexOutOfBoundsException e) {

                    }
                }

            }
            index++;
        }
        for (Year23_Day13_Object individual: maps) {
            for (int x = 0; x < grid.size() - 1; x++) {
                System.out.println(individual.getGrid().get(x));
            }
        }
    }
}
