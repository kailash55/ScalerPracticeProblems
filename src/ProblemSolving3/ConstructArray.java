package ProblemSolving3;

import java.util.ArrayList;

public class ConstructArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ConstructArraySolution().solve(7, 39, 41));
	}

}

class ConstructArraySolution
{
	public ArrayList<Integer> solve(final int A, final int B, final int C) {
		
		ArrayList<Integer> divisors = new ArrayList<Integer>();
		int difference = C - B;
		
		int finalLeft = -1;
		int finalDivisor = -1;
		int lowestRightCount = -1;
		for(int i=1; Math.pow(i, 2) <= difference; i++)
		{
			if(difference % i == 0)
			{
				divisors.add(i);
				
				if(i != (difference/i))
					divisors.add(difference/i);
			}
		}
		
		
		for(int i=0; i<divisors.size(); i++)
		{
			int divisor = divisors.get(i);
			boolean validDivisor = false;
			int left = C;
			int count = 0;
			while(left > 0)
			{
				left = left - divisor;
				count++;
				
				if(count == A)
					break;
			}
			
			left = left + divisor;
			
			
			if(count == A && left <= B && left >= 0)
			{
				validDivisor = true;
				if(left < finalLeft)
				{
					finalLeft = left;
					finalDivisor = divisor;
				}
				continue;
			}
			
			if(count == A && left > B)
			{
				validDivisor = false;
			}
			
			if(count != A)
			{
//				if(finalLeft == -1 || left < finalLeft)
//				{
//					finalLeft = left;
//					finalDivisor = divisor;
//				}
				int right = C;
				int rightCount = 0;
				while(count != A)
				{
					count++;
					rightCount++;
					right = right + divisor;
				}
				
				if(lowestRightCount == -1 || rightCount <= lowestRightCount)
				{
					lowestRightCount = rightCount;
					finalLeft = left;
					finalDivisor = divisor;
				}
			}
		}
		
		
		ArrayList<Integer> out = new ArrayList<Integer>();
		out.add(finalLeft);
		for(int i=2; i<=A; i++)
		{
			finalLeft = finalLeft + finalDivisor;
			out.add(finalLeft);
		}
		return out;
	}
}

