package eg.edu.alexu.csd.filestructure.sort.cs34;

import eg.edu.alexu.csd.filestructure.sort.IHeap;
import eg.edu.alexu.csd.filestructure.sort.INode;
import eg.edu.alexu.csd.filestructure.sort.ISort;

import java.util.ArrayList;

/**
 * ISort implementation.
 *
 * @param <T> type of node values
 */
public class Sort<T extends Comparable<T>> implements ISort<T> {
    @Override
    public final IHeap<T> heapSort(final ArrayList<T> unordered) {
        Heap<T> heap = new Heap<T>(unordered);
        unordered.clear();

        T element = heap.extract();
        while (element != null) {
            unordered.add(0, element);
            element = heap.extract();
        }

        ArrayList<INode<T>> heapArray =
            new ArrayList<INode<T>>(unordered.size());
        for (T val : unordered) {
            heapArray.add(
                    new ArrayHeapNode<T>(heapArray, heapArray.size(), val));
        }
        return new Heap<T>(heapArray);
    }

    //Bubble sort O(n^2).
    @Override
    public void sortSlow(ArrayList<T> unordered) {

        for (int i = 0; i < unordered.size() - 1; i++) {
            for (int j = 0; j < unordered.size() - 1; j++) {
                //greater than.
                if (unordered.get(j)
                        .compareTo(unordered.get(j + 1)) > 0) {
                    swap(unordered, j, j + 1);
                }
            }
        }
    }

    //Merge sort O(nlogn).
    @Override
    public void sortFast(ArrayList<T> unordered) {
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
    private void mergeSort(ArrayList<T> unordered) {
        if (unordered.size() == 1) { //base case.
            return;
        }

        //divide.
        int median = unordered.size() / 2;
        ArrayList<T> leftPart = new ArrayList<T>(unordered.subList(
                0, median));
        ArrayList<T> rightPart = new ArrayList<T>(unordered.subList
                (median, unordered.size()));

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
    private void merge(ArrayList<T> left, ArrayList<T> right, ArrayList<T> unordered) {
        int leftCounter, rightCounter, mergedCounter;
        leftCounter = rightCounter = mergedCounter = 0;
        while (leftCounter < left.size() && rightCounter < right.size()) {
            //greater than.
            if (left.get(leftCounter)
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
