import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Year23_Day23 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("23/23");
        Scanner s = new Scanner(f);

        ArrayList<Year23_Day23_Object> progression = new ArrayList<>();

        String[][] grid = new String[23][23];

        int count = 0;
        while (s.hasNext()) {
            String line = s.nextLine();
            for (int i = 0; i < line.length(); i++) {
                grid[count][i] = line.substring(i, i + 1);
            }
            count++;
        }


        progression.add(new Year23_Day23_Object(grid));

        for (int i = 0; i < 109; i++) {
            for (int x = 0; x < progression.size(); x++) {
                if (progression.get(x).lookAround(grid) > 1 && progression.get(x).isOriginal()) {
                    progression.add(new Year23_Day23_Object(progression.get(x)));
                }
                if (progression.get(x).lookAround(grid) != 0) {
                    progression.get(x).move();
                }
                else {
                    System.out.println("asd");
                }
            }
            System.out.println("Step:" + i + " " + progression.size());
        }
        for (Year23_Day23_Object point: progression) {
            System.out.println(point.getLength());
            System.out.println(point.getTest());
        }
    }
}
