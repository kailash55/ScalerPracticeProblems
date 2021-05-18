package arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RotationGame {

	public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
		Scanner sc= new Scanner(System.in);
		try {
		int noOfTestCases = sc.nextInt();
		
		for(int i=1; i<=noOfTestCases; i++)
		{
			int arrLength = sc.nextInt();
			int[] arr = new int[arrLength];
			
			for(int j=0; j<arrLength; j++)
			{
				arr[j] = sc.nextInt();
			}
			
			int noOfDigitsToRotate = sc.nextInt();
			
			if(i!=1)
				System.out.println();
			rotate(arr, noOfDigitsToRotate);
			
		}

		}
		finally
		{
			sc.close();
		}
        
    }
	
	public static void rotate(int[] arr, int noOfDigit) 
	{
		int[] arrCopy = new int[arr.length];
		for(int i=0; i<arr.length; i++)
		{
			arrCopy[i] = arr[i];
		}
		
		for(int i=0; i<arr.length; i++)
		{
			int newPosition = (i + noOfDigit) % arr.length;
			arr[newPosition] = arrCopy[i];
		}
		
		for(int i=0; i<arr.length; i++)
		{
			if(i!=0)
				System.out.print(" ");
			System.out.print(arr[i]);
		}
	}
}
