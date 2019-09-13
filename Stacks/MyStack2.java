/*
Helen Li
July 27, 2019

Question 2

Using stack, print individual words in reverse
*/

import java.util.Scanner;

// generic stack class
public class MyStack2<T>
{
	private T[] stack;
	private int topIndex;
	private final static int FINAL_SIZE = 30;

	public MyStack2()
	{
		stack = (T[]) new Object[FINAL_SIZE];
		topIndex = -1; // empty stack
	}

	// if stack is not full, insert element
	public void push(T item)
	{
		if(isFull())
			System.out.println("The stack is full");
		else
		{
			topIndex++;
			stack[topIndex] = item;
		}
	}

	//if stack is not empty, pop top element
	public void pop()
	{
		if(isEmpty())
			System.out.println("The stack is empty");
		else
		{
			stack[topIndex] = null;
			topIndex--;
		}
	}

	// if stack is not empty, return top element
	public T top()
	{
		T item = null;

		if(isEmpty())
		{
			System.out.println("The stack is empty");
			return item;
		}
		else
		{
			item = stack[topIndex];
			return item;
		}
	}

	// if topIndex == -1, then stack is empty
	public boolean isEmpty()
	{
		if(topIndex == -1)
			return true;
		else
			return false;
	}

	// if topIndex == stack.length - 1, then stack is full
	public boolean isFull()
	{
		if(topIndex == stack.length - 1)
			return true;
		else
			return false;
	}

	public static void main(String[] args)
	{
		MyStack2<Character> myStack = new MyStack2<Character>();

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter a line of text: ");
		String line = scan.nextLine();

		char[] ch = line.toCharArray();
		for(int i = 0; i < line.length(); i++)
			myStack.push(ch[i]);

		while(!myStack.isEmpty())
		{
			System.out.print(myStack.top());
			myStack.pop();
		}

		System.out.println();
	}
}
