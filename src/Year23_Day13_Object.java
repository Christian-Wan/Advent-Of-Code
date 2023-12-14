import java.util.ArrayList;

public class Year23_Day13_Object {

    private ArrayList<ArrayList<String>> grid, flip;
    private int bad;

    public Year23_Day13_Object(ArrayList<ArrayList<String>> twoDimension) {
        grid = twoDimension;
        flip = findFlip();
        bad = findMirror();
    }

    public ArrayList<ArrayList<String>> getGrid() {
        return grid;
    }

    public int specialFindMirror() {
        for (int a = 0; a < grid.size(); a++) {
            for (int b = 0; b < grid.get(0).size(); b++) {
                if (grid.get(a).get(b).equals("#")) {
                    grid.get(a).set(b, ".");
                } else {
                    grid.get(a).set(b, "#");
                }
                System.out.println(grid);
                for (int i = 0; i < grid.size(); i++) {
                    int max = (i + 1) * 2;
                    int start = i - (grid.size() - i);
                    if (start < 0) {
                        start = 0;
                    }
                    for (int x = start; x <= i; x++) {
                        try {
//                            System.out.println(grid.get(x));
//                            System.out.println("+++++++++++++");
//                            System.out.println(grid.get(max - 1 - x));
//                            System.out.println("888888888888888888888888");
                            if (!grid.get(x).equals(grid.get(max - 1 - x))) {
                                break;
                            }
//                            else {
//                                System.out.println("works");
//                            }
//                            System.out.println("------------------------------");
                        } catch (IndexOutOfBoundsException e) {

                        }
                        if (x == i && (i + 1) * 100 != bad && i != grid.size() - 1) {
                            return (i + 1) * 100;
                        }
                    }
                }
                if (grid.get(a).get(b).equals("#")) {
                    grid.get(a).set(b, ".");
                } else {
                    grid.get(a).set(b, "#");
                }
            }
        }
        for (int a = 0; a < flip.size(); a++) {
            for (int b = 0; b < flip.get(0).size(); b++) {
                if (flip.get(a).get(b).equals("#")) {
                    flip.get(a).set(b, ".");
                } else {
                    flip.get(a).set(b, "#");
                }
                System.out.println(flip);
                for (int i = 0; i < flip.size(); i++) {
                    int max = (i + 1) * 2;
                    int start = i - (flip.size() - i);
                    if (start < 0) {
                        start = 0;
                    }
                    for (int x = start; x <= i; x++) {
                        try {
//                            System.out.println(flip.get(x));
//                            System.out.println("+++++++++++++");
//                            System.out.println(flip.get(max - 1 - x));
//                            System.out.println("888888888888888888888888");
                            if (!flip.get(x).equals(flip.get(max - 1 - x))) {
                                break;
                            }
//                            else {
//                                System.out.println("works");
//                            }
//                            System.out.println("------------------------------");
                        } catch (IndexOutOfBoundsException e) {

                        }
                        if (x == i && i + 1 != bad && i != flip.size() - 1) {
                            return i + 1;
                        }
                    }
                }
                if (flip.get(a).get(b).equals("#")) {
                    flip.get(a).set(b, ".");
                } else {
                    flip.get(a).set(b, "#");
                }
            }
        }
        return 0;
    }

    public int findMirror() {
        for (int i = 0; i < grid.size(); i++) {
            int max = (i + 1) * 2;
            int start = i - (grid.size() - i);
            if (start < 0) {
                start = 0;
            }
            for (int x = start; x <= i; x++) {
                try {
//                    System.out.println(grid.get(x));
//                    System.out.println("+++++++++++++");
//                    System.out.println(grid.get(max - 1 - x));
//                    System.out.println("888888888888888888888888");
                    if (!grid.get(x).equals(grid.get(max - 1 - x))) {
                        break;
                    }
//                    else {
//                        System.out.println("works");
//                    }
//                    System.out.println("------------------------------");
                } catch (IndexOutOfBoundsException e) {

                }

                if (x == i && i != grid.size() - 1) {
                    return (i + 1) * 100;
                }
            }
        }
        for (int i = 0; i < flip.size(); i++) {
            int max = (i + 1) * 2;
            int start = i - (flip.size() - i);
            if (start < 0) {
                start = 0;
            }
            for (int x = start; x <= i; x++) {
                try {
//                    System.out.println(flip.get(x));
//                    System.out.println("+++++++++++++");
//                    System.out.println(flip.get(max - 1 - x));
//                    System.out.println("888888888888888888888888");
                    if (!flip.get(x).equals(flip.get(max - 1 - x))) {
                        break;
                    }
//                    else {
//                        System.out.println("works");
//                    }
//                    System.out.println("------------------------------");
                } catch (IndexOutOfBoundsException e) {

                }
                if (x == i && i != flip.size() - 1) {
                    return i + 1;
                }
            }
        }
        return 0;
    }

    public ArrayList<ArrayList<String>> findFlip() {
        ArrayList<ArrayList<String>> flipped = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
//        System.out.println(grid.size());
        for (int i = 0; i < grid.get(0).size(); i++) {
            temp = new ArrayList<>();
            for (int x = grid.size() - 1; x >= 0; x--) {
                temp.add(grid.get(x).get(i));
            }
            flipped.add(temp);
        }
        return flipped;
    }

    public ArrayList<ArrayList<String>> getFlip() {
        return flip;
    }

    public int getBad() {
        return bad;
    }
}
