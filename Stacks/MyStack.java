/*
Helen Li
July 27, 2019

Question 1

Using stack, returns the smallest element
*/

// stack class for int
public class MyStack
{
	private int[] stack;
	private int topIndex;
	private final static int FINAL_SIZE = 30;

	public MyStack()
	{
		stack = new int[FINAL_SIZE];
		topIndex = -1; // empty stack
	}

	// if stack is not full, insert element
	public void push(int item)
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
			stack[topIndex] = 0;
			topIndex--;
		}
	}

	// if stack is not empty, return top element
	public int top()
	{
		int item = 0;

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

	// if stack is not empty, find the smallest element in stack
	public int getMin()
	{
		int item = 0;
		int min;

		if(isEmpty())
		{
			System.out.println("The stack is empty");
			return 0;
		}
		else
		{
			min = top();
			for(int i = topIndex; i >= 0; i--)
			{
				item = top();
				if(item < min)
					min = item;
				pop();
			}
			return min;
		}
	}

	// implement function to find minimum element in stack
	public static void main(String[] args)
	{
		MyStack myStack = new MyStack();

		myStack.push(12);
		myStack.push(14);
		myStack.push(6);
		myStack.push(11);
		System.out.println(myStack.getMin());
	}
}

