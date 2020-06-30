## ARRAYLIST

Ordered collection of elements. 
can contain duplicates.

add(index, element) : inserts the element at the particular index. 
Complexity is O(n)  : because in the worst case insertion is at the start of the list and there have to n shifts to complete the insertion.

add(element)        : adds the elment at the end of the list.
Complexity is O(1)  : since there is not need of shifting elements when we insert the element at the end of the list.

get(index)          : gets the element from the specified index.
Complexity is O(1)  : In the array list element can be directly fetched from the index. no need of travesal.

indexOf(element)    : finds the index of a specified element
Complexity is O(n)  : because in the worst case if the element is the last element in the list, then it have to traverse all the n elements.

## LINKEDLIST


## PRIORITY QUEUE

Implementation of a heap data structure.
By default a min heap.
For max heap pass the comparator during the object instantiation as a constructor parameter.
Example: PriorityQueue<Integer>  queue = new PriorityQueue((a, b) -> b - a);

add(element)            : adds the element into the heap and balances(heapify) the heap.
Complexity is O(log n)  : because it has to balance the heap tree after insertion.

peek()                  : returns the root node of the heap without deleting. min element incase of min heap and vice versa.
Complexity is O(1)      : just returns the root element.

poll()                  : returns the root node and deletes the node from the heap.
Complexity is O(log n)  : since tree will be balanced again.


## HASHSET


## HASHMAP


## TREESET

## TREEMAP


## LINKEDHASHSET


## LINKEDHASHMAP

## QUEUE
Queue<Integer> queue = new LinkedList<>();
queue.offer(i); // queue
 int current = queue.poll();  // dequeue

 
## STACK


## EQUALS AND HASHMAP

## COMPARATOR

## COMPARABLE




