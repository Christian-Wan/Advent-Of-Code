public class Year23_Day23_Object {

    private int x, y, oldX, oldY, length, skipping;
    private boolean up, down, left, right = false;
    private boolean original;
    private String[][] test;

    public Year23_Day23_Object(String[][] grid) {
        x = 1;
        y = 1;
        oldX = 1;
        oldY = 0;
        length = 1;
        skipping = 0;
        original = true;
        test = grid;
    }
    public Year23_Day23_Object(Year23_Day23_Object duplicate) {
        x = duplicate.x;
        y = duplicate.y;
        oldX = duplicate.oldX;
        oldY = duplicate.oldY;
        up = duplicate.up;
        down = duplicate.down;
        left = duplicate.left;
        right = duplicate.right;
        length = duplicate.length;
        skipping = duplicate.skipping - 1;
        original = false;
        test = duplicate.test;
    }

    public int lookAround(String[][] grid) {
        int count = 0;
        if (grid[y][x + 1].equals(".") || grid[y][x + 1].equals(">")) {
            if (!(y == oldY && x + 1 == oldX)) {
                right = true;
                count++;
            }
        }
        if (grid[y][x - 1].equals(".") || grid[y][x - 1].equals("<")) {
            if (!(y == oldY && x - 1 == oldX)) {
                left = true;
                count++;
            }
        }
        try {
            if (grid[y + 1][x].equals(".") || grid[y + 1][x].equals("v")) {
                if (!(y + 1 == oldY && x == oldX)) {
                    down = true;
                    count++;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
            if (grid[y - 1][x].equals(".")) {
                if (!(y - 1 == oldY && x == oldX)) {
                    up = true;
                    count++;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {

        }
        skipping = count;
        return count;
    }

    public void move() {
        oldY = y;
        oldX = x;
        int count = 0;
        if (right) {
            count++;
            if (count >= skipping) {
                x++;
            }
        }
        if (left) {
            count++;
            if (count >= skipping) {
                x--;
            }
        }
        if (down) {
            count++;
            if (count >= skipping) {
                y++;
            }
        }
        if (up) {
            count++;
            if (count >= skipping) {
                y--;
            }
        }
        length++;
        original = true;
        up = false;
        right = false;
        left = false;
        down = false;
    }

    public boolean isOriginal() {
        return original;
    }

    public int getLength() {
        return length;
    }

    public String[][] getTest() {
        return test;
    }
}
