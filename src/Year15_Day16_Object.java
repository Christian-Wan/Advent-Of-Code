public class Year15_Day16_Object {
    public String[] known = new String[3];
    public int[] amount = new int[3];

    public Year15_Day16_Object(String[] input) {
        for (int i = 0; i < 3; i++) {
            known[i] = input[i].substring(0, input[i].indexOf(":"));
            amount[i] = Integer.parseInt(input[i].substring(input[i].indexOf(":") + 2));
        }
    }

    public String[] getKnown() {
        return known;
    }

    public int[] getAmount() {
        return amount;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < 3; i++) {
            result += known[i] + ": " + amount[i];
        }
        return result;
    }


}
