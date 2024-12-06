import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Year24_Day06 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("24/6");
        Scanner s = new Scanner(f);

        int size = 130;
        String[][] grid = new String[size][size];
        Set<String> been = new HashSet<>();
        int guardR = 0;
        int guardC = 0;
        int guardRStart = 0;
        int guardCRStart = 0;
        int count = 0;
        String direction = "up";

        while (s.hasNext()) {
            String line = s.nextLine();
            for (int i = 0; i < line.length(); i++) {
                if (line.substring(i, i + 1).equals("^")) {
                    guardR = count;
                    guardC = i;
                    guardRStart = count;
                    guardCRStart = i;
                }
                grid[count][i] = line.substring(i, i + 1);
            }
            count++;
        }


        while (true) {
            if (direction.equals("up")) {
                if (guardR == 0) {
                    break;
                }
                else if (grid[guardR - 1][guardC].equals("#")) {
                    direction = "right";
                }
                else {
                    been.add(guardR + "," + guardC);
                    guardR--;
                }
            }
            if (direction.equals("right")) {
                if (guardC == size - 1) {
                    break;
                }
                else if (grid[guardR][guardC + 1].equals("#")) {
                    direction = "down";
                }
                else {
                    been.add(guardR + "," + guardC);
                    guardC++;
                }
            }
            if (direction.equals("down")) {
                if (guardR == size - 1) {
                    break;
                }
                else if (grid[guardR + 1][guardC].equals("#")) {
                    direction = "left";
                }
                else {
                    been.add(guardR + "," + guardC);
                    guardR++;
                }
            }
            if (direction.equals("left")) {
                if (guardC == 0) {
                    break;
                }
                else if (grid[guardR][guardC - 1].equals("#")) {
                    direction = "up";
                }
                else {
                    been.add(guardR + "," + guardC);
                    guardC--;
                }
            }
        }
        been.add(guardR + "," + guardC);
        System.out.println(been.size());







        int total = 0;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (grid[r][c].equals(".")) {
                    grid[r][c] = "#";
                    been.clear();
//                    System.out.println("--------------------------------");
//                    for (int i = 0; i < size; i++) {
//                        for (int x = 0; x < size; x++) {
//                            System.out.print(grid[i][x]);
//                        }
//                        System.out.println();
//                    }
                    while (true) {
                        if (direction.equals("up")) {
                            if (guardR == 0) {
                                break;
                            } else if (grid[guardR - 1][guardC].equals("#")) {
                                direction = "right";
                            } else {
                                if (been.contains(guardR + "," + guardC + "up")) {
                                    total++;
//                                    System.out.println(r + "," + c);
                                    break;
                                }
                                been.add(guardR + "," + guardC + "up");
                                guardR--;
                            }
                        } else if (direction.equals("right")) {
                            if (guardC == size - 1) {
                                break;
                            } else if (grid[guardR][guardC + 1].equals("#")) {
                                direction = "down";
                            } else {
                                if (been.contains(guardR + "," + guardC + "right")) {
                                    total++;
//                                    System.out.println(r + "," + c);
                                    break;
                                }
                                been.add(guardR + "," + guardC + "right");
                                guardC++;
                            }
                        } else if (direction.equals("down")) {
                            if (guardR == size - 1) {
                                break;
                            } else if (grid[guardR + 1][guardC].equals("#")) {
                                direction = "left";
                            } else {
                                if (been.contains(guardR + "," + guardC + "down")) {
                                    total++;
//                                    System.out.println(r + "," + c);
                                    break;
                                }
                                been.add(guardR + "," + guardC + "down");
                                guardR++;
                            }
                        } else {
                            if (guardC == 0) {
                                break;
                            } else if (grid[guardR][guardC - 1].equals("#")) {
                                direction = "up";
                            } else {
                                if (been.contains(guardR + "," + guardC + "left")) {
                                    total++;
//                                    System.out.println(r + "," + c);
                                    break;
                                }
                                been.add(guardR + "," + guardC + "left");
                                guardC--;
                            }
                        }
                    }
                    grid[r][c] = ".";
                    guardR = guardRStart;
                    guardC = guardCRStart;
                    direction = "up";
                }
            }
        }
        System.out.println(total);
    }

    //144
}
