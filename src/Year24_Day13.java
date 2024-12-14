import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Year24_Day13 {
    public static void main(String[] args) throws FileNotFoundException {
        File f= new File("24/13");
        Scanner s = new Scanner(f);
        ArrayList<Year24_Day13_Object> machines = new ArrayList<>();

        while (s.hasNext()) {
            String line = s.nextLine();
            if (line.contains("Button A")) {
                String buttonB = s.nextLine();
                String prize = s.nextLine();

                machines.add(new Year24_Day13_Object(Integer.parseInt(line.substring(line.indexOf("X+") + 2, line.indexOf(","))), Integer.parseInt(line.substring(line.indexOf("Y+") + 2)), Integer.parseInt(buttonB.substring(buttonB.indexOf("X+") + 2, buttonB.indexOf(","))), Integer.parseInt(buttonB.substring(buttonB.indexOf("Y+") + 2)), Integer.parseInt(prize.substring(prize.indexOf("X=") + 2, prize.indexOf(","))), Integer.parseInt(prize.substring(prize.indexOf("Y=") + 2))));
            }
        }
        long total = 0;

        for (int i = 0; i < machines.size(); i++) {
            int equation1X = (machines.get(i).getButtonAX() * machines.get(i).getButtonBY()) - (machines.get(i).getButtonBX() * machines.get(i).getButtonAY());
            long equation1Final = (machines.get(i).getFinalX() * machines.get(i).getButtonBY()) - (machines.get(i).getFinalY() * machines.get(i).getButtonBX());
            long machineAInputs = 0;
            long machineBInputs = 0;

//            System.out.println(equation1X + ": " + i);
//            System.out.println(equation1Final);
            if (equation1Final % equation1X == 0) {
//                System.out.println("here");
                machineAInputs = equation1Final / equation1X;
                if ((machines.get(i).getFinalX() - (machines.get(i).getButtonAX() * machineAInputs)) % machines.get(i).getButtonBX() == 0) {
                    machineBInputs = (machines.get(i).getFinalX() - (machines.get(i).getButtonAX() * machineAInputs)) / machines.get(i).getButtonBX();
                }
                else {
                    machineAInputs = 0;
                }
            }

            total += machineAInputs * 3 + machineBInputs;
        }
        System.out.println(total);
    }
}
