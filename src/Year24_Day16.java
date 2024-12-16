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
        HashMap<String, ArrayList<ArrayList<String>>> table = new HashMap<>(); //First arrayList will contain 2 strings being score, direction
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


        while (!visited.isEmpty()) {
            unvisited.add(startRow + "," + startColumn);
            visited.remove(startRow + "," + startColumn);
            if (grid.get(startRow - 1).get(startColumn).equals("E") || grid.get(startRow - 1).get(startColumn).equals(".")) {
                if (table.keySet().contains((startRow - 1) + "," + startColumn) {
                    table
                }
            }
            if (grid.get(startRow).get(startColumn + 1).equals("E") || grid.get(startRow).get(startColumn + 1).equals(".")) {
            }
            if (grid.get(startRow + 1).get(startColumn).equals("E") || grid.get(startRow + 1).get(startColumn).equals(".")) {
            }
            if (grid.get(startRow).get(startColumn - 1).equals("E") || grid.get(startRow).get(startColumn - 1).equals(".")) {
            }
        }

    }


    //Directions:
    //      0
    //    3   1
    //      2


}
