import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Year23_Day11 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("23/11");
        Scanner s = new Scanner(f);
        ArrayList<ArrayList<String>> galaxy = new ArrayList<>();
        while (s.hasNext()) {
            String line = s.nextLine();
            ArrayList<String> temp = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                temp.add(line.substring(i, i + 1));
            }
            galaxy.add(temp);
        }
        ArrayList<Integer> xEmpty = new ArrayList<>();
        ArrayList<Integer> yEmpty = new ArrayList<>();
//        for (int i = 0; i < galaxy.size(); i++) {
//            for (int x = 0; x < galaxy.get(0).size(); x++) {
//                System.out.print(galaxy.get(i).get(x));
//            }
//            System.out.println();
//        }
        for (int i = 0; i < galaxy.size(); i++) {
            boolean hasGalaxy = false;
            if (galaxy.get(i).contains("#")) {
                hasGalaxy = true;
            }

            if (!hasGalaxy) {
                yEmpty.add(i);
            }
        }
        for (int i = 0; i < galaxy.get(0).size(); i++) {
            boolean hasGalaxy = false;
            for (int x = 0; x < galaxy.size(); x++) {
                if (galaxy.get(x).get(i).equals("#")) {
                    hasGalaxy = true;
                }
            }

            if (!hasGalaxy) {
                xEmpty.add(i);
            }
        }
        ArrayList<String> cords = new ArrayList<>(); //(y, x)

        for (int i = 0; i < galaxy.size(); i++) {
            for (int x = 0; x < galaxy.get(0).size(); x++) {
                if (galaxy.get(i).get(x).equals("#")) {
                    cords.add(i + "/" + x);
                }
            }
        }
        System.out.println(cords);
        System.out.println(xEmpty);
        System.out.println(yEmpty);
        long total = 0;
        for (String coordinates: cords) {
            for (String coordinates2: cords) {
//                total = 0;
                System.out.println(coordinates);
                System.out.println(coordinates2);
                if (coordinates != coordinates2) {
                    if (!(Integer.parseInt(coordinates.substring(0, coordinates.indexOf("/"))) > Integer.parseInt(coordinates2.substring(0, coordinates2.indexOf("/"))))) {
                        for (int i = Integer.parseInt(coordinates.substring(0, coordinates.indexOf("/"))); i < Integer.parseInt(coordinates2.substring(0, coordinates2.indexOf("/"))); i++) {
                            total++;
                            if (yEmpty.contains(i)) {
                                total += 999999;
                            }
                        }
                    }
                    else {
                        for (int i = Integer.parseInt(coordinates.substring(0, coordinates.indexOf("/"))); i > Integer.parseInt(coordinates2.substring(0, coordinates2.indexOf("/"))); i--) {
                            total++;
                            if (yEmpty.contains(i)) {
                                total += 999999;
                            }
                        }
                    }
                    System.out.println(total);
                    if (!(Integer.parseInt(coordinates.substring(coordinates.indexOf("/") + 1)) > Integer.parseInt(coordinates2.substring(coordinates2.indexOf("/") + 1)))) {
                        for (int i = Integer.parseInt(coordinates.substring(coordinates.indexOf("/") + 1)); i < Integer.parseInt(coordinates2.substring(coordinates2.indexOf("/") + 1)); i++) {
                            total++;
                            if (xEmpty.contains(i)) {
                                total += 999999;
                            }
                        }
                    }
                    else {
                        for (int i = Integer.parseInt(coordinates.substring(coordinates.indexOf("/") + 1)); i > Integer.parseInt(coordinates2.substring(coordinates2.indexOf("/") + 1)); i--) {
                            total++;
                            if (xEmpty.contains(i)) {
                                total += 999999;
                            }
                        }
                    }
                    System.out.println(total);
                }
                System.out.println("------------------------------------------");
            }
        }
        System.out.println(total / 2);
    }
}
