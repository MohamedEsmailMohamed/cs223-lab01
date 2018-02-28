package Test;

import eg.edu.alexu.csd.filestructure.sort.IHeap;
import eg.edu.alexu.csd.filestructure.sort.INode;
import eg.edu.alexu.csd.filestructure.sort.cs34.Heap;
import org.junit.Assert;
import org.junit.Test;

public class HeapTest {

    Integer[] array = {1,2,3,4,5,6,7};
    Integer[] sortedarray = {7,6,5,4,3,2,1};
    @Test
    public void test1() {
        Heap<Integer> heap = new Heap();
        for(int i = 0; i< array.length; i++) {
            heap.insert(array[i]);
        }
        for (INode<Integer> i : heap.array) {
            System.out.print(i.getValue() + "  ");
        }
        for(int i = 0; i < sortedarray.length; i++) {
            Integer x = heap.extract();
            System.out.println("extracted: " + x + "___________________________________");
            for (INode<Integer> j : heap.array) {
                System.out.print(j.getValue() + "  ");
            }
        }

    }
}
