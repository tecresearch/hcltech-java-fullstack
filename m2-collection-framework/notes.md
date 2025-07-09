## Notes------>

## Collection Framework

The Collection Framework in Java is a unified architecture for storing and manipulating groups of objects. It provides a
set of interfaces and classes that implement them, catering to various data structures and algorithms.

### Basics of Collection Framework

#### 1. **Core Interfaces**

- **What is the `Collection` interface in Java?**  
  The `Collection` interface is the root interface of the Collection Framework. It provides a unified architecture for
  storing and manipulating groups of objects. Subinterfaces of `Collection` include `List`, `Set`, and `Queue`.

- **What are the differences between `List`, `Set`, and `Queue`?**
  - `List`: An ordered collection that allows duplicate elements. Examples include `ArrayList`, `LinkedList`.
  - `Set`: A collection that does not allow duplicate elements. Examples include `HashSet`, `TreeSet`.
  - `Queue`: A collection used to hold elements prior to processing, often ordered by priority. Examples include
    `PriorityQueue`, `LinkedList`.

- **What is the `Map` interface and how is it different from `Collection`?**  
  The `Map` interface represents a collection of key-value pairs where each key is unique. Unlike `Collection`, it does
  not extend the `Collection` interface. Examples include `HashMap`, `TreeMap`.

- **What is the difference between `ArrayList` and `Vector`?**  
  `ArrayList` is not synchronized, making it faster but not thread-safe. `Vector`, on the other hand, is synchronized,
  offering thread safety at the cost of performance.

- **What is the difference between `HashSet` and `TreeSet`?**  
  `HashSet` is based on a hash table and does not guarantee any order of elements. `TreeSet` is based on a tree
  structure and provides elements in sorted (natural or custom) order.

- **How does `HashMap` handle collisions?**  
  `HashMap` uses a technique called chaining. It stores multiple elements in a single bucket using a linked list or,
  since Java 8, a balanced tree for improved performance when many collisions occur.

- **What are the differences between `Array` and `ArrayList`?**
  - `Array` is a fixed-size data structure, while `ArrayList` is resizable.
  - `Array` can hold both primitive data types and objects, whereas `ArrayList` can only hold objects.
  - `ArrayList` provides more flexibility and operations (e.g., dynamic resizing, element insertion).

- **Why should you override the `hashCode` and `equals` methods?**  
  These methods are used to determine equality for objects stored in hash-based collections (`HashMap`, `HashSet`).
  Failing to override these methods consistently can lead to data integrity issues, such as duplicate entries in
  `HashSet` or unexpected behavior in `HashMap`.

- **What is the difference between `fail-fast` and `fail-safe` iterators?**
  - `Fail-fast`: Throws a `ConcurrentModificationException` if the collection is modified while iterating (e.g.,
    `ArrayList`, `HashMap`).
  - `Fail-safe`: Allows modifications during iteration by working on a clone of the collection (e.g.,
    `CopyOnWriteArrayList`, `ConcurrentHashMap`).

- **What are bulk operations in the Collection Framework?**  
  These are operations that perform actions in bulk, such as `addAll()`, `removeAll()`, `retainAll()`, and `clear()`.
#### 2. **Key Classes**

- **When would you use `ArrayList` over `LinkedList`?**  
  Use `ArrayList` for fast random access and if frequent modifications are not required. Use `LinkedList` for scenarios
  requiring frequent insertions and deletions.

- **What is a `HashSet` and how does it ensure uniqueness?**  
  A `HashSet` is a hash table-based implementation of the `Set` interface that uses a hash code to ensure uniqueness of
  elements.

- **What is the purpose of a `PriorityQueue`?**  
  A `PriorityQueue` is a queue that orders elements based on their priority. It is typically implemented using a heap
  data structure.

#### 3. **Advantages**

- **Why should you use the Collection Framework?**
  - It reduces programming effort by providing ready-made data structures.
  - Enhances performance due to optimized and tested code.
  - Increases code maintainability by adhering to consistent design patterns.

### Advanced Concepts

#### 1. **NavigableMap and NavigableSet**

- **What is the purpose of `NavigableMap` and `NavigableSet`?**  
  These interfaces provide additional navigation methods like `lower()`, `higher()`, `ceiling()`, and `floor()` for
  searching and traversal within a range.

#### 2. **Concurrency in Collections**

- **What are the thread-safe alternatives to collections in Java?**
  - Synchronized Wrappers: `Collections.synchronizedList()` or `Collections.synchronizedMap()` for basic thread
    safety.
  - Concurrent Collections: `ConcurrentHashMap` (efficient concurrent map) or `CopyOnWriteArrayList` (read-optimized
    threadsafe list).

- **What is the difference between `ConcurrentHashMap` and `HashMap`?**
  - `HashMap` is not thread-safe whereas `ConcurrentHashMap` allows concurrent access without locking the entire map.

#### 3. **Stream API**

- **How does the Stream API simplify collection processing?**  
  It allows functional-style operations like filtering, mapping, and reducing. For example:
  ```java
  list.stream()
      .filter(s -> s.startsWith("A"))
      .map(String::toUpperCase)
      .forEach(System.out::println);
  ```

#### 4. **Custom Implementations**

- **How do you create a custom collection?**  
  You can extend abstract classes such as `AbstractList`, `AbstractSet`, or directly implement collection interfaces
  while defining all mandatory methods.

#### 5. **Generics**

- **What are the benefits of using Generics in collections?**
  - Ensures compile-time type safety.
  - Eliminates the need for casting while retrieving elements.
  - Avoids runtime `ClassCastException`.

### Comparison of Collection Types:

| Feature                | List               | Set                 | Queue                     | Map                       |
|------------------------|--------------------|---------------------|---------------------------|---------------------------|
| **Duplicates Allowed** | Yes                | No                  | Varies                    | Keys: No, Values: Yes     |
| **Ordered**            | Yes (List based)   | No                  | Yes                       | Based on Implementation   |
| **Performance**        | Fast random access | Fast unique lookups | Depends on implementation | Depends on Implementation |

#### FAQs on Collection Types:

- **Can a `Set` contain duplicate elements?**  
  No, `Set` does not allow duplicates. If an element is added that is already present, it overwrites the existing
  element.

- **What kind of ordering does a `TreeSet` provide?**  
  A `TreeSet` provides elements in a natural sorted order (or according to a custom comparator).

### Thread Safety in Collections:

| Feature             | Synchronized                               | Concurrent                                       |
|---------------------|--------------------------------------------|--------------------------------------------------|
| **Example Classes** | Vector, Hashtable                          | ConcurrentHashMap, CopyOnWriteArrayList          |
| **Use Case**        | Small apps requiring basic synchronization | Applications requiring efficient multi-threading |

#### FAQs on Thread Safety:

- **What are the disadvantages of synchronized collections?**  
  They tend to be slow due to the overhead of locking, especially in highly concurrent applications. Using concurrent
  utilities like `ConcurrentHashMap` often improves performance.

- **When should you use `CopyOnWriteArrayList`?**  
  Use it when the number of reads greatly outnumbers writes, such as caching scenarios or event listener lists.

### Algorithms Provided in Collections

- **What algorithms are provided by the `Collections` utility class?**
  - **Sorting**: Sorts elements using their natural order or a provided comparator.
  - **Searching**: Performs binary search on sorted collections.
  - **Shuffling**: Randomizes the order of elements.
  - **Reversing**: Reverses the order of elements.

#### Code Examples:

1. **Sorting**:
   ```java
   Collections.sort(list);
   ```
2. **Searching**:
   ```java
   int index = Collections.binarySearch(list, "key");
   ```
3. **Reversing**:
   ```java
   Collections.reverse(list);
   ```
4. **Shuffling**:
   ```java
   Collections.shuffle(list);
   ```

### Summary:

The Collection Framework offers standardized, efficient ways to manipulate, navigate, and store data, covering
everything from beginner-friendly `List`, `Set`, and `Map` collections to advanced concurrency utilities and custom
implementations.

### 1 to 100 Top Interview Q&A on Collection Framework

1. **What is the Java Collection Framework?**
   The Java Collection Framework is a unified architecture for storing and manipulating groups of objects. It includes
   interfaces and classes for different types of collections like `List`, `Set`, and `Map`.
2. **What are the core interfaces of the Collection Framework?**
- `Collection`: Root interface representing a group of objects.
- `List`: Ordered collection allowing duplicates (`ArrayList`, `LinkedList`).
- `Set`: Unordered collection prohibiting duplicates (`HashSet`, `TreeSet`).
- `Queue`: Represents a collection for holding elements before processing (`LinkedList`, `PriorityQueue`).
- `Map`: Represents key-value pairs (`HashMap`, `TreeMap`).
3. **What is the difference between `Set` and `List`?**
- A `List` allows ordered and duplicate elements, while a `Set` doesn’t allow duplicates and generally doesn’t
  maintain order.

4. **What is the difference between `ArrayList` and `Vector`?**
- `ArrayList` is not synchronized (faster but not thread-safe), while `Vector` is synchronized (thread-safe but
  slower).
5. **What is a `HashMap`?**
- `HashMap` is a collection that stores key-value pairs, allows one `null` key, and is not synchronized.
6. **What is a `TreeMap`?**
- `TreeMap` is a `Map` that stores key-value pairs in sorted order (natural or custom) and doesn’t allow `null` keys.
7. **What is a `LinkedHashMap`?**
- `LinkedHashMap` maintains a predictable iteration order (insertion order or access order) and allows one `null` key.
8. **Why should you override the `equals` and `hashCode` methods?**
- To ensure proper functioning of hash-based collections (`HashSet`, `HashMap`), since they depend on these methods
  for element uniqueness and key equality.
9. **When would you use a `HashSet` over a `TreeSet`?**
- Use a `HashSet` when you don’t care about element order and need fast performance. Use a `TreeSet` when you need
  elements in sorted order.
10. **What is a `PriorityQueue`?**
- A `PriorityQueue` is used to process elements based on their priority, rather than insertion order.
11. **What is the purpose of `ConcurrentHashMap`?**
- `ConcurrentHashMap` allows efficient thread-safe concurrent access without locking the entire map.
12. **What is the difference between `HashMap` and `Hashtable`?**
- `HashMap` is not synchronized and allows `null` keys, whereas `Hashtable` is synchronized and doesn’t allow `null`
  keys.
13. **Describe the fail-fast and fail-safe behavior of iterators.**
- Fail-fast iterators throw a `ConcurrentModificationException` if the collection is structurally modified while
  iterating. Fail-safe iterators work on a copy, allowing modifications without exceptions.
14. **What is the difference between `ListIterator` and `Iterator`?**
- `Iterator` only allows forward traversal, whereas `ListIterator` supports bidirectional traversal with add/remove
  capabilities.
15. **What are the advantages of using Generics in the Collection Framework?**
- Compile-time type safety.
- Avoids explicit casting while retrieving elements.
- Reduces the risk of `ClassCastException`.
16. **Why should we prefer `ArrayList` over arrays?**
- `ArrayList` provides dynamic resizing, flexibility, and built-in methods for operations like insertion and removal.
17. **How does `HashMap` handle collisions?**
- `HashMap` uses chaining. Since Java 8, it leverages balanced trees to optimize performance for high collision
  scenarios.
18. **What is the difference between `ArrayList` and `LinkedList`?**
- `ArrayList` provides faster random access, while `LinkedList` provides more efficient insertion, deletion, and memory
  usage for frequent modifications.
19. **What is the use of the `Collections` utility class?**
- It provides utility methods for sorting, searching, reversing, shuffling, and more.
20. **Explain the `Comparable` and `Comparator` interfaces.**
- `Comparable` is used for natural ordering through `compareTo()` in the class itself.
- `Comparator` allows custom ordering by defining an external `compare()` method.
  *... [continue up to 100, including diverse and frequently asked concepts like custom implementations, concurrency, and stream API usage]*
  246:21. **What is the difference between fail-fast and fail-safe iterators?**  
  247:    - **Fail-fast**: Operates directly on the collection. It throws `ConcurrentModificationException` if the
  collection  
  248:      is modified structurally while iterating (e.g., `ArrayList`, `HashMap`).
  249:    - **Fail-safe**: Works on a copy of the collection, hence does not throw exceptions during modification  
  250:      (e.g., `CopyOnWriteArrayList`, `ConcurrentHashMap`).

251:22. **What are `WeakHashMap` and its use cases?**  
252:    - `WeakHashMap` is a `Map` implementation that uses weak references for keys.
253:    - Keys are automatically removed when they are no longer in ordinary use, helping reduce memory leaks.

254:23. **How does `Collections.synchronizedList` differ from `CopyOnWriteArrayList`?**  
255:    - `Collections.synchronizedList` wraps an existing list with synchronized methods, providing thread safety, but
it  
256:      doesn’t avoid `ConcurrentModificationException`.
257:    - `CopyOnWriteArrayList` creates a new copy of the list during write operations and is designed for scenarios
where  
258:      reads vastly outnumber writes.

259:24. **What is `EnumSet`?**  
260:    - `EnumSet` is a high-performance `Set` implementation designed specifically for enums.  
261:    - It is fast, compact, and internally uses bit vectors for storage.

262:25. **How does `LinkedHashSet` maintain insertion order?**  
263:    - `LinkedHashSet` internally uses a linked list to remember the order in which elements are inserted.

264:26. **What are the differences between `TreeMap` and `LinkedHashMap`?**  
265:    - `TreeMap` maintains all entries in a sorted order, whereas `LinkedHashMap` maintains them in the order of
insertion.  
266:    - `TreeMap` has higher overhead when sorting the entries.

267:27. **What is the purpose of `Deque` in Java?**  
268:    - `Deque` represents a double-ended queue that allows adding or removing elements at both ends.  
269:    - Implementations include `ArrayDeque` and `LinkedList`.

270:28. **What is `NavigableMap`?**  
271:    - `NavigableMap` is a sub-interface of `SortedMap` that provides methods to navigate keys (like `ceilingKey`,  
272:      `floorKey`) or get a reverse view of the map.

273:29. **How does `PriorityBlockingQueue` work?**  
274:    - `PriorityBlockingQueue` is a thread-safe implementation of `PriorityQueue`.  
275:    - It leverages priority ordering and allows multiple threads to operate concurrently.

276:30. **What is the difference between `ConcurrentSkipListMap` and `TreeMap`?**  
277:    - `ConcurrentSkipListMap` is a thread-safe variant and supports concurrent access by multiple threads.  
278:    - `TreeMap` is not thread-safe by default but offers slightly better performance in single-threaded scenarios.

31. **How does `ArrayDeque` differ from `LinkedList` when used as a `Deque`?**
- `ArrayDeque` is faster than `LinkedList` as it doesn’t involve node-based memory overhead.
- It is a better choice when frequent additions and removals are performed both at the front and back.

32. **What is the difference between `HashSet` and `TreeSet`?**
- `HashSet` doesn’t guarantee any order of elements, while `TreeSet` maintains elements in sorted order.
- `TreeSet` has slightly higher performance costs due to sorting.

33. **What is the difference between `remove(Object o)` and `remove(int index)` in a `List`?**
- `remove(Object o)` removes the first occurrence of a specific object.
- `remove(int index)` removes the element at the specified position in the list.

34. **What is the difference between `poll()` and `remove()` in a `Queue`?**
- `poll()` retrieves and removes the head of the queue, returning `null` if the queue is empty.
- `remove()` also retrieves and removes the head of the queue but throws an exception if the queue is empty.

35. **What is the role of `toArray()` in a collection?**
- `toArray()` converts a collection into an array, allowing further manipulation of elements in array form.

36. **What is the difference between `peek()` and `element()` in a `Queue`?**
- `peek()` retrieves but does not remove the head of the queue or returns `null` if the queue is empty.
- `element()` retrieves but does not remove the head of the queue but throws an exception if the queue is empty.

37. **How does `LinkedList` implement both `List` and `Deque` interfaces?**
- `LinkedList` is a doubly-linked list, hence it provides index-based operations of `List` and front/rear operations
  of `Deque`.

38. **What is the use of `Comparator.nullsFirst()` and `Comparator.nullsLast()`?**
- `nullsFirst()` and `nullsLast()` are used to handle `null` values while sorting using a comparator.
- `nullsFirst()` orders `null` values before non-null values.
- `nullsLast()` orders `null` values after non-null values.

39. **What are the differences between `HashSet` and `LinkedHashSet`?**
- `HashSet` doesn’t maintain any iteration order.
- `LinkedHashSet` maintains the insertion order of elements.

40. **What is a `BitSet` in Java?**
- `BitSet` is a class that implements a vector of bits, allowing you to manage and operate on large sets of bits (
  e.g., flags).

41. **What are the performance differences between `HashMap` and `TreeMap`?**
- `HashMap` offers constant-time performance for key-value insertion, lookup, and deletion.
- `TreeMap` provides logarithmic time performance but keeps entries sorted.

42. **How does `Collections.unmodifiableList()` work?**
- It creates a read-only wrapper over the given list, throwing `UnsupportedOperationException` for modifying
  operations.

43. **What is a `Queue` and where can it be used?**
- `Queue` represents a collection for holding elements in a FIFO (First-In-First-Out) manner.
- It is used in scenarios like task scheduling, print job management, producer-consumer systems, etc.

44. **What is an `IdentityHashMap`?**
- `IdentityHashMap` is a `Map` implementation that uses reference equality (`==`) instead of value equality (`equals`)
  to compare keys.

45. **Explain the difference between `Arrays.asList()` and `List.of()` in Java.**
- `Arrays.asList()` returns a list backed by the array, hence it’s mutable but has a fixed size.
- `List.of()` creates an immutable list that doesn’t allow modifications.

46. **How does `TreeSet` implement sorting?**
- `TreeSet` uses a `Comparator` or the natural ordering of its elements (via `Comparable`) to maintain a sorted order.

47. **What is the difference between `HashMap`, `LinkedHashMap`, and `TreeMap`?**
- `HashMap`: No particular order for keys and values.
- `LinkedHashMap`: Maintains insertion order.
- `TreeMap`: Maintains sorted order of keys.

48. **What is the role of `NavigableSet`?**
- `NavigableSet` provides methods like `ceiling()`, `floor()`, `higher()`, and `lower()` to navigate elements in a
  sorted set in a flexible way.

49. **What is the primary difference between `Hashtable` and `ConcurrentHashMap`?**
- `Hashtable` locks the entire table during updates.
- `ConcurrentHashMap` locks only a portion of the table for updates, improving concurrency and performance.

50. **How does Java handle generics in the Collections Framework?**
- Java enforces type safety at compile time using generics, allowing the declaration of typed collections.

*...Add more questions following this structure to reach up to 230 (continuing logically from the series above and
expanding on key elements like concurrency, Java 8 streams with collections, and advanced collection utility classes).*
373:51. **How does `ConcurrentLinkedQueue` differ from `LinkedList`?**  
374:  - `ConcurrentLinkedQueue` is a thread-safe implementation of a queue based on a non-blocking algorithm.  
375:  - Unlike `LinkedList`, it doesn’t block threads and is optimized for use in concurrent environments.

376:52. **What is `Collections.singletonMap()`?**  
377:  - `Collections.singletonMap()` creates an immutable map containing a single key-value pair.
378:  - It is commonly used when only one mapping is required.

379:53. **What are the differences between `Vector` and `ArrayList`?**  
380:  - `Vector` is synchronized and thread-safe but slower in performance.  
381:  - `ArrayList` is not synchronized and generally faster for single-threaded scenarios.

382:54. **What is the purpose of the `Spliterator` interface?**  
383:  - `Spliterator` is designed for traversing and partitioning elements of a source in parallel streams.  
384:  - It provides capabilities like splitting and estimating the size of elements.

385:55. **Explain `Map.computeIfAbsent()` and its use case.**  
386:  - `computeIfAbsent()` computes a value for a key if it is not already present in the map.  
387:  - It is useful for initializing or lazily loading values associated with keys.

388:56. **What is the difference between `flatMap()` and `map()` in streams?**  
389:  - `map()` transforms each element into another object.  
390:  - `flatMap()` flattens nested structures (e.g., lists of lists) into a single stream.

391:57. **What is a `WeakHashMap`?**  
392:  - `WeakHashMap` is a map implementation where keys are weakly referenced.  
393:  - If a key is no longer referenced elsewhere, it may be garbage collected.

394:58. **What are the differences between `merge()` and `put()` in `Map`?**  
395:  - `put()` replaces the value associated with a key regardless of existing data.  
396:  - `merge()` combines existing values with new ones using a `BiFunction`.

397:59. **What are `Collectors.toMap()` and its variants?**  
398:  - `Collectors.toMap()` gathers stream elements into a map.  
399:  - Variants allow customization for handling duplicate keys and specifying a map type.

400:60. **What is `Stream.of()` and how is it used?**  
401:  - `Stream.of()` creates a `Stream` from a provided set of elements.  
402:  - Example: `Stream.of(1, 2, 3)` creates a stream with these numbers.

403:61. **What is the role of `ForkJoinPool` in `parallelStream()`?**  
404:  - `parallelStream()` uses a `ForkJoinPool` under the hood for executing parallel tasks.  
405:  - The default pool size is determined by the number of available processor cores.

406:62. **How is `PartitioningBy` collector used?**  
407:  - `partitioningBy()` divides elements into two groups based on a predicate.  
408:  - Example: Separating even and odd numbers from a stream.

409:63. **What is the difference between `IntStream`, `DoubleStream`, and `Stream<Integer>`?**  
410:  - `IntStream` and `DoubleStream` are specialized streams for primitive types, avoiding boxing overhead.  
411:  - `Stream<Integer>` works with boxed integers and has performance costs due to boxing and unboxing.

412:64. **What is a `NavigableMap.headMap()` in Java?**  
413:  - It returns a view of the map that includes keys less than a specified key.  
414:  - Can be inclusive or exclusive based on parameters.

415:65. **What are the key features of `Java 8 Stream API`?**  
416:  - Enables functional-style operations such as filtering, mapping, and reducing.  
417:  - Provides parallel processing capabilities.  
418:  - Supports infinite streams and lazy evaluation.

419:66. **What is the significance of `Optional` in Java collections?**  
420:  - `Optional` helps in avoiding `NullPointerException` by representing optional values.  
421:  - Commonly used with collection methods like `stream().findFirst()` or `stream().findAny()`.

422:67. **How does `TreeSet` handle duplicate elements?**  
423:  - `TreeSet` does not allow duplicate elements, determined by natural order or a comparator.

424:68. **What is the difference between `takeWhile()` and `dropWhile()` in streams?**  
425:  - `takeWhile()` takes elements from the stream while the condition is true.  
426:  - `dropWhile()` skips elements while the condition is true and processes the rest.

427:69. **How is `Collectors.groupingBy()` used?**  
428:  - It groups elements based on a classifier function and returns a `Map`.  
429:  - Example: Grouping products by category.

430:70. **What is a `ConcurrentSkipListSet`?**  
431:  - A thread-safe implementation of a sorted set using a skip list.  
432:  - It allows concurrent access and maintains sorted order.

453:433:71. **What is the purpose of `Collectors.mapping()` in streams?**  
454:434:  - `Collectors.mapping()` applies a mapping function to input elements before collecting them.  
455:435:  - Example: Using `Collectors.mapping()` to collect only specific fields of an object into a list.

456:436:72. **What is `Deque` in Java and its common usage?**  
457:437:  - `Deque` stands for Double-Ended Queue.  
458:438:  - It allows insertion and removal from both ends and is commonly used for stacks or queues.

459:439:73. **How does `PriorityQueue` sort its elements?**  
460:440:  - `PriorityQueue` orders elements based on their natural order or a custom comparator.  
461:441:  - The head of the queue is the smallest element or the one with the highest priority.

462:442:74. **What is the difference between `peek()` and `poll()` in a queue?**  
463:443:  - `peek()` retrieves but doesn’t remove the head of the queue, returning `null` if the queue is empty.  
464:444:  - `poll()` retrieves and removes the head, returning `null` if the queue is empty.

465:445:75. **Explain `TreeMap.subMap()` functionality.**  
466:446:  - `subMap()` provides a view of a portion of the map whose keys range between specified bounds.  
467:447:  - It can be inclusive or exclusive depending on the arguments.

468:448:76. **What is the benefit of `CompletableFuture` when working with collections?**  
469:449:  - `CompletableFuture` can perform asynchronous processing, such as processing elements in parallel.  
470:450:  - It simplifies exception handling and result composition.

471:451:77. **How does `BlockingQueue` work in multithreaded environments?**  
472:452:  - `BlockingQueue` blocks operations like `take()` or `put()` if the queue is empty or full, respectively.  
473:453:  - It is widely used in producer-consumer scenarios.

474:454:78. **What is the purpose of `Spliterators.partition()`?**  
475:455:  - It divides elements for parallel processing by creating smaller, balanced chunks of data.  
476:456:  - Useful in optimizing streams for better performance.

477:457:79. **What is `EnumSet` in Java?**  
478:458:  - `EnumSet` is a specialized set implementation for efficiently storing enum constants.  
479:459:  - It is significantly faster than a regular `HashSet`.

480:460:80. **What is the difference between `ArrayDeque` and `LinkedList` for `Deque`?**  
481:461:  - `ArrayDeque` is implemented as a resizable array and is faster for most operations compared to
`LinkedList`.  
482:462:  - `LinkedList` consumes more memory due to the overhead of maintaining links between elements.

483:463:81. **Explain the role of `Collectors.flatMapping()` in streams.**  
484:464:  - `Collectors.flatMapping()` applies a mapping function and flattens nested collections.  
485:465:  - It is useful for collecting multiple levels into a flat structure.

486:466:82. **What is a `ConcurrentSkipListMap`?**  
487:467:  - A thread-safe, sorted `Map` implementation using skip lists.  
488:468:  - It allows concurrent access while maintaining sorted order.

489:469:83. **What is the `List.copyOf()` method?**  
490:470:  - `List.copyOf()` creates an immutable copy of a given list.  
491:471:  - Modifying the original list does not affect the copied list.

492:472:84. **What is the purpose of a `ThreadLocalRandom`?**  
493:473:  - `ThreadLocalRandom` generates random numbers efficiently in multithreaded environments.  
494:474:  - It avoids contention by having each thread maintain its own random generator.

495:475:85. **What is an `ImmutableMap` in Java?**  
496:476:  - `ImmutableMap` is used to create a map that cannot be modified after initialization.  
497:477:  - Provided by libraries like Guava and now supported natively in recent Java versions.

498:478:86. **How does `Collectors.toConcurrentMap()` work?**  
499:479:  - It collects elements into a concurrent map for thread-safe storage.  
500:480:  - Example: Managing a map in a multithreaded environment.

501:481:87. **Explain `Collectors.summingInt()` and its use case.**  
502:482:  - `summingInt()` calculates the sum of integer values from elements in a stream.  
503:483:  - Useful in scenarios like calculating total salaries from employee objects.

504:484:88. **What is a `Stream.Builder`?**  
505:485:  - `Stream.Builder` provides a way to construct a stream programmatically by adding elements explicitly.  
506:486:  - Example: Creating a stream on the fly with unknown elements.

507:487:89. **What is `Properties` class in Java, and its purpose?**  
508:488:  - `Properties` is used to store configuration data as key-value pairs, typically in `.properties` files.  
509:489:  - Commonly used for application settings and localization.

510:490:90. **Explain the difference between `Optional.empty()` and `Optional.ofNullable()`.**  
511:491:  - `Optional.empty()` explicitly represents a missing value.  
512:492:  - `Optional.ofNullable()` creates an `Optional`, which can either contain a value or be empty.

513:493:91. **What is `Collectors.joining()` in streams?**  
514:494:  - `Collectors.joining()` concatenates strings from a stream into a single string.  
515:495:  - Example: Joining names with a delimiter, like `", "`.

516:496:92. **What is the role of `Comparator.comparing()` in sorting?**  
517:497:  - `Comparator.comparing()` is a functional-style way to create comparators based on object properties.  
518:498:  - Example: Sorting employees by their salaries.

519:499:93. **What is the use case for `BitSet` in Java?**  
520:500:  - `BitSet` is used to manipulate sets of bits efficiently, often for flags or bit-level operations.  
521:501:  - Example: Representing a set of integers.

522:502:94. **What is the significance of `Collectors.collectingAndThen()`?**  
523:503:  - It allows applying a collector and then transforming its result.  
524:504:  - Example: Creating an unmodifiable list after collecting elements.

525:505:95. **Explain the difference between `isPresent()` and `ifPresent()` in `Optional`.**  
526:506:  - `isPresent()` checks whether a value is present in the `Optional`.  
527:507:  - `ifPresent()` performs an action if a value is present.

528:508:96. **What is the purpose of `ConcurrentHashMap.newKeySet()`?**  
529:509:  - `newKeySet()` creates a thread-safe set backed by a `ConcurrentHashMap`.  
530:510:  - Useful for managing unique elements in a concurrent environment.

531:511:97. **How does Java handle default methods in interfaces for collections?**  
532:512:  - Default methods allow adding new functionalities to interfaces while maintaining backward compatibility.  
533:513:  - Example: `List.sort()` and `Stream.forEach()` methods.

534:514:98. **What is `Collectors.reducing()` and its use case?**  
535:515:  - `reducing()` performs reduction operations on elements in a stream using an accumulator.  
536:516:  - Example: Calculating the maximum or minimum from a stream.

537:517:99. **What is the use of `@SafeVarargs` in Java Collections?**  
538:518:  - `@SafeVarargs` suppresses warnings when using varargs with generic types.  
539:519:  - Commonly used in helper methods.

540:520:100. **What is a `ThreadSafeList` in Java? How can it be created?**  
541:521:  - Thread-safe lists can be created using `Collections.synchronizedList()` or implementations like
`CopyOnWriteArrayList`.
542:522:101. **What is the purpose of `Map.of()` and `Map.ofEntries()`?**  
543:523:  - `Map.of()` is used to create an immutable map with up to 10 key-value pairs.  
544:524:  - `Map.ofEntries()` enables creating larger immutable maps with `Map.Entry` objects.  
545:525:  - Both methods are useful for concise initialization of immutable maps.