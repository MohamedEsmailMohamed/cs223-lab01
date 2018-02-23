package eg.edu.alexu.csd.filestructure.sort;

import com.sun.corba.se.spi.ior.ObjectKey;
import com.sun.org.apache.bcel.internal.generic.INEG;
import sun.net.www.content.text.Generic;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * ISort implementation.
 *
 */
public class Sort implements ISort {
    @Override
    public IHeap heapSort(ArrayList unordered) {
        return null;
    }

    //Bubble sort O(n^2).
    @Override
    public void sortSlow(ArrayList unordered) {

        for (int i = 0; i < unordered.size() - 1; i++) {
            for (int j = 0; j < unordered.size() - 1; j++) {
                //greater than.
                if (((Comparable) unordered.get(j))
                        .compareTo(unordered.get(j + 1)) > 0) {
                    swap(unordered, j, j + 1);
                }
            }
        }
    }

    //Merge sort O(nlogn).
    @Override
    public void sortFast(ArrayList unordered) {

       unordered =  mergeSort(unordered);
    }

    /**
     * Swaps the given to values in the given arraylist.
     * @param unordered
     *                  given arraylist.
     * @param first
     *              first value.
     * @param second
     *              second value.
     */
    private void swap(ArrayList unordered, int first, int second) {
        Object temp = unordered.get(first);
        unordered.set(first, unordered.get(second));
        unordered.set(second, temp);
    }

    /**
     * Recursive method for merge sort.
     * @param unordered
     *                  arrayList to be sorted.
     * @return
     *          the sorted arraylist.
     */
    private ArrayList mergeSort(ArrayList unordered) {
        if(unordered.size() == 1) { //base case.
            return unordered;
        }

        //divide.
        int median = unordered.size() / 2;
        ArrayList leftPart = (ArrayList)unordered.subList(0, median);
        ArrayList rightPart = (ArrayList)unordered.subList( median + 1, unordered.size());

        //recursive.
        leftPart = mergeSort(leftPart);
        rightPart = mergeSort(rightPart);

        //conquer.
        return merge(leftPart, rightPart);
    }

    /**
     * Sorts and merges two given arraylists into one.
     * @param left
     *              first arraylist to be sorted.
     * @param right
     *              second arraylist to be sorted.
     * @return
     *         the merged arraylist.
     */
    private ArrayList merge(ArrayList left, ArrayList right) {
        ArrayList mergedArray = new ArrayList(left.size() + right.size());
        int leftCounter, rightCounter;
        leftCounter = rightCounter = 0;
        while (leftCounter < left.size() && rightCounter < right.size()) {
            //greater than.
            if(((Comparable) left.get(leftCounter))
                    .compareTo(right.get(rightCounter)) > 0) {
                mergedArray.add(right.get(rightCounter++));
            } else {
                mergedArray.add(left.get(leftCounter++));
            }
        }
        while(leftCounter < left.size()) {
            mergedArray.add(left.get(leftCounter++));
        }
        while(rightCounter < right.size()) {
            mergedArray.add(left.get(rightCounter++));
        }
        return mergedArray;
    }
}
