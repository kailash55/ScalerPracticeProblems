package Searching;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>
		(Arrays.asList(1,2,3,4,5,8,10,11));
		
		System.out.println(new SortedInsertPositionSolution().searchInsert(a, 12));
	}

}

class SortedInsertPositionSolution
{
	public int searchInsert(ArrayList<Integer> A, int B) {
		
		
		return search(A, 0, A.size()-1, B);
    }
	
	public int search(ArrayList<Integer> A, int start, int end, int B)
	{
		if(start > end)
		{
			System.out.println(start + " " + end);
			return end + 1;
		}
		
		int mid = (start + end)/2;
		
		if(A.get(mid) == B)
			return mid;
		
		if(A.get(mid) > B)
			return search(A, start, mid-1, B);
		else
			return search(A, mid+1, end, B);
	}
}
