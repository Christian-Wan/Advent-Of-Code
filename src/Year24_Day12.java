import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class Year24_Day12 {
    public static void main(String[] args) throws FileNotFoundException {
        File f= new File("24/12");
        Scanner s= new Scanner(f);

        ArrayList<ArrayList<String>> grid = new ArrayList<>();
        HashSet<String> been = new HashSet<>();
        HashMap<String, ArrayList<String>> groups = new HashMap<>();

        int count = 0;
        while (s.hasNext()) {
            String line = s.nextLine();
            grid.add(new ArrayList<>());

            for (int i = 0; i < line.length(); i++) {
                grid.get(count).add(line.substring(i, i + 1));
            }
            count++;
        }

        count = 1;
        for (int row = 0; row < grid.size(); row++) {
            for (int column = 0; column < grid.get(row).size(); column++) {
                if (!been.contains(row + "," + column)) {
                    String keyName = "region" + count;
                    count++;
                    ArrayList<String> grouping = new ArrayList<>();
                    findGroup(grouping, grid, row + "," + column, been);
                    groups.put(keyName, grouping);
                }
            }
        }
//        System.out.println(been);
//        System.out.println(groups);
        int total = 0;
//        for (String key: groups.keySet()) {
//            int perimeter = 0;
//            for (String value: groups.get(key)) {
//                int row = Integer.parseInt(value.substring(0, value.indexOf(",")));
//                int column = Integer.parseInt(value.substring(value.indexOf(",") + 1));
//                String letter = grid.get(row).get(column);
//                try {
//                    //up
//                    if (!grid.get(row - 1).get(column).equals(letter)) {
//                        perimeter++;
//                    }
//                } catch (IndexOutOfBoundsException e) {
//                    perimeter++;
//                }
//                try {
//                    //right
//                    if (!grid.get(row).get(column + 1).equals(letter)) {
//                        perimeter++;
//                    }
//                } catch (IndexOutOfBoundsException e) {
//                    perimeter++;
//                }
//                try {
//                    //down
//                    if (!grid.get(row + 1).get(column).equals(letter)) {
//                        perimeter++;
//                    }
//                } catch (IndexOutOfBoundsException e) {
//                    perimeter++;
//                }
//                try {
//                    //left
//                    if (!grid.get(row).get(column - 1).equals(letter)) {
//                        perimeter++;
//                    }
//                } catch (IndexOutOfBoundsException e) {
//                    perimeter++;
//                }
//            }
//            total += groups.get(key).size() * perimeter;
//        }


        HashSet<String> taken = new HashSet<>();
        for (String key: groups.keySet()) {
            int sides = 0;
            taken.clear();
            for (String value: groups.get(key)) {
                int row = Integer.parseInt(value.substring(0, value.indexOf(",")));
                int column = Integer.parseInt(value.substring(value.indexOf(",") + 1));
                String letter = grid.get(row).get(column);
                try {
                    //up
                    if (!grid.get(row - 1).get(column).equals(letter)) {
                        if (!taken.contains(row + "," + column + "top")) {
                            System.out.println(value + " up1");
                            sides++;
                            taken.add(row + "," + column + "top");
                            int tempColumn = column;
                            while (tempColumn >= 0) {
                                if (!grid.get(row - 1).get(tempColumn).equals(letter) && grid.get(row).get(tempColumn).equals(letter)) {
                                    taken.add(row + "," + tempColumn + "top");
                                }
                                else {
                                    break;
                                }
                                tempColumn--;
                            }
                            tempColumn = column;
                            while (tempColumn < grid.get(0).size()) {
                                if (!grid.get(row - 1).get(tempColumn).equals(letter) && grid.get(row).get(tempColumn).equals(letter)) {
                                    taken.add(row + "," + tempColumn + "top");
                                }
                                else {
                                    break;
                                }
                                tempColumn++;
                            }
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    if (!taken.contains(row + "," + column + "top")) {
                        System.out.println(value + " up2");
                        sides++;
                        taken.add(row + "," + column + "top");
                        int tempColumn = column;
                        while (tempColumn >= 0) {
                            if (grid.get(row).get(tempColumn).equals(letter)) {
                                taken.add(row + "," + tempColumn + "top");
                            }
                            else {
                                break;
                            }
                            tempColumn--;
                        }
                        tempColumn = column;
                        while (tempColumn < grid.get(0).size()) {
                            if (grid.get(row).get(tempColumn).equals(letter)) {
                                taken.add(row + "," + tempColumn + "top");
                            }
                            else {
                                break;
                            }
                            tempColumn++;
                        }
                    }
                }
                try {
                    //right
                    if (!grid.get(row).get(column + 1).equals(letter)) {
                        if (!taken.contains(row + "," + column + "right")) {
                            System.out.println(value + " right1");

                            sides++;
                            taken.add(row + "," + column + "right");
                            int tempRow = row;
                            while (tempRow >= 0) {
                                if (!grid.get(tempRow).get(column + 1).equals(letter) && grid.get(tempRow).get(column).equals(letter)) {
                                    taken.add(tempRow + "," + column + "right");
                                }
                                else {
                                    break;
                                }
                                tempRow--;
                            }
                            tempRow = row;
                            while (tempRow < grid.size()) {
                                if (!grid.get(tempRow).get(column + 1).equals(letter) && grid.get(tempRow).get(column).equals(letter)) {
                                    taken.add(tempRow + "," + column + "right");
                                }
                                else {
                                    break;
                                }
                                tempRow++;
                            }
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    if (!taken.contains(row + "," + column + "right")) {
                        System.out.println(value + " right2");

                        sides++;
                        taken.add(row + "," + column + "right");
                        int tempRow = row;
                        while (tempRow >= 0) {
                            if (grid.get(tempRow).get(column).equals(letter)) {
                                taken.add(tempRow + "," + column + "right");
                            }
                            else {
                                break;
                            }
                            tempRow--;
                        }
                        tempRow = row;
                        while (tempRow < grid.size()) {
                            if (grid.get(tempRow).get(column).equals(letter)) {
                                taken.add(tempRow + "," + column + "right");
                            }
                            else {
                                break;
                            }
                            tempRow++;
                        }
                    }
                }
                try {
                    //down
                    if (!grid.get(row + 1).get(column).equals(letter)) {
                        if (!taken.contains(row + "," + column + "bottom")) {
                            System.out.println(value + " down1");

                            sides++;
                            taken.add(row + "," + column + "bottom");
                            int tempColumn = column;
                            while (tempColumn >= 0) {
                                if (!grid.get(row + 1).get(tempColumn).equals(letter) && grid.get(row).get(tempColumn).equals(letter)) {
                                    taken.add(row + "," + tempColumn + "bottom");
                                }
                                else {
                                    break;
                                }
                                tempColumn--;
                            }
                            tempColumn = column;
                            while (tempColumn < grid.get(0).size()) {
                                if (!grid.get(row + 1).get(tempColumn).equals(letter) && grid.get(row).get(tempColumn).equals(letter)) {
                                    taken.add(row + "," + tempColumn + "bottom");
                                }
                                else {
                                    break;
                                }
                                tempColumn++;
                            }
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    if (!taken.contains(row + "," + column + "bottom")) {
                        System.out.println(value + " down2");

                        sides++;
                        taken.add(row + "," + column + "bottom");
                        int tempColumn = column;
                        while (tempColumn >= 0) {
                            if (grid.get(row).get(tempColumn).equals(letter)) {
                                taken.add(row + "," + tempColumn + "bottom");
                            }
                            else {
                                break;
                            }
                            tempColumn--;
                        }
                        tempColumn = column;
                        while (tempColumn < grid.get(0).size()) {
                            if (grid.get(row).get(tempColumn).equals(letter)) {
                                taken.add(row + "," + tempColumn + "bottom");
                            }
                            else {
                                break;
                            }
                            tempColumn++;
                        }
                    }
                }
                try {
                    //left
                    if (!grid.get(row).get(column - 1).equals(letter)) {
                        if (!taken.contains(row + "," + column + "left")) {
                            System.out.println(value + " left1");

                            sides++;
                            taken.add(row + "," + column + "left");
                            int tempRow = row;
                            while (tempRow >= 0) {
                                if (!grid.get(tempRow).get(column - 1).equals(letter) && grid.get(tempRow).get(column).equals(letter)) {
                                    taken.add(tempRow + "," + column + "left");
                                }
                                else {
                                    break;
                                }
                                tempRow--;
                            }
                            tempRow = row;
                            while (tempRow < grid.size()) {
                                if (!grid.get(tempRow).get(column - 1).equals(letter) && grid.get(tempRow).get(column).equals(letter)) {
                                    taken.add(tempRow + "," + column + "left");
                                }
                                else {
                                    break;
                                }
                                tempRow++;
                            }
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    if (!taken.contains(row + "," + column + "left")) {
                        System.out.println(value + " left2");

                        sides++;
                        taken.add(row + "," + column + "left");
                        int tempRow = row;
                        while (tempRow >= 0) {
                            if (grid.get(tempRow).get(column).equals(letter)) {
                                taken.add(tempRow + "," + column + "left");
                            }
                            else {
                                break;
                            }
                            tempRow--;
                        }
                        tempRow = row;
                        while (tempRow < grid.size()) {
                            if (grid.get(tempRow).get(column).equals(letter)) {
                                taken.add(tempRow + "," + column + "left");
                            }
                            else {
                                break;
                            }
                            tempRow++;
                        }
                    }
                }
            }
            System.out.println(groups.get(key));
            System.out.println(sides);
            total += groups.get(key).size() * sides;
        }
        System.out.println(total);
    }

    private static void findGroup(ArrayList<String> grouping, ArrayList<ArrayList<String>> grid, String start, HashSet<String> been) {
        int startRow = Integer.parseInt(start.substring(0, start.indexOf(",")));
        int startColumn = Integer.parseInt(start.substring(start.indexOf(",") + 1));
        String letter = grid.get(startRow).get(startColumn);
        been.add(start);
        grouping.add(start);
        try {
            //up
            if (grid.get(startRow - 1).get(startColumn).equals(letter) && !grouping.contains((startRow - 1) + "," + startColumn)) {
                findGroup(grouping, grid, (startRow - 1) + "," + startColumn, been);
            }
        } catch (IndexOutOfBoundsException e) {}
        try {
            //right
            if (grid.get(startRow).get(startColumn + 1).equals(letter) && !grouping.contains((startRow) + "," + (startColumn + 1))) {
                findGroup(grouping, grid, (startRow) + "," + (startColumn + 1), been);
            }
        } catch (IndexOutOfBoundsException e) {}
        try {
            //down
            if (grid.get(startRow + 1).get(startColumn).equals(letter) && !grouping.contains((startRow + 1) + "," + startColumn)) {
                findGroup(grouping, grid, (startRow + 1) + "," + startColumn, been);
            }
        } catch (IndexOutOfBoundsException e) {}
        try {
            //left
            if (grid.get(startRow).get(startColumn - 1).equals(letter) && !grouping.contains((startRow) + "," + (startColumn - 1))) {
                findGroup(grouping, grid, (startRow) + "," + (startColumn - 1), been);
            }
        } catch (IndexOutOfBoundsException e) {}
    }
}
