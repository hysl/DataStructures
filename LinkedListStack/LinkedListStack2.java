/*
Helen Li
August 3, 2019

Chapter 2 & 3
Question 2

Reverse and print a non-empty linked list
*/

// generic linked list stack
public class LinkedListStack2<T>
{
	private Node<T> topData;
	private int size;

	public LinkedListStack2()
	{
		topData = null; // data on top points to null
		size = 0;
	}

	// generic node class with information and a link
	private class Node<T>
	{
		private T info;
		private Node<T> link;

		public Node(T info, Node<T> link)
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

		public void setLink(Node<T> link)
		{
			this.link = link;
		}

		public Node<T> getLink()
		{
			return link;
		}
	}

	// add item to the linked list stack
	public void push(T item)
	{
		Node<T> data = new Node<T>(item, topData);
		topData = data;
		size++;
	}

	// if stack is not empty, remove and return top item
	public T pop() throws RuntimeException
	{
		if(isEmpty())
			throw new RuntimeException("The stack is empty");;
		T temp = topData.getInfo();
		topData = topData.getLink();
		size--;
		return temp;
	}

	// if stack is not empty, return top item
	public T top() throws RuntimeException
	{
		if(isEmpty())
			throw new RuntimeException("The stack is empty");
		return topData.getInfo();
	}

	// if stack is not empty, print all items in stack
	public void display()
	{
		if(size == 0)
			System.out.println("The stack is empty");
		else
		{
			Node<T> data = topData;

			while(data != null)
			{
				System.out.println(data.getInfo());
				data = data.getLink();
			}
		}
	}

	// display items in linked list stack in reverse recursively
	public void displayReverse(Node<T> item)
	{
		if(item != null)
		{
			displayReverse(item.getLink());
			System.out.println(item.getInfo());
		}
	}

	public boolean isEmpty()
	{
		if(topData == null)
			return true;
		else
			return false;
	}

	// linked list stack is never full
	public boolean isFull()
	{
		return false;
	}

	// Simple Test Driver
	public static void main(String[] args)
	{
		LinkedListStack2<Integer> linkedListStack = new LinkedListStack2<Integer>();

		linkedListStack.push(3);
		linkedListStack.push(2);
		linkedListStack.push(9);
		linkedListStack.push(5);
		System.out.println(linkedListStack.top());
		System.out.println();
		linkedListStack.push(6);
		linkedListStack.displayReverse(linkedListStack.topData);
		System.out.println();
		System.out.println(linkedListStack.pop());
		System.out.println();
		linkedListStack.push(8);
		linkedListStack.displayReverse(linkedListStack.topData);
	}
}
