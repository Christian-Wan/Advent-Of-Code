import java.io.FileNotFoundException;

public class Year23_Day6 {
    public static void main(String[] args) throws FileNotFoundException {
        int time = 46689866;
        String part1 = "3581054";
        String part2 = "18071080";
        long distance = Long.parseLong(part1 + part2);


        int count = 0;
        for (int x = 0; x < time; x++) {
            int remain = time - x;
            if ((long) remain * x > distance) {
                count++;
            }
        }
        System.out.println(count);
    }
}
