import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Year23_Day18 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("23/18");
        Scanner s = new Scanner(f);
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        ArrayList<String> hexadecimal = new ArrayList<>();
        String BLUE = "\u001B[44m";
        String RED = "\u001B[41m";
        String RESET = "\u001B[0m";

        ArrayList<String> directions = new ArrayList<>();
        while (s.hasNext()) {
            String line = s.nextLine();
            directions.add(line.substring(0, line.indexOf("(") - 1));
            hexadecimal.add(line.substring(line.indexOf("(") + 2, line.length() - 1));
        }
        for (int i = 0; i < hexadecimal.size(); i++) {
            String newDirections = hexadecimal.get(i).substring(hexadecimal.get(i).length() - 1) + " " + Integer.toString(Integer.parseInt(hexadecimal.get(i).substring(0, hexadecimal.get(i).length() - 1), 16));
            directions.set(i, newDirections);
        }
        System.out.println(hexadecimal);
        System.out.println(directions);
        grid.add(new ArrayList<>());
        grid.get(0).add(1);
        int x = 0;
        int y = 0;
        for (int i = 0; i < directions.size(); i++) {
            System.out.println(directions.get(i));
            if (directions.get(i).charAt(0) == '0') {
                for (int a = 0; a < Integer.parseInt(directions.get(i).substring(2, directions.get(i).length())); a++) {
                    x++;
                    try {
                        grid.get(y).set(x, 1);
                    }
                    catch (IndexOutOfBoundsException e) {
                        for (int b = 0; b < grid.size(); b++) {
                            grid.get(b).add(0);
                        }
                        grid.get(y).set(x, 1);
                    }
                }
            }
            else if (directions.get(i).charAt(0) == '2') {
                for (int a = 0; a < Integer.parseInt(directions.get(i).substring(2, directions.get(i).length())); a++) {
                    x--;
                    try {
                        grid.get(y).set(x, 1);
                    }
                    catch (IndexOutOfBoundsException e) {
                        for (int b = 0; b < grid.size(); b++) {
                            grid.get(b).addFirst(0);
                        }
                        x = 0;
                        grid.get(y).set(x, 1);
                    }
                }
            }
            else if (directions.get(i).charAt(0) == '3') {
                for (int a = 0; a < Integer.parseInt(directions.get(i).substring(2, directions.get(i).length())); a++) {
                    y--;
                    try {
                        grid.get(y).set(x, 1);
                    }
                    catch (IndexOutOfBoundsException e) {
                        grid.addFirst(new ArrayList<>());
                        for (int b = 0; b < grid.get(1).size(); b++) {
                            grid.get(0).add(0);
                        }
                        y = 0;
                        grid.get(y).set(x, 1);
                    }
                }
            }
            else if (directions.get(i).charAt(0) == '1') {
                for (int a = 0; a < Integer.parseInt(directions.get(i).substring(2, directions.get(i).length())); a++) {
                    y++;
                    try {
                        grid.get(y).set(x, 1);
                    }
                    catch (IndexOutOfBoundsException e) {
                        grid.add(new ArrayList<>());
                        for (int b = 0; b < grid.get(0).size(); b++) {
                            grid.get(y).add(0);
                        }
                        grid.get(y).set(x, 1);
                    }
                }
            }
        }


        for (int i = 0; i < grid.size(); i++) {
            if (grid.get(i).get(0) != 1) {
                grid.get(i).set(0, 9);
            }
            if (grid.get(i).get(grid.get(0).size() - 1) != 1) {
                grid.get(i).set(grid.get(0).size() - 1, 9);
            }
        }
        for (int i = 0; i < grid.get(0).size(); i++) {
            if (grid.get(0).get(i) != 1) {
                grid.get(0).set(i, 9);
            }
            if (grid.get(grid.size() - 1).get(i) != 1) {
                grid.get(grid.size() - 1).set(i, 9);
            }
        }

        int intersection;
        for (int i = 1; i < grid.size(); i++) {
            intersection = 0;
            for (int a = 0; a < grid.get(0).size(); a++) {
                if ((grid.get(i).get(a) == 1 && grid.get(i - 1).get(a) == 1)) {
                    intersection++;
                }
                if (intersection % 2 == 0 && grid.get(i).get(a) != 1) {
                    grid.get(i).set(a, 9);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int a = 0; a < grid.get(0).size(); a++) {
                if (grid.get(i).get(a) == 1) {
                    System.out.print(BLUE + grid.get(i).get(a) + RESET);
                }
                if (grid.get(i).get(a) == 9) {
                    System.out.print(RED + grid.get(i).get(a) + RESET);
                }
                if (grid.get(i).get(a) == 0) {
                    System.out.print(grid.get(i).get(a));
                }
                if (grid.get(i).get(a) == 1 || grid.get(i).get(a) == 0) {
                    count++;
                }
            }
            System.out.println();
        }
        System.out.println(count);

    }
}
