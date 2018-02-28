package Test;

import eg.edu.alexu.csd.filestructure.sort.INode;
import eg.edu.alexu.csd.filestructure.sort.ISort;
import eg.edu.alexu.csd.filestructure.sort.cs34.ArrayHeapNode;
import eg.edu.alexu.csd.filestructure.sort.cs34.Sort;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class HeapSortTest {

    Integer[] unsortedArray = {2, 8, 5, 3, 9, 4, 1};
    Integer[] sortedArray = {1, 2, 3, 4, 5, 8, 9};
    ISort mISort = new Sort();

    @Test
    public void test1() {
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i < unsortedArray.length; i++) {
            array.add(unsortedArray[i]);
        }
        mISort.heapSort(array);
        for(int i = 0; i < sortedArray.length; i++) {
            Assert.assertEquals(array.get(i), sortedArray[i]);
        }

    }

    @Test
    public void testNull() {
        ArrayList<Integer> array = null;
        try {
            mISort.heapSort(array);
            Assert.fail();
            ArrayList<INode<Integer>> array2 = null;
            mISort.heapSort(array2);
            Assert.fail();
        } catch (Exception e) {
            //passed.
        }
    }

    @Test
    public void testNullElement() {
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i < unsortedArray.length; i++) {
            array.add(unsortedArray[i]);
        }
        array.add(2, null);
        try {
            mISort.heapSort(array);
            Assert.fail();
            ArrayList<INode<Integer>> array2 = new ArrayList<>();
            INode<Integer> node1 = new ArrayHeapNode<>();
            node1.setValue(50);
            INode<Integer> node2 = new ArrayHeapNode<>();
            node2.setValue(6);
            array2.add(node1);
            array2.add(null);
            array2.add(node2);
            mISort.heapSort(array2);
            Assert.fail();
        } catch (Exception e) {
            //passed.
        }
    }

}
