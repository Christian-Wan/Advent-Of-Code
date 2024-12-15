import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Year18_Day04 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("18/4");
        Scanner s= new Scanner(f);

        ArrayList<String> input = new ArrayList<>();
        HashMap<String, ArrayList<Integer>> guards = new HashMap<>();
        boolean sleeping = false;
        int startSleep = 0;
        String id = "";

        while (s.hasNext()) {
            input.add(s.nextLine());
        }
        Collections.sort(input);

        for (String line: input){
            if (line.contains("#")) {
                if (sleeping) {
                    for (int i = startSleep; i < 60; i++) {
                        guards.get(id).add(i);
                    }
                    sleeping = false;
                }
                id = line.substring(line.indexOf("#") + 1, line.indexOf("begins") - 1);
                if (!guards.keySet().contains(id)) {
                    guards.put(id, new ArrayList<>());
                }
            }
            else if (line.contains("falls") && !sleeping) {
                sleeping = true;
                startSleep = Integer.parseInt(line.substring(line.indexOf(":") + 1, line.indexOf("]")));
            }
            else if (line.contains("wakes") && sleeping) {
                for (int i = startSleep; i < Integer.parseInt(line.substring(line.indexOf(":") + 1, line.indexOf("]"))); i++) {
                    guards.get(id).add(i);
                }
                sleeping = false;
            }
        }

        String guard = "";
        int hoursSleeping = 0;
        int hour = 0;
        int numberOfTimes = 0;
        for (String key: guards.keySet()) {
            for (int i = 0; i < 59; i++) {
                int count = 0;
                for (int value: guards.get(key)) {
                    if (value == i) {
                        count++;
                    }
                }
                if (count > numberOfTimes) {
                    guard = key;
                    hour = i;
                    numberOfTimes = count;
                }
            }
        }


        System.out.println(hour * Integer.parseInt(guard));
    }
    //32070 high
}
