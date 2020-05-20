/**
 * Programmer: Manzano, Jonathan
 * Course: ComSc-076-201
 * Instructor: Estrada
 * Assignment: Extra Credit - Implementing a Doubly Linked List
 * Due date: April 23, 2020
 *
 * Description:  The MyLinkedList class used in Listing 24.5 is a one-way
 * directional linked list that enables one-way traversal of the list. Modify
 * the Node class to add the new data field named previous to refer to the
 * previous node in the list as follows:
 * 
 * public class Node<E> {
 *   E element;
 *   Node<E>  next;
 *   Node<E> previous;
 *  
 *   public Node(E e) {
 *     element = e;
 *   }
 * }
 * 
 * Implement a new class named TwoWayLinkedList that uses a doubly linked list
 * to store elements. Define TwoWayLinkedList to implement MyList. You need to
 * implement all the methods defined in MyLinkedList as well as the methods
 * listIterator( ) and listIterator(int, index). Both return an instance of
 * java.util.ListIterator<E>. The former sets the cursor to the head of the list
 * and the latter to the element at the specified index.
 * 
 * Write a driver program to test this new version of the TwoWayLinkedList class.
 */