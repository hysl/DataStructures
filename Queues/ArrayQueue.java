/*
Helen Li
August 10, 2019

Chapter 4
Question 1

Implement an array-based queue that enqueues 3 items and prints them,
dequeues one element and print it, and prints the front and rear items
*/

public class ArrayQueue<T>
{
	private static final int DEFCAP = 100;
	private T[] elements;
	private int numElements;
	private int front;
	private int rear;

	public ArrayQueue()
	{
		elements = (T[]) new Object[DEFCAP];
		numElements = 0;
		front = 0;
		rear = DEFCAP - 1;
	}

	// if not full, add element to rear of queue
	public void enqueue(T element) throws RuntimeException
	{
		if(isFull())
			throw new RuntimeException("The queue is full");
		else
		{
			rear = (rear + 1) % elements.length;
			elements[rear] = element;
			numElements++;
			System.out.println(element + " enqueued");
		}
	}

	// if not empty, remove element from queue and return it
	public T dequeue() throws RuntimeException
	{
		if(isEmpty())
			throw new RuntimeException("The queue is empty");
		else
		{
			T temp = elements[front];
			elements[front] = null;
			front = (front + 1) % elements.length;
			numElements--;
			return temp;
		}
	}

	public boolean isFull()
	{
		return (numElements == elements.length);
	}

	public boolean isEmpty()
	{
		return (numElements == 0);
	}

	public int size()
	{
		return numElements;
	}

	public T getFront() throws RuntimeException
	{
		if(isEmpty())
			throw new RuntimeException("The queue is empty");
		else
			return elements[front];
	}

	public T getRear() throws RuntimeException
	{
		if(isEmpty())
			throw new RuntimeException("The queue is empty");
		else
			return elements[rear];
	}

	public static void main(String[] args)
	{
		ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>();

		arrayQueue.enqueue(1);
		arrayQueue.enqueue(2);
		arrayQueue.enqueue(3);
		System.out.println(arrayQueue.dequeue() + " dequeued");
		System.out.println(arrayQueue.getFront() + " is front item");
		System.out.println(arrayQueue.getRear() + " is rear item");
	}
}
