package Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotatedSortedArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>
		(Arrays.asList(4, 5, 6, 7, 0, 1, 2));
		
		System.out.println(new RotatedSortedArraySearchSolution().search(a,7));
	}

}

class RotatedSortedArraySearchSolution
{
	public int search(final List<Integer> A, int B) {
		int dipPoint = searchDipPoint(A, 0, A.size()-1);
		
		int left = binarySearch(A, 0, dipPoint-1, B);
		if(left >=0)
			return left;
		
		int right = binarySearch(A, dipPoint, A.size()-1, B);
		
		return right;
    }
	
	public int binarySearch(List<Integer> A, int start, int end, int B)
	{
		if(start>end)
			return -1;
		
		int mid = (start + end) / 2;
		
		if(A.get(mid) == B)
			return mid;
		
		if(A.get(mid) > B)
			return binarySearch(A, start, mid-1, B);
		else
			return binarySearch(A, mid+1, end,B);
	}
	public int searchDipPoint(List<Integer> A, int start, int end)
	{
		int mid = (start + end) / 2;
		
		int midEl = A.get(mid);
		int prevEl = mid == 0 ? 0 : A.get(mid-1);
		int nextEl = mid == A.size()-1 ? 0 : A.get(mid+1);
		
		if((midEl < prevEl || mid == 0) && (midEl < nextEl || mid == A.size()-1))
			return mid;
		
		if(midEl > A.get(A.size()-1))
		{
			return searchDipPoint(A, mid + 1, end);
		}
		else
		{
			return searchDipPoint(A, start, mid-1);
		}
	}
}
