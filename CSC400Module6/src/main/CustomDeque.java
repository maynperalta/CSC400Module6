package main;

import java.util.*;

public class CustomDeque {
	private Deque<Integer> deque;
		
	public CustomDeque() {
		this.deque = new LinkedList<>();
	}
	public void enqueueFront(int data) {
		deque.addFirst(data);
	}
	
	public void enqueueRear(int data) {
		deque.addLast(data);
	}
	
	public int dequeueFront() {
		if (isEmpty()) {
			throw new NoSuchElementException("Deque is empty");
		}
		return deque.removeFirst();
	}
	
	public int dequeueRear() {
		if(isEmpty()) {
			throw new NoSuchElementException("Deque is empty");
		}
		return deque.removeLast();
	}
	
	public Iterator<Integer> iterator() {
		return new DequeIterator();
	}
	
	public boolean isEmpty() {
		return deque.isEmpty();
	}
	
	private class DequeIterator implements Iterator<Integer> {
		private Iterator<Integer> iterator = deque.iterator();
		
		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}
		
		@Override
		public Integer next() {
			if(!hasNext()) {
				throw new NoSuchElementException("Deque is empty");
			}
			return iterator.next();
		}
	}
	
	public static void main(String[] args) {
			CustomDeque customDeque = new CustomDeque();
		
			// Enqueue elements
		
			customDeque.enqueueFront(1);
			customDeque.enqueueRear(2);
			customDeque.enqueueFront(3);
		
			// Iterate and display elements
			Iterator<Integer> iterator = customDeque.iterator();
			while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}
}