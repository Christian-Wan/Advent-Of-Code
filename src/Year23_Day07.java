import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Year23_Day07 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("23/7");
        Scanner s = new Scanner(f);
        ArrayList<Year23_Day07_Object> hands = new ArrayList<>();
        int total = 0;
        while (s.hasNext()) {
            String line = s.nextLine();
            hands.add(new Year23_Day07_Object(line.substring(0, 5), Integer.parseInt(line.substring(6))));
        }
        for (int i = 0; i < hands.size() - 1; i++) {
            Year23_Day07_Object storage = null;
            if (!Year23_Day07_Object.firstBeatsSecond(hands.get(i), hands.get(i + 1))) {
                storage = hands.get(i);
                hands.set(i, hands.get(i + 1));
                hands.set(i + 1, storage);
                i = -1;
            }
        }
        int index = 0;
        for (int i = hands.size(); i > 0; i--) {
            total += hands.get(index).getBid() * i;
            index++;
        }
        System.out.println(total);
    }
}
