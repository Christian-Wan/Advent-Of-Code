import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Year23_Day21 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("23/21");
        Scanner s = new Scanner(f);
        String[][] garden = new String[131][131];
        int count = 0;
        while (s.hasNext()) {
            String line = s.nextLine();
            for (int i = 0; i < line.length(); i++) {
                garden[count][i] = line.substring(i, i + 1);
                if (garden[count][i].equals("S")) {
                    garden[count][i] = "0";
                }
            }
            count++;
        }


        for (int a = 0; a < 26501365; a++) {
            if (a % 5000 == 0) {
                System.out.println(a);
            }
            for (int i = 0; i < garden.length; i++) {
                for (int x = 0; x < garden[0].length; x++) {
                    if (garden[i][x].equals("0")) {
                        try {
                            if (!garden[i + 1][x].equals("#")) {
                                garden[i + 1][x] = "9";
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {

                        }
                        try {
                            if (!garden[i - 1][x].equals("#")) {
                                garden[i - 1][x] = "9";
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {

                        }
                        try {
                            if (!garden[i][x + 1].equals("#")) {
                                garden[i][x + 1] = "9";
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {

                        }
                        try {
                            if (!garden[i][x - 1].equals("#")) {
                                garden[i][x - 1] = "9";
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {

                        }
                    }
                }
            }
            for (int q = 0; q < garden.length; q++) {
                for (int w = 0; w < garden[0].length; w++) {
                    if (garden[q][w].equals("0")) {
                        garden[q][w] = ".";
                    }
                    if (garden[q][w].equals("9")) {
                        garden[q][w] = "0";
                    }
                }
            }
        }
        int counter = 0;
        for (int q = 0; q < garden.length; q++) {
            for (int w = 0; w < garden[0].length; w++) {
                if (garden[q][w].equals("0")) {
                    counter++;
                }

            }
        }
        System.out.println(counter);
    }
}
