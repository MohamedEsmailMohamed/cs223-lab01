package eg.edu.alexu.csd.filestructure.sort.cs34;

import eg.edu.alexu.csd.filestructure.sort.IHeap;
import eg.edu.alexu.csd.filestructure.sort.INode;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Binary heap implementation.
 *
 * @author H
 *
 */
public class Heap<T extends Comparable<T>> implements IHeap<T> {

    /**
     * The ArrayList that holds the nodes of the p
     */
    public ArrayList<INode<T>> array;

    /**
     * Default constructor.
     */
    public Heap() {
        array = new ArrayList<INode<T>>();
    }

    /**
     * Copy constructor.
     * @param arrayIn ArrayList assumed heapified.
     */
    public Heap(final ArrayList<INode<T>> arrayIn) {
        array = arrayIn;
    }

    /**
     * Constructor that takes any regular collection and
     * generates heap with its elements.
     * @param arrayIn
     */
    public Heap(final Collection<T> arrayIn) {
        build(arrayIn);
    }

    @Override
    public INode<T> getRoot() {
        if (array == null || array.size() == 0) {
            return null;
        }
        return array.get(0);
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public void heapify(INode<T> node) {
        if (node == null) {
            throw new IllegalArgumentException("Insertion of null.");
        } else {
            while (node.getParent() != null // Heapifying up.
                    && node.getValue().compareTo(
                            node.getParent().getValue()
                            ) > 0) { // Greater than parent
                INode<T> parent = node.getParent();
                swap(parent, node);
                node = parent;
            }

            while (node.getLeftChild() != null) { // Heapifying down.
                INode<T> higherChild = null;
                 // Find higher child.
                if (node.getRightChild() != null) {
                    higherChild =
                            node.getLeftChild().getValue().compareTo(
                                    node.getRightChild().getValue()
                            ) > 0 ? node.getLeftChild() : node.getRightChild();
                } else {
                    higherChild = node.getLeftChild();
                }

                if (node.getValue().compareTo(
                        higherChild.getValue()
                ) < 0) {
                    swap(higherChild, node);
                    node = higherChild;
                } else {
                    break;
                }
            }
        }
    }

    @Override
    public T extract() {
        if (array == null || array.size() == 0) {
            return null;
        }
        final INode<T> maxNode = array.get(0); // Always holds extremest value.
        if (maxNode == null) {
            return null;
        } else {
            int lastIndex = array.size() - 1;
            T returner = maxNode.getValue();
            swap(maxNode, array.get(lastIndex));
            array.remove(lastIndex--); // Size decreases due to removal.
            if (array.size() > 1) {
            	heapify(maxNode);
            }
            return returner;
        }
    }

    @Override
    public void insert(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Insertion of null.");
        } else {
            final int index = array.size();
            INode<T> node = new ArrayHeapNode<T>(array, index, element);
            array.add(node);
            heapify(node);
        }

    }

    @Override
    public void build(java.util.Collection<T> unordered) {
        if (unordered == null) {
            throw new IllegalArgumentException("Can't build heap with null.");
        } else {
            array = new ArrayList<INode<T>>();
            for (T element : unordered) {
                insert(element);
            }
        }

    }

    /**
     * Returns a deep clone of this heap.
     * The values of the nodes are copied by reference.
     *
     * @return a clone of this heap
     */
    public IHeap<T> clone() {
        IHeap<T> heap = new Heap<T>();
        ((Heap<T>) heap).array = new ArrayList<INode<T>>(this.array.size());
        ArrayList<INode<T>> heapArray = ((Heap<T>) heap).array;

        for (INode<T> node : this.array) {
            heapArray.add(new ArrayHeapNode<T>(
                        heapArray, heapArray.size(), node.getValue()));
        }

        return heap;
    }

    /**
     * Percolates a node up to maintain the min-heap property.
     *
     * @param target node to percolate up
     */
    public void percolateUp(final INode<T> target) {
        INode<T> node = target;
        INode<T> parent = node.getParent();
        while (parent != null
                && ((ArrayHeapNode<T>) node).isLessThan(parent)) {
            swap(node, parent);
            node = parent;
            parent = node.getParent();
        }
    }

    /**
     * Builds a min-heap from the given collection of values.
     *
     * @param unordered the collection of values to build the heap from
     * @return this Heap after building
     */
    public IHeap<T> buildMinHeap(final java.util.Collection<T> unordered) {
        if (unordered == null) {
            throw new IllegalArgumentException("Can't build heap with null.");
        } else {
            array = new ArrayList<INode<T>>(unordered.size());

            for (T element : unordered) {
                INode<T> node = new ArrayHeapNode<T>(
                            array, array.size(), element);
                array.add(node);
                percolateUp(node);

                // Ensure that left child <= right child
                INode<T> parent = node.getParent();
                if (parent != null && parent.getRightChild() != null) {
                    INode<T> leftChild = parent.getLeftChild();
                    INode<T> rightChild = parent.getRightChild();
                    if (((ArrayHeapNode<T>) rightChild).isLessThan(leftChild)) {
                        swap(leftChild, rightChild);
                    }
                }
            }

            return this;
        }
    }

    /**
     * Returns an array of values representing the heap.
     *
     * @return an ArrayList<T> representing the heap
     */
    public ArrayList<T> getValues() {
        ArrayList<T> valuesArray = new ArrayList<T>(this.array.size());
        for (INode<T> node : this.array) {
            valuesArray.add(node.getValue());
        }
        return valuesArray;
    }

    /**
     * Swapping algorithm for the values in nodes.
     * Simply swaps the values in the two nodes but keeps
     * the two nodes in place as they are position
     * holders and not value holders.
     * @param node1
     * @param node2
     */
    private void swap(INode<T> node1, INode<T> node2) {
        T swapper;
        swapper = node1.getValue();
        node1.setValue(node2.getValue());
        node2.setValue(swapper);
    }

}
