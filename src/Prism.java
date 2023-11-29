public class Prism {
    private int height;
    private int length;
    private int width;


    public Prism(int h, int l, int w) {
        height = h;
        length = l;
        width = w;
    }

    public Prism(int side) {
        height = side;
        length = side;
        width = side;
    }

    public Prism() {
        int random = (int) (Math.random() * 91) + 10;
    }
    public void setHeight(int height) {
        this.height = height;
    }


    public void setLength(int length) {
        this.length = length;
    }


    public void setWidth(int width) {
        this.width = width;
    }


    public String toString() {
        return "Height: " + height +
                "\nLength: " + length +
                "\nWidth: " + width;
    }


    public int volume() {
        return height * length * width;
    }


    public int surfaceArea() {
        return 2 * ((height * width) + (height * length) + (length * width));
    }
}
