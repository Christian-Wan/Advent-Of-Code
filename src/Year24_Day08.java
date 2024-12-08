import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Year24_Day08 {
    public static void main(String[] args) throws FileNotFoundException {
        File f=  new File("24/8");
        Scanner s = new Scanner(f);

        int size = 50;
        String[][] grid = new String[size][size];
        HashMap<String, ArrayList<String>> frequency = new HashMap<>();
        int total = 0;

        int index = 0;
        while (s.hasNext()) {
            String line = s.nextLine();
            for (int i = 0; i < line.length(); i++) {
                String charAt = line.substring(i, i + 1);
                grid[index][i] = charAt;
                if (!frequency.containsKey(charAt)) {
                    ArrayList<String> cords = new ArrayList<>();
                    cords.add(index + "," + i);
                    frequency.put(charAt, cords);
                }
                else {
                    ArrayList<String> cords = new ArrayList<>(frequency.get(charAt));
                    cords.add(index + "," + i);
                    frequency.replace(charAt, cords);
                }
            }
            index++;
        }
        frequency.remove(".");

        System.out.println(frequency.keySet());



        ArrayList<String> antiNodes = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>(frequency.keySet());
        for (String key: keys) {
            ArrayList<String> values = new ArrayList<>(frequency.get(key));
            for (int i = 0; i < values.size(); i++) {
                for (int x = 0; x < values.size() - 1; x++) {
                    String cord = values.get(i);
                    String cord2 = "";

                    if (x >= i) {
                        cord2 = values.get(x + 1);

                    }
                    else {
                        cord2 = values.get(x);
                    }
                    int newX = Integer.parseInt(cord.substring(0, cord.indexOf(","))) - Integer.parseInt(cord2.substring(0, cord2.indexOf(",")));
                    int newY = Integer.parseInt(cord.substring(cord.indexOf(",") + 1)) - Integer.parseInt(cord2.substring(cord2.indexOf(",") + 1));
                    int newXReal = Integer.parseInt(cord.substring(0, cord.indexOf(","))) - newX;
                    int newYReal = Integer.parseInt(cord.substring(cord.indexOf(",") + 1)) - newY;
                    while (true) {
                        newXReal = newXReal + newX;
                        newYReal = newYReal + newY;
                        if (newXReal >= 0 && newYReal >= 0 && newXReal < size && newYReal < size) {
                            boolean test = false;
                            System.out.println(newXReal + "," + newYReal);
                            for (String key2: keys) {
                                if (antiNodes.contains(newXReal + "," + newYReal)) {
                                    test = true;

                                }
                            }
                            if (!test) {
                                antiNodes.add(newXReal + "," + newYReal);
                                total++;
                                System.out.println(antiNodes);
//                            System.out.println(cord);
                            }
                        }
                        else {
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(total);
    }

    //279
    //267
}
