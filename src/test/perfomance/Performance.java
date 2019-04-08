package test.perfomance;

import test.WriteToFile;
import test.classes.ClassOfRandomTriangles;
import test.classes.MyTriangle;

import java.io.FileNotFoundException;

abstract public class Performance {
    //TESTS
    protected int size = 20000;
    private long startTime;
    private long estimatedTime;
    private String fileName;

    private ClassOfRandomTriangles classOfRandomTriangles = new ClassOfRandomTriangles();
    protected MyTriangle[] arrayOfTriangles = new MyTriangle[size];


    public Performance(String fileName) {
        this.fileName = fileName;
        creationOfObjectsForTests();
        WriteToFile creationOfFile = new WriteToFile(fileName);
        creationOfFile.clearingOfFile();

        long[] arrayOfAmountOfObjectsInCollection = new long[size];
        for (int i = 0; i < size; i++) {
            arrayOfAmountOfObjectsInCollection[i] = i + 1;
            creationOfFile.functionForWritingInFile(arrayOfAmountOfObjectsInCollection[i]);
        }
        creationOfFile.functionToCloseFile();

    }

    protected void creationOfObjectsForTests() {
        for (int k = 0; k < size; k++) {
            arrayOfTriangles[k] = classOfRandomTriangles.creationOfTriangles();
        }
    }



}