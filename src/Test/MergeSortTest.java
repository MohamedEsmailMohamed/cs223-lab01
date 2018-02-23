package Test;

import eg.edu.alexu.csd.filestructure.sort.ISort;
import eg.edu.alexu.csd.filestructure.sort.Sort;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MergeSortTest {

    Integer[] unsortedArray = {15, 3, 2, 1, 9, 5, 7, 8, 6};
    Integer[] sortedArray = {1, 2, 3, 5, 6, 7, 8, 9, 15};
    ISort mISort = new Sort();

    @Test
    public void test1() {
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i < unsortedArray.length; i++) {
            array.add(unsortedArray[i]);
        }
        mISort.sortFast(array);
        System.out.println(array);
        for(int i = 0; i < sortedArray.length; i++) {
            Assert.assertEquals(array.get(i), sortedArray[i]);
        }

    }
}