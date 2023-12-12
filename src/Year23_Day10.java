import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Year23_Day10 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("23/10");
        Scanner s = new Scanner(f);
        String[][] grid = new String[9][10];
        String[] info = new String[4];
        int[][] pipe = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int x = 0; x < grid[0].length; x++) {
                pipe[i][x] = 0;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            String line = s.nextLine();
            for (int x = 0; x < grid[0].length; x++) {
                grid[i][x] = line.substring(x, x + 1);
                if (grid[i][x].equals("S")) {
                    info[0] = Integer.toString(x);
                    info[1] = Integer.toString(i);
                }
            }
        }
        pipe[Integer.parseInt(info[1])][Integer.parseInt(info[0])] = 1;
        info[2] = "";
        info[3] = "Yes";
        try {
            if ((grid[Integer.parseInt(info[1]) - 1][Integer.parseInt(info[0])].equals("7") || grid[Integer.parseInt(info[1]) - 1][Integer.parseInt(info[0])].equals("|") || grid[Integer.parseInt(info[1]) - 1][Integer.parseInt(info[0])].equals("F")) && !info[2].equals("North")) {
                System.out.println("North");
                info[2] = "South";
                info[1] = Integer.toString(Integer.parseInt(info[1]) - 1);
                info[3] = "No";
                System.out.println(grid[Integer.parseInt(info[1])][Integer.parseInt(info[0])]);
                System.out.println("---------------------------");
                
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
            if ((grid[Integer.parseInt(info[1])][Integer.parseInt(info[0]) + 1].equals("7") || grid[Integer.parseInt(info[1])][Integer.parseInt(info[0]) + 1].equals("-") || grid[Integer.parseInt(info[1])][Integer.parseInt(info[0]) + 1].equals("J")) && !info[2].equals("East") && info[3].equals("Yes")) {
                System.out.println("East");
                info[2] = "West";
                info[0] = Integer.toString(Integer.parseInt(info[0]) + 1);
                info[3] = "No";
                System.out.println(grid[Integer.parseInt(info[1])][Integer.parseInt(info[0])]);
                System.out.println("---------------------------");
                
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
            if ((grid[Integer.parseInt(info[1]) + 1][Integer.parseInt(info[0])].equals("L") || grid[Integer.parseInt(info[1]) + 1][Integer.parseInt(info[0])].equals("|") || grid[Integer.parseInt(info[1]) + 1][Integer.parseInt(info[0])].equals("J")) && !info[2].equals("South") && info[3].equals("Yes")) {
                System.out.println("South");
                info[2] = "North";
                info[1] = Integer.toString(Integer.parseInt(info[1]) + 1);
                info[3] = "No";
                System.out.println(grid[Integer.parseInt(info[1])][Integer.parseInt(info[0])]);
                System.out.println("---------------------------");
                
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
            if ((grid[Integer.parseInt(info[1])][Integer.parseInt(info[0]) - 1].equals("L") || grid[Integer.parseInt(info[1])][Integer.parseInt(info[0]) - 1].equals("-") || grid[Integer.parseInt(info[1])][Integer.parseInt(info[0]) - 1].equals("F")) && !info[2].equals("West") && info[3].equals("Yes")) {
                System.out.println("West");
                info[2] = "East";
                info[0] = Integer.toString(Integer.parseInt(info[0]) - 1);
                info[3] = "No";
                System.out.println(grid[Integer.parseInt(info[1])][Integer.parseInt(info[0])]);
                System.out.println("---------------------------");
                
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {

        }
        pipe[Integer.parseInt(info[1])][Integer.parseInt(info[0])] = 1;

        int count = 1;

        while (!info[2].equals("Done")) {
            info = movement(grid, info);
            count++;
            System.out.println(count);
            pipe[Integer.parseInt(info[1])][Integer.parseInt(info[0])] = 1;
        }
        System.out.println("ans: " + count / 2);
//------------------------------------------------------------------------------------------------------
        count = 0;
        for (int i = 0; i < pipe.length; i++) {
            if (pipe[i][0] != 1) {
                pipe[i][0] = 9;
            }
            if (pipe[i][pipe[0].length - 1] != 1) {
                pipe[i][pipe[0].length - 1] = 9;
            }
        }
        for (int i = 0; i < pipe[0].length; i++) {
            if (pipe[0][i] != 1) {
                pipe[0][i] = 9;
            }
            if (pipe[pipe.length - 1][i] != 1) {
                pipe[pipe.length - 1][i] = 9;
            }
        }
        for (int i = 0; i < pipe.length; i++) {
            for (int x = 0; x < pipe[0].length; x++) {
                System.out.print(pipe[i][x]);
            }
            System.out.println();
        }
        System.out.println();

        int[][] oldPipes = new int[pipe.length][pipe[0].length];
        while (!Arrays.deepEquals(oldPipes, pipe)) {
            for (int i = 0; i < pipe.length; i++) {
                for (int x = 0; x < pipe[0].length; x++) {
                    oldPipes[i][x] = pipe[i][x];
                }
            }

            for (int i = 0; i < pipe.length; i++) {
                for (int x = 0; x < pipe[0].length; x++) {
                    if (pipe[i][x] != 1) {
                        try {
                            if (pipe[i + 1][x] == 9) {
                                pipe[i][x] = 9;
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {

                        }
                        try {
                            if (pipe[i - 1][x] == 9) {
                                pipe[i][x] = 9;
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {

                        }
                        try {
                            if (pipe[i][x + 1] == 9) {
                                pipe[i][x] = 9;
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {

                        }
                        try {
                            if (pipe[i][x - 1] == 9) {
                                pipe[i][x] = 9;
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {

                        }
                    }
                }
            }
        }
//        System.out.println();
//        for (int i = 0; i < pipe.length; i++) {
//            for (int x = 0; x < pipe[0].length; x++) {
//                System.out.print(pipe[i][x]);
//            }
//            System.out.println();
//        }
//        pipe = check(pipe, grid);
//        oldPipes = new int[pipe.length][pipe[0].length];
//        while (!Arrays.deepEquals(oldPipes, pipe)) {
//            for (int i = 0; i < pipe.length; i++) {
//                for (int x = 0; x < pipe[0].length; x++) {
//                    oldPipes[i][x] = pipe[i][x];
//                }
//            }
//
//            for (int i = 0; i < pipe.length; i++) {
//                for (int x = 0; x < pipe[0].length; x++) {
//                    if (pipe[i][x] != 1) {
//                        try {
//                            if (pipe[i + 1][x] == 9) {
//                                pipe[i][x] = 9;
//                            }
//                        } catch (ArrayIndexOutOfBoundsException e) {
//
//                        }
//                        try {
//                            if (pipe[i - 1][x] == 9) {
//                                pipe[i][x] = 9;
//                            }
//                        } catch (ArrayIndexOutOfBoundsException e) {
//
//                        }
//                        try {
//                            if (pipe[i][x + 1] == 9) {
//                                pipe[i][x] = 9;
//                            }
//                        } catch (ArrayIndexOutOfBoundsException e) {
//
//                        }
//                        try {
//                            if (pipe[i][x - 1] == 9) {
//                                pipe[i][x] = 9;
//                            }
//                        } catch (ArrayIndexOutOfBoundsException e) {
//
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println();
//        for (int i = 0; i < pipe.length; i++) {
//            for (int x = 0; x < pipe[0].length; x++) {
//                System.out.print(pipe[i][x]);
//            }
//            System.out.println();
//        }
        String noWork = "|| |L |F J| 7| JL JF 7F 7L |S S| SL SF JS 7S";
        for (int i = 0; i < pipe.length; i++) {
            int indexOfLast = 0;
            int indexOfFirst = 0;
            for (int x = pipe[0].length - 1; x >= 0; x--) {
                if (pipe[i][x] == 1) {
                    indexOfLast = x;
                    break;
                }
            }
            for (int x = 0; x < pipe[0].length; x++) {
                if (pipe[i][x] == 1) {
                    indexOfFirst = x;
                    break;
                }
            }
            for (int x = 0; x < pipe[0].length; x++) {
                int intersections = 0;
                boolean stillLine = false;
                for (int a = x; a < pipe[0].length - 1; a++) {
                    if (pipe[i][x] == 0) {

                        if (pipe[i][a - 1] == 1 && (pipe[i][a] + pipe[i][a + 1] == 2 && noWork.contains(grid[i][a] + grid[i][a + 1]))) {
                            intersections += 2;
                            a += 2;
//                            if (stillLine) {
//                                intersections -= 1;
//                            }
                        }
                        else if ((pipe[i][a] + pipe[i][a + 1] == 1 || pipe[i][a] + pipe[i][a + 1] == 10)) {
                            intersections++;
                            if (a == indexOfLast && stillLine) {
                                System.out.println("ASD");
                                intersections--;
                            }

                            stillLine = true;
                        }
                        try {
                            if (pipe[i][a] == 0 || pipe[i][a] == 9) {
                                stillLine = false;
                            }
                        }
                        catch (ArrayIndexOutOfBoundsException e) {

                        }
                    }
                }
                if (intersections != 0) {
                    System.out.println(intersections);
                }
                if (intersections % 2 == 1) {
                    pipe[i][x] = 5;
                }
            }
        }
//        oldPipes = new int[pipe.length][pipe[0].length];
//        while (!Arrays.deepEquals(oldPipes, pipe)) {
//            for (int i = 0; i < pipe.length; i++) {
//                for (int x = 0; x < pipe[0].length; x++) {
//                    oldPipes[i][x] = pipe[i][x];
//                }
//            }
//
//            for (int i = 0; i < pipe.length; i++) {
//                for (int x = 0; x < pipe[0].length; x++) {
//                    if (pipe[i][x] != 1) {
//                        try {
//                            if (pipe[i + 1][x] == 5) {
//                                pipe[i][x] = 5;
//                            }
//                        } catch (ArrayIndexOutOfBoundsException e) {
//
//                        }
//                        try {
//                            if (pipe[i - 1][x] == 5) {
//                                pipe[i][x] = 5;
//                            }
//                        } catch (ArrayIndexOutOfBoundsException e) {
//
//                        }
//                        try {
//                            if (pipe[i][x + 1] == 5) {
//                                pipe[i][x] = 5;
//                            }
//                        } catch (ArrayIndexOutOfBoundsException e) {
//
//                        }
//                        try {
//                            if (pipe[i][x - 1] == 5) {
//                                pipe[i][x] = 5;
//                            }
//                        } catch (ArrayIndexOutOfBoundsException e) {
//
//                        }
//                    }
//                }
//            }
//        }
        for (int i = 0; i < pipe.length; i++) {
            for (int x = 0; x < pipe[0].length; x++) {
                System.out.print(pipe[i][x]);
                if (pipe[i][x] == 5) {
                    count++;
                }
            }
            System.out.println("  Line " + (i + 1));
        }
//        System.out.println();
//        for (int i = 0; i < 140; i++) {
//            System.out.print(pipe[62][i]);
//        }
//        System.out.println();
//        for (int i = 0; i < 140; i++) {
//            System.out.print(grid[62][i]);
//        }
        System.out.println();
        System.out.println("ans: " + count);
    }
//------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static String[] movement(String[][] grid, String[] info) {
        int x = Integer.parseInt(info[0]);
        int y = Integer.parseInt(info[1]);
        String been = info[2];
        System.out.println(grid[y][x]);
        if (grid[y][x].equals("S") && !info[3].equals("Yes")) {
            been = "Done";
            String[] result = {Integer.toString(x), Integer.toString(y), been, info[3]};
            return result;
        }
        else {
            try {
                if (grid[y][x].equals("|")) {

                    if (been.equals("South")) {
                        y--;
                        been = "South";
                    }
                    else {
                        y++;
                        been = "North";
                    }
                    info[3] = "No";
                    String[] result = {Integer.toString(x), Integer.toString(y), been, info[3]};
                    System.out.println(grid[y][x]);
                    System.out.println("---------------------------");
                    return result;
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {

            }
            try {
                if (grid[y][x].equals("-")) {

                    if (been.equals("West")) {
                        x++;
                        been = "West";
                    }
                    else {
                        x--;
                        been = "East";
                    }
                    info[3] = "No";
                    String[] result = {Integer.toString(x), Integer.toString(y), been, info[3]};
                    System.out.println(grid[y][x]);
                    System.out.println("---------------------------");
                    return result;
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {

            }
            try {
                if (grid[y][x].equals("L")) {

                    if (been.equals("East")) {
                        y--;
                        been = "South";
                    }
                    else {
                        x++;
                        been = "West";
                    }
                    info[3] = "No";
                    String[] result = {Integer.toString(x), Integer.toString(y), been, info[3]};
                    System.out.println(grid[y][x]);
                    System.out.println("---------------------------");
                    return result;
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {

            }
            try {
                if (grid[y][x].equals("J")) {

                    if (been.equals("North")) {
                        x--;
                        been = "East";
                    }
                    else {
                        y--;
                        been = "South";
                    }
                    info[3] = "No";
                    String[] result = {Integer.toString(x), Integer.toString(y), been, info[3]};
                    System.out.println(grid[y][x]);
                    System.out.println("---------------------------");
                    return result;
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {

            }
            try {
                if (grid[y][x].equals("7")) {

                    if (been.equals("West")) {
                        y++;
                        been = "North";
                    }
                    else {
                        x--;
                        been = "East";
                    }
                    info[3] = "No";
                    String[] result = {Integer.toString(x), Integer.toString(y), been, info[3]};
                    System.out.println(grid[y][x]);
                    System.out.println("---------------------------");
                    return result;
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {

            }
            try {
                if (grid[y][x].equals("F")) {

                    if (been.equals("South")) {
                        x++;
                        been = "West";
                    }
                    else {
                        y++;
                        been = "North";
                    }
                    info[3] = "No";
                    String[] result = {Integer.toString(x), Integer.toString(y), been, info[3]};
                    System.out.println(grid[y][x]);
                    System.out.println("---------------------------");
                    return result;
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {

            }
        }
        String[] filler = {};
        return filler;
    }

//    public static int[][] check(int[][] pipe, String[][] grid) {
//        ArrayList<String> acceptableHorizontal = new ArrayList<>();
//        acceptableHorizontal.add("--");
//        acceptableHorizontal.add("L-");
//        acceptableHorizontal.add("-J");
//        acceptableHorizontal.add("-7");
//        acceptableHorizontal.add("F-");
////        acceptableHorizontal.add("S-");
////        acceptableHorizontal.add("-S");
////        acceptableHorizontal.add("LS");
////        acceptableHorizontal.add("S7");
////        acceptableHorizontal.add("SJ");
////        acceptableHorizontal.add("FS");
//        acceptableHorizontal.add("LJ");
//        acceptableHorizontal.add("L7");
//        acceptableHorizontal.add("FJ");
//        acceptableHorizontal.add("F7");
//        ArrayList<String> acceptableVertical = new ArrayList<>();
//        acceptableVertical.add("||");
//        acceptableVertical.add("|L");
//        acceptableVertical.add("|J");
//        acceptableVertical.add("7|");
//        acceptableVertical.add("F|");
////        acceptableVertical.add("S|");
////        acceptableVertical.add("|S");
////        acceptableVertical.add("SL");
////        acceptableVertical.add("7S");
////        acceptableVertical.add("SJ");
////        acceptableVertical.add("FS");
//        acceptableVertical.add("7L");
//        acceptableVertical.add("7J");
//        acceptableVertical.add("FJ");
//        acceptableVertical.add("FL");
//        for (int i = 0; i < pipe.length; i++) {
//            for (int x = 0; x < pipe[0].length; x++) {
//                boolean top1 = false;
//                boolean top2 = false;
//                boolean bot1 = false;
//                boolean bot2 = false;
//                boolean l1 = false;
//                boolean l2 = false;
//                boolean r1 = false;
//                boolean r2 = false;
//                if (pipe[i][x] == 0) {
//                    System.out.println(pipe[i][x]);
//                    for (int a = i; a < pipe.length; a++) {
//                        if (pipe[a][x - 1] == 1 && pipe[a][x] == 1 && acceptableHorizontal.contains(grid[a][x - 1] + grid[a][x])) {
//                            bot1 = true;
//                        }
//                        if (pipe[a][x] == 1 && pipe[a][x + 1] == 1 && acceptableHorizontal.contains(grid[a][x] + grid[a][x + 1])) {
//                            bot2 = true;
//                        }
//                    }
//                    for (int a = i; a >= 0; a--) {
//                        if (pipe[a][x - 1] == 1 && pipe[a][x] == 1 && acceptableHorizontal.contains(grid[a][x - 1] + grid[a][x])) {
//                            top1 = true;
//                        }
//                        if (pipe[a][x] == 1 && pipe[a][x + 1] == 1 && acceptableHorizontal.contains(grid[a][x] + grid[a][x + 1])) {
//                            top2 = true;
//                        }
//                    }
//                    for (int a = x; a < pipe[0].length; a++) {
//                        if (pipe[i - 1][a] == 1 && pipe[i][a] == 1 && acceptableVertical.contains(grid[i - 1][a] + grid[i][a])) {
//                            r1 = true;
//                        }
//                        if (pipe[i][a] == 1 && pipe[i + 1][a] == 1 && acceptableVertical.contains(grid[i][a] + grid[i + 1][a])) {
//                            r2 = true;
//                        }
//                    }
//                    for (int a = x; a >= 0; a--) {
//                        if (pipe[i - 1][a] == 1 && pipe[i][a] == 1 && acceptableVertical.contains(grid[i - 1][a] + grid[i][a])) {
//                            l1 = true;
//                        }
//                        if (pipe[i][a] == 1 && pipe[i + 1][a] == 1 && acceptableVertical.contains(grid[i][a] + grid[i + 1][a])) {
//                            l2 = true;
//                        }
//                    }
//                    System.out.println("top1" + top1);
//                    System.out.println("top2" + top2);
//                    System.out.println("bot1" + bot1);
//                    System.out.println("bot2" + bot2);
//                    System.out.println("r1" + r1);
//                    System.out.println("r2" + r2);
//                    System.out.println("l1" + l1);
//                    System.out.println("l2" + l2);
//                    if (!(top1 && top2 && bot1 && bot2 && r1 && r2 && l1 && l2)) {
//                        pipe[i][x] = 9;
//                    }
//                }
//            }
//        }
//        return pipe;
//    }
}
