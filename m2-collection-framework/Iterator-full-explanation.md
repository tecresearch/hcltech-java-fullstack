
# Understanding the `iterator()` Method in Java Collection Framework

## **The Core Issue**

You may have observed that the `iterator()` method appears in both the `Iterable` interface and the `Collection` interface. However, there is **no redeclaration** of the method in the `Collection` interface â€” it's just **inherited** from `Iterable`.

## **Hierarchy and Inheritance**

### **1. `Iterable` Interface:**

The `Iterable` interface defines the contract for iteration:

```java
public interface Iterable<T> {
    Iterator<T> iterator(); // Declared here
}
```

- **Purpose**: The `iterator()` method allows a class that implements `Iterable` to be iterated using an `Iterator`.

### **2. `Collection` Interface:**

The `Collection` interface extends `Iterable`, so it inherits the `iterator()` method:

```java
public interface Collection<E> extends Iterable<E> {
    // `iterator()` is inherited from Iterable, so no need to redeclare it here.
    Iterator<E> iterator();  // Technically inherited from Iterable but available here for clarity.

    // Other methods like add(), remove(), size(), etc.
}
```

- **Note**: The `Collection` interface doesn't **redeclare** `iterator()`. Instead, it **inherits** it from `Iterable`, but Java shows it in the `Collection` interface for clarity and to make it explicit that all `Collection` types have an `iterator()` method.

### **3. Concrete Implementations (e.g., `ArrayList`):**

Any class that implements `Collection`, such as `ArrayList`, will provide its own implementation of the `iterator()` method:

```java
public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable {

    @Override
    public Iterator<E> iterator() {
        return new Itr();  // Inner class Itr implements Iterator<E>
    }
}
```

- **The actual implementation**: `ArrayList` provides its own `iterator()` implementation to iterate over the elements.

### **4. `Itr` Class Implementation:**

The `Itr` class is an inner class of `ArrayList`, which implements the `Iterator` interface to provide iteration functionality. Here's an example of how the `Itr` class works:

```java
private class Itr implements Iterator<E> {
    private int cursor = 0; // The current position in the list

    @Override
    public boolean hasNext() {
        return cursor < size;  // Checks if there's another element
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return elementData[cursor++];  // Returns the current element and moves to the next
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
```

- **Explanation**:
  - `hasNext()`: Returns `true` if there are more elements to iterate over.
  - `next()`: Returns the next element in the list and advances the cursor.
  - `remove()`: Throws `UnsupportedOperationException` because removing elements directly via the iterator is not supported here.

---

## **Why Does `iterator()` Appear in `Collection`?**

Although `Collection` inherits `iterator()` from `Iterable`, it **appears in `Collection`** for the following reasons:

1. **Visibility and Clarity**: It ensures that any collection class (like `ArrayList`, `HashSet`) explicitly follows the iteration contract and can be used in enhanced for-loops.
2. **No Redundancy**: The `iterator()` method **is not redeclared** in `Collection`. It is simply **inherited from `Iterable`**, but shown in the `Collection` interface to make the iteration method explicit and clear for developers.
3. **Design Philosophy**: Java collections like `ArrayList`, `HashSet`, and others **must** provide an `iterator()` method, which is made visible through `Collection` (even though inherited from `Iterable`).

---

## **Summary of Key Concepts**

| Interface       | `iterator()` Declaration  | Why Appears Here |
|-----------------|---------------------------|------------------|
| `Iterable<E>`   | Yes                       | Defines the iteration contract for classes to implement. |
| `Collection<E>` | No (inherited)            | Inherited from `Iterable`, shown explicitly for clarity and consistency. |
| `ArrayList<E>`  | Yes (implemented)         | Provides its own implementation of `iterator()` to support iteration. |


---

## **Is it Compulsory to Show `iterator()` in `Collection`?**

No, it is **not compulsory** to explicitly show the `iterator()` method in the `Collection` interface, because:

- `Collection` **inherits** it from `Iterable`.
- Even if itâ€™s not shown explicitly, itâ€™s still available due to inheritance.

### Then why is it shown?
- **Documentation clarity**: To remind developers that collections can be iterated.
- **Readability**: Makes the contract clear without checking the parent interface.

### What happens if not shown?
**Nothing breaks.** The method is inherited. It's shown for better developer understanding, not for compiler necessity.

---

## **Is it Compulsory for All Classes to Provide Body of `iterator()`?**

### 1. If a class implements `Iterable` or `Collection` directly:
Yes, it **must** provide a body for `iterator()` unless itâ€™s an **abstract class** or inherits it from a superclass.

```java
public class MyList<T> implements Iterable<T> {
    public Iterator<T> iterator() {
        // Must provide logic here
    }
}
```

### 2. If a class extends an abstract class like `AbstractList`:
Not necessarily. The method can be inherited.

```java
public class MyArrayList<E> extends AbstractList<E> {
    // No need to override iterator() unless custom behavior is needed
}
```

### Summary Table

| Class Type | Needs to Implement `iterator()`? | Notes |
|------------|-------------------------------|-------|
| Interface (`Collection`, `Iterable`) | **No** | Only declares method (no body). |
| Concrete class implementing `Collection` | **Yes** | Must implement unless inherited. |
| Abstract class | **Optional** | Can declare or implement; subclass must handle it. |
| Extending class with inherited implementation | **No** | Inherits method. |

---

## **Conclusion**

---

- The `iterator()` method is **inherited** from `Iterable` to `Collection`.  
- `Collection` does not **redeclare** `iterator()`. It **inherits** it, and the method is visible in the `Collection` interface for clarity.
- **No conflict** arises because of this inheritance.

This design ensures that all collections, such as `ArrayList`, `HashSet`, etc., implement the `iterator()` method, and they can be used seamlessly in enhanced for-loops.
---
- `iterator()` is inherited from `Iterable` to `Collection`.
- Itâ€™s not **mandatory** to show it in `Collection`, but itâ€™s done for clarity.
- All concrete classes **must implement** it unless inherited.
- `ArrayList` provides its own implementation using an inner `Itr` class.

```
                                          Brijesh Nishad
                                   (SDE-Java Fullstack Developer)
           


```

                          
