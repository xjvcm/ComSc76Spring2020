/**
 * Programmer: Manzano, Jonathan
 * Course: ComSc-076-201
 * Instructor: Estrada
 * Assignment: Implementing Lists
 * Due date: April 21, 2020
 *
 * Description:  Start by carefully reading Listing 24.5: MyLinkedList.java (on
 * page 938 of the 11th Edition of the text). Note that the listing is
 * incomplete. Your assignment is to implement a revised MyLinkedList class
 * after you have included all the code needed to fill in and complete all the
 * methods that were omitted. Next, write a (main) driver program that
 * initializes a linked list with 10 names (your choice), and then completely
 * tests every one of its methods of ensure that the class meets all its
 * requirements.
 */

import java.util.Iterator;

interface MyList<E> extends Iterable<E> {
  /** Add a new element at the end of this list */
  public void add(E e);
  
  /** Add a new element at the specified index in this list */
  public void add(int index, E e);
  
  /** Clear the list */
  public void clear();
  
  /** Return true if this list contains the element */
  public boolean contains(E e);
  
  /** Return the element from this list at the specified index */
  public E get(int index);
  
  /** Return the index of the first matching element in this list.
   * Return -1 if no match. */
  public int indexOf(E e);
  
  /** Return true if this list contains no elements */
  public boolean isEmpty();
  
  /** Return the index of the last matching element in this list
   * Return -1 if no match. */
  public int lastIndexOf(E e);
  
  /** Remove the first occurrence of the element o from this list.
   * Shift any subsequent elements to the left.
   * Return true if the element is removed. */
  public boolean remove(E e);
  
  /** Remove the element at the specified position in this list
   * Shift any subsequent elements to the left.
   * Return the element that was removed from the list. */
  public E remove(int index);
  
  /** Replace the element at the specified position in this list
   * with the specified element and returns the new set. */
  public Object set(int index, E e);
  
  /** Return the number of elements in this list */
  public int size();
}

abstract class MyAbstractList<E> implements MyList<E> {
  protected int size = 0; // The size of the list

  /** Create a default list */
  protected MyAbstractList() {
  }

  /** Create a list from an array of objects */
  protected MyAbstractList(E[] objects) {
    for (int i = 0; i < objects.length; i++)
      add(objects[i]);
  }

  @Override /** Add a new element at the end of this list */
  public void add(E e) {
    add(size, e);
  }

  @Override /** Return true if this list contains no elements */
  public boolean isEmpty() {
    return size == 0;
  }

  @Override /** Return the number of elements in this list */
  public int size() {
    return size;
  }

  @Override /** Remove the first occurrence of the element e 
   *  from this list. Shift any subsequent elements to the left.
   *  Return true if the element is removed. */
  public boolean remove(E e) {
    if (indexOf(e) >= 0) {
      remove(indexOf(e));
      return true;
    }
    else
      return false;
  }
}

class MyLinkedList<E> extends MyAbstractList<E> {
  private Node<E> head, tail;

  /** Create a default list */
  public MyLinkedList() {
  }

  /** Create a list from an array of objects */
  public MyLinkedList(E[] objects) {
    super(objects);
  }

  /** Return the head element in the list */
  public E getFirst() {
    if (size == 0) {
      return null;
    }
    else {
      return head.element;
    }
  }

  /** Return the last element in the list */
  public E getLast() {
    if (size == 0) {
      return null;
    }
    else {
      return tail.element;
    }
  }

  /** Add an element to the beginning of the list */
  public void addFirst(E e) {
    Node<E> newNode = new Node<E>(e); // Create a new node
    newNode.next = head; // link the new node with the head
    head = newNode; // head points to the new node
    size++; // Increase list size

    if (tail == null) // the new node is the only node in list
      tail = head;
  }

  /** Add an element to the end of the list */
  public void addLast(E e) {
    Node<E> newNode = new Node<E>(e); // Create a new for element e

    if (tail == null) {
      head = tail = newNode; // The new node is the only node in list
    }
    else {
      tail.next = newNode; // Link the new with the last node
      tail = tail.next; // tail now points to the last node
    }

    size++; // Increase size
  }


  @Override /** Add a new element at the specified index 
   * in this list. The index of the head element is 0 */
  public void add(int index, E e) {
    if (index == 0) {
      addFirst(e);
    }
    else if (index >= size) {
      addLast(e);
    }
    else {
      Node<E> current = head;
      for (int i = 1; i < index; i++) {
        current = current.next;
      }
      Node<E> temp = current.next;
      current.next = new Node<E>(e);
      (current.next).next = temp;
      size++;
    }
  }

  /** Remove the head node and
   *  return the object that is contained in the removed node. */
  public E removeFirst() {
    if (size == 0) {
      return null;
    }
    else {
      Node<E> temp = head;
      head = head.next;
      size--;
      if (head == null) {
        tail = null;
      }
      return temp.element;
    }
  }

  /** Remove the last node and
   * return the object that is contained in the removed node. */
  public E removeLast() {
    if (size == 0) {
      return null;
    }
    else if (size == 1) {
      Node<E> temp = head;
      head = tail = null;
      size = 0;
      return temp.element;
    }
    else {
      Node<E> current = head;

      for (int i = 0; i < size - 2; i++) {
        current = current.next;
      }

      Node<E> temp = tail;
      tail = current;
      tail.next = null;
      size--;
      return temp.element;
    }
  }

  @Override /** Remove the element at the specified position in this 
   *  list. Return the element that was removed from the list. */
  public E remove(int index) {   
    if (index < 0 || index >= size) {
      return null;
    }
    else if (index == 0) {
      return removeFirst();
    }
    else if (index == size - 1) {
      return removeLast();
    }
    else {
      Node<E> previous = head;

      for (int i = 1; i < index; i++) {
        previous = previous.next;
      }

      Node<E> current = previous.next;
      previous.next = current.next;
      size--;
      return current.element;
    }
  }

  @Override /** Override toString() to return elements in the list */
  public String toString() {
    StringBuilder result = new StringBuilder("[");

    Node<E> current = head;
    for (int i = 0; i < size; i++) {
      result.append(current.element);
      current = current.next;
      if (current != null) {
        result.append(", "); // Separate two elements with a comma
      }
      else {
        result.append("]"); // Insert the closing ] in the string
      }
    }

    return result.toString();
  }

  @Override /** Clear the list */
  public void clear() {
    size = 0;
    head = tail = null;
  }

  @Override /** Return true if this list contains the element e */
  public boolean contains(E e) {
    boolean contains = false;

    if (size == 0) {
      return contains;
    } else {
      Node<E> current = head;

      while (current != null) {
        if (current.element == e) {
          contains = true;
        }
        current = current.next;
      }
    }
    return contains;
  }

  @Override /** Return the element at the specified index */
  public E get(int index) {
    if (index < 0 || index >= size) {
      return null; // Out of range
    } else if (index == 0) {
      return getFirst();
    } else if (index == size - 1) {
      return getLast();
    } else {
      Node<E> current = head.next;

      for (int i = 1; i < index; i++) {
        current = current.next;
      }

      return current.element;
    }
  }

  @Override /** Return the index of the head matching element in 
   *  this list. Return -1 if no match. */
  public int indexOf(E e) {
    if (head.element == e) {
      return 0;
    } else if (tail.element == e) {
      return size -1;
    } else {
      Node<E> current = head.next;
      int index = 1;
      while (current != null) {
        if (current.element == e) {
          return index;
        }
        current = current.next;
        index++;
      }
    }
    return -1;
  }

  @Override /** Return the index of the last matching element in 
   *  this list. Return -1 if no match. */
  public int lastIndexOf(E e) {
    int index = -1;
    Node<E> current = head;
    for (int i = 0; i < size; i++) {
      if (current.element == e) {
        index = 1;
      }
      current = current.next;
    }
    return index;
  }

  @Override /** Replace the element at the specified position 
   *  in this list with the specified element. */
  public E set(int index, E e) {
    if (index < 0 || index > size -1) {
      return null;
    } else {
      Node<E> current = head;
      for (int i = 0; i < index; i++) {
        current = current.next;
      }
      current.element = e;
      return current.element;
    }
  }

  @Override /** Override iterator() defined in Iterable */
  public java.util.Iterator<E> iterator() {
    return new LinkedListIterator();
  }

  private void checkIndex(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException
        ("Index: " + index + ", Size: " + size);
  }
  
  private class LinkedListIterator 
      implements java.util.Iterator<E> {
    private Node<E> current = head; // Current index 
    
    @Override
    public boolean hasNext() {
      return (current != null);
    }

    @Override
    public E next() {
      E e = current.element;
      current = current.next;
      return e;
    }

    @Override
    public void remove() {
      System.out.println("Implementation left as an exercise");
    }
  }
  
  private static class Node<E> {
    E element;
    Node<E> next;

    public Node(E element) {
      this.element = element;
    }
  }
}

public class Jonathan_Manzano_ImplementingLists {
  public static void main(String[] args) {
    MyLinkedList<String> list = new MyLinkedList<>();

    // Add elements to the list
    list.add("Tamanna Browne");
    list.add("Riyad Francis");
    list.add("Tiana Healy");
    list.add("Maureen Richards");
    list.add("Mindy Kline");
    list.add("Rohit Stevenson");
    list.add("Henrietta Hurst");
    list.add("Reo Keenan");
    list.add("Kylie Lucero");
    list.add("Fox Rasmussen");

    System.out.println(list + "\n");

    // getFirst Method
    System.out.println("The first name on the list is " + list.getFirst());

    // getLast Method
    System.out.println("The last name on the list is " + list.getLast());

    // addFirst Method
    list.addFirst("Jez Finch");
    System.out.println("\n\"Jez Finch\" is add to the front of the list\n"
        + list);

    // addLast Method
    list.addLast("Monet Bird");
    System.out.println("\n\"Monet Bird\" is added to the end of the list\n"
        + list);

    // removeFirst Method
    list.removeFirst();
    System.out.println("\n\"Jez Finch\" is removed from the front of the list\n"
        + list);

    // removeLast Method
    list.removeLast();
    System.out.println("\n\"Monet Bird\" is removed from the end of the list\n"
        + list);

    // remove
    System.out.println("\nThe name removed at index 5 is " + list.remove(5));

    // toString
    System.out.println("\nInvoking toString method: \n" + list.toString());

    // Contains
    System.out.println("\nDoes the list contain \"Henrietta Hurst\"? " +
        list.contains("Henrietta Hurst")); 
    
    // Get
    System.out.println("\nThe name at index 7 is " + list.get(7));

    //indexOf
    System.out.println("\n\"Riyad Francis\" is at index "
        + list.indexOf("Riyad Francis"));

    // set
    list.set(4, "Cayden Higgs");
    System.out.println("\n\"Cayden Higgs\" replaced \"Mindy Kline\" at index" 
        + "4\n");
    System.out.println(list);
    
    //Clear
    System.out.println("Clear list with clear() method");
    list.clear();
    System.out.println(list + "]");
  }
}