import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Year24_Day09 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("24/9");
        Scanner s = new Scanner(f);

        ArrayList<String> files = new ArrayList<>(); // file,id,size/blank,size
        ArrayList<Integer> yes = new ArrayList<>();

        int count = 0;
        while (s.hasNext()) {
            String line = s.nextLine();
            for (int i = 0; i < line.length(); i++) {
                yes.add(Integer.parseInt(line.substring(i, i + 1)));
                if (count % 2 == 0) {
                    files.add("file," + count / 2 + "," + line.substring(i, i + 1));
                }
                else {
                    files.add("blank," + line.substring(i, i + 1));
                }
                count++;
            }
        }

        for (int i = files.size() - 1; i > 0; i--) {
            if (files.get(i).contains("file")) {
//                System.out.println(files.get(i));
                int fileSize = Integer.parseInt(files.get(i).substring(files.get(i).length() - 1));
                for (int x = 0; x < i; x++) {
                    if (files.get(x).contains("blank")) {
                        int blankSize = Integer.parseInt(files.get(x).substring(files.get(x).indexOf(",") + 1));
                        if (fileSize <= blankSize) {
                            files.set(x, "blank," + (blankSize - fileSize));
                            files.add(x, files.get(i));
                            files.set(i + 1, "blank," + fileSize);
                            i++;
                            break;
                        }
                    }
                }
            }
        }

//        System.out.println(files);
        long total = 0;
        long index = 0;
        for (int i = 0; i < files.size(); i++) {
//            System.out.println(files.get(i));
            if (files.get(i).contains("file")) {
                int size = Integer.parseInt(files.get(i).substring(files.get(i).length() - 1));
                int ID = Integer.parseInt(files.get(i).substring(5, files.get(i).length() - 2));
                for (int x = 0; x < size; x++) {
                    total += ID * index;
                    index++;
                }
            }
            else {
                index += Long.parseLong(files.get(i).substring(6));
            }
        }

        System.out.println(total);












//        System.out.println(yes.size());
//        long total = 0;
//        long index = 0;
//        for (int i = 0; i < yes.size(); i++) {
//            while (yes.get(i) != 0) {
//                if (i % 2 == 0) {
//                    total += index * (i / 2);
//                }
//                else {
//                    int last = (yes.size() - 1) / 2;
//                    yes.set(yes.size() - 1, yes.getLast() - 1);
//                    if (yes.getLast() == 0) {
//                        yes.removeLast();
//                        yes.removeLast();
//                    }
//                    total += last * index;
//                }
//                index++;
//                yes.set(i, yes.get(i) - 1);
//            }
//        }
//        System.out.println(total);


    }

    //6415184586057 high
}
