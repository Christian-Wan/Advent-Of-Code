import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Year15_Day3 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("15/3");
        Scanner s = new Scanner(f);
        String instructions = s.nextLine();
        int sx = 0;
        int sy = 0;
        int rx = 0;
        int ry = 0;
        Set<String> visited = new TreeSet<>() ;
        visited.add("x" + sx + "y" + sy);
        for (int i = 0; i < instructions.length(); i++) {
            if (i % 2 == 0) {
                if (instructions.charAt(i) == '>') {
                    sx++;
                } else if (instructions.charAt(i) == '<') {
                    sx--;
                } else if (instructions.charAt(i) == '^') {
                    sy++;
                } else {
                    sy--;
                }
                visited.add("x" + sx + "y" + sy);
            }
            else {
                if (instructions.charAt(i) == '>') {
                    rx++;
                }
                else if (instructions.charAt(i) == '<') {
                    rx--;
                }
                else if (instructions.charAt(i) == '^') {
                    ry++;
                }
                else {
                    ry--;
                }
                visited.add("x" + rx + "y" + ry);
            }
        }
        System.out.println(visited);
        System.out.println(visited.size());
    }
}
