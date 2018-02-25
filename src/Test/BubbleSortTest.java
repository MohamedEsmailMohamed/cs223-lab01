package Test;

import eg.edu.alexu.csd.filestructure.sort.ISort;
import eg.edu.alexu.csd.filestructure.sort.cs34.Sort;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BubbleSortTest {

    Integer[] unsortedArray = {2, 8, 5, 3, 9, 4, 1};
    Integer[] sortedArray = {1, 2, 3, 4, 5, 8, 9};
    ISort mISort = new Sort();

    @Test
    public void test1() {
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i < unsortedArray.length; i++) {
            array.add(unsortedArray[i]);
        }
        mISort.sortSlow(array);
        for(int i = 0; i < sortedArray.length; i++) {
            Assert.assertEquals(array.get(i), sortedArray[i]);
        }

    }
}
