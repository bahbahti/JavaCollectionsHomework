package test.perfomance;

import test.WriteToFile;
import test.classes.MyTriangle;

import java.util.Map;

public class PerformanceForMaps extends Performance {

    private long startTime;
    private long estimatedTime;
    private Integer[] arrayOfKeys = new Integer[size];

    public PerformanceForMaps() {
        super("./second task/map/AmountOfNumbers.txt");
        creationOfIntegers();

    }

    private void creationOfIntegers() {
        for (int k = 0; k < size; k++) {
            arrayOfKeys[k] = new Integer(k);
        }
    }

    public void addPerformance(Map<Integer, MyTriangle> someMap) {

        String fileName = someMap.getClass().toString();
        long[] arrayForEstimatedTime = new long[size];
        WriteToFile creationOfFile = new WriteToFile("./second task/map/add" + fileName + ".txt");
        creationOfFile.clearingOfFile();

        for (int i = 0; i < size; i++) {
            startTime = System.nanoTime();
            someMap.put(arrayOfKeys[i], arrayOfTriangles[i]);
            estimatedTime = System.nanoTime() - startTime;
            arrayForEstimatedTime[i] = estimatedTime;
            creationOfFile.functionForWritingInFile(arrayForEstimatedTime[i]);
        }
        creationOfFile.functionToCloseFile();

    }


    public void getPerformance(Map<Integer, MyTriangle> someMap) {

        String fileName = someMap.getClass().toString();
        long[] arrayForMyEstimatedTime = new long[size];
        WriteToFile creationOfFile = new WriteToFile("./second task/map/get" + fileName + ".txt");
        creationOfFile.clearingOfFile();


        for (int i = 0; i < size; i++) {
            startTime = System.nanoTime();
            someMap.get(arrayOfKeys[i]);
            estimatedTime = System.nanoTime() - startTime;
            arrayForMyEstimatedTime[i] = estimatedTime;
            creationOfFile.functionForWritingInFile(arrayForMyEstimatedTime[i]);
        }
        creationOfFile.functionToCloseFile();

    }


    public void removePerformance(Map<Integer, MyTriangle> someMap) {

        String fileName = someMap.getClass().toString();
        long[] arrayForMyEstimatedTime = new long[size];
        WriteToFile creationOfFile = new WriteToFile("./second task/map/remove" + fileName + ".txt");
        creationOfFile.clearingOfFile();

        for (int i = 0; i < size; i++) {
            startTime = System.nanoTime();
            someMap.remove(arrayOfKeys[i]);
            estimatedTime = System.nanoTime() - startTime;
            arrayForMyEstimatedTime[i] = estimatedTime;
            creationOfFile.functionForWritingInFile(arrayForMyEstimatedTime[i]);
        }
        creationOfFile.functionToCloseFile();

    }

}
