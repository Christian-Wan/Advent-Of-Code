import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Year15_Day08 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("15/8");
        Scanner s = new Scanner(f);
        int total = 0;
        int stored = 0;
//        while (s.hasNext()) {
//            int subtracting = 2;
//            String line = s.nextLine();
//            total += line.length();
//            for (int i = 0; i < line.length() - 1; i++) {
//                if (line.charAt(i) == '\\') {
//                    if (line.charAt(i + 1) == 'x') {
//                        subtracting += 3;
//                    }
//                    else {
//                        if (line.charAt(i + 1) == '\\') {
//                            i++;
//                        }
//                        subtracting += 1;
//                    }
//                }
//            }
//            stored += line.length() - subtracting;
//            System.out.println(line.length());
//            System.out.println(line.length() - subtracting);
//            System.out.println("-----------------");
//        }
//        System.out.println(total - stored);



        total = 0;
        stored = 0;
        while (s.hasNext()) {
            int adding = 4;
            String line = s.nextLine();
            total += line.length();
            for (int i = 1; i < line.length() - 1; i++) {
                if (line.charAt(i) == '\\') {
                    if (line.charAt(i + 1) == 'x') {
                        adding += 1;
                    }
                    else {
                        if (line.charAt(i + 1) == '\\') {
                            i++;
                        }
                        adding += 2;
                    }
                }
            }
            stored += line.length() - adding;
            System.out.println(line.length());
            System.out.println(line.length() + adding);
            System.out.println("-----------------");
        }
        System.out.println(total - stored);
    }
}
