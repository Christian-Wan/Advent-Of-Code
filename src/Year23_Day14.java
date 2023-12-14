import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Year23_Day14 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("23/14");
        Scanner s = new Scanner(f);
        ArrayList<String> grid = new ArrayList<>();
        while (s.hasNext()) {
            String line = s.nextLine();
            grid.add(line);
        }

        for (int i = 0; i < 1000; i++) {
            grid = moveNorth(grid);
            grid = moveEast(grid);
            grid = moveSouth(grid);
            grid = moveWest(grid);
        }
        System.out.println(findLoad(grid));

    }

    public static ArrayList<String> moveNorth(ArrayList<String> grid) {
        ArrayList<String> oldGrid = new ArrayList<>();
        while (!grid.equals(oldGrid)) {
            oldGrid = new ArrayList<>();
            oldGrid.addAll(grid);
            for (int i = 0; i < grid.size(); i++) {
                for (int x = 0; x < grid.get(0).length(); x++) {
                    if (grid.get(i).charAt(x) == 'O') {
                        try {
                            if (grid.get(i - 1).charAt(x) == '.') {
                                String changing = grid.get(i - 1);
                                changing = changing.substring(0, x) + "O" + changing.substring(x + 1);
                                grid.set(i - 1, changing);
                                String move = grid.get(i);
                                move = move.substring(0, x) + "." + move.substring(x + 1);
                                grid.set(i, move);
                            }
                        }
                        catch (IndexOutOfBoundsException e) {

                        }
                    }
                }
            }
        }
        return grid;
    }

    public static ArrayList<String> moveSouth(ArrayList<String> grid) {
        ArrayList<String> oldGrid = new ArrayList<>();
        while (!grid.equals(oldGrid)) {
            oldGrid = new ArrayList<>();
            oldGrid.addAll(grid);
            for (int i = 0; i < grid.size(); i++) {
                for (int x = 0; x < grid.get(0).length(); x++) {
                    if (grid.get(i).charAt(x) == 'O') {
                        try {
                            if (grid.get(i + 1).charAt(x) == '.') {
                                String changing = grid.get(i + 1);
                                changing = changing.substring(0, x) + "O" + changing.substring(x + 1);
                                grid.set(i + 1, changing);
                                String move = grid.get(i);
                                move = move.substring(0, x) + "." + move.substring(x + 1);
                                grid.set(i, move);
                            }
                        }
                        catch (IndexOutOfBoundsException e) {

                        }
                    }
                }
            }
        }
        return grid;
    }

    public static ArrayList<String> moveWest(ArrayList<String> grid) {
        ArrayList<String> oldGrid = new ArrayList<>();
        while (!grid.equals(oldGrid)) {
            oldGrid = new ArrayList<>();
            oldGrid.addAll(grid);
            for (int i = 0; i < grid.size(); i++) {
                for (int x = 0; x < grid.get(0).length(); x++) {
                    if (grid.get(i).charAt(x) == 'O') {
                        try {
                            if (grid.get(i).charAt(x + 1) == '.') {
                                String changing = grid.get(i);
                                changing = changing.substring(0, x + 1) + "O" + changing.substring(x + 2);
                                grid.set(i, changing);
                                String move = grid.get(i);
                                move = move.substring(0, x) + "." + move.substring(x + 1);
                                grid.set(i, move);
                            }
                        }
                        catch (IndexOutOfBoundsException e) {

                        }
                    }
                }
            }
        }
        return grid;
    }

    public static ArrayList<String> moveEast(ArrayList<String> grid) {
        ArrayList<String> oldGrid = new ArrayList<>();
        while (!grid.equals(oldGrid)) {
            oldGrid = new ArrayList<>();
            oldGrid.addAll(grid);
            for (int i = 0; i < grid.size(); i++) {
                for (int x = 0; x < grid.get(0).length(); x++) {
                    if (grid.get(i).charAt(x) == 'O') {
                        try {
                            if (grid.get(i).charAt(x - 1) == '.') {
                                String changing = grid.get(i);
                                changing = changing.substring(0, x - 1) + "O" + changing.substring(x);
                                grid.set(i, changing);
                                String move = grid.get(i);
                                move = move.substring(0, x) + "." + move.substring(x + 1);
                                grid.set(i, move);
                            }
                        }
                        catch (IndexOutOfBoundsException e) {

                        }
                    }
                }
            }
        }
        return grid;
    }

    public static int findLoad(ArrayList<String> grid) {
        int total = 0;
        int weight = 1;
        for (int i = grid.size() - 1; i >= 0; i--) {
            for (int x = 0; x < grid.get(0).length(); x++) {
                if (grid.get(i).charAt(x) == 'O') {
                    total += weight;
                }
            }
            weight++;
        }
        return total;
    }

}
