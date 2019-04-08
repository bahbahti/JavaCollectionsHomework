package test.classes;

public class ClassOfRandomTriangles {

    private int min = 1;
    private int max = 100000;
    private int x1, x2, x3, y1, y2, y3;

    private int randomFunction()
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public MyTriangle creationOfTriangles(){
        x1 = randomFunction();
        x2 = randomFunction();
        x3 = randomFunction();
        y1 = randomFunction();
        y2 = randomFunction();
        y3 = randomFunction();
        return new MyTriangle(new MyPoint(x1, y1), new MyPoint(x2, y2), new MyPoint(x3, y3));

    }
}
