package test.perfomance;

import collections.ILinkedList;
import test.WriteToFile;
import test.classes.MyTriangle;


public class PerformanceForMyCollection extends PerformanceForLists {
    private long startTime;
    private long estimatedTime;
    private String directory = "./first task/";

    public PerformanceForMyCollection() {
        super("./first task/AmountOfNumbers.txt", "./first task/");
    }


    public void addPerformance(ILinkedList<MyTriangle> someList) {

        String fileName = someList.getClass().toString();
        long[] arrayForEstimatedTime = new long[size];
        WriteToFile creationOfFile = new WriteToFile(directory +"add" + fileName + ".txt");
        creationOfFile.clearingOfFile();

        int halfOFSize = (int) size / 2;
        for (int i = 0; i < halfOFSize; i++) {
            startTime = System.nanoTime();
            someList.add(arrayOfTriangles[i]);
            estimatedTime = System.nanoTime() - startTime;
            arrayForEstimatedTime[i] = estimatedTime;
            creationOfFile.functionForWritingInFile(arrayForEstimatedTime[i]);
        }

        for (int i = halfOFSize; i < size ; i++) {
            startTime = System.nanoTime();
            someList.add(halfOFSize, arrayOfTriangles[i]);
            estimatedTime = System.nanoTime() - startTime;
            arrayForEstimatedTime[i] = estimatedTime;
            creationOfFile.functionForWritingInFile(arrayForEstimatedTime[i]);
        }
        creationOfFile.functionToCloseFile();
    }


    public void getPerformance(ILinkedList<MyTriangle> someList) {

        String fileName = someList.getClass().toString();
        long[] arrayForMyEstimatedTime = new long[size];
        WriteToFile creationOfFile = new WriteToFile(directory + "get" + fileName + ".txt");
        creationOfFile.clearingOfFile();


        for (int i = 0; i < size; i++) {
            startTime = System.nanoTime();
            someList.get(i);
            estimatedTime = System.nanoTime() - startTime;
            arrayForMyEstimatedTime[i] = estimatedTime;
            creationOfFile.functionForWritingInFile(arrayForMyEstimatedTime[i]);
        }
        creationOfFile.functionToCloseFile();

    }


    public void removePerformance(ILinkedList<MyTriangle> someList) {

        String fileName = someList.getClass().toString();
        long[] arrayForMyEstimatedTime = new long[size];
        WriteToFile creationOfFile = new WriteToFile(directory + "remove" + fileName + ".txt");
        creationOfFile.clearingOfFile();

        for (int i = 0; i < size; i++) {
            startTime = System.nanoTime();
            someList.remove((int) someList.size() / 2);
            estimatedTime = System.nanoTime() - startTime;
            arrayForMyEstimatedTime[i] = estimatedTime;
            creationOfFile.functionForWritingInFile(arrayForMyEstimatedTime[i]);
        }
        creationOfFile.functionToCloseFile();

    }

}
