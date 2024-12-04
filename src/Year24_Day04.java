import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Year24_Day04 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("24/4");
        Scanner s = new Scanner(f);

        int size = 140;
        String[][] puzzle = new String[size][size];
        int count = 0;
        int total = 0;
        int total2 = 0;

        while (s.hasNext()) {
            String line = s.nextLine();
            for (int i = 0; i < line.length(); i++) {
                puzzle[count][i] = line.substring(i, i + 1);
            }
            count++;
        }
        //part1
        for (int i = 0; i < size; i++ ) {
            for(int x = 0; x < size; x++) {
                String upLeft = "";
                String up = "";
                String upRight = "";
                String left = "";
                String right = "";
                String downLeft = "";
                String down = "";
                String downRight = "";
                if (puzzle[i][x].equals("X")) {
                    if (i >= 3) {
                        up = puzzle[i][x] + puzzle[i - 1][x] + puzzle[i - 2][x] + puzzle[i - 3][x];
                        if (x >= 3) {
                            upLeft = puzzle[i][x] + puzzle[i - 1][x - 1] + puzzle[i - 2][x - 2] + puzzle[i - 3][x - 3];
                        }
                        if (x < size - 3) {
                            upRight = puzzle[i][x] + puzzle[i - 1][x + 1] + puzzle[i - 2][x + 2] + puzzle[i - 3][x + 3];
                        }
                    }
                    if (x >= 3) {
                        left = puzzle[i][x] + puzzle[i][x - 1] + puzzle[i][x - 2] + puzzle[i][x - 3];
                    }
                    if (x < size - 3) {
                        right = puzzle[i][x] + puzzle[i][x + 1] + puzzle[i][x + 2] + puzzle[i][x + 3];
                    }
                    if (i < size - 3) {
                        down = puzzle[i][x] + puzzle[i + 1][x] + puzzle[i + 2][x] + puzzle[i + 3][x];
                        if (x >= 3) {
                            downLeft = puzzle[i][x] + puzzle[i + 1][x - 1] + puzzle[i + 2][x - 2] + puzzle[i + 3][x - 3];
                        }
                        if (x < size - 3) {
                            downRight = puzzle[i][x] + puzzle[i + 1][x + 1] + puzzle[i + 2][x + 2] + puzzle[i + 3][x + 3];
                        }
                    }

                    if (upLeft.equals("XMAS")) {
                        total++;
                    }
                    if (up.equals("XMAS")) {
                        total++;
                    }
                    if (upRight.equals("XMAS")) {
                        total++;
                    }
                    if (left.equals("XMAS")) {
                        total++;
                    }
                    if (right.equals("XMAS")) {
                        total++;
                    }
                    if (downLeft.equals("XMAS")) {
                        total++;
                    }
                    if (down.equals("XMAS")) {
                        total++;
                    }
                    if (downRight.equals("XMAS")) {
                        total++;
                    }
                }
            }
        }
        System.out.println(total);

        //part2
        for (int i = 1; i < size - 1; i++) {
            for (int x = 1; x < size - 1; x++) {
                if (puzzle[i][x].equals("A")) {
                    String first = puzzle[i - 1][x - 1] + puzzle[i + 1][x + 1];
                    String second = puzzle[i - 1][x + 1] + puzzle[i + 1][x - 1];
                    if ((first.equals("MS") || first.equals("SM")) && (second.equals("MS") || second.equals("SM"))) {
                        total2++;
                    }
                }
            }
        }
        System.out.println(total2);
    }
    //2434


}
