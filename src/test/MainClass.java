package test;

import collections.ILinkedList;
import collections.MyLinkedList;
import test.classes.Circle;
import test.classes.MyTriangle;
import test.perfomance.*;

import java.util.*;

public class MainClass {

    public static void main(String[] args) {
        int indexForCircles = 0;
        int indexForTriangles = 0;
        //CREATION OF INSTANCE OF MYLINKEDLIST (TYPE INTEGER)
        ILinkedList<Integer> collectionOfIntegers = new MyLinkedList<>();
        collectionOfIntegers.add(4);
        collectionOfIntegers.add(2);
        collectionOfIntegers.add(17);
        collectionOfIntegers.add(8);
        collectionOfIntegers.add(1);
        System.out.println("Element of my collection whose index is 3 -----> " + collectionOfIntegers.get(3));

        //OPERATIONS: ADD, REMOVE, SET
        collectionOfIntegers.add(2, 7);
        collectionOfIntegers.remove(1);
        collectionOfIntegers.set(2,11);
        collectionOfIntegers.add(null);
        collectionOfIntegers.add(3, null);

        //ITERATOR
        System.out.println("Elements of my collection: ");
        Iterator myIterator = collectionOfIntegers.iterator();
        while (myIterator.hasNext()) {
            System.out.print(myIterator.next() + ", ");
        }
        System.out.println();
        System.out.println("Size of my collection is: " + collectionOfIntegers.size());

        //System.out.println(collectionOfIntegers.indexOf(5));
        //collectionOfIntegers.clear();

        //TO ARRAY METHOD
        System.out.println("Elements of new created array from list: ");
        Integer[] myArray = collectionOfIntegers.toArray();
        //Integer[] myArray = ((MyLinkedList<Integer>) collectionOfIntegers).toArray(new Integer[0]);
        for (Integer elementOfArray : myArray) {
            System.out.print(elementOfArray + ", ");
        }
        System.out.println();

        //TO STRING
        System.out.println(collectionOfIntegers.toString());
        System.out.println();



        //CREATION OF INSTANCE OF MYLINKEDLIST(TYPE CIRCLE)
        ILinkedList<Circle> collectionOfCircles  = new MyLinkedList<>();
        Circle[] arrayOfCircles = new Circle[10];
        for (int i = 0; i < 10; i++) {
            arrayOfCircles[i] = new Circle(i * 3);
            collectionOfCircles.add(arrayOfCircles[i]);
        }

        //ADD(INDEX, ELEMENT)
        collectionOfCircles.add(3, new Circle(225.595,"Green"));

        //ITERATOR FOR CIRCLES
        Iterator iteratorForCircle = collectionOfCircles.iterator();
        while (iteratorForCircle.hasNext()) {
            System.out.println("Number in list: " + indexForCircles++ + " has element: " + iteratorForCircle.next());
        }
        System.out.println();

        //INDEX OF
        System.out.println("Index of circle which has a radius = 225.595 and color.green --------> " + collectionOfCircles.indexOf(new Circle(225.595,"Green")));
        //TO STRING
        System.out.println(collectionOfCircles.toString());



        //TESTS

        //MyCollection vs LinkedList
        //Результаты в виде графиков представлены в папках и в отчете


        Performance comparisonOfMyListAndLinkedList = new PerformanceForMyCollection();

        ILinkedList<MyTriangle> myList = new MyLinkedList<>();
        List<MyTriangle> linkedListForFirstTask = new LinkedList<>();

        ((PerformanceForMyCollection) comparisonOfMyListAndLinkedList).addPerformance(myList);
        ((PerformanceForMyCollection) comparisonOfMyListAndLinkedList).addPerformance(linkedListForFirstTask);

        ((PerformanceForMyCollection) comparisonOfMyListAndLinkedList).getPerformance(myList);
        ((PerformanceForMyCollection) comparisonOfMyListAndLinkedList).getPerformance(linkedListForFirstTask);

        ((PerformanceForMyCollection) comparisonOfMyListAndLinkedList).removePerformance(myList);
        ((PerformanceForMyCollection) comparisonOfMyListAndLinkedList).removePerformance(linkedListForFirstTask);



        //LISTS
/*
        Performance listComparison = new PerformanceForLists();

        List<MyTriangle> linkedList = new LinkedList<>();
        List<MyTriangle> arrayList = new ArrayList<>();

        ((PerformanceForLists) listComparison).addPerformance(linkedList);
        ((PerformanceForLists) listComparison).addPerformance(arrayList);

        ((PerformanceForLists) listComparison).getPerformance(linkedList);
        ((PerformanceForLists) listComparison).getPerformance(arrayList);

        ((PerformanceForLists) listComparison).removePerformance(linkedList);
        ((PerformanceForLists) listComparison).removePerformance(arrayList);
*/


        //SETS

/*      Performance setComparison = new PerformanceForSets();

        Set<MyTriangle> hashSet = new HashSet<>();
        Set<MyTriangle> linkedHashSet = new LinkedHashSet<>();
        Set<MyTriangle> treeSet = new TreeSet<>();

        ((PerformanceForSets) setComparison).addPerformance(hashSet);
        ((PerformanceForSets) setComparison).addPerformance(linkedHashSet);
        ((PerformanceForSets) setComparison).addPerformance(treeSet);

        ((PerformanceForSets) setComparison).getPerformance(hashSet);
        ((PerformanceForSets) setComparison).getPerformance(linkedHashSet);
        ((PerformanceForSets) setComparison).getPerformance(treeSet);

        ((PerformanceForSets) setComparison).removePerformance(hashSet);
        ((PerformanceForSets) setComparison).removePerformance(linkedHashSet);
        ((PerformanceForSets) setComparison).removePerformance(treeSet);*/


        //MAPS

/*        Performance mapComparison = new PerformanceForMaps();

        Map<Integer, MyTriangle> hashMap = new HashMap<>();
        Map<Integer, MyTriangle> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, MyTriangle> treeMap = new TreeMap<>();

        ((PerformanceForMaps) mapComparison).addPerformance(hashMap);
        ((PerformanceForMaps) mapComparison).addPerformance(linkedHashMap);
        ((PerformanceForMaps) mapComparison).addPerformance(treeMap);

        ((PerformanceForMaps) mapComparison).getPerformance(hashMap);
        ((PerformanceForMaps) mapComparison).getPerformance(linkedHashMap);
        ((PerformanceForMaps) mapComparison).getPerformance(treeMap);

        ((PerformanceForMaps) mapComparison).removePerformance(hashMap);
        ((PerformanceForMaps) mapComparison).removePerformance(linkedHashMap);
        ((PerformanceForMaps) mapComparison).removePerformance(treeMap);*/

    }
}
