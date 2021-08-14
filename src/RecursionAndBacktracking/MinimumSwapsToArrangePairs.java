package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumSwapsToArrangePairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(10, 1, 7, 4, 6, 2, 3, 5, 8, 9));
		ArrayList<ArrayList<Integer>> C = new ArrayList<ArrayList<Integer>>();
		C.add(new ArrayList<Integer>(Arrays.asList(6, 7)));
		C.add(new ArrayList<Integer>(Arrays.asList(3, 9)));
		C.add(new ArrayList<Integer>(Arrays.asList(2, 5)));
		C.add(new ArrayList<Integer>(Arrays.asList(1, 4)));
		C.add(new ArrayList<Integer>(Arrays.asList(8, 10)));
		
		System.out.println(new MinimumSwapsToArrangePairsSolution().solve(3, B, C));
	}

}

class MinimumSwapsToArrangePairsSolution
{
	public int solve(int A, ArrayList<Integer> B, ArrayList<ArrayList<Integer>> C) {
		
		return rec(B, C, 0);
    }
	
	public int rec(ArrayList<Integer> B, ArrayList<ArrayList<Integer>> C, int i)
	{
		int iVal = B.get(i);
		int iPlusOneVal = B.get(i+1);
		
		int iPair = findPair(iVal, C);
		int iPlusOnePair = findPair(iPlusOneVal, C);
		
		while(i <= B.size()-3)
		{
			if(iPlusOneVal == iPair)
			{
				i=i+2;
			}
			else {
				break;
			}
		}
		
		if(i == B.size()-2)
		{
			return 0;
		}
		
		
		int swappedIndex = swapPair(i+1, iPair, B);
		int leftCount = rec(B, C, i+2);
		swap(i+1, swappedIndex, B);
		swappedIndex = swapPair(i, iPlusOnePair, B);
		int rightCount = rec(B, C, i+2);
		swap(i, swappedIndex, B);
		
		return Math.min(leftCount, rightCount) + 1;
	}

	private void swap(int i, int swappedIndex, ArrayList<Integer> B) {
		// TODO Auto-generated method stub
		int a = B.get(i);
		int b = B.get(swappedIndex);
		B.set(swappedIndex, a);
		B.set(i, b);
	}

	private int swapPair(int i, int iPair, ArrayList<Integer> B) {
		// TODO Auto-generated method stub
		int swapIndex = 0;
		for(int j=0; j<B.size(); j++ )
		{
			if(B.get(j) == iPair)
			{
				swapIndex = j;
			}
		}
		swap(i, swapIndex, B);
		return swapIndex;
	}

	private int findPair(int i, ArrayList<ArrayList<Integer>> C) {
		// TODO Auto-generated method stub
		for(int j=0; j< C.size(); j++)
		{
			int a = C.get(j).get(0);
			int b = C.get(j).get(1);
			
			if(a == i)
				return b;
			
			if(i == b)
				return a;
		}
		return 0;
	}
}

