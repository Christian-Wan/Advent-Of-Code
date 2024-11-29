import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Year18_Day02 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("18/2");
        Scanner s = new Scanner(f);

        ArrayList<String> ids = new ArrayList<String>();

        while (s.hasNext()) {
            ids.add(s.nextLine());
        }

        for (int i = 0; i < ids.size(); i++) {
            String string1 = ids.get(i);
            for (int x = i + 1; x < ids.size(); x++) {
                String string2 = ids.get(x);
                for (int y = 0; y < string1.length(); y++) {
                    String altered1 = string1.substring(0,y) + string1.substring(y + 1);
                    String altered2 = string2.substring(0,y) + string2.substring(y + 1);
                    if (altered1.equals(altered2)) {
                        System.out.println(altered2);
                    }
                }
            }
        }




//        Part 1
//        int duplicates = 0;
//        int triples = 0;
//        boolean checkedDuplicates = false;
//        boolean checkedTriples = false;
//        int length = 0;
//
//        while (s.hasNext()) {
//            String line = s.nextLine();
//            checkedTriples = false;
//            checkedDuplicates = false;
//            length = line.length();
//            while (length != 0) {
//                String first = line.substring(0,1);
//                line = line.replaceAll(first, "");
//                if (length - line.length() == 2 && !checkedDuplicates) {
//                    checkedDuplicates = true;
//                    duplicates++;
//                }
//                else if (length - line.length() == 3 && !checkedTriples) {
//                    checkedTriples = true;
//                    triples++;
//                }
//                length = line.length();
//            }
//        }
//        System.out.println(duplicates * triples);
    }
}
