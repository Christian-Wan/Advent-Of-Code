import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Year23_Day19 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("23/19");
        Scanner scanner = new Scanner(f);
        HashMap<String, String[]> workflow = makeMap(scanner);
        ArrayList<String[]> start = makeList(scanner);

        for (int i = 0; i < start.size(); i++) {
            System.out.println(Arrays.toString(start.get(i)));
        }
        String[] keys = workflow.keySet().toArray(String[]::new);
        for (int i = 0; i < workflow.size(); i++) {
            System.out.print(Arrays.toString(workflow.get(keys[i])));
        }
        System.out.println();
//        System.out.println(part1(workflow, start));

        ArrayList<String> acceptable = new ArrayList<>();
        ArrayList<String> acceptableFinale = new ArrayList<>();
        for (String key: keys) {
            for (String rule: workflow.get(key)) {
                if (rule.equals("A") || rule.substring(rule.indexOf(":") + 1).equals("A")) {
                    acceptable.add(key);
                    acceptableFinale.add(rule);
                }
            }
        }
        System.out.println(acceptable);
        System.out.println(acceptableFinale);

        HashMap<String, ArrayList<String>> flow = new HashMap<>();
        for (String key: keys) {
            ArrayList<String> temporary = new ArrayList<>();
            for (String rule: workflow.get(key)) {
                try {
                    if (!rule.substring(rule.indexOf(":") + 1).equals("A") && !rule.substring(rule.indexOf(":") + 1).equals("R")) {
                        temporary.add(rule.substring(rule.indexOf(":") + 1));
                    }
                } catch (IndexOutOfBoundsException e) {
                    if (!rule.equals("A") && !rule.equals("R")) {
                        temporary.add(rule);
                    }
                }
            }
            flow.put(key, temporary);
        }

        long total = 0;
        int counter = 0;
        for (int i = 0; i <acceptable.size(); i++) {
            String key = acceptable.get(i);
            long xMin = 1;
            long xMax = 4000;
            long mMin = 1;
            long mMax = 4000;
            long aMin = 1;
            long aMax = 4000;
            long sMin = 1;
            long sMax = 4000;
            for (String last: workflow.get(key)) {
                if (last.equals(acceptableFinale.get(i))) {
                    if (last.contains("<")) {
                        int comparing = Integer.parseInt(last.substring(2, last.indexOf(":")));
                        if (last.charAt(0) == 'x') {
                            if (xMax > comparing) {
                                xMax = comparing - 1;
                            }
                        } else if (last.charAt(0) == 'm') {
                            if (mMax > comparing) {
                                mMax = comparing - 1;
                            }
                        } else if (last.charAt(0) == 'a') {
                            if (aMax > comparing) {
                                aMax = comparing - 1;
                            }
                        } else if (last.charAt(0) == 's') {
                            if (sMax > comparing) {
                                sMax = comparing - 1;
                            }
                        }
                    } else if (last.contains(">")) {
                        int comparing = Integer.parseInt(last.substring(2, last.indexOf(":")));
                        if (last.charAt(0) == 'x') {
                            if (xMin < comparing) {
                                xMin = comparing + 1;
                            }
                        } else if (last.charAt(0) == 'm') {
                            if (mMin < comparing) {
                                mMin = comparing + 1;
                            }
                        } else if (last.charAt(0) == 'a') {
                            if (aMin < comparing) {
                                aMin = comparing + 1;
                            }
                        } else if (last.charAt(0) == 's') {
                            if (sMin < comparing) {
                                sMin = comparing + 1;
                            }
                        }
                    }
                }
                else {
                    if (last.contains(">")) {
                        int comparing = Integer.parseInt(last.substring(2, last.indexOf(":")));
                        if (last.charAt(0) == 'x') {
                            if (xMax > comparing) {
                                xMax = comparing;
                            }
                        } else if (last.charAt(0) == 'm') {
                            if (mMax > comparing) {
                                mMax = comparing;
                            }
                        } else if (last.charAt(0) == 'a') {
                            if (aMax > comparing) {
                                aMax = comparing;
                            }
                        } else if (last.charAt(0) == 's') {
                            if (sMax > comparing) {
                                sMax = comparing;
                            }
                        }
                    } else if (last.contains("<")) {
                        int comparing = Integer.parseInt(last.substring(2, last.indexOf(":")));
                        if (last.charAt(0) == 'x') {
                            if (xMin < comparing) {
                                xMin = comparing;
                            }
                        } else if (last.charAt(0) == 'm') {
                            if (mMin < comparing) {
                                mMin = comparing;
                            }
                        } else if (last.charAt(0) == 'a') {
                            if (aMin < comparing) {
                                aMin = comparing;
                            }
                        } else if (last.charAt(0) == 's') {
                            if (sMin < comparing) {
                                sMin = comparing;
                            }
                        }
                    }
                }
                if (last.equals(acceptableFinale.get(i))) {
                    String next = key;
                    counter = 0;
                    System.out.println("------------");
                    while (counter == 0) {
                        if (next.equals("in")) {
                            counter++;
                        }
                        System.out.println(next);
                        for (String guess : keys) {
                            if (flow.get(guess).contains(next)) {
                                for (String rule : workflow.get(guess)) {
                                    if (rule.substring(rule.indexOf(":") + 1).equals(next)) {
                                        if (rule.contains("<")) {
                                            int comparing = Integer.parseInt(rule.substring(2, rule.indexOf(":")));
                                            if (rule.charAt(0) == 'x') {
                                                if (xMax > comparing) {
                                                    xMax = comparing - 1;
                                                }
                                            } else if (rule.charAt(0) == 'm') {
                                                if (mMax > comparing) {
                                                    mMax = comparing - 1;
                                                }
                                            } else if (rule.charAt(0) == 'a') {
                                                if (aMax > comparing) {
                                                    aMax = comparing - 1;
                                                }
                                            } else if (rule.charAt(0) == 's') {
                                                if (sMax > comparing) {
                                                    sMax = comparing - 1;
                                                }
                                            }
                                        } else if (rule.contains(">")) {
                                            int comparing = Integer.parseInt(rule.substring(2, rule.indexOf(":")));
                                            if (rule.charAt(0) == 'x') {
                                                if (xMin < comparing) {
                                                    xMin = comparing + 1;
                                                }
                                            } else if (rule.charAt(0) == 'm') {
                                                if (mMin < comparing) {
                                                    mMin = comparing + 1;
                                                }
                                            } else if (rule.charAt(0) == 'a') {
                                                if (aMin < comparing) {
                                                    aMin = comparing + 1;
                                                }
                                            } else if (rule.charAt(0) == 's') {
                                                if (sMin < comparing) {
                                                    sMin = comparing + 1;
                                                }
                                            }
                                        }
                                        break;
                                    } else {
                                        if (rule.contains(">")) {
                                            int comparing = Integer.parseInt(rule.substring(2, rule.indexOf(":")));
                                            if (rule.charAt(0) == 'x') {
                                                if (xMax > comparing) {
                                                    xMax = comparing;
                                                }
                                            } else if (rule.charAt(0) == 'm') {
                                                if (mMax > comparing) {
                                                    mMax = comparing;
                                                }
                                            } else if (rule.charAt(0) == 'a') {
                                                if (aMax > comparing) {
                                                    aMax = comparing;
                                                }
                                            } else if (rule.charAt(0) == 's') {
                                                if (sMax > comparing) {
                                                    sMax = comparing;
                                                }
                                            }
                                        } else if (rule.contains("<")) {
                                            int comparing = Integer.parseInt(rule.substring(2, rule.indexOf(":")));
                                            if (rule.charAt(0) == 'x') {
                                                if (xMin < comparing) {
                                                    xMin = comparing;
                                                }
                                            } else if (rule.charAt(0) == 'm') {
                                                if (mMin < comparing) {
                                                    mMin = comparing;
                                                }
                                            } else if (rule.charAt(0) == 'a') {
                                                if (aMin < comparing) {
                                                    aMin = comparing;
                                                }
                                            } else if (rule.charAt(0) == 's') {
                                                if (sMin < comparing) {
                                                    sMin = comparing;
                                                }
                                            }
                                        }
                                    }
                                }
                                next = guess;
                            }


                        }
                    }
                    System.out.println("x: (" + xMin + ", " + xMax + ")");
                    System.out.println((xMax - xMin) + 1);
                    System.out.println("m: (" + mMin + ", " + mMax + ")");
                    System.out.println((mMax - mMin) + 1);
                    System.out.println("a: (" + aMin + ", " + aMax + ")");
                    System.out.println((aMax - aMin) + 1);
                    System.out.println("s: (" + sMin + ", " + sMax + ")");
                    System.out.println((sMax - sMin) + 1);
                    System.out.println(((xMax - xMin) + 1) * ((mMax - mMin) + 1) * ((aMax - aMin) + 1) * ((sMax - sMin) + 1));
                    total += ((xMax - xMin) + 1) * ((mMax - mMin) + 1) * ((aMax - aMin) + 1) * ((sMax - sMin) + 1);

                }
            }
        }
        System.out.println(total);
        System.out.println("167409079868000");

    }
    public static HashMap<String, String[]> makeMap(Scanner s) {
        HashMap<String, String[]> result = new HashMap<>();
        String[] transformation;
        while (s.hasNext()) {
            String line = s.nextLine();
            if (line.isEmpty()) {
                break;
            }
            transformation = line.substring(line.indexOf("{") + 1, line.indexOf("}")).split(",");
            result.put(line.substring(0, line.indexOf("{")), transformation);
        }

        return result;
    }

    public static ArrayList<String[]> makeList(Scanner s) {
        ArrayList<String[]> result = new ArrayList<>();
        String[] sub;

        while (s.hasNext()) {
            String line = s.nextLine();
            sub = line.substring(1, line.indexOf("}")).split(",");
            result.add(sub);
        }
        return result;
    }

    public static int part1(HashMap<String, String[]> workflow, ArrayList<String[]> start) {
        int total = 0;
        for (String[] xmas: start) {
            int x = Integer.parseInt(xmas[0].substring(2));
            int m = Integer.parseInt(xmas[1].substring(2));
            int a = Integer.parseInt(xmas[2].substring(2));
            int s = Integer.parseInt(xmas[3].substring(2));
            String position = "in";
            while (!position.equals("A") && !position.equals("R")) {
                for (String rule: workflow.get(position)) {
                    if (rule.contains("<")) {
                        int comparing = Integer.parseInt(rule.substring(2, rule.indexOf(":")));
                        if (rule.charAt(0) == 'x') {
                            if (x < comparing) {
                                position = rule.substring(rule.indexOf(":") + 1);
                                break;
                            }
                        }
                        else if (rule.charAt(0) == 'm') {
                            if (m < comparing) {
                                position = rule.substring(rule.indexOf(":") + 1);
                                break;
                            }
                        }
                        else if (rule.charAt(0) == 'a') {
                            if (a < comparing) {
                                position = rule.substring(rule.indexOf(":") + 1);
                                break;
                            }
                        }
                        else if (rule.charAt(0) == 's') {
                            if (s < comparing) {
                                position = rule.substring(rule.indexOf(":") + 1);
                                break;
                            }
                        }
                    }
                    else if (rule.contains(">")) {
                        int comparing = Integer.parseInt(rule.substring(2, rule.indexOf(":")));
                        if (rule.charAt(0) == 'x') {
                            if (x > comparing) {
                                position = rule.substring(rule.indexOf(":") + 1);
                                break;
                            }
                        }
                        else if (rule.charAt(0) == 'm') {
                            if (m > comparing) {
                                position = rule.substring(rule.indexOf(":") + 1);
                                break;
                            }
                        }
                        else if (rule.charAt(0) == 'a') {
                            if (a > comparing) {
                                position = rule.substring(rule.indexOf(":") + 1);
                                break;
                            }
                        }
                        else if (rule.charAt(0) == 's') {
                            if (s > comparing) {
                                position = rule.substring(rule.indexOf(":") + 1);
                                break;
                            }
                        }
                    }
                    else {
                        position = rule;
                        break;
                    }
                }

                if (position.equals("A")) {
                    total += x + m + a + s;
                }
            }
        }
        return total;
    }
}
