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

	private ArrayList<INode<T>> array;

	private int size;

	/**
	 * Default constructor.
	 */
	public Heap() {
		array = new ArrayList<INode<T>>();
		size = 0;
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
		array = new ArrayList<INode<T>>();
		for (T element : arrayIn) {
			insert(element);
		}
	}

	@Override
	public INode<T> getRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub

	}

}
