/*
Helen Li
August 17, 2019

Chapter 7

Implement a Binary Search Tree with an insert method and
search method, and prints the tree in inOrder traversal
*/

import java.util.*;

public class BinarySearchTree
{
	private BSTNode root;

	public BinarySearchTree()
	{
		root = null;
	}

	// node class for binary search tree
	private class BSTNode
	{
		private int info;
		private BSTNode left;
		private BSTNode right;

		public BSTNode(int info)
		{
			this.info = info;
			left = null;
			right = null;
		}

		public void setInfo(int info)
		{
			this.info = info;
		}

		public int getInfo()
		{
			return info;
		}

		public void setLeft(BSTNode link)
		{
			left = link;
		}

		public void setRight(BSTNode link)
		{
			right = link;
		}

		public BSTNode getLeft()
		{
			return left;
		}

		public BSTNode getRight()
		{
			return right;
		}
	}

	// insert method that takes an int
	public void insert(int element)
	{
		root = insert(root, element);
	}

	// recursively insert element in correct position of tree
	public BSTNode insert(BSTNode root, int element)
	{
		if(root == null)
			root = new BSTNode(element);

		else if(element <= root.getInfo())
			root.setLeft(insert(root.getLeft(), element));
		
		else
			root.setRight(insert(root.getRight(), element));

		return root;
	}

	// prints elements of tree in inOrder traversal
	public void printInOrder()
	{
		printInOrder(root);
	}

	// recursively prints elements of tree in inOrder traversal
	public void printInOrder(BSTNode root)
	{
		if(root != null)
		{
			printInOrder(root.getLeft());
			System.out.println(root.getInfo());
			printInOrder(root.getRight());
		}
	}

	// search for element in tree
	public void search(int element)
	{
		BSTNode parent = null;
		search(root, element, parent);
	}

	// recursively search tree for element
	// if found, print its position relative to its parent
	public void search(BSTNode root, int element, BSTNode parent)
	{
		if(root == null)
		{
			System.out.println(element + " not found");
			return;
		}
		else if(root.getInfo() == element)
		{
			if(parent == null)
				System.out.println("The node with " + element + " is the root node");
			else if(element <= parent.getInfo())
				System.out.println("The node with " + element + " is on the left" +
					" of the node with " + parent.getInfo());
			else
				System.out.println("The node with " + element + " is on the right" +
					" of the node with " + parent.getInfo());
			return;
		}

		if(element <= root.getInfo())
			search(root.getLeft(), element, root);
		else
			search(root.getRight(), element, root);
	}

	public static void main(String[] args)
	{
		BinarySearchTree tree = new BinarySearchTree();

		tree.insert(5);
		tree.insert(10);
		tree.insert(7);
		tree.insert(3);
		tree.insert(4);
		tree.insert(13);
		tree.insert(2);
		tree.insert(1);

		tree.printInOrder();

		tree.search(6);
		tree.search(4);
		tree.search(7);
		tree.search(5);
	}
}

