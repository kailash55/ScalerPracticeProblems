package ProblemSolving3;

import java.util.ArrayList;

public class ConstructArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ConstructArraySolution().solve(3,10,39));
	}

}

class ConstructArraySolution
{
	public ArrayList<Integer> solve(final int A, final int B, final int C) {
		
		ArrayList<Integer> divisors = new ArrayList<Integer>();
		int difference = C - B;
		
		
		for(int i=1; Math.pow(i, 2) <= difference; i++)
		{
			if(difference % i == 0)
			{
				divisors.add(i);
				
				if(i != (difference/i))
					divisors.add(difference/i);
			}
		}
		
		
		ArrayList<ArrayList<Integer>> arraysList = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<divisors.size(); i++)
		{
			ArrayList<Integer> arr = new ArrayList<Integer>();
			int divisor = divisors.get(i);
			boolean validDivisor = false;
			int left = C;
			int count = 0;
			while(left > 0)
			{
				arr.add(0,left);
				left = left - divisor;
				count++;
				
				if(count == A)
					break;
			}
			
			if(left <= B)
			{
				int right = C + divisor;
				while(count != A)
				{
					arr.add(right);
					right = right + divisor;
					count++;
				}
				
				arraysList.add(arr);
			}
			
		}
		
		ArrayList<Integer> outArray = new ArrayList<Integer>();
		int lowestRight = Integer.MAX_VALUE;
		for(int i=0; i<arraysList.size(); i++)
		{
			if(arraysList.get(i).get(arraysList.get(i).size() - 1) < lowestRight)
			{
				outArray = arraysList.get(i);
				lowestRight = arraysList.get(i).get(arraysList.get(i).size() - 1);
			}
			else if(arraysList.get(i).get(arraysList.get(i).size() - 1) == lowestRight)
			{
				if(arraysList.get(i).get(0) < outArray.get(0))
				{
					outArray = arraysList.get(i);
				}
			}
		}
		return outArray;
	}
}

