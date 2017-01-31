package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		LLNode<E> newNode = new LLNode<E>(element);

		if (size == 0) {
			head = newNode;
			tail = newNode;
		} else {
			LLNode<E> curr = this.head;
			for (int i = 0; i < size - 1; i++) {
				curr = curr.next;
			}
			curr.next = newNode;
			newNode.prev = curr;
			tail = newNode;
		}
		size++;
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		// corner case
		if (index > size - 1 || index < 0) throw new IndexOutOfBoundsException();
		LLNode<E> curr = this.head;
		for (int i = 0; i < index; i++) {
			curr = curr.next;
		}
		return curr.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (element == null)  throw new NullPointerException();
		// case 1: size = 0, add @ 0
		// case 2: add @ index = size
		// corner case: index > size, index < 0
		if (index > size || index < 0) throw new IndexOutOfBoundsException();
		LLNode<E> newNode = new LLNode<E>(element);

		if (size == 0) {
			head = newNode;
			tail = newNode;
		} else if (index == size) {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		} else {
			LLNode<E> curr = this.head;
			for (int i = 0; i < index; i++) {
				curr = curr.next;
			}
			newNode.next = curr;
			newNode.prev = curr.prev;
			if (index == 0) {
				curr.prev = newNode;
				head = newNode;
			} else {
				curr.prev.next = newNode;
				curr.prev = newNode;
			}
		}
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index > size - 1 || index < 0) throw new IndexOutOfBoundsException();
		LLNode<E> curr = this.head;
		for (int i = 0; i < index; i++) {
			curr = curr.next;
		}
		E result = curr.data;
		if (size == 1) {
			head = new LLNode<E>(null);
			tail = new LLNode<E>(null);
		} else {
			if (index == 0) {
				curr.next.prev = null;
				head = curr.next;
			} else if (index == size - 1) {
				curr.prev.next = null;
				tail = curr.prev;
			} else {
				curr.prev.next = curr.next;
				curr.next.prev = curr.prev;
			}
		}
		curr.prev = null;
		curr.next = null;
		size--;
		return result;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (index > size - 1 || index < 0) throw new IndexOutOfBoundsException();
		if (element == null) throw new NullPointerException();
		
		LLNode<E> curr = this.head;
		for (int i = 0; i < index; i++) {
			curr = curr.next;
		}
		E result = curr.data;
		curr.data = element;
		return result;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
