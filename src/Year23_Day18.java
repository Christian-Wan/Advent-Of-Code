import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Year23_Day18 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("23/18");
        Scanner s = new Scanner(f);
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        ArrayList<String> hexadecimal = new ArrayList<>();
        String BLUE = "\u001B[44m";
        String RED = "\u001B[41m";
        String RESET = "\u001B[0m";

        ArrayList<String> directions = new ArrayList<>();
        while (s.hasNext()) {
            String line = s.nextLine();
            directions.add(line.substring(0, line.indexOf("(") - 1));
            hexadecimal.add(line.substring(line.indexOf("(") + 2, line.length() - 1));
        }
        for (int i = 0; i < hexadecimal.size(); i++) {
            String newDirections = hexadecimal.get(i).substring(hexadecimal.get(i).length() - 1) + " " + Integer.toString(Integer.parseInt(hexadecimal.get(i).substring(0, hexadecimal.get(i).length() - 1), 16));
            directions.set(i, newDirections);
        }
        System.out.println(hexadecimal);
        System.out.println(directions);
        grid.add(new ArrayList<>());
        grid.get(0).add(1);
        int x = 0;
        int y = 0;
        int oldX = 0;
        int oldY = 0;
        long total = 0;
        boolean topLeft = true;
        boolean topRight = false;
        boolean bottomRight = false;
        boolean bottomLeft = false;
        for (int i = 0; i < directions.size(); i++) {
            System.out.println(directions.get(i));
            if (topRight) {
                System.out.println("topRight");
            }
            if (topLeft) {
                System.out.println("topLeft");
            }
            if (bottomRight) {
                System.out.println("bottomRight");
            }
            if (bottomLeft) {
                System.out.println("bottomLeft");
            }
            int moveBy = Integer.parseInt(directions.get(i).substring(2)) + 1;
            if (directions.get(i).charAt(0) == '0') {
                if (topRight || bottomRight) {
                    moveBy -= 1;
                }
                if (topRight || topLeft) {
                    topRight = true;
                    bottomRight = false;
                    bottomLeft = false;
                    topLeft = false;
                }
                else {
                    bottomRight = true;
                    topRight = false;
                    bottomLeft = false;
                    topLeft = false;
                }
                try {
                    if (directions.get(i + 1).charAt(0) == '3') {
                        if (topRight) {
                            moveBy -= 1;
                            topRight = false;
                            topLeft = true;
                        }
                    }
                    if (directions.get(i + 1).charAt(0) == '1') {
                        if (bottomRight) {
                            moveBy -= 1;
                            bottomRight = false;
                            bottomLeft = true;
                        }
                    }
                }
                catch (IndexOutOfBoundsException e) {
                    if (directions.get(0).charAt(0) == '3') {
                        if (topRight) {
                            moveBy -= 1;
                            topRight = false;
                            topLeft = true;
                        }
                    }
                    if (directions.get(0).charAt(0) == '1') {
                        if (bottomRight) {
                            moveBy -= 1;
                            bottomRight = false;
                            bottomLeft = true;
                        }
                    }
                }
                x += moveBy;
            }
            else if (directions.get(i).charAt(0) == '2') {
                if (topLeft || bottomLeft) {
                    moveBy -= 1;
                }
                if (topRight || topLeft) {
                    topRight = false;
                    bottomRight = false;
                    bottomLeft = false;
                    topLeft = true;
                }
                else {
                    bottomRight = false;
                    topRight = false;
                    bottomLeft = true;
                    topLeft = false;
                }
                try {
                    if (directions.get(i + 1).charAt(0) == '3') {
                        if (topLeft) {
                            moveBy -= 1;
                            topRight = true;
                            topLeft = false;
                        }
                    }
                    if (directions.get(i + 1).charAt(0) == '1') {
                        if (bottomLeft) {
                            moveBy -= 1;
                            bottomRight = true;
                            bottomLeft = false;
                        }
                    }
                }
                catch (IndexOutOfBoundsException e) {
                    if (directions.get(0).charAt(0) == '3') {
                        if (topLeft) {
                            moveBy -= 1;
                            topRight = true;
                            topLeft = false;
                        }
                    }
                    if (directions.get(0).charAt(0) == '1') {
                        if (bottomLeft) {
                            moveBy -= 1;
                            bottomRight = true;
                            bottomLeft = false;
                        }
                    }
                }
                x -= moveBy;
            }
            else if (directions.get(i).charAt(0) == '3') {
                if (topRight || topLeft) {
                    moveBy -= 1;
                }

                if (topRight || bottomRight) {
                    topRight = true;
                    bottomRight = false;
                    bottomLeft = false;
                    topLeft = false;
                }
                else {
                    bottomRight = false;
                    topRight = false;
                    bottomLeft = false;
                    topLeft = true;
                }
                try {
                    if (directions.get(i + 1).charAt(0) == '0') {
                        if (topRight) {
                            moveBy -= 1;
                            bottomRight = true;
                            topRight = false;
                        }
                    }
                    if (directions.get(i + 1).charAt(0) == '2') {
                        if (topLeft) {
                            moveBy -= 1;
                            topLeft = false;
                            bottomLeft = true;
                        }
                    }
                }
                catch (IndexOutOfBoundsException e) {
                    if (directions.get(0).charAt(0) == '0') {
                        if (topRight) {
                            moveBy -= 1;
                            bottomRight = true;
                            topRight = false;
                        }
                    }
                    if (directions.get(0).charAt(0) == '2') {
                        if (topLeft) {
                            moveBy -= 1;
                            topLeft = false;
                            bottomLeft = true;
                        }
                    }
                }
                y += moveBy;

            }
            else if (directions.get(i).charAt(0) == '1') {
                if (bottomRight || bottomLeft) {
                    moveBy -= 1;
                }

                if (bottomLeft || topLeft) {
                    topRight = false;
                    bottomRight = false;
                    bottomLeft = true;
                    topLeft = false;
                }
                else {
                    bottomRight = true;
                    topRight = false;
                    bottomLeft = false;
                    topLeft = false;
                }
                try {
                    if (directions.get(i + 1).charAt(0) == '0') {
                        if (bottomRight) {
                            moveBy -= 1;
                            topRight = true;
                            bottomRight = false;
                        }
                    }
                    if (directions.get(i + 1).charAt(0) == '2') {
                        if (bottomLeft) {
                            moveBy -= 1;
                            topLeft = true;
                            bottomLeft = false;
                        }
                    }
                }
                catch (IndexOutOfBoundsException e) {
                    if (directions.get(0).charAt(0) == '0') {
                        if (bottomRight) {
                            moveBy -= 1;
                            topRight = true;
                            bottomRight = false;
                        }
                    }
                    if (directions.get(0).charAt(0) == '2') {
                        if (bottomLeft) {
                            moveBy -= 1;
                            topLeft = true;
                            bottomLeft = false;
                        }
                    }
                }
                y -= moveBy;
            }
            System.out.println("(" + oldX + ", " + oldY + ")");
            System.out.println("(" + x + ", " + y + ")");
            System.out.println(((long) oldX * y) - ((long) x * oldY));
            total += ((long) oldX * y) - ((long) x * oldY);
            oldX = x;
            oldY = y;
        }
        total = Math.abs(total);
        total /= 2;
        System.out.println(total);
    }
}
