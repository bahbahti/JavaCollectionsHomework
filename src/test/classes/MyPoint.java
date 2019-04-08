package test.classes;

public class MyPoint {

    private int x = 0;
    private int y = 0;


    public MyPoint() {
    };

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    };

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getXY() {
        return new int[] {x, y};
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" +
                "x=" + x +
                ", y=" + y +
                ')';
    }

    public double distance(int x, int y) {
        return Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
    }

    public double distance(MyPoint another) {
        return Math.sqrt((this.x - another.getX()) * (this.x - another.getX()) + (this.y - another.getY()) * (this.y - another.getY()));
    }

    public double distance() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        MyPoint right = (MyPoint) obj;
        return x == right.x &&
                y == right.y;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + x;
        result = 37 * result + y;
        return result;
    }
}
