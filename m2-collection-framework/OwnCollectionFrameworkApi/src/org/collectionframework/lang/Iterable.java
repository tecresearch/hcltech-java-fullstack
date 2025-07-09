package org.collectionframework.lang;

import org.collectionframework.util.Iterator;

public interface Iterable<E> {
	Iterator<E> iterator();
}
