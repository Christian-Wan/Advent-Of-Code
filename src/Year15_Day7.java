import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Year15_Day7 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("15/7");
        Scanner s = new Scanner(f);
        String file = "";
        HashMap<String, Integer> thing = new HashMap<>();

        while (s.hasNext()) {
            file += s.nextLine() + "\n";
        }
        int count = 0;
        String storage = file;
        for (int i = 0; i < 2; i++) {
            while (thing.get("a") == null) {
                count++;
                if (count % 10000000 == 0) {
                    System.out.println(thing);
                }
                String first = "";
                String second = "";
                String result = "";
                int amount = 0;
                if (file.isEmpty()) {
                    file = storage;
                }
                String line = file.substring(0, file.indexOf("\n"));
                file = file.substring(file.indexOf("\n") + 1);

                if (line.contains("AND")) {
                    first = line.substring(0, line.indexOf(" "));
                    second = line.substring(line.indexOf("AND") + 4, line.indexOf("-") - 1);
                    result = line.substring(line.indexOf(">") + 2);
                    if (thing.get(first) != null && thing.get(second) != null && thing.get(result) == null) {
                        thing.put(result, thing.get(first) & thing.get(second));

                    }
                    if (first.equals("1") && thing.get(second) != null && thing.get(result) == null) {
                        thing.put(result, 1 & thing.get(second));
                    }
                } else if (line.contains("OR")) {
                    first = line.substring(0, line.indexOf(" "));
                    second = line.substring(line.indexOf("OR") + 3, line.indexOf("-") - 1);
                    result = line.substring(line.indexOf(">") + 2);
                    if (thing.get(first) != null && thing.get(second) != null && thing.get(result) == null) {
                        thing.put(result, thing.get(first) | thing.get(second));
                    }
                    if (first.equals("1") && thing.get(second) != null && thing.get(result) == null) {
                        thing.put(result, 1 | thing.get(second));
                    }
                } else if (line.contains("NOT")) {

                    first = line.substring(line.indexOf("NOT") + 4, line.indexOf("-") - 1);
                    result = line.substring(line.indexOf(">") + 2);
                    if (thing.get(first) != null && thing.get(result) == null) {
                        thing.put(result, 6535 - thing.get(first));

                    }
                } else if (line.contains("RSHIFT")) {
                    first = line.substring(0, line.indexOf(" "));
                    amount = Integer.parseInt(line.substring(line.indexOf("SHIFT") + 6, line.indexOf("-") - 1));
                    result = line.substring(line.indexOf(">") + 2);
                    if (thing.get(first) != null && thing.get(result) == null) {
                        thing.put(result, thing.get(first) >> amount);
                    }
                } else if (line.contains("LSHIFT")) {
                    first = line.substring(0, line.indexOf(" "));
                    amount = Integer.parseInt(line.substring(line.indexOf("SHIFT") + 6, line.indexOf("-") - 1));
                    result = line.substring(line.indexOf(">") + 2);
                    if (thing.get(first) != null && thing.get(result) == null) {
                        thing.put(result, thing.get(first) << amount);
                    }
                } else {
                    first = line.substring(0, line.indexOf("-") - 1);
                    result = line.substring(line.indexOf(">") + 2);
                    if (thing.get(first) != null) {
                        thing.put(result, thing.get(first));
                    } else {
                        try {
                            thing.put(result, Integer.parseInt(first));
                        } catch (NumberFormatException e) {

                        }
                    }
                }
            }
            System.out.println(thing.get("a"));
            int store = thing.get("a");
            thing = new HashMap<>();
            thing.put("b", store);
        }
    }
}
