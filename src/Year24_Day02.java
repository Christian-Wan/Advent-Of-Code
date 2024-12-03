import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Year24_Day02 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("24/2");
        Scanner s = new Scanner(f);

        int total = 0;

        while (s.hasNext()) {
            String line = s.nextLine();
            String[] split = line.split(" ");
            boolean increasing = false;
            boolean pass = true;
            boolean tolerate = true;

            if (Integer.parseInt(split[0]) - Integer.parseInt(split[1]) < 0) {
                increasing = true;
            }
            else if (Integer.parseInt(split[0]) - Integer.parseInt(split[1]) == 0) {
                tolerate = false;
            }

            for (int i = 0; i < split.length - 1; i++) {
                if (increasing) {
                    if (Integer.parseInt(split[i]) - Integer.parseInt(split[i + 1]) >= 0) {
                        tolerate = false;
                        break;
                    }
                    if (Math.abs(Integer.parseInt(split[i]) - Integer.parseInt(split[i + 1])) > 3) {
                        tolerate = false;
                        break;
                    }
                }
                else {
                    if (Integer.parseInt(split[i]) - Integer.parseInt(split[i + 1]) <= 0) {
                        tolerate = false;
                        break;
                    }
                    if (Math.abs(Integer.parseInt(split[i]) - Integer.parseInt(split[i + 1])) > 3) {
                        tolerate = false;
                        break;
                    }
                }
            }

            if (!tolerate) {
                for (int t = 0; t < split.length; t++) {
                    String[] test = new String[split.length - 1];
                    for (int x = 0; x < split.length - 1; x++) {
                        if (x < t) {
                            test[x] = split[x];
                        }
                        else {
                            test[x] = split[x + 1];
                        }
                    }

                    pass = true;
                    increasing = false;
                    if (Integer.parseInt(test[0]) - Integer.parseInt(test[1]) < 0) {
                        increasing = true;
                    }
                    else if (Integer.parseInt(test[0]) - Integer.parseInt(test[1]) == 0) {
                        pass = false;
                    }

                    for (int i = 0; i < test.length - 1; i++) {
                        if (increasing) {
                            if (Integer.parseInt(test[i]) - Integer.parseInt(test[i + 1]) >= 0) {
                                pass = false;
                                break;
                            }
                            if (Math.abs(Integer.parseInt(test[i]) - Integer.parseInt(test[i + 1])) > 3) {
                                pass = false;
                                break;
                            }
                        }
                        else {
                            if (Integer.parseInt(test[i]) - Integer.parseInt(test[i + 1]) <= 0) {
                                pass = false;
                                break;
                            }
                            if (Math.abs(Integer.parseInt(test[i]) - Integer.parseInt(test[i + 1])) > 3) {
                                pass = false;
                                break;
                            }
                        }
                    }
                    if (pass) {
                        break;
                    }
                }
            }

            if (pass) {
                total++;
            }
        }
        System.out.println(total);
    }
}
