package main;

import java.util.*;

public class CustomDeque {
	private Deque<Integer> deque;
		
	public CustomDeque() {
		this.deque = new LinkedList<>();
	}
// Insert at front 	
	public void enqueueFront(int data) {
		deque.addFirst(data);
	}
// Insert at rear	
	public void enqueueRear(int data) {
		deque.addLast(data);
	}
// Remove from front
	public int dequeueFront() {
		if (isEmpty()) {
			throw new NoSuchElementException("Deque is empty");
		}
		return deque.removeFirst();
	}
// Remove from rear
	public int dequeueRear() {
		if(isEmpty()) {
			throw new NoSuchElementException("Deque is empty");
		}
		return deque.removeLast();
	}
// Return Iterator	
	public Iterator<Integer> iterator() {
		return new DequeIterator();
	}
	
	public boolean isEmpty() {
		return deque.isEmpty();
	}
// Inner iterator class	
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
// Test with random integers	
	public static void main(String[] args) {
			CustomDeque customDeque = new CustomDeque();
			Random random = new Random();
			
			int[] randomIntegers = new int[10];
			
			System.out.println("Random integer array: ");
// Generate random integers from 0 - 99			
			for(int i = 0; i < 10; ++i) {
				randomIntegers[i] = random.nextInt(100);
				System.out.print(randomIntegers[i] + " ");
			}
// Alternate adding integers to front and rear of deque
			System.out.println("\n\nAdding integers to deque...");
			
			for (int i = 0; i < randomIntegers.length; ++i) {
				if (i % 2 == 0) {
					customDeque.enqueueFront(randomIntegers[i]);
				} else {
					customDeque.enqueueRear(randomIntegers[i]);
				}
			}
// Use iterator to traverse deque			
			System.out.println("\nDeque elements: ");
			Iterator<Integer> iterator = customDeque.iterator();
			while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
// Demonstrate removing elements from deque
			System.out.println("\n\nRemoving element from front of deque: " + customDeque.dequeueFront());
			System.out.println("Removing element from rear of deque: " + customDeque.dequeueRear());
			
			System.out.println("\nCurrent deque: ");
			iterator = customDeque.iterator();
			while(iterator.hasNext()) {
				System.out.print(iterator.next() + " ");
			}
	}
}