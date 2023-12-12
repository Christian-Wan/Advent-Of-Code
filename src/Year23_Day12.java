import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Year23_Day12 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("23/12");
        Scanner s = new Scanner(f);
        ArrayList<Year23_Day12_Object> hotSprings = new ArrayList<>();
        while (s.hasNext()) {
            String line = s.nextLine();
            Year23_Day12_Object records = new Year23_Day12_Object(line.substring(0, line.indexOf(" ")), line.substring(line.indexOf(" ") + 1));
            hotSprings.add(records);
        }
        System.out.println(hotSprings);
        for (Year23_Day12_Object springs: hotSprings) {
            System.out.println(springs.getLakes() + " " + springs.getAltData());
            System.out.println(springs.getMinimum());
        }
    }
}
