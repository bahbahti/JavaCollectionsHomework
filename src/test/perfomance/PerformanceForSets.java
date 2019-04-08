package test.perfomance;

import test.WriteToFile;
import test.classes.MyTriangle;

import java.util.Set;

public class PerformanceForSets extends Performance {

    private long startTime;
    private long estimatedTime;

    public PerformanceForSets() {
        super("./second task/set/AmountOfNumbers.txt");
    }

    public void addPerformance(Set<MyTriangle> someSet) {

        //double timeInSeconds = (double)estimatedTime / 1_000_000_000.0;
        String fileName = someSet.getClass().toString();
        long[] arrayForEstimatedTime = new long[size];
        WriteToFile creationOfFile = new WriteToFile("./second task/set/add" + fileName + ".txt");
        creationOfFile.clearingOfFile();

        for (int i = 0; i < size; i++) {
            startTime = System.nanoTime();
            someSet.add(arrayOfTriangles[i]);
            estimatedTime = System.nanoTime() - startTime;
            arrayForEstimatedTime[i] = estimatedTime;
            creationOfFile.functionForWritingInFile(arrayForEstimatedTime[i]);
        }
        creationOfFile.functionToCloseFile();

    }


    public void getPerformance(Set<MyTriangle> someSet) {

        String fileName = someSet.getClass().toString();
        long[] arrayForMyEstimatedTime = new long[size];
        WriteToFile creationOfFile = new WriteToFile("./second task/set/get" + fileName + ".txt");
        creationOfFile.clearingOfFile();


        for (int i = 0; i < size; i++) {
            startTime = System.nanoTime();
            someSet.contains(arrayOfTriangles[i]);
            estimatedTime = System.nanoTime() - startTime;
            arrayForMyEstimatedTime[i] = estimatedTime;
            creationOfFile.functionForWritingInFile(arrayForMyEstimatedTime[i]);
        }
        creationOfFile.functionToCloseFile();

    }


    public void removePerformance(Set<MyTriangle> someSet) {

        String fileName = someSet.getClass().toString();
        long[] arrayForMyEstimatedTime = new long[size];
        WriteToFile creationOfFile = new WriteToFile("./second task/set/remove" + fileName + ".txt");
        creationOfFile.clearingOfFile();

        for (int i = 0; i < size; i++) {
            startTime = System.nanoTime();
            someSet.remove(arrayOfTriangles[i]);
            estimatedTime = System.nanoTime() - startTime;
            arrayForMyEstimatedTime[i] = estimatedTime;
            creationOfFile.functionForWritingInFile(arrayForMyEstimatedTime[i]);
        }
        creationOfFile.functionToCloseFile();

    }

}