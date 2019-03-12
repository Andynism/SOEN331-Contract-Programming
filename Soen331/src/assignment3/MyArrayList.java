package assignment3;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<E> implements List<E>{

	  private int size;	//number of elements in the array
		private E[] data;	//Array that contains the data

		//Constructor
		public MyArrayList(){
			this(10);
		}

		//Constructor with an initial capacity
	  public MyArrayList(int initialCapacity) {
	    	super();
		    if (initialCapacity < 0)
		    	throw new IllegalArgumentException("Wrong Capacity: " + initialCapacity);
		    this.data = (E[]) new Object[initialCapacity];
		}

	    //Check if the array as enough capacity to add a new element
	    public void checkCapacity(int capacityRequired) {
	    	if(capacityRequired - data.length > 0)
	    		doubleCapacity();
	    }

	    //Doubles the capacity of the array
	    public void doubleCapacity() {
	    	int newCapacity = data.length * 2;
	    	data = Arrays.copyOf(data, newCapacity);
	    }

	    //Divide the capacity in 2, if there is useless space
	    public void halfCapacity() {
	    	int newCapacity = data.length / 2;
	    	data = Arrays.copyOf(data, newCapacity);
	    }

	    //Add element e
		@Override
		public boolean add(E e) {
			checkCapacity(size + 1);
			data[size++] = e;
			return true;
		}

		//Add element e at a given index
		@Override
		public void add(int index, E element) {
			if (index > size || index < 0)
				throw new IndexOutOfBoundsException();

			checkCapacity(size + 1);
			System.arraycopy(data, index, data, index + 1, size - index);
			data[index] = element;
			size++;
		}

		//Clear the array completely
		@Override
		public void clear() {
			for(int i = 0; i < size; i++)
				data[i]=null;

			size=0;
		}

		//Remove and return an element at a given index
		@Override
		public E remove(int index) {
			if (index >= size || index < 0) {
				System.out.println("Wrong index");
				return null;
			}

			E valueToRemove = data[index];

			int numberOfElementsToMove = size - index -1;
			if(numberOfElementsToMove > 0 )
				System.arraycopy(data, index + 1, data, index, numberOfElementsToMove);
			data[--size] = null;
			if(size * 4 < data.length)
	    		halfCapacity();
			return valueToRemove;
		}

		//Remove a given object o from the array list
		@Override
		public boolean remove(Object o) {
			for(int i = 0; i < size; i++) {
				if(o.equals(data[i])) {
					int numberOfElementsToMove = size - i -1;
					if(numberOfElementsToMove > 0)
						System.arraycopy(data, i + 1, data, i, numberOfElementsToMove);
					data[--size] = null;
					if(size * 4 < data.length)
			    		halfCapacity();
					return true;
				}
			}
			return false;
		}

		//Return the arraylist information in a String
		@Override
		public String toString() {
			String result = "";
			for(int i = 0; i < size; i++) {
				result += data[i] + ", ";
			}
			 return "ArrayList: " + result;
		}

		//Return the size of the arraylist (the number of elements in it)
		@Override
		public int size() {
			return size;
		}

		@Override
		public E set(int index, E element) {
			data[index] = element;
			return element;
		}

		@Override
		public E get(int index) {
			return data[index];
		}




		//Useless methods


		@Override
		public boolean addAll(Collection<? extends E> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean addAll(int index, Collection<? extends E> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean contains(Object o) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public int indexOf(Object o) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean isEmpty() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Iterator<E> iterator() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int lastIndexOf(Object o) {
			throw new UnsupportedOperationException();
		}

		@Override
		public ListIterator<E> listIterator() {
			throw new UnsupportedOperationException();
		}

		@Override
		public ListIterator<E> listIterator(int index) {
			throw new UnsupportedOperationException();
		}


		@Override
		public boolean removeAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}


		@Override
		public List<E> subList(int fromIndex, int toIndex) {
			throw new UnsupportedOperationException();
		}

		@Override
		public Object[] toArray() {
			throw new UnsupportedOperationException();
		}

		@Override
		public <T> T[] toArray(T[] a) {
			throw new UnsupportedOperationException();
		}

	}

