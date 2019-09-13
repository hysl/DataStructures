/*
Helen Li
August 10, 2019

Chapter 4
Question 2

Implement a linked-list-based queue, where items 1, 2 and 3 are enqueued,
followed by a dequeue operation. Print the dequeued item.
*/

public class LinkedListQueue<T>
{
	private LLNode<T> front;
	private LLNode<T> rear;

	public LinkedListQueue()
	{
		front = null;
		rear = null;
	}

	// generic node class with information and a link
	private class LLNode<T>
	{
		private T info;
		private LLNode<T> link;

		public LLNode(T info)
		{
			this.info = info;
			link = null;
		}

		public LLNode(T info, LLNode<T> link)
		{
			this.info = info;
			this.link = link;
		}

		public void setInfo(T info)
		{
			this.info = info;
		}

		public T getInfo()
		{
			return info;
		}

		public void setLink(LLNode<T> link)
		{
			this.link = link;
		}

		public LLNode<T> getLink()
		{
			return link;
		}
	}

	// add element to rear of queue
	public void enqueue(T element)
	{
		LLNode<T> newNode = new LLNode<T>(element);
		if(rear == null)
			front = newNode;
		else
			rear.setLink(newNode);
		rear = newNode;
		//System.out.println(element + " enqueued");
	}

	// if not empty, remove element from queue and return it
	public T dequeue() throws RuntimeException
	{
		if(isEmpty())
			throw new RuntimeException("The queue is empty");
		else
		{
			T element;
			element = front.getInfo();
			front = front.getLink();
			if(front == null)
				rear = null;
			return element;
		}
	}

	public boolean isEmpty()
	{
		return (front == null);
	}

	public boolean isFull()
	{
		return false;
	}

	public T getFront() throws RuntimeException
	{
		if(isEmpty())
			throw new RuntimeException("The queue is empty");
		else
			return front.getInfo();
	}

	public T getRear() throws RuntimeException
	{
		if(isEmpty())
			throw new RuntimeException("The queue is empty");
		else
			return rear.getInfo();
	}

	public static void main(String[] args)
	{
		LinkedListQueue<Integer> linkedQueue = new LinkedListQueue<Integer>();

		linkedQueue.enqueue(1);
		linkedQueue.enqueue(2);
		linkedQueue.enqueue(3);
		System.out.println(linkedQueue.dequeue() + " dequeued");
		//System.out.println(linkedQueue.getFront() + " is front item");
		//System.out.println(linkedQueue.getRear() + " is rear item");
	}
}

