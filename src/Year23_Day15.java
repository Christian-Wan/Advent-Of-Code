import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Year23_Day15 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("23/15");
        Scanner s = new Scanner(f);
        String line = s.nextLine();
        String[] words = line.split(",");
        int current = 0;
        int total = 0;
        HashMap<Integer, LinkedHashMap<String, Integer>> boxes = new HashMap<>();

        for (int x = 0; x < words.length; x++) {
            current = 0;
            if (words[x].contains("=")) {
                for (int i = 0; i < words[x].length() - 2; i++) {
                    current += words[x].charAt(i);
                    current *= 17;
                    current %= 256;
                }
            }
            else {
                for (int i = 0; i < words[x].length() - 1; i++) {
                    current += words[x].charAt(i);
                    current *= 17;
                    current %= 256;
                }
            }

            if (words[x].contains("=")) {
                int value = Integer.parseInt(words[x].substring(words[x].indexOf("=") + 1));
                if (boxes.get(current) == null) {
                    boxes.put(current, new LinkedHashMap<>());
                    boxes.get(current).put(words[x].substring(0, words[x].length() - 2), value);
                }
                else if (boxes.get(current).containsKey(words[x].substring(0, words[x].length() - 2))) {
                    boxes.get(current).replace(words[x].substring(0, words[x].length() - 2), value);
                }
                else {
                    boxes.get(current).put(words[x].substring(0, words[x].length() - 2), value);
                }
            }
            else {
                System.out.println(current);
                System.out.println(words[x]);
                if (boxes.get(current) == null) {
                }
                else boxes.get(current).remove(words[x].substring(0, words[x].length() - 1));
            }
            System.out.println(boxes);
        }
        for (int i = 0; i < 256; i++) {
            try {
                String[] tag = boxes.get(i).keySet().toArray(new String[0]);
                for (int x = 0; x < tag.length; x++) {
                    total += (i + 1) * (x + 1) * boxes.get(i).get(tag[x]);
                }
            }
            catch (NullPointerException e) {

            }

        }
        System.out.println(total);
    }
}
