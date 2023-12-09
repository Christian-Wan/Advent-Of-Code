import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Year23_Day8 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("23/8");
        Scanner s = new Scanner(f);
        String line = s.nextLine();
        String[] steps = new String[line.length()];
        for (int i = 0; i < line.length(); i++) {
            steps[i] = line.substring(i, i + 1);
        }
        line = s.nextLine();
        String file = "";
        while (s.hasNext()) {
            file += s.nextLine() + "\n";
        }
        HashMap<String, String[]> nodes = makeMap(file);
        String[] nodeKeys = Arrays.toString(nodes.keySet().toArray()).substring(1, Arrays.toString(nodes.keySet().toArray()).length() - 1).split(", ");
        ArrayList<String> startNodes = new ArrayList<>();
        for (int i = 0; i < nodeKeys.length; i++) {
            if (nodeKeys[i].charAt(2) == 'A') {
                startNodes.add(nodeKeys[i]);
            }
        }
        ArrayList<String> endNodes = new ArrayList<>();
        for (int i = 0; i < nodeKeys.length; i++) {
            if (nodeKeys[i].charAt(2) == 'Z') {
                endNodes.add(nodeKeys[i]);
            }
        }

        ArrayList<Integer> beforeLoop = new ArrayList<>();
        ArrayList<String> beenTo = new ArrayList<>();

        for (int i = 0; i < startNodes.size(); i++) {
            int count = 0;
            int storage = 0;
            int index = 0;
            String test = startNodes.get(i);
            beenTo = new ArrayList<>();
            while (!beenTo.contains(test) || !endNodes.contains(test)) {
                beenTo.add(test);
                if (endNodes.contains(test)) {
                    storage = count;
                }
                test = moveNodes(steps, test, index, nodes);
                count++;
                if (index == steps.length - 1) {
                    index = 0;
                } else {
                    index++;
                }
            }
            beforeLoop.add(storage);
        }

        long total = beforeLoop.get(0);
        for (int i = 1; i < beforeLoop.size(); i++) {
            long gcd = 0;
            for (long x = beforeLoop.get(i); x > 0; x--) {
                if (total % x == 0 && beforeLoop.get(i) % x == 0) {
                    gcd = x;
                    break;
                }
            }
            total = (total * beforeLoop.get(i)) / gcd;
        }
        System.out.println(total);
    }

    public static HashMap<String, String[]> makeMap(String file) {
        HashMap<String, String[]> result = new HashMap<>();
        while (!file.isEmpty()) {
            String line = file.substring(0, file.indexOf("\n"));
            file = file.substring(file.indexOf("\n") + 1);
            String[] outcomes = new String[2];
            outcomes[0] = line.substring(line.indexOf("(") + 1, line.indexOf(","));
            outcomes[1] = line.substring(line.indexOf(",") + 2, line.indexOf(")"));
            result.put(line.substring(0, 3), outcomes);
        }
        return result;
    }

    public static String moveNodes(String[] steps, String currentlyOn, int index, HashMap<String, String[]> nodes) {
        if (steps[index].equals("L")) {
            return nodes.get(currentlyOn)[0];
        } else {
            return nodes.get(currentlyOn)[1];
        }
    }
}