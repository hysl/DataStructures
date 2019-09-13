/*
Helen Li
July 27, 2019
*/

import java.util.Scanner;

// given a sorted array and integer k, find the number of elements
// in the array which are greater than k
public class Question3
{
	public static void main(String[] args)
	{
		int[] myArr = {1, 3, 3, 6, 7, 9};

		int k = 7;
		int count = 0;

		for(int i = 0; i < myArr.length; i++)
		{
			if(myArr[i] > k)
				count++;
		}

		System.out.println("The number of elements greater than " + k
			+ " are " + count + ".");
	}
}
