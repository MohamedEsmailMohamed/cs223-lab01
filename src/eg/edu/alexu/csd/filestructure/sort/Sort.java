package eg.edu.alexu.csd.filestructure.sort;

import java.awt.*;
import java.util.ArrayList;

/**
 * ISort implementation.
 */
public class Sort<T extends Comparable<T>> implements ISort {
    @Override
    public IHeap<T> heapSort(ArrayList unordered) {
        Heap<T> heap = new Heap(unordered);
        Heap<T> heap2 = new Heap((ArrayList) unordered.clone());
        unordered.clear();
        T element = heap.extract();
        while (element != null) {
            unordered.add(0, element);
            element = heap.extract();
        }
        return heap2;
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
        mergeSort(unordered);
    }

    /**
     * Swaps the given to values in the given arrayArrayList.
     *
     * @param unordered given arrayArrayList.
     * @param first     first value.
     * @param second    second value.
     */
    private void swap(ArrayList<T> unordered, int first, int second) {
        T temp = unordered.get(first);
        unordered.set(first, unordered.get(second));
        unordered.set(second, temp);
    }

    /**
     * Recursive method for merge sort.
     *
     * @param unordered ArrayList to be sorted.
     * @return the sorted ArrayList.
     */
    private void mergeSort(ArrayList unordered) {
        if (unordered.size() == 1) { //base case.
            return;
        }

        //divide.
        int median = unordered.size() / 2;
        ArrayList leftPart = new ArrayList();
        ArrayList rightPart = new ArrayList();
        for(int i = 0; i < unordered.size(); i++) {
            if(i < median) {
                leftPart.add(unordered.get(i));
            } else {
                rightPart.add(unordered.get(i));
            }
        }

        //recursive.
        mergeSort(leftPart);
        mergeSort(rightPart);

        //conquer.
        merge(leftPart, rightPart, unordered);
    }

    /**
     * Sorts and merges two given ArrayLists into one.
     *
     * @param left  first ArrayList to be sorted.
     * @param right second ArrayList to be sorted.
     * @return the merged ArrayList.
     */
    private void merge(ArrayList left, ArrayList right, ArrayList unordered) {
        int leftCounter, rightCounter, mergedCounter;
        leftCounter = rightCounter = mergedCounter = 0;
        while (leftCounter < left.size() && rightCounter < right.size()) {
            //greater than.
            if (((Comparable) left.get(leftCounter))
                    .compareTo(right.get(rightCounter)) > 0) {
                unordered.set(mergedCounter++, right.get(rightCounter++));
            } else {
                unordered.set(mergedCounter++, left.get(leftCounter++));
            }
        }
        while (leftCounter < left.size()) {
            unordered.set(mergedCounter++, left.get(leftCounter++));
        }
        while (rightCounter < right.size()) {
            unordered.set(mergedCounter++, right.get(rightCounter++));
        }
    }
}
