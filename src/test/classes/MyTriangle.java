package test.classes;

public class MyTriangle implements Comparable<MyTriangle>{

    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;


    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.v1.setX(x1);
        this.v1.setY(y1);
        this.v2.setX(x2);
        this.v2.setY(y2);
        this.v3.setX(x3);
        this.v3.setY(y3);
    };

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    };

    @Override
    public String toString() {
        return "MyTriangle[" +
                "v1=" + v1 +
                ", v2=" + v2 +
                ", v3=" + v3 +
                ']';
    }

    public double getPerimeter() {
        return v1.distance(v2) + v2.distance(v3) + v3.distance(v1);
    }

    public String getType() {
        if (v1.distance(v2) == v2.distance(v3) && v2.distance(v3) == v3.distance(v1)) {
            return "Equilateral";
        }
        else if(v1.distance(v2) == v2.distance(v3) || v2.distance(v3) == v3.distance(v1) || v3.distance(v1) == v1.distance(v2)) {
            return "Isosceles";
        }
        else {
            return "Scalene";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        MyTriangle right = (MyTriangle) obj;
        return v1.equals(right.v1) &&
                v2.equals(right.v2) &&
                 v3.equals(right.v3);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + (v1 == null ? 0 : v1.hashCode());
        result = 37 * result + (v2 == null ? 0 : v2.hashCode());
        result = 37 * result + (v3 == null ? 0 : v3.hashCode());
        return result;
    }

    @Override
    public int compareTo(MyTriangle o)  {
        return (this.getPerimeter() < o.getPerimeter()) ? -1 : ((this.getPerimeter() == o.getPerimeter()) ? 0 : 1);
    }
}
