package queue_singlelinkedlist;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	e the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E e) {

		QueueNode<E> node = new QueueNode<E>(e);
		//Om sistaplatsen är tom, node blir sistaplatsen
		if(last == null){
			node.next = node;
		}
		// Nästa nod blir tillsatt efter last
		else {
			node.next = last.next;
			last.next = node; 
		}

		last = node; //Sätter last som en nod till "node"
		size++; //ökar kön med ett. 
		return true;
	}
	
	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {		
		return size; 
	}
	
	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		//Om sist i platsen är tom, är kön tom
		if(last == null){
			return null;
		}
		//Returnar elementet för den som är först i kön
		else {
			return last.next.element;
		}
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {
		QueueNode<E> node = last;
		//Om listan är tom
		if(last == null){
			return null;
		}
		//Om sist i kö är först i kö, ska noden tas bort
		if(last.next == last){
			last = null; 
		}
		//Tar bort "first"
		else {
			node = last.next;
			last.next = node.next; 
		}

		size--;
		return node.element;
	}
	
	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		return new QueueIterator();
	}
	
	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}

	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;

		/* Konstruktor */

		private QueueIterator() {
			//pos blir sistaplats i kön
			pos = last; 
		}

		public boolean hasNext() {

			return pos!=null; 
		}

		public E next() {
			//Kollar om det går att peka på nästa nod
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			//Skapar ny nod som blir nästa nod från pos
			QueueNode<E> next = pos.next; 
			pos = pos.next; 
			//Om pos är sista noden, blir denna null
			if(pos == last){
				pos = null; 
			}
			//returnar elemtentet från näsat
			return next.element;
		}
		
	}

		/**
		* Appends the specified queue to this queue
		* post: all elements from the specified queue are appended
		* to this queue. The specified queue (q) is empty after the call.
		* @param q the queue to append
		* @throws IllegalArgumentException if this queue and q are identical
		*/
public void append(FifoQueue<E> q){
	//Om man försöker appenda med sig själv
	if(q == this){
		throw new IllegalArgumentException();
	}
	//Kollar så den inte är tom
	if(q != this){
		if(q.last != null){
			//skapar noder för q, första och sista nod.
			QueueNode<E> qFirst = q.last.next;
			QueueNode<E> qLast = q.last; 
				//Om q´s sista nod inte är null, 
				if(last != null){
					qLast.next = last.next;
					last.next = qFirst; 
				}
				//noden last blir qLast och sizen på listan ökas med sizen av q
				last = qLast; 
				size += q.size; 
				//Resettar q
				q.last = null; 
				q.size = 0; 
		}
	}
}
		
}
