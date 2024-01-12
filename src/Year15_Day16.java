import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Year15_Day16 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("15/16");
        Scanner s = new Scanner(f);
        HashMap<String, Integer> facts = new HashMap<>();
        facts.put("children", 3);
        facts.put("cats", 7);
        facts.put("samoyeds", 2);
        facts.put("pomeranians", 3);
        facts.put("akitas", 0);
        facts.put("vizslas", 0);
        facts.put("goldfish", 5);
        facts.put("trees", 3);
        facts.put("cars", 2);
        facts.put("perfumes", 1);

        Year15_Day16_Object[] sue = new Year15_Day16_Object[500];
        int index = 0;
        while (s.hasNext()) {
            String line = s.nextLine();
            line = line.substring(line.indexOf(":") + 2);
            String[] temp = line.split(", ");
            sue[index] = new Year15_Day16_Object(temp);
            index++;
        }
        for (int i = 0; i < 500; i++) {
            System.out.println(sue[i]);
        }
//        part 1
//        int counter = 0;
//        for (int i = 0; i < 500; i++) {
//            counter = 0;
//            System.out.println("sue " + i);
//            for (int x = 0; x < 3; x++) {
//                System.out.println(sue[i].getKnown()[x] + sue[i].getAmount()[x]);
//                if (facts.get(sue[i].getKnown()[x]) == sue[i].getAmount()[x]) {
//                    System.out.println("yes");
//                    counter++;
//                }
//            }
//            if (counter == 3) {
//                System.out.println(i + 1);
//                break;
//            }
//        }

//       part 2
        int counter = 0;
        for (int i = 0; i < 500; i++) {
            counter = 0;
            System.out.println("sue " + i);
            for (int x = 0; x < 3; x++) {
                System.out.println(sue[i].getKnown()[x] + sue[i].getAmount()[x]);
                if (sue[i].getKnown()[x].equals("cats") || sue[i].getKnown()[x].equals("trees")) {
                    if (facts.get(sue[i].getKnown()[x]) < sue[i].getAmount()[x]) {
                        System.out.println("yes");
                        counter++;
                    }
                }
                else if (sue[i].getKnown()[x].equals("pomeranians") || sue[i].getKnown()[x].equals("goldfish")) {
                    if (facts.get(sue[i].getKnown()[x]) > sue[i].getAmount()[x]) {
                        System.out.println("yes");
                        counter++;
                    }
                }
                else {
                    if (facts.get(sue[i].getKnown()[x]) == sue[i].getAmount()[x]) {
                        System.out.println("yes");
                        counter++;
                    }
                }
            }
            if (counter == 3) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}