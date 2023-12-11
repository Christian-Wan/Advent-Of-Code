import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Year15_Day06 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("15/6");
        Scanner s = new Scanner(f);
        int[][] lights = new int[1000][1000];
        int count = 0;
        String numbers = "1234567890";
        while (s.hasNext()) {
            String line = s.nextLine();
            int index = 0;
            String x1 = "";
            String x2 = "";
            String y1 = "";
            String y2 = "";
            String temp = "";
            for (int i = 0; i <= line.indexOf(","); i++) {
                if (numbers.contains(line.substring(i, i + 1))) {
                    x1 += line.substring(i, i + 1);
                }
            }
            for (int i = line.indexOf(","); i < line.indexOf(",") + 4; i++) {
                if (numbers.contains(line.substring(i, i + 1))) {
                    y1 += line.substring(i, i + 1);
                }
            }
            for (int i = line.length() - 1; i > 0; i--) {
                if (numbers.contains(line.substring(i, i + 1))) {
                    temp += line.substring(i, i + 1);
                    index = i;
                }
                else {
                    break;
                }
            }
            for (int i = temp.length() - 1; i >= 0; i--) {
                y2 += temp.substring(i , i + 1);
            }
            temp = "";
            for (int i = index - 2; i > 0; i--) {
                if (numbers.contains(line.substring(i, i + 1))) {
                    temp += line.substring(i, i + 1);
                }
                else {
                    break;
                }
            }
            for (int i = temp.length() - 1; i >= 0; i--) {
                x2 += temp.substring(i , i + 1);
            }

            if (line.contains("toggle")) {
                toggle(lights, Integer.parseInt(x1), Integer.parseInt(y1), Integer.parseInt(x2), Integer.parseInt(y2));
            }
            else if (line.contains("turn on")) {
                turnOn(lights, Integer.parseInt(x1), Integer.parseInt(y1), Integer.parseInt(x2), Integer.parseInt(y2));
            }
            else {
                turnOff(lights, Integer.parseInt(x1), Integer.parseInt(y1), Integer.parseInt(x2), Integer.parseInt(y2));
            }
        }

        for (int i = 0; i < lights.length; i++) {
            for (int x = 0; x < lights.length; x++) {
                    count += lights[i][x];
            }
        }
        System.out.println(count);
    }

    public static int[][] turnOn(int[][] lights, int x1, int y1, int x2, int y2) {
        for (int y = y1; y <= y2; y++) {
            for (int x = x1; x <= x2; x++) {
                lights[y][x] += 1;
            }
        }
        return lights;
    }

    public static int[][] turnOff(int[][] lights, int x1, int y1, int x2, int y2) {
        for (int y = y1; y <= y2; y++) {
            for (int x = x1; x <= x2; x++) {
                if (lights[y][x] != 0) {
                    lights[y][x] -= 1;
                }
            }
        }
        return lights;
    }
    public static int[][] toggle(int[][] lights, int x1, int y1, int x2, int y2) {
        for (int y = y1; y <= y2; y++) {
            for (int x = x1; x <= x2; x++) {
                lights[y][x] += 2;
            }
        }
        return lights;
    }
}
