import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Year16_Day2 {
    public static void main(String[] args) throws FileNotFoundException {
        String[][] thing = {
                {"0","0","1","0","0"},
                {"0","2","3","4","0"},
                {"5","6","7","8","9"},
                {"0","A","B","C","0"},
                {"0","0","D","0","0"}
        };
        File f = new File("16/2");
        Scanner s = new Scanner(f);
        int row = 1;
        int column = 1;
        while (s.hasNext()) {
            String line = s.nextLine();
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == 'U' && row != 0) {
                    row--;
                    if (thing[row][column].equals("0")) {
                        row++;
                    }
                }
                else if (line.charAt(i) == 'L' && column != 0) {
                    column--;
                    if (thing[row][column].equals("0")) {
                        column++;
                    }
                }
                else if (line.charAt(i) == 'D' && row != 4) {
                    row++;
                    if (thing[row][column].equals("0")) {
                        row--;
                    }
                }
                else if (line.charAt(i) == 'R' && column != 4){
                    column++;
                    if (thing[row][column].equals("0")) {
                        column--;
                    }
                }
            }
            System.out.print(thing[row][column]);
        }
    }
}