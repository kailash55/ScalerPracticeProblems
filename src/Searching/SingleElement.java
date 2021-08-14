package Searching;

import java.util.ArrayList;
import java.util.Arrays;

public class SingleElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(13, 13, 21, 21, 27, 50, 50, 102, 102, 108, 108, 110, 110, 117, 117, 120, 120, 123, 123, 124, 124, 132, 132, 164, 164, 166, 166, 190, 190, 200, 200, 212, 212, 217, 217, 225, 225, 238, 238, 261, 261, 276, 276, 347, 347, 348, 348, 386, 386, 394, 394, 405, 405, 426, 426, 435, 435, 474, 474, 493, 493));
		System.out.println(new SingleElementSolution().solve(A));
	}

}

class SingleElementSolution
{
	public int solve(ArrayList<Integer> A) {
		
		
		return search(A,0, A.size()-1);
    }
	
	public int search(ArrayList<Integer> A, int start, int end)
	{
		if(start >= end)
		{
			return A.get(start);
		}
		int mid = (start + end) / 2;
		int prev = mid-1;
		int next = mid+1;
		
		int c = 0;
		if(A.get(prev).intValue() != A.get(mid).intValue() && A.get(next).intValue() != A.get(mid).intValue())
		{
			return A.get(mid);
		}
		else if(mid == 0 || (A.get(prev).intValue() == A.get(mid).intValue()))
		{
			c = mid-1;
		}
		else
		{
			c = mid;
		}
		
		if((c+1) % 2 != 0)
		{
			return search(A, c+2, end);
		}
		else
		{
			return search(A, start , c-1);
		}
	}
}
