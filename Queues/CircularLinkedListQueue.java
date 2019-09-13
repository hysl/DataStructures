/*
Helen Li
August 10, 2019

Chapter 4
Question 3

Implement a circular linked list queue
*/

public class CircularLinkedListQueue<T>
{
	private LLNode<T> rear;

	public CircularLinkedListQueue()
	{
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
		if(isEmpty())
		{
			LLNode<T> newNode = new LLNode<T>(element);
			rear = newNode;
			newNode.setLink(rear);
		}
		else
		{
			LLNode<T> newNode = rear.getLink();
			rear.setLink(new LLNode<T>(element, newNode));
			rear = rear.getLink();
		}
		
		System.out.println(element + " enqueued");
	}

	// if not empty, remove element from queue and return it
	public T dequeue() throws RuntimeException
	{
		if(isEmpty())
			throw new RuntimeException("The queue is empty");
		else
		{
			LLNode<T> newNode = rear.getLink();
			T temp = newNode.getInfo();
			if(rear == rear.getLink())
				rear = null;
			else
				rear.setLink(newNode.getLink());
			return temp;
		}
	}

	public boolean isEmpty()
	{
		return (rear == null);
	}

	public boolean isFull()
	{
		return false;
	}

	// if not empty, retrieve head of queue
	public T peek() throws RuntimeException
	{
		if(isEmpty())
			throw new RuntimeException("The queue is empty");
		else
			return rear.getLink().getInfo();
	}

	public static void main(String[] args)
	{
		CircularLinkedListQueue<Integer> circularLinkedQueue = new CircularLinkedListQueue<Integer>();

		circularLinkedQueue.enqueue(1);
		circularLinkedQueue.enqueue(2);
		circularLinkedQueue.enqueue(3);
		System.out.println(circularLinkedQueue.dequeue() + " dequeued");
		System.out.println(circularLinkedQueue.peek() + " is head item");
	}
}

