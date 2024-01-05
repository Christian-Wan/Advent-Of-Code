import java.util.ArrayList;

public class Year15_Day10 {
    public static void main(String[] args) {
        String number = "3113322113";
        String newNumber = "";
        int counter = 1;
        for (int i = 0; i < 50; i++) {
            System.out.println(i);
            newNumber = "";
            for (int x = 1; x < number.length() + 1; x++) {
                try {
                    if (number.charAt(x) == number.charAt(x - 1)) {
                        counter++;
                    } else {
                        newNumber += counter + number.substring(x - 1, x);

                        counter = 1;
                    }
                } catch (IndexOutOfBoundsException e) {
                    newNumber += counter + number.substring(x - 1, x);

                    counter = 1;
                }

            }
            number = newNumber;
        }
        System.out.println(number.length());
    }
}
