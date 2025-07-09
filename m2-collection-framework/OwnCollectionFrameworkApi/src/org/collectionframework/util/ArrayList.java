package org.collectionframework.util;


public class ArrayList<E> implements List<E> {

    private Object[] elementData;
    private int size = 0;
    private int capacity = 10;

    public ArrayList() {
        elementData = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean add(E e) {
        ensureCapacity();
        elementData[size++] = e;
        return true;
    }

    @Override
    public void add(int index, E element) {
        checkIndexForAdd(index);
        ensureCapacity();
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = element;
        size++;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) elementData[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E old = (E) elementData[index];
        elementData[index] = element;
        return old;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E removed = (E) elementData[index];
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[--size] = null;
        return removed;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (elementData[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = elementData[i];
        }
        return result;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            // Create a new array of the same runtime type and size
            T[] newArray = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
            for (int i = 0; i < size; i++) {
                newArray[i] = (T) elementData[i];
            }
            return newArray;
        }
        for (int i = 0; i < size; i++) {
            a[i] = (T) elementData[i];
        }
        if (a.length > size) {
            a[size] = null; // Null termination
        }
        return a;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<?> it = c.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Iterator<? extends E> it = c.iterator();
        boolean modified = false;
        while (it.hasNext()) {
            add(it.next());
            modified = true;
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        Iterator<?> it = c.iterator();
        while (it.hasNext()) {
            if (remove(it.next())) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(elementData[i])) {
                remove(i);
                i--; // Adjust index after remove
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        ArrayList<E> sublist = new ArrayList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            sublist.add(get(i));
        }
        return sublist;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public E next() {
                return (E) elementData[cursor++];
            }

			@Override
			public void remove() {
				System.out.println("Optional");
			}
        };
    }

    
    private void ensureCapacity() {
        if (size >= capacity) {
            capacity = capacity * 2;
            Object[] newArray = new Object[capacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = elementData[i];
            }
            elementData = newArray;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index);
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index: " + index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
    
    
    @Override
    public SequencedCollection<E> reversed() {
        return new SequencedCollection<E>() {
            @Override
            public Iterator<E> iterator() {
                return new Iterator<E>() {
                    int cursor = size - 1;

                    @Override
                    public boolean hasNext() {
                        return cursor >= 0;
                    }

                    @Override
                    public E next() {
                        return (E) elementData[cursor--];
                    }

                    @Override
                    public void remove() {
                        // optional - leave empty or implement if needed
                    }
                    
                };
            }

            @Override
            public int size() {
                return size;
            }

            @Override
            public boolean isEmpty() {
                return size == 0;
            }

            @Override
            public boolean contains(Object o) {
                return ArrayList.this.contains(o);
            }

            @Override
            public boolean add(E e) {
                return ArrayList.this.add(e);
            }

            @Override
            public boolean remove(Object o) {
                return ArrayList.this.remove(o);
            }

            @Override
            public SequencedCollection<E> reversed() {
                return ArrayList.this; // reverse of reverse is original
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                Iterator<?> it = c.iterator();
                while (it.hasNext()) {
                    if (!contains(it.next())) {
                        return false;
                    }
                }
                return true;
            }

            @Override
            public Object[] toArray() {
                Object[] result = new Object[size()];
                int index = 0;
                Iterator<E> it = iterator();
                while (it.hasNext()) {
                    result[index++] = it.next();
                }
                return result;
            }

            @Override
            public <T> T[] toArray(T[] a) {
                int s = size();
                if (a.length < s) {
                    a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), s);
                }

                int i = 0;
                Iterator<E> it = iterator();
                while (it.hasNext()) {
                    a[i++] = (T) it.next();
                }

                if (a.length > s) {
                    a[s] = null;
                }

                return a;
            }

            @Override
            public boolean addAll(Collection<? extends E> c) {
                boolean modified = false;
                Iterator<? extends E> it = c.iterator();
                while (it.hasNext()) {
                    if (add(it.next())) {
                        modified = true;
                    }
                }
                return modified;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                boolean modified = false;
                Iterator<E> it = iterator();
                while (it.hasNext()) {
                    E e = it.next();
                    if (c.contains(e)) {
                        remove(e);
                        modified = true;
                    }
                }
                return modified;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                boolean modified = false;
                Iterator<E> it = iterator();
                while (it.hasNext()) {
                    E e = it.next();
                    if (!c.contains(e)) {
                        remove(e);
                        modified = true;
                    }
                }
                return modified;
            }

            @Override
            public void clear() {
                ArrayList.this.clear();
            }
        };
    }
    
    

}
