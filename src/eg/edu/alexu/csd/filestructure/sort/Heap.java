package eg.edu.alexu.csd.filestructure.sort;

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
	private ArrayList<INode<T>> array;

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
		return array.get(0);
	}

	@Override
	public int size() {
		return array.size();
	}

	@Override
	public void heapify(INode<T> node) {
		// TODO Auto-generated method stub

	}

	@Override
	public T extract() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(T element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void build(java.util.Collection<T> unordered) {
		array = new ArrayList<INode<T>>();
		for (T element : unordered) {
			insert(element);
		}
	}

}
