import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Year24_Day16 {
    public static void main(String[] args) throws FileNotFoundException {
        File f= new File("24/16");
        Scanner s = new Scanner(f);

        ArrayList<ArrayList<String>> grid = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        HashSet<String> unvisited = new HashSet<>();
        HashMap<String, Year24_Day16_Object> table = new HashMap<>();
        int startRow = 0;
        int startColumn = 1;


        int count = 0;
        while (s.hasNext()) {
            String line = s.nextLine();
            ArrayList<String> next = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                next.add(line.substring(i, i + 1));
                if (!line.substring(i, i + 1).equals("#")) {
                    unvisited.add(count + "," + i);
                }
                if (line.substring(i, i + 1).equals("S")) {
                    startRow = count;
                    next.removeLast();
                    next.add(".");
                }
            }
            count++;
            grid.add(next);
        }
        System.out.println(unvisited);
        table.put(startRow + "," + startColumn, new Year24_Day16_Object(0, 1, "", new HashSet<>()));
        while (!unvisited.isEmpty()) {
            String current = "";
            for (String key: table.keySet()) {
                if (unvisited.contains(key)) {
                    current = key;
                }
            }
            startRow = Integer.parseInt(current.substring(0, current.indexOf(",")));
            startColumn = Integer.parseInt(current.substring(current.indexOf(",") + 1));
            unvisited.remove(current);
            visited.add(current);
            if (grid.get(startRow - 1).get(startColumn).equals("E") || grid.get(startRow - 1).get(startColumn).equals(".")) {
                String up = (startRow - 1) + "," + startColumn;
                int scoreAdd = 1;
                HashSet<String> nextHashSet = new HashSet<>(table.get(current).getPossiblePaths());
                nextHashSet.add(current);
                if (table.get(current).getDirection() != 0) {
                    scoreAdd += 1000;
                }
                if (table.keySet().contains(up)) {
                    if (table.get(up).getScore() > table.get(current).getScore() + scoreAdd) {
                        table.replace(up, new Year24_Day16_Object(table.get(current).getScore() + scoreAdd, 0, current, nextHashSet));
                    }
                }
                else {
                    table.put(up, new Year24_Day16_Object(table.get(current).getScore() + scoreAdd, 0, current, nextHashSet));
                }
            }
            if (grid.get(startRow).get(startColumn + 1).equals("E") || grid.get(startRow).get(startColumn + 1).equals(".")) {
                String right = (startRow) + "," + (startColumn + 1);
                int scoreAdd = 1;
                HashSet<String> nextHashSet = new HashSet<>(table.get(current).getPossiblePaths());
                nextHashSet.add(current);
                if (table.get(current).getDirection() != 1) {
                    scoreAdd += 1000;
                }
                if (table.keySet().contains(right)) {
                    if (table.get(right).getScore() > table.get(current).getScore() + scoreAdd) {
                        table.replace(right, new Year24_Day16_Object(table.get(current).getScore() + scoreAdd, 1, current, nextHashSet));
                    }
                }
                else {
                    table.put(right, new Year24_Day16_Object(table.get(current).getScore() + scoreAdd, 1, current, nextHashSet));
                }
            }
            if (grid.get(startRow + 1).get(startColumn).equals("E") || grid.get(startRow + 1).get(startColumn).equals(".")) {
                String down = (startRow + 1) + "," + (startColumn);
                int scoreAdd = 1;
                HashSet<String> nextHashSet = new HashSet<>(table.get(current).getPossiblePaths());
                nextHashSet.add(current);
                if (table.get(current).getDirection() != 2) {
                    scoreAdd += 1000;
                }
                if (table.keySet().contains(down)) {
                    if (table.get(down).getScore() > table.get(current).getScore() + scoreAdd) {
                        table.replace(down, new Year24_Day16_Object(table.get(current).getScore() + scoreAdd, 1, current, nextHashSet));
                    }
                }
                else {
                    table.put(down, new Year24_Day16_Object(table.get(current).getScore() + scoreAdd, 1, current, nextHashSet));
                }
            }
            if (grid.get(startRow).get(startColumn - 1).equals("E") || grid.get(startRow).get(startColumn - 1).equals(".")) {
                String left = (startRow) + "," + (startColumn - 1);
                int scoreAdd = 1;
                HashSet<String> nextHashSet = new HashSet<>(table.get(current).getPossiblePaths());
                nextHashSet.add(current);
                if (table.get(current).getDirection() != 3) {
                    scoreAdd += 1000;
                }
                if (table.keySet().contains(left)) {
                    if (table.get(left).getScore() > table.get(current).getScore() + scoreAdd) {
                        table.replace(left, new Year24_Day16_Object(table.get(current).getScore() + scoreAdd, 1, current, nextHashSet));
                    }
                }
                else {
                    table.put(left, new Year24_Day16_Object(table.get(current).getScore() + scoreAdd, 1, current, nextHashSet));
                }
            }
        }
        System.out.println(table.keySet());
        System.out.println(table.get("1,13").getScore());
    }


    //Directions:
    //      0
    //    3   1
    //      2

    public static void replaceFuture(int newScore, Year24_Day16_Object current) {

    }
}
