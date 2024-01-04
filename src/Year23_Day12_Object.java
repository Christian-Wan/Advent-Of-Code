import java.util.ArrayList;

public class Year23_Day12_Object {
    private ArrayList<String> lakes = new ArrayList<>();
    private ArrayList<Integer> altData = new ArrayList<>();
    private ArrayList<String> minimum = new ArrayList<>();
    private int numberOfDamaged, numberOfWorking, numberOfUnknown;

    public Year23_Day12_Object(String lakes, String altData) {
        for (int i = 0; i < lakes.length(); i++) {
            String state = lakes.substring(i, i + 1);
            this.lakes.add(state);
            if (state.equals(".")) {
                numberOfWorking++;
            }
            if (state.equals("#")) {
                numberOfDamaged++;
            }
            if (state.equals("?")) {
                numberOfUnknown++;
            }
        }
        for (String data: altData.split(",")) {
            this.altData.add(Integer.parseInt(data));
        }
        minimum = findMinimum();
    }


    public int findSolutions() {
        int minDamaged = 0;
        for (int i = 0; i < altData.size(); i++) {
            minDamaged += altData.get(i);
        }
        int required = altData.size() - 1 + minDamaged;
        if (required == lakes.size()) {
            return 1;
        }
        return 0;
    }

//    private boolean fitsRules() {
//
//    }

    public int brokenLength(ArrayList<String> data, int index) { //make it go back then go forward
        int count = 0;
        for (int i = index; i > 0; i--) {
            if (data.get(i).equals(".")) {
                index = i + 1;
                break;
            }
        }
        for (int i = index; i < data.size(); i++) {
            if (data.get(i).equals("#")) {
                count++;
            }
            else {
                break;
            }
        }
        return count;
    }

    public ArrayList<String> findMinimum() { //doesn't work
        int part = 0;
        ArrayList<String> minimum = new ArrayList<>(lakes);
        for (int i = 0; i < minimum.size(); i++) {
            if (minimum.get(i).equals("?")) {
                minimum.set(i, "#");
                brokenLength(minimum, i);
                if (brokenLength(minimum, i) > altData.get(part)) {
                    minimum.set(i, ".");
                }

            }
            if (minimum.get(i).equals("#")) {
                if (brokenLength(minimum, i) == altData.get(part)) {

                    for (int x = 0; x < altData.get(part) - 1; x++) {
                        if (minimum.get(i + x).equals("?")) {
                            minimum.set(i + x, ".");
                            break;
                        }
                    }
                    part++;
                }
            }
//            if (part == altData.size()) {
//                for (int x = i; x < minimum.size(); x++) {
//                    i++;
//                    if (minimum.get(i).equals("?")) {
//                        minimum.set(i, ".");
//                    }
//                }
//            }
        }
        return minimum;
    }
    public ArrayList<String> getLakes() {
        return lakes;
    }

    public ArrayList<Integer> getAltData() {
        return altData;
    }

    public ArrayList<String> getMinimum() {
        return minimum;
    }
}
