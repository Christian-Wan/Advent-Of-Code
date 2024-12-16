import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Year24_Day16 {
    public static void main(String[] args) throws FileNotFoundException {
        File f= new File("24/16");
        Scanner s = new Scanner(f);

        ArrayList<ArrayList<String>> grid = new ArrayList<>();
        int startRow = 0;


        int count = 0;
        while (s.hasNext()) {
            String line = s.nextLine();
            ArrayList<String> next = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                next.add(line.substring(i, i + 1));
                if (line.substring(i, i + 1).equals("S")) {
                    startRow = count;
                    next.removeLast();
                    next.add(".");
                }
            }
            count++;
            grid.add(next);
        }

        path(grid, startRow, 1, new HashSet<>(), 0, 1);
        int lowest = scores.getFirst();
        for (int score: scores) {
            if (score < lowest) {
                lowest = score;
            }
        }
        System.out.println(lowest);
    }

    public static ArrayList<Integer> scores = new ArrayList<>();

    //Directions:
    //      0
    //    3   1
    //      2

    public static void path(ArrayList<ArrayList<String>> grid, int startRow, int startColumn, HashSet<String> been, int score, int direction) {
        while (true) {
//            System.out.println(startRow + "," + startColumn);
            been.add(startRow + "," + startColumn);
            ArrayList<Integer> directions = new ArrayList<>();
            if (grid.get(startRow - 1).get(startColumn).equals("E") || grid.get(startRow - 1).get(startColumn).equals(".") && !been.contains((startRow - 1) + "," + startColumn)) {
                directions.add(0);
            }
            if (grid.get(startRow).get(startColumn + 1).equals("E") || grid.get(startRow).get(startColumn + 1).equals(".") && !been.contains((startRow) + "," + (startColumn + 1))) {
                directions.add(1);
            }
            if (grid.get(startRow + 1).get(startColumn).equals("E") || grid.get(startRow + 1).get(startColumn).equals(".") && !been.contains((startRow + 1) + "," + startColumn)) {
                directions.add(2);
            }
            if (grid.get(startRow).get(startColumn - 1).equals("E") || grid.get(startRow).get(startColumn - 1).equals(".") && !been.contains((startRow) + "," + (startColumn - 1))) {
                directions.add(3);
            }

            if (directions.isEmpty()) {
                break;
            }

            while (directions.size() > 1) {
                HashSet<String> temp = new HashSet<>(been);

                if (directions.getFirst() == direction) {
                    if (direction == 0) {
                        path(grid, startRow - 1, startColumn, temp, score + 1, direction);
                    }
                    else if (direction == 1) {
                        path(grid, startRow, startColumn + 1, temp, score + 1, direction);
                    }
                    else if (direction == 2) {
                        path(grid, startRow + 1, startColumn, temp, score + 1, direction);
                    }
                    else {
                        path(grid, startRow, startColumn - 1, temp, score + 1, direction);
                    }
                }
                else {
                    if (directions.getFirst() == 0) {
                        path(grid, startRow - 1, startColumn, temp, score + 1001, directions.getFirst());
                    }
                    else if (directions.getFirst() == 1) {
                        path(grid, startRow, startColumn + 1, temp, score + 1001, directions.getFirst());
                    }
                    else if (directions.getFirst() == 2) {
                        path(grid, startRow + 1, startColumn, temp, score + 1001, directions.getFirst());
                    }
                    else {
                        path(grid, startRow, startColumn - 1, temp, score + 1001, directions.getFirst());
                    }
                }
                directions.removeFirst();
            }
            if (directions.getFirst() != direction) {
                score += 1000;
                direction = directions.getFirst();
            }
            if (directions.getFirst() == 0) {
                startRow--;
            }
            else if (directions.getFirst() == 1) {
                startColumn++;
            }
            else if (directions.getFirst() == 2) {
                startRow++;
            }
            else {
                startColumn--;
            }
            score++;

            if (grid.get(startRow).get(startColumn).equals("E")) {
                System.out.println(score);
                scores.add(score);
                break;
            }
        }
    }
}
