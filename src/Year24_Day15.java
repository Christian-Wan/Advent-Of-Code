import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Year24_Day15 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("24/15-1");
        Scanner s = new Scanner(f);

        ArrayList<ArrayList<String>> grid = new ArrayList<>();
        String commands = "";
        int robotRow = 0;
        int robotColumn = 0;

        int count = 0;
        while (s.hasNext()) {
            String line = s.nextLine();
            ArrayList<String> parsed = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                if (line.substring(i, i + 1).equals(".") || line.substring(i, i + 1).equals("#")) {
                    parsed.add(line.substring(i, i + 1));
                    parsed.add(line.substring(i, i + 1));
                }
                else if (line.substring(i, i + 1).equals("O")) {
                    parsed.add("[");
                    parsed.add("]");
                }
                else if (line.substring(i, i + 1).equals("@")) {
                    robotRow = count;
                    robotColumn = i * 2;
                    parsed.add("@");
                    parsed.add(".");
                }
            }
            count++;
            grid.add(parsed);
        }
        for (ArrayList<String> thing: grid) {
            System.out.println(thing);
        }
        System.out.println(robotRow);
        System.out.println(robotColumn);

        f = new File("24/15-2");
        s = new Scanner(f);

        while (s.hasNext()) {
            commands += s.nextLine();
        }
        ArrayList<ArrayList<String>> saveState = new ArrayList<>();
        for (int i = 0; i < commands.length(); i++) {
            count = 0;
            saveState.clear();
            for (ArrayList<String> row: grid) {
                saveState.add(new ArrayList<>());
                for (String value: row) {
                    saveState.get(count).add(value);
                }
                count++;
            }
            canMove = true;
            if (move(grid, commands.substring(i, i + 1), robotRow, robotColumn, false) && canMove) {
                if (commands.substring(i, i + 1).equals("^")) {
                    robotRow--;
                } else if (commands.substring(i, i + 1).equals(">")) {
                    robotColumn++;
                } else if (commands.substring(i, i + 1).equals("v")) {
                    robotRow++;
                } else {
                    robotColumn--;
                }
            }
            if (!canMove) {
                grid = new ArrayList<>(saveState);
            }
        }

        long total = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int x = 0; x < grid.get(i).size(); x++) {
                if (grid.get(i).get(x).equals("[")) {
                    total += 100 * i + x;
                }
            }
        }
        System.out.println(total);
    }
    public static boolean canMove;

    public static boolean move(ArrayList<ArrayList<String>> grid, String direction, int row, int column, boolean checked) {
        if (grid.get(row).get(column).equals("[") && !checked && (direction.equals("^") || direction.equals("v"))) {
            move(grid, direction, row , column + 1, true);
        }
        else if (grid.get(row).get(column).equals("]") && !checked && (direction.equals("^") || direction.equals("v"))) {
            move(grid, direction, row , column - 1, true);
        }
        if (direction.equals("^")) {
            //up
            if (grid.get(row - 1).get(column).equals("[") || grid.get(row - 1).get(column).equals("]")) {
                if (move(grid, direction, row - 1, column, false)) {
                    if (canMove) {
                        grid.get(row - 1).set(column, grid.get(row).get(column));
                        grid.get(row).set(column, ".");
                    }
                }
                else {
                    return false;
                }
            }
            else if (grid.get(row - 1).get(column).equals(".") && canMove) {
                grid.get(row - 1).set(column, grid.get(row).get(column));
                grid.get(row).set(column, ".");
            }
            else if (grid.get(row - 1).get(column).equals("#")) {
                canMove = false;
                return false;
            }
        }
        else if (direction.equals(">")) {
            //right
            if (grid.get(row).get(column + 1).equals("[") || grid.get(row).get(column + 1).equals("]")) {
                if (move(grid, direction, row, column + 1, false)) {
                    grid.get(row).set(column + 1, grid.get(row).get(column));
                    grid.get(row).set(column, ".");
                }
                else {
                    return false;
                }
            }
            else if (grid.get(row).get(column + 1).equals(".")) {
                grid.get(row).set(column + 1, grid.get(row).get(column));
                grid.get(row).set(column, ".");
            }
            else if (grid.get(row).get(column + 1).equals("#")) {
                return false;
            }
        }
        else if (direction.equals("v")) {
            //down
            if (grid.get(row + 1).get(column).equals("[") || grid.get(row + 1).get(column).equals("]")) {
                if (move(grid, direction, row + 1, column, false)) {
                    if (canMove) {
                        grid.get(row + 1).set(column, grid.get(row).get(column));
                        grid.get(row).set(column, ".");
                    }
                }
                else {
                    return false;
                }
            }
            else if (grid.get(row + 1).get(column).equals(".") && canMove) {
                grid.get(row + 1).set(column, grid.get(row).get(column));
                grid.get(row).set(column, ".");
            }
            else if (grid.get(row + 1).get(column).equals("#")) {
                canMove = false;
                return false;
            }
        }
        else {
            //left
            if (grid.get(row).get(column - 1).equals("]") || grid.get(row).get(column - 1).equals("[")) {
                if (move(grid, direction, row, column - 1, false)) {
                    grid.get(row).set(column - 1, grid.get(row).get(column));
                    grid.get(row).set(column, ".");
                }
                else {
                    return false;
                }
            }
            else if (grid.get(row).get(column - 1).equals(".")) {
                grid.get(row).set(column - 1, grid.get(row).get(column));
                grid.get(row).set(column, ".");
            }
            else if (grid.get(row).get(column - 1).equals("#")) {
                return false;
            }
        }
        return true;
    }
}
