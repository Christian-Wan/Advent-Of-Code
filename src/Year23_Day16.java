import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Year23_Day16 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("23/16");
        Scanner s = new Scanner(f);
        Scanner pause = new Scanner(System.in);
        String[][] physicalGrid = new String[110][110];
        int[][] beamGrid = new int[physicalGrid.length][physicalGrid.length];
        ArrayList<String> currentLocations = new ArrayList<>();
        ArrayList<String> alreadyBeen = new ArrayList<>();
        int index = 0;

        while (s.hasNext()) {
            String line = s.nextLine();
            for (int i = 0; i < line.length(); i++) {
                physicalGrid[index][i] = line.substring(i, i + 1);
            }
            index++;
        }
        int max = 0;


        for (int a = 0; a < beamGrid.length; a++) {
            int[][] oldBeamGrid = new int[beamGrid.length][beamGrid.length];
            currentLocations = new ArrayList<>();
            beamGrid = new int[physicalGrid.length][physicalGrid.length];
            beamGrid[a][0] = 1;
            alreadyBeen = new ArrayList<>();
            currentLocations.add("e0," + a);
            System.out.println(currentLocations);
            while (!currentLocations.isEmpty()) {
                for (int i = 0; i < currentLocations.size(); i++) {
                    alreadyBeen.addAll(currentLocations);
                }
                for (int i = 0; i < currentLocations.size(); i++) {
                    String direction = currentLocations.get(i).substring(0, 1);
                    int x = Integer.parseInt(currentLocations.get(i).substring(1, currentLocations.get(i).indexOf(",")));
                    int y = Integer.parseInt(currentLocations.get(i).substring(currentLocations.get(i).indexOf(",") + 1));
                    if (x >= beamGrid.length || y >= beamGrid.length || x < 0 || y < 0) {
                        currentLocations.remove(i);
                        i--;
                    } else if (physicalGrid[y][x].equals(".")) {
                        String newLocation;
                        if (direction.equals("n")) {
                            newLocation = "n" + x + "," + (y - 1);
                        } else if (direction.equals("e")) {
                            newLocation = "e" + (x + 1) + "," + y;
                        } else if (direction.equals("s")) {
                            newLocation = "s" + x + "," + (y + 1);
                        } else {
                            newLocation = "w" + (x - 1) + "," + y;
                        }
                        currentLocations.set(i, newLocation);
                        if (alreadyBeen.contains(newLocation)) {
                            currentLocations.remove(i);
                            i--;
                        }
                    } else if (physicalGrid[y][x].equals("/")) {
                        String newLocation;
                        if (direction.equals("n")) {
                            newLocation = "e" + (x + 1) + "," + y;
                        } else if (direction.equals("e")) {
                            newLocation = "n" + x + "," + (y - 1);
                        } else if (direction.equals("s")) {
                            newLocation = "w" + (x - 1) + "," + y;
                        } else {
                            newLocation = "s" + x + "," + (y + 1);
                        }
                        currentLocations.set(i, newLocation);
                        if (alreadyBeen.contains(newLocation)) {
                            currentLocations.remove(i);
                            i--;
                        }
                    } else if (physicalGrid[y][x].equals("\\")) {
                        String newLocation;
                        if (direction.equals("n")) {
                            newLocation = "w" + (x - 1) + "," + y;
                        } else if (direction.equals("e")) {
                            newLocation = "s" + x + "," + (y + 1);
                        } else if (direction.equals("s")) {
                            newLocation = "e" + (x + 1) + "," + y;
                        } else {
                            newLocation = "n" + x + "," + (y - 1);
                        }
                        currentLocations.set(i, newLocation);
                        if (alreadyBeen.contains(newLocation)) {
                            currentLocations.remove(i);
                            i--;
                        }
                    } else if (physicalGrid[y][x].equals("-")) {
                        if (direction.equals("n") || direction.equals("s")) {
                            currentLocations.remove(i);
                            currentLocations.addFirst("w" + (x - 1) + "," + y);
                            currentLocations.addFirst("e" + (x + 1) + "," + y);
                            i++;
                        } else {
                            String newLocation;
                            if (direction.equals("e")) {
                                newLocation = "e" + (x + 1) + "," + y;
                            } else {
                                newLocation = "w" + (x - 1) + "," + y;
                            }
                            currentLocations.set(i, newLocation);
                            if (alreadyBeen.contains(newLocation)) {
                                currentLocations.remove(i);
                                i--;
                            }
                        }
                    } else if (physicalGrid[y][x].equals("|")) {
                        if (direction.equals("e") || direction.equals("w")) {
                            currentLocations.remove(i);
                            currentLocations.addFirst("n" + x + "," + (y - 1));
                            currentLocations.addFirst("s" + x + "," + (y + 1));
                            i++;
                        } else {
                            String newLocation;
                            if (direction.equals("n")) {
                                newLocation = "n" + x + "," + (y - 1);
                            } else {
                                newLocation = "s" + x + "," + (y + 1);
                            }
                            currentLocations.set(i, newLocation);
                            if (alreadyBeen.contains(newLocation)) {
                                currentLocations.remove(i);
                                i--;
                            }
                        }
                    }
                }
                for (int i = 0; i < currentLocations.size(); i++) {
                    try {
                        beamGrid[Integer.parseInt(currentLocations.get(i).substring(currentLocations.get(i).indexOf(",") + 1))][Integer.parseInt(currentLocations.get(i).substring(1, currentLocations.get(i).indexOf(",")))] = 1;
                    } catch (IndexOutOfBoundsException e) {

                    }
                }
//                int total = 0;
//                for (int i = 0; i < beamGrid.length; i++) {
//                    for (int x = 0; x < beamGrid.length; x++) {
//                        if (beamGrid[i][x] == 1) {
//                            total++;
//                        }
//                    }
//                }
//                System.out.println(total);
            }
            int total = 0;
            for (int i = 0; i < beamGrid.length; i++) {
                for (int x = 0; x < beamGrid.length; x++) {
                    if (beamGrid[i][x] == 1) {
                        total++;
                    }
                }
            }
            if (total > max) {
                max = total;
                System.out.println(max);
            }
        }
        for (int a = 0; a < beamGrid.length; a++) {
            int[][] oldBeamGrid = new int[beamGrid.length][beamGrid.length];
            currentLocations = new ArrayList<>();
            beamGrid = new int[physicalGrid.length][physicalGrid.length];
            beamGrid[beamGrid.length - 1][a] = 1;
            alreadyBeen = new ArrayList<>();
            currentLocations.add("n" + a + "," + (beamGrid.length - 1));
            System.out.println(currentLocations);
            while (!currentLocations.isEmpty()) {
                for (int i = 0; i < currentLocations.size(); i++) {
                    alreadyBeen.addAll(currentLocations);
                }
                for (int i = 0; i < currentLocations.size(); i++) {
                    String direction = currentLocations.get(i).substring(0, 1);
                    int x = Integer.parseInt(currentLocations.get(i).substring(1, currentLocations.get(i).indexOf(",")));
                    int y = Integer.parseInt(currentLocations.get(i).substring(currentLocations.get(i).indexOf(",") + 1));
                    if (x >= beamGrid.length || y >= beamGrid.length || x < 0 || y < 0) {
                        currentLocations.remove(i);
                        i--;
                    } else if (physicalGrid[y][x].equals(".")) {
                        String newLocation;
                        if (direction.equals("n")) {
                            newLocation = "n" + x + "," + (y - 1);
                        } else if (direction.equals("e")) {
                            newLocation = "e" + (x + 1) + "," + y;
                        } else if (direction.equals("s")) {
                            newLocation = "s" + x + "," + (y + 1);
                        } else {
                            newLocation = "w" + (x - 1) + "," + y;
                        }
                        currentLocations.set(i, newLocation);
                        if (alreadyBeen.contains(newLocation)) {
                            currentLocations.remove(i);
                            i--;
                        }
                    } else if (physicalGrid[y][x].equals("/")) {
                        String newLocation;
                        if (direction.equals("n")) {
                            newLocation = "e" + (x + 1) + "," + y;
                        } else if (direction.equals("e")) {
                            newLocation = "n" + x + "," + (y - 1);
                        } else if (direction.equals("s")) {
                            newLocation = "w" + (x - 1) + "," + y;
                        } else {
                            newLocation = "s" + x + "," + (y + 1);
                        }
                        currentLocations.set(i, newLocation);
                        if (alreadyBeen.contains(newLocation)) {
                            currentLocations.remove(i);
                            i--;
                        }
                    } else if (physicalGrid[y][x].equals("\\")) {
                        String newLocation;
                        if (direction.equals("n")) {
                            newLocation = "w" + (x - 1) + "," + y;
                        } else if (direction.equals("e")) {
                            newLocation = "s" + x + "," + (y + 1);
                        } else if (direction.equals("s")) {
                            newLocation = "e" + (x + 1) + "," + y;
                        } else {
                            newLocation = "n" + x + "," + (y - 1);
                        }
                        currentLocations.set(i, newLocation);
                        if (alreadyBeen.contains(newLocation)) {
                            currentLocations.remove(i);
                            i--;
                        }
                    } else if (physicalGrid[y][x].equals("-")) {
                        if (direction.equals("n") || direction.equals("s")) {
                            currentLocations.remove(i);
                            currentLocations.addFirst("w" + (x - 1) + "," + y);
                            currentLocations.addFirst("e" + (x + 1) + "," + y);
                            i++;
                        } else {
                            String newLocation;
                            if (direction.equals("e")) {
                                newLocation = "e" + (x + 1) + "," + y;
                            } else {
                                newLocation = "w" + (x - 1) + "," + y;
                            }
                            currentLocations.set(i, newLocation);
                            if (alreadyBeen.contains(newLocation)) {
                                currentLocations.remove(i);
                                i--;
                            }
                        }
                    } else if (physicalGrid[y][x].equals("|")) {
                        if (direction.equals("e") || direction.equals("w")) {
                            currentLocations.remove(i);
                            currentLocations.addFirst("n" + x + "," + (y - 1));
                            currentLocations.addFirst("s" + x + "," + (y + 1));
                            i++;
                        } else {
                            String newLocation;
                            if (direction.equals("n")) {
                                newLocation = "n" + x + "," + (y - 1);
                            } else {
                                newLocation = "s" + x + "," + (y + 1);
                            }
                            currentLocations.set(i, newLocation);
                            if (alreadyBeen.contains(newLocation)) {
                                currentLocations.remove(i);
                                i--;
                            }
                        }
                    }
                }
                for (int i = 0; i < currentLocations.size(); i++) {
                    try {
                        beamGrid[Integer.parseInt(currentLocations.get(i).substring(currentLocations.get(i).indexOf(",") + 1))][Integer.parseInt(currentLocations.get(i).substring(1, currentLocations.get(i).indexOf(",")))] = 1;
                    } catch (IndexOutOfBoundsException e) {

                    }
                }
//                int total = 0;
//                for (int i = 0; i < beamGrid.length; i++) {
//                    for (int x = 0; x < beamGrid.length; x++) {
//                        if (beamGrid[i][x] == 1) {
//                            total++;
//                        }
//                    }
//                }
//                System.out.println(total);
            }
            int total = 0;
            for (int i = 0; i < beamGrid.length; i++) {
                for (int x = 0; x < beamGrid.length; x++) {
                    if (beamGrid[i][x] == 1) {
                        total++;
                    }
                }
            }
            if (total > max) {
                max = total;
                System.out.println(max);
            }
        }
        for (int a = 0; a < beamGrid.length; a++) {
            int[][] oldBeamGrid = new int[beamGrid.length][beamGrid.length];
            currentLocations = new ArrayList<>();
            beamGrid = new int[physicalGrid.length][physicalGrid.length];
            beamGrid[a][beamGrid.length - 1] = 1;
            alreadyBeen = new ArrayList<>();
            currentLocations.add("w" + (beamGrid.length - 1) + "," + a);
            System.out.println(currentLocations);
            while (!currentLocations.isEmpty()) {
                for (int i = 0; i < currentLocations.size(); i++) {
                    alreadyBeen.addAll(currentLocations);
                }
                for (int i = 0; i < currentLocations.size(); i++) {
                    String direction = currentLocations.get(i).substring(0, 1);
                    int x = Integer.parseInt(currentLocations.get(i).substring(1, currentLocations.get(i).indexOf(",")));
                    int y = Integer.parseInt(currentLocations.get(i).substring(currentLocations.get(i).indexOf(",") + 1));
                    if (x >= beamGrid.length || y >= beamGrid.length || x < 0 || y < 0) {
                        currentLocations.remove(i);
                        i--;
                    } else if (physicalGrid[y][x].equals(".")) {
                        String newLocation;
                        if (direction.equals("n")) {
                            newLocation = "n" + x + "," + (y - 1);
                        } else if (direction.equals("e")) {
                            newLocation = "e" + (x + 1) + "," + y;
                        } else if (direction.equals("s")) {
                            newLocation = "s" + x + "," + (y + 1);
                        } else {
                            newLocation = "w" + (x - 1) + "," + y;
                        }
                        currentLocations.set(i, newLocation);
                        if (alreadyBeen.contains(newLocation)) {
                            currentLocations.remove(i);
                            i--;
                        }
                    } else if (physicalGrid[y][x].equals("/")) {
                        String newLocation;
                        if (direction.equals("n")) {
                            newLocation = "e" + (x + 1) + "," + y;
                        } else if (direction.equals("e")) {
                            newLocation = "n" + x + "," + (y - 1);
                        } else if (direction.equals("s")) {
                            newLocation = "w" + (x - 1) + "," + y;
                        } else {
                            newLocation = "s" + x + "," + (y + 1);
                        }
                        currentLocations.set(i, newLocation);
                        if (alreadyBeen.contains(newLocation)) {
                            currentLocations.remove(i);
                            i--;
                        }
                    } else if (physicalGrid[y][x].equals("\\")) {
                        String newLocation;
                        if (direction.equals("n")) {
                            newLocation = "w" + (x - 1) + "," + y;
                        } else if (direction.equals("e")) {
                            newLocation = "s" + x + "," + (y + 1);
                        } else if (direction.equals("s")) {
                            newLocation = "e" + (x + 1) + "," + y;
                        } else {
                            newLocation = "n" + x + "," + (y - 1);
                        }
                        currentLocations.set(i, newLocation);
                        if (alreadyBeen.contains(newLocation)) {
                            currentLocations.remove(i);
                            i--;
                        }
                    } else if (physicalGrid[y][x].equals("-")) {
                        if (direction.equals("n") || direction.equals("s")) {
                            currentLocations.remove(i);
                            currentLocations.addFirst("w" + (x - 1) + "," + y);
                            currentLocations.addFirst("e" + (x + 1) + "," + y);
                            i++;
                        } else {
                            String newLocation;
                            if (direction.equals("e")) {
                                newLocation = "e" + (x + 1) + "," + y;
                            } else {
                                newLocation = "w" + (x - 1) + "," + y;
                            }
                            currentLocations.set(i, newLocation);
                            if (alreadyBeen.contains(newLocation)) {
                                currentLocations.remove(i);
                                i--;
                            }
                        }
                    } else if (physicalGrid[y][x].equals("|")) {
                        if (direction.equals("e") || direction.equals("w")) {
                            currentLocations.remove(i);
                            currentLocations.addFirst("n" + x + "," + (y - 1));
                            currentLocations.addFirst("s" + x + "," + (y + 1));
                            i++;
                        } else {
                            String newLocation;
                            if (direction.equals("n")) {
                                newLocation = "n" + x + "," + (y - 1);
                            } else {
                                newLocation = "s" + x + "," + (y + 1);
                            }
                            currentLocations.set(i, newLocation);
                            if (alreadyBeen.contains(newLocation)) {
                                currentLocations.remove(i);
                                i--;
                            }
                        }
                    }
                }
                for (int i = 0; i < currentLocations.size(); i++) {
                    try {
                        beamGrid[Integer.parseInt(currentLocations.get(i).substring(currentLocations.get(i).indexOf(",") + 1))][Integer.parseInt(currentLocations.get(i).substring(1, currentLocations.get(i).indexOf(",")))] = 1;
                    } catch (IndexOutOfBoundsException e) {

                    }
                }
//                int total = 0;
//                for (int i = 0; i < beamGrid.length; i++) {
//                    for (int x = 0; x < beamGrid.length; x++) {
//                        if (beamGrid[i][x] == 1) {
//                            total++;
//                        }
//                    }
//                }
//                System.out.println(total);
            }
            int total = 0;
            for (int i = 0; i < beamGrid.length; i++) {
                for (int x = 0; x < beamGrid.length; x++) {
                    if (beamGrid[i][x] == 1) {
                        total++;
                    }
                }
            }
            if (total > max) {
                max = total;
                System.out.println(max);
            }
        }
        for (int a = 0; a < beamGrid.length; a++) {
            int[][] oldBeamGrid = new int[beamGrid.length][beamGrid.length];
            currentLocations = new ArrayList<>();
            beamGrid = new int[physicalGrid.length][physicalGrid.length];
            beamGrid[0][a] = 1;
            alreadyBeen = new ArrayList<>();
            currentLocations.add("s" + a + ",0");
            System.out.println(currentLocations);
            while (!currentLocations.isEmpty()) {
                for (int i = 0; i < currentLocations.size(); i++) {
                    alreadyBeen.addAll(currentLocations);
                }
                for (int i = 0; i < currentLocations.size(); i++) {
                    String direction = currentLocations.get(i).substring(0, 1);
                    int x = Integer.parseInt(currentLocations.get(i).substring(1, currentLocations.get(i).indexOf(",")));
                    int y = Integer.parseInt(currentLocations.get(i).substring(currentLocations.get(i).indexOf(",") + 1));
                    if (x >= beamGrid.length || y >= beamGrid.length || x < 0 || y < 0) {
                        currentLocations.remove(i);
                        i--;
                    } else if (physicalGrid[y][x].equals(".")) {
                        String newLocation;
                        if (direction.equals("n")) {
                            newLocation = "n" + x + "," + (y - 1);
                        } else if (direction.equals("e")) {
                            newLocation = "e" + (x + 1) + "," + y;
                        } else if (direction.equals("s")) {
                            newLocation = "s" + x + "," + (y + 1);
                        } else {
                            newLocation = "w" + (x - 1) + "," + y;
                        }
                        currentLocations.set(i, newLocation);
                        if (alreadyBeen.contains(newLocation)) {
                            currentLocations.remove(i);
                            i--;
                        }
                    } else if (physicalGrid[y][x].equals("/")) {
                        String newLocation;
                        if (direction.equals("n")) {
                            newLocation = "e" + (x + 1) + "," + y;
                        } else if (direction.equals("e")) {
                            newLocation = "n" + x + "," + (y - 1);
                        } else if (direction.equals("s")) {
                            newLocation = "w" + (x - 1) + "," + y;
                        } else {
                            newLocation = "s" + x + "," + (y + 1);
                        }
                        currentLocations.set(i, newLocation);
                        if (alreadyBeen.contains(newLocation)) {
                            currentLocations.remove(i);
                            i--;
                        }
                    } else if (physicalGrid[y][x].equals("\\")) {
                        String newLocation;
                        if (direction.equals("n")) {
                            newLocation = "w" + (x - 1) + "," + y;
                        } else if (direction.equals("e")) {
                            newLocation = "s" + x + "," + (y + 1);
                        } else if (direction.equals("s")) {
                            newLocation = "e" + (x + 1) + "," + y;
                        } else {
                            newLocation = "n" + x + "," + (y - 1);
                        }
                        currentLocations.set(i, newLocation);
                        if (alreadyBeen.contains(newLocation)) {
                            currentLocations.remove(i);
                            i--;
                        }
                    } else if (physicalGrid[y][x].equals("-")) {
                        if (direction.equals("n") || direction.equals("s")) {
                            currentLocations.remove(i);
                            currentLocations.addFirst("w" + (x - 1) + "," + y);
                            currentLocations.addFirst("e" + (x + 1) + "," + y);
                            i++;
                        } else {
                            String newLocation;
                            if (direction.equals("e")) {
                                newLocation = "e" + (x + 1) + "," + y;
                            } else {
                                newLocation = "w" + (x - 1) + "," + y;
                            }
                            currentLocations.set(i, newLocation);
                            if (alreadyBeen.contains(newLocation)) {
                                currentLocations.remove(i);
                                i--;
                            }
                        }
                    } else if (physicalGrid[y][x].equals("|")) {
                        if (direction.equals("e") || direction.equals("w")) {
                            currentLocations.remove(i);
                            currentLocations.addFirst("n" + x + "," + (y - 1));
                            currentLocations.addFirst("s" + x + "," + (y + 1));
                            i++;
                        } else {
                            String newLocation;
                            if (direction.equals("n")) {
                                newLocation = "n" + x + "," + (y - 1);
                            } else {
                                newLocation = "s" + x + "," + (y + 1);
                            }
                            currentLocations.set(i, newLocation);
                            if (alreadyBeen.contains(newLocation)) {
                                currentLocations.remove(i);
                                i--;
                            }
                        }
                    }
                }
                for (int i = 0; i < currentLocations.size(); i++) {
                    try {
                        beamGrid[Integer.parseInt(currentLocations.get(i).substring(currentLocations.get(i).indexOf(",") + 1))][Integer.parseInt(currentLocations.get(i).substring(1, currentLocations.get(i).indexOf(",")))] = 1;
                    } catch (IndexOutOfBoundsException e) {

                    }
                }
//                int total = 0;
//                for (int i = 0; i < beamGrid.length; i++) {
//                    for (int x = 0; x < beamGrid.length; x++) {
//                        if (beamGrid[i][x] == 1) {
//                            total++;
//                        }
//                    }
//                }
//                System.out.println(total);
            }
            int total = 0;
            for (int i = 0; i < beamGrid.length; i++) {
                for (int x = 0; x < beamGrid.length; x++) {
                    if (beamGrid[i][x] == 1) {
                        total++;
                    }
                }
            }
            if (total > max) {
                max = total;
                System.out.println(max);
            }
        }
        System.out.println(max);
    }
}
