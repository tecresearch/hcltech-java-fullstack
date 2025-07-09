package org.collectionframework.util;

public interface List<E> extends SequencedCollection<E>{


	void add(int index, E element);
	E get(int index);
	E set(int index, E element);
	E remove(int index);
	int indexOf(Object o);
	int lastIndexOf(Object o);
	List<E> subList(int fromIndex, int toIndex);

	
}
