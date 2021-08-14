package Searching;

import java.util.ArrayList;
import java.util.Arrays;

public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> A = new ArrayList<Integer>(
				Arrays.asList(71, 83, 127, 255, 434, 438, 478, 449, 410, 407, 388, 361, 340, 250, 238, 202, 193, 134, 105, 82, 76, 60, 21));
		
		System.out.println(new FindPeakElementSolution().solve(A));
	}

}


class FindPeakElementSolution
{
	public int solve(ArrayList<Integer> A) {
		
		int n = A.size();
		
		if(n == 1)
			return A.get(0);
		
		if(A.get(0) >= A.get(1))
			return A.get(0);
		
		if(A.get(n - 1) >= A.get(n-2))
			return A.get(n-1);
		
		return search(A, 1, n-1);
    }
	
	public int search(ArrayList<Integer> A, int start, int end)
	{
		int mid = (start + end) / 2;
		
		if(A.get(mid + 1) <= A.get(mid) && A.get(mid -1 ) <= A.get(mid))
		{
			return A.get(mid);
		}
		
		if(A.get(mid + 1 ) > A.get(mid))
		{
			return search(A, mid + 1, end);
		}
		else
		{
			return search(A, start, mid -1);
		}
	}
}
