public class Year24_Day13_Object {

    private int buttonAX;
    private int buttonAY;
    private int buttonBX;
    private int buttonBY;
    private long finalX;
    private long finalY;

    public Year24_Day13_Object(int AX, int AY, int BX, int BY, int fX, int fY) {
        buttonAX = AX;
        buttonAY = AY;
        buttonBX = BX;
        buttonBY = BY;
        finalX = fX + 10000000000000l;
        finalY = fY + 10000000000000l;
    }

    public int getButtonAX() {
        return buttonAX;
    }

    public void setButtonAX(int buttonAX) {
        this.buttonAX = buttonAX;
    }

    public int getButtonAY() {
        return buttonAY;
    }

    public void setButtonAY(int buttonAY) {
        this.buttonAY = buttonAY;
    }

    public int getButtonBX() {
        return buttonBX;
    }

    public void setButtonBX(int buttonBX) {
        this.buttonBX = buttonBX;
    }

    public int getButtonBY() {
        return buttonBY;
    }

    public void setButtonBY(int buttonBY) {
        this.buttonBY = buttonBY;
    }

    public long getFinalX() {
        return finalX;
    }

    public void setFinalX(int finalX) {
        this.finalX = finalX;
    }

    public long getFinalY() {
        return finalY;
    }

    public void setFinalY(int finalY) {
        this.finalY = finalY;
    }
}
