import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class TwentythreeThree {
    public static void main(String[] args) throws FileNotFoundException {


        String[][] schematic = makeSchematic();
        String symbols = "*";
        String numbers = "1234567890";
        int total = 0;

        for (int row = 0; row < 140; row++) {
            for (int column = 0; column < 140; column++) {
                if (symbols.contains(schematic[row][column])) {
                    ArrayList<Integer> gears = new ArrayList<>();
                    for (int i = -1; i <= 1; i++) {
                        for (int x = -1; x <= 1; x++) {
                            try {
                                int currentY = row + i;
                                int currentX = column + x;
                                if (numbers.contains(schematic[currentY][currentX])) {
                                    gears.add(findNumber(schematic, currentY, currentX));
                                    x += findLast(schematic, currentY, currentX) - (currentX);
                                }
                            } catch (IndexOutOfBoundsException e) {

                            }
                        }
                    }
                    if (gears.size() > 1) {
                        int product = 1;
                        for (int value: gears) {
                            product *= value;
                        }
                        total += product;
                    }
                }
            }
        }
        System.out.println(total);
    }

    public static String[][] makeSchematic() throws FileNotFoundException {
        File f = new File("Twentythree/three");
        Scanner s = new Scanner(f);
        String[][] schematic = new String[140][140];

        while (s.hasNext()) {
            for (int i = 0; i < 140; i++) {
                String line = s.nextLine();
                String[] row = line.split("");
                for (int x = 0; x < row.length; x++) {
                    schematic[i][x] = row[x];
                }
            }
        }

        return schematic;
    }

    public static int findNumber(String[][] schematic, int y, int x) {
        String numbers = "1234567890";
        String result = "";
        try {
            while (numbers.contains(schematic[y][x])) {
                x--;
            }
        }
        catch (IndexOutOfBoundsException e) {

        }
        x++;
        try {
            while (numbers.contains(schematic[y][x])) {
                result += schematic[y][x];
                x++;
            }
        }
        catch (IndexOutOfBoundsException e) {
            
        }
        return Integer.parseInt(result);
    }

    public static int findLast(String[][] schematic, int y, int x) {
        String numbers = "1234567890";
        while (numbers.contains(schematic[y][x])) {
            x--;
        }
        x++;
        while (numbers.contains(schematic[y][x])) {
            x++;
        }
        return x;
    }
}
