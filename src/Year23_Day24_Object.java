public class Year23_Day24_Object {
    long x, y, z;
    int xSlope, ySlope, zSlope;
    double yxSlope, zxSlope, yxIntercept, zxIntercept;

    public Year23_Day24_Object(long x, long y, long z, int xSlope, int ySlope, int zSlope) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.xSlope = xSlope;
        this.ySlope = ySlope;
        this.zSlope = zSlope;
        yxSlope = (double) ySlope / xSlope;
        zxSlope = (double) zSlope / xSlope;
        yxIntercept = y - (yxSlope * x);
        zxIntercept = z - (zxSlope * x);
    }

    public boolean solveSystem(Year23_Day24_Object equation, long min, long max) {
        double xCord = (yxIntercept - equation.yxIntercept) / (equation.yxSlope - yxSlope);
        double yCord = yxSlope * xCord + yxIntercept;
        if (xCord >= min && xCord <= max && yCord >= min && yCord <= max && ((xSlope < 0 && xCord <= x) || (xSlope > 0 && xCord >= x)) && ((equation.xSlope < 0 && xCord <= equation.x) || (equation.xSlope > 0 && xCord >= equation.x))) {
            return true;
        }
        return false;
    }
}
