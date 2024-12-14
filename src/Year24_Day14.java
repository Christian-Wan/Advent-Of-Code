import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Year24_Day14 {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        File f= new File("24/14");
        Scanner s = new Scanner(f);

        int height = 103; //103
        int width = 101; //101
        int time = 100;
        HashMap<String, Year24_Day14_Object> robots = new HashMap<>();

        int count = 0;
        while (s.hasNext()) {
            String line = s.nextLine();
            String secondPart = line.substring(line.indexOf("v"));
            robots.put("robot" + count, new Year24_Day14_Object(Integer.parseInt(line.substring(line.indexOf(",") + 1, line.indexOf(" "))), Integer.parseInt(line.substring(2, line.indexOf(","))), Integer.parseInt(secondPart.substring(secondPart.indexOf(",") + 1)), Integer.parseInt(secondPart.substring(2, secondPart.indexOf(",")))));
            count++;
        }
        long topLeft = 0;
        long topRight = 0;
        long bottomLeft = 0;
        long bottomRight = 0;
        count = 1;
        String[][] grid = new String[height][width];
        HashSet<String> positions = new HashSet<>();
        while (true) {
            for (String key : robots.keySet()) {
                Year24_Day14_Object robot = robots.get(key);
                int row = 0;
                int column = 0;


                row = robot.startHeight + robot.vertical;
                column = robot.startWidth + robot.horizontal;

                if (row < 0) {
                    row = height + row;
                }
                else if (row >= height) {
                    row = row - height;
                }
                if (column < 0) {
                    column = width + column;
                }
                else if (column > width) {
                    column = column - width;
                }

                robot.setStartHeight(row);
                robot.setStartWidth(column);
                positions.add(row + "," + column);
            }
            if (count % 103 == 60) {
                for (int r = 0; r < height; r++) {
                    for (int c = 0; c < width; c++) {
                        if (positions.contains(r + "," + c)) {
                            grid[r][c] = "#";
                        } else grid[r][c] = ".";
                    }
                }

                System.out.println("seconds: " + count);

                for (int r = 0; r < height; r++) {
                    for (int c = 0; c < width; c++) {
                        System.out.print(grid[r][c]);
                    }
                    System.out.println();
                }
                Thread.sleep(500);
            }
            positions.clear();
            count++;
        }
    }
}
