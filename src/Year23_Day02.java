import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Year23_Day02 {
    public static void main(String[] args) throws FileNotFoundException {

        File f = new File("23/2");
        Scanner s = new Scanner(f);
        int total = 0;

        while (s.hasNext()) {

            String line = s.nextLine();
            total += checkGame(groupGame(line));

            }
        System.out.println(total);
    }

    public static ArrayList<HashMap<String, String>> groupGame(String input) {

        input = input.substring(input.indexOf(": ") + 2);
        String[] subsets = input.split("; ");
        ArrayList<HashMap<String, String>> result = new ArrayList<>();

        for(int i = 0; i < subsets.length; i++) {

            HashMap<String, String> tempMap = new HashMap<>();
            String single = subsets[i].replace(",", "");
            String[] group = single.split(" ");

            for (int x = 1; x < group.length; x += 2) {

                tempMap.put(group[x], group[x - 1]);

            }

            result.add(tempMap);
        }
        return result;
    }

    public static int checkGame(ArrayList<HashMap<String, String>> game) {
        int red = 0;
        int green = 0;
        int blue = 0;

        for (int i = 0; i < game.size(); i++) {
            HashMap<String, String> currentSubSet = game.get(i);

            try {

                if (Integer.parseInt(currentSubSet.get("red")) > red) {
                    red = Integer.parseInt(currentSubSet.get("red"));
                }

            }
            catch (NumberFormatException e) {

            }

            try {

                if (Integer.parseInt(currentSubSet.get("green")) > green) {
                    green = Integer.parseInt(currentSubSet.get("green"));
                }

            }
            catch (NumberFormatException e) {

            }

            try {

                if (Integer.parseInt(currentSubSet.get("blue")) > blue) {
                    blue = Integer.parseInt(currentSubSet.get("blue"));
                }

            }
            catch (NumberFormatException e) {

            }
        }
        return red * green * blue;
    }
}