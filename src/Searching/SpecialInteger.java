package Searching;

import java.util.ArrayList;
import java.util.Arrays;

public class SpecialInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>
		(Arrays.asList(5, 17, 100, 11));
		
		System.out.println(new SpecialIntegerSolution().solve(a, 130));
	}

}

class SpecialIntegerSolution
{
	public int solve(ArrayList<Integer> Ar, int B) {
		
		ArrayList<Long> A = new ArrayList<Long>();
		A.add((long) Ar.get(0));
		
		for(int i=1; i<Ar.size(); i++)
		{
			A.add((long)(Ar.get(i) + A.get(i-1)));
		}
		
		int k = -1;
		int start = 0;
		int end = A.size()-1;
		
		while(start <= end)
		{
			int mid = (start + end) / 2;
			boolean IfSatisfies = checkIfSatisfies(A, B, mid);
			if(IfSatisfies)
			{
				k = mid;
				start = mid + 1;
			}
			else
			{
				end = mid -1;
			}
		}
		return k+1;
    }
	
	public boolean checkIfSatisfies(ArrayList<Long> A, int B, int k)
	{
		for(int i=k; i<A.size(); i++)
		{
			long sum = A.get(i);
			if(i > k)
			{
				sum = sum - A.get(i - (k+1));
			}
			
			if(sum > B)
				return false;
		}
		return true;
	}
}
