/*
Helen Li
August 3, 2019

Chapter 2 & 3
Question 4

Insert an element at the beginning, middle and end of a non-empty list
*/

// generic linked list stack
public class LinkedListStack4<T>
{
	private Node<T> topData;
	private int size;

	public LinkedListStack4()
	{
		topData = null; // data on top points to null
		size = 0;
	}

	// generic node class with information and a link
	private class Node<T>
	{
		private T info;
		private Node<T> link;

		public Node(T info)
		{
			this.info = info;
			link = null;
		}

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

	// insert new item at the end of the list
	public Node<T> insertEnd(T newData, Node<T> item)
	{
		if(item != null)
			item.setLink(insertEnd(newData, item.getLink()));
		else
		{
			item = new Node<T>(newData);
			size++;
		}
		return item;
	}

	// insert new item at the beginning of the list
	public void insertBeg(T newData, Node<T> item)
	{
		if(item != null)
			insertBeg(newData, item.getLink());
		else
		{
			item = new Node<T>(newData, topData);
			topData = item;
			size++;
		}
	}
	
	// insert new item at a specific index from the top
	public Node<T> insertAt(T newData, Node<T> item, int index)
	{
		if(index != 0 && item != null)
		{
			item.setLink(insertAt(newData, item.getLink(), index - 1));
		}
		else
		{
			item = new Node<T>(newData, item);
			size++;
		}
		return item;
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
		LinkedListStack4<Integer> linkedListStack = new LinkedListStack4<Integer>();

		linkedListStack.push(3);
		linkedListStack.push(2);
		linkedListStack.insertEnd(0, linkedListStack.topData);
		linkedListStack.push(9);
		linkedListStack.insertBeg(1, linkedListStack.topData);
		linkedListStack.push(5);
		System.out.println(linkedListStack.top());
		System.out.println();
		linkedListStack.push(6);
		linkedListStack.display();
		System.out.println();
		linkedListStack.insertAt(4, linkedListStack.topData, 2);
		linkedListStack.display();
		System.out.println();
		System.out.println(linkedListStack.pop());
		System.out.println();
		linkedListStack.push(8);
		linkedListStack.display();
	}
}
