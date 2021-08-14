package Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class AllSubarrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(9684070, 8434295, 5257262, 2548570, 2302579, 7388791, 3806526, 6533330, 5381853, 4544656));
		System.out.println(new AllSubarraysSolution().solve(a));
	}

}

class AllSubarraysSolution
{
	public int solve(ArrayList<Integer> A) {
		int n = A.size();
		Stack<Integer> s = new Stack<Integer>();
		Integer out = Integer.MIN_VALUE;
		ArrayList<Integer> leftMaxIndex = new ArrayList<Integer>();
		//find maximum on left
		s.push(0);
		leftMaxIndex.add(0);
		for(int i=1; i<A.size(); i++)
		{
			if(A.get(i) >A.get(s.peek()))	
			{
				leftMaxIndex.add(s.peek());
				s.push(i);
			}
			else
			{
				leftMaxIndex.add(-1);
			}
		}
		
		
		ArrayList<Integer> rightMaxIndex = new ArrayList<Integer>();
		//find maximum on right
		s.empty();
		s.push(n-1);
		rightMaxIndex.add(n-1);
		
		for(int j=1; j<A.size(); j++)
		{
			int i = n-1-j;
			rightMaxIndex.add(0, s.peek());
			if(A.get(i) > A.get(s.peek()))
			{
				rightMaxIndex.add(i);
				s.push(i);
			}
			else
			{
				rightMaxIndex.add(-1);
			}
		}
		
		
		for(int i=0; i<A.size(); i++)
		{
			int leftMaxXor = -1;
			if(leftMaxIndex.get(i) != -1)
			{
				leftMaxXor = A.get(leftMaxIndex.get(i)) ^ A.get(i);
			}
			
			int rightMaxXor = -1;
			if(rightMaxIndex.get(i) != -1)
			{
				rightMaxXor = A.get(rightMaxIndex.get(i)) ^ A.get(i);
			}

			
			int max = Math.max(leftMaxXor, rightMaxXor);
			
			if(max > out)
			{
				out = max;
			}
		}
		return out;
    }
}
