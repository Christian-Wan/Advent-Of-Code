import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Year24_Day10 {

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("24/10");
        Scanner s = new Scanner(f);

        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        ArrayList<String> starts = new ArrayList<>();
        int row = 0;

        while (s.hasNext()) {
            String line = s.nextLine();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                if (Integer.parseInt(line.substring(i, i + 1)) == 0) {
                    starts.add(row + "," + i);
                }
                temp.add(Integer.parseInt(line.substring(i, i + 1)));
            }
            row++;
            grid.add(temp);
        }

        int total = 0;
        for (String start: starts) {
            total += checkPaths1(grid, start).size();
        }
        System.out.println("Part 1: " + total);

        total = 0;
        for (String start: starts) {
            total += checkPaths(grid, start);
        }
        System.out.println("Part 2: " + total);
    }

    private static int checkPaths(ArrayList<ArrayList<Integer>> grid, String start) {
        int directions = 0;
        boolean up = false;
        boolean right = false;
        boolean down = false;
        boolean left = false;
        int startRow = Integer.parseInt(start.substring(0, start.indexOf(",")));
        int startColumn = Integer.parseInt(start.substring(start.indexOf(",") + 1));
        int startValue = grid.get(startRow).get(startColumn);
        int total = 0;

//        System.out.println(start + ": " + startValue);
        if (startValue == 9) {
            return 1;
        }
        try {
            if (grid.get(startRow - 1).get(startColumn) == startValue + 1) {
                directions++;
                up = true;
            }
        } catch (IndexOutOfBoundsException e) {}
        try {
            if (grid.get(startRow).get(startColumn + 1) == startValue + 1) {
                directions++;
                right = true;
            }
        } catch (IndexOutOfBoundsException e) {}
        try {
            if (grid.get(startRow + 1).get(startColumn) == startValue + 1) {
                directions++;
                down = true;
            }
        } catch (IndexOutOfBoundsException e) {}
        try {
            if (grid.get(startRow).get(startColumn - 1) == startValue + 1) {
                directions++;
                left = true;
            }
        } catch (IndexOutOfBoundsException e) {}
        if (directions > 0) {
            if (up) {
                total += checkPaths(grid, (startRow - 1) + "," + startColumn);
            }
            if (right) {
                total += checkPaths(grid, startRow + "," + (startColumn + 1));
            }
            if (down) {
                total += checkPaths(grid, (startRow + 1) + "," + startColumn);
            }
            if (left) {
                total += checkPaths(grid, (startRow) + "," + (startColumn - 1));
            }
            return total;
        }
        else {
            return 0;
        }

    }


    private static HashSet<String> checkPaths1(ArrayList<ArrayList<Integer>> grid, String start) {
        int directions = 0;
        boolean up = false;
        boolean right = false;
        boolean down = false;
        boolean left = false;
        int startRow = Integer.parseInt(start.substring(0, start.indexOf(",")));
        int startColumn = Integer.parseInt(start.substring(start.indexOf(",") + 1));
        int startValue = grid.get(startRow).get(startColumn);
        HashSet<String> endings = new HashSet<>();

//        System.out.println(start + ": " + startValue);
        if (startValue == 9) {
            endings.add(startRow + "," + startColumn);
            return endings;
        }
        try {
            if (grid.get(startRow - 1).get(startColumn) == startValue + 1) {
                directions++;
                up = true;
            }
        } catch (IndexOutOfBoundsException e) {}
        try {
            if (grid.get(startRow).get(startColumn + 1) == startValue + 1) {
                directions++;
                right = true;
            }
        } catch (IndexOutOfBoundsException e) {}
        try {
            if (grid.get(startRow + 1).get(startColumn) == startValue + 1) {
                directions++;
                down = true;
            }
        } catch (IndexOutOfBoundsException e) {}
        try {
            if (grid.get(startRow).get(startColumn - 1) == startValue + 1) {
                directions++;
                left = true;
            }
        } catch (IndexOutOfBoundsException e) {}
        if (directions > 0) {
            if (up) {
                endings.addAll(checkPaths1(grid, (startRow - 1) + "," + startColumn));
            }
            if (right) {
                endings.addAll(checkPaths1(grid, startRow + "," + (startColumn + 1)));
            }
            if (down) {
                endings.addAll(checkPaths1(grid, (startRow + 1) + "," + startColumn));
            }
            if (left) {
                endings.addAll(checkPaths1(grid, (startRow) + "," + (startColumn - 1)));
            }
            return endings;
        }
        else {
            return endings;
        }

    }
}
