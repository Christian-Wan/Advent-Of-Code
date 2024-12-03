import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Year24_Day03 {

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("24/3");
        Scanner s = new Scanner(f);

        String valid = "1234567890,)";
        int total = 0;
        boolean last = true;

        while(s.hasNext()) {
            String line = s.nextLine();
            String firstDo = "";
            if (last) {
                firstDo = "do()" + line;
            }
            else {
                firstDo = line;
            }
            while (firstDo.contains("do()")) {
                firstDo = firstDo.substring(firstDo.indexOf("do()") + 4);
//                System.out.println("check) " + firstDo);
                int stop = firstDo.indexOf("don't()");
                String sub = "";
                if (stop != -1) {
                    sub = firstDo.substring(0, stop);
                }
                else {
                    sub = firstDo;
                }
                System.out.println(sub);
                while (sub.contains("mul(")) {
                    sub = sub.substring(sub.indexOf("mul(") + 4);
                    System.out.println("Decreasing) " + sub);
                    boolean works = true;
                    int i = 0;
                    while (true) {
                        if (!valid.contains(sub.substring(i, i + 1))) {
                            works = false;
                            break;
                        } else if (sub.charAt(i) == ')') {
                            break;
                        }
                        i++;
                    }

                    if (works) {
                        System.out.println("adding " + sub.substring(0, i));
                        String check = sub.substring(0, i);
                        String[] numbers = check.split(",");
                        total += Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]);
                    }
                }
                if (stop != -1) {
                    firstDo = firstDo.substring(stop);
                }
                else {
                    break;
                }
                if (!firstDo.contains("do()")) {
                    last = false;
                }
            }
        }
        System.out.println(total);
    }
    //173517243

    //103089406
    //102360389
}
