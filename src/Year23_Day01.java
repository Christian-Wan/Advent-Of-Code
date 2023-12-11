import java.io.File;
import java.io.FileNotFoundException;
import java.security.KeyException;
import java.util.HashMap;
import java.util.Scanner;

public class Year23_Day01 {
    public static void main(String[] args) throws FileNotFoundException, KeyException {
        File f = new File("23/1");
        Scanner s = new Scanner(f);
        int total = 0;
        String letterFormat = "";
        HashMap<String, String> numbers = new HashMap<>();
        numbers.put("one", "1");
        numbers.put("two", "2");
        numbers.put("three", "3");
        numbers.put("four", "4");
        numbers.put("five", "5");
        numbers.put("six", "6");
        numbers.put("seven", "7");
        numbers.put("eight", "8");
        numbers.put("nine", "9");
        numbers.put("zero", "0");
        while (s.hasNext()) {
            String tempNumber = "";
            String line = s.nextLine();
            for (int i = 0; i < line.length(); i++) {
                if ("1234567890".indexOf(line.charAt(i)) != -1 || line.charAt(i) == 'o' || line.charAt(i) == 't' || line.charAt(i) == 'f' || line.charAt(i) == 's' || line.charAt(i) == 'e' || line.charAt(i) == 'n' || line.charAt(i) == 'z') {
                    if ("1234567890".indexOf(line.charAt(i)) != -1) {
                        tempNumber += line.charAt(i);
                        break;
                    }
                    else {
                        for (int x = 3; x <= 5; x++) {
                            try {
                                letterFormat = line.substring(i, i + x);
                                if (numbers.get(letterFormat) != null) {
                                    tempNumber += numbers.get(letterFormat);
                                    break;
                                }
                            }
                            catch (IndexOutOfBoundsException t) {

                            }
                        }
                        if (tempNumber.length() == 1) {
                            break;
                        }
                    }
                }
            }
            for (int i = line.length() - 1; i >= 0; i--) {
                if ("1234567890".indexOf(line.charAt(i)) != -1 || line.charAt(i) == 'o' || line.charAt(i) == 't' || line.charAt(i) == 'f' || line.charAt(i) == 's' || line.charAt(i) == 'e' || line.charAt(i) == 'n' || line.charAt(i) == 'z') {
                    if ("1234567890".indexOf(line.charAt(i)) != -1) {
                        tempNumber += line.charAt(i);
                        break;
                    }
                    else {
                        for (int x = 3; x <= 5; x++) {
                            try {
                                letterFormat = line.substring(i, i + x);
                                if (numbers.get(letterFormat) != null) {
                                    tempNumber += numbers.get(letterFormat);
                                    break;
                                }
                            }
                            catch (IndexOutOfBoundsException t) {
                            }
                        }
                        if (tempNumber.length() == 2) {
                            break;
                        }
                    }
                }
            }
            total += Integer.parseInt(tempNumber);
        }
        System.out.println(total);
    }
}
