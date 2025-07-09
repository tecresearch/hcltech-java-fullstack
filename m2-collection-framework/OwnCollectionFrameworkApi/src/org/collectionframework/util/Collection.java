/**
 * 
 */
package org.collectionframework.util;
import org.collectionframework.lang.Iterable;
import org.collectionframework.util.Collection;
import java.util.List;
import java.util.Set;
/**
 * 
 */
public interface Collection<E> extends Iterable<E>{

	    int size();
	    boolean isEmpty();
	    boolean contains(Object o);
	    boolean add(E e);
	    boolean remove(Object o);
	    boolean containsAll(Collection<?> c);
        /*now matches my custom Iterator must be implementation via each
	    classes if collection is implemented via any class	*/    
	    Iterator<E> iterator(); 
	    Object[] toArray();
	    <T> T[] toArray(T[] a);
	    boolean addAll(Collection<? extends E> c);
	    boolean removeAll(Collection<?> c);
	    boolean retainAll(Collection<?> c);
	    void clear();
	    boolean equals(Object o);
	    int hashCode();
	  
}
