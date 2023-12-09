import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Year16_Day1 {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        boolean north = true;
        boolean south = false;
        boolean east = false;
        boolean west = false;
        String[] movement;
        ArrayList<String> grid = new ArrayList<>();
        File f = new File("16/1");
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        String line = s.nextLine();
        movement = line.split(", ");
        for (String i: movement) {
            char direction = i.charAt(0);
            int amount = Integer.parseInt(i.substring(1));
            if (north) {
                if (direction == 'L') {
                    west = true;
                    for (int a = 0; a < amount; a++) {
                        x--;
                        grid.add("x" + x + "y" + y);
                    }
                }
                else {
                    east = true;
                    for (int a = 0; a < amount; a++) {
                        x++;
                        grid.add("x" + x + "y" + y);
                    }
                }
                north = false;
            }
            else if (east) {
                if (direction == 'L') {
                    north = true;
                    for (int a = 0; a < amount; a++) {
                        y++;
                        grid.add("x" + x + "y" + y);
                    }
                }
                else {
                    south = true;
                    for (int a = 0; a < amount; a++) {
                        y--;
                        grid.add("x" + x + "y" + y);
                    }
                }
                east = false;
            }
            else if (south) {
                if (direction == 'L') {
                    east = true;
                    for (int a = 0; a < amount; a++) {
                        x++;
                        grid.add("x" + x + "y" + y);
                    }
                }
                else {
                    west = true;
                    for (int a = 0; a < amount; a++) {
                        x--;
                        grid.add("x" + x + "y" + y);
                    }
                }
                south = false;
            }
            else {
                if (direction == 'L') {
                    south = true;
                    for (int a = 0; a < amount; a++) {
                        y--;
                        grid.add("x" + x + "y" + y);
                    }
                }
                else {
                    north = true;
                    for (int a = 0; a < amount; a++) {
                        y++;
                        grid.add("x" + x + "y" + y);
                    }

                }
                west = false;
            }

        }
        int count = 0;
        boolean found = false;
        for (String cords: grid) {
            for (int i = 0; i < grid.size(); i++) {
                if (cords.equals(grid.get(i)) && count != i) {
                    System.out.println(cords);
                    found = true;
                    break;
                }
            }
            count++;
            if (found) {
                System.out.println(Math.abs(Integer.parseInt(cords.substring(1, cords.indexOf("y")))) + Math.abs(Integer.parseInt(cords.substring(cords.indexOf("y") + 1))));
                break;
            }
        }

    }
}