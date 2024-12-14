public class Year24_Day14_Object {

    int startHeight;
    int startWidth;
    int vertical;
    int horizontal;

    public Year24_Day14_Object(int h,int w,int v,int h2) {
        startHeight = h;
        startWidth = w;
        vertical = v;
        horizontal = h2;
    }

    public int getStartHeight() {
        return startHeight;
    }

    public void setStartHeight(int startHeight) {
        this.startHeight = startHeight;
    }

    public int getStartWidth() {
        return startWidth;
    }

    public void setStartWidth(int startWidth) {
        this.startWidth = startWidth;
    }

    public int getVertical() {
        return vertical;
    }

    public void setVertical(int vertical) {
        this.vertical = vertical;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }

    @Override
    public String toString() {
        return "Year24_Day14_Object{" +
                "startHeight=" + startHeight +
                ", startWidth=" + startWidth +
                ", vertical=" + vertical +
                ", horizontal=" + horizontal +
                '}';
    }
}
