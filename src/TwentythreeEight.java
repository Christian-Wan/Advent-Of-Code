import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TwentythreeEight {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("Twentythree/eight");
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
        System.out.println(Arrays.toString(nodeKeys));
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
        long count = 0;
        int index = 0;
        System.out.println(startNodes);
        System.out.println(endNodes);
        while (!allOnFinal(startNodes, endNodes)) {
            if (count % 1000000 == 0) {
                System.out.println(count);
            }
            for (int i = 0; i < startNodes.size(); i++) {
                String currentlyOn = startNodes.get(i);
                startNodes.set(i, moveNodes(steps, currentlyOn, index, nodes));
            }
            count++;
            if (index == steps.length - 1) {
                index = 0;
            } else {
                index++;
            }

        }
        System.out.println(count);

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

    public static boolean allOnFinal(ArrayList<String> currentNodes, ArrayList<String> endNodes) {
        for (int i = 0; i < currentNodes.size(); i++) {
            if (!endNodes.contains(currentNodes.get(i))) {
                return false;
            }
        }
        return true;
    }
}
