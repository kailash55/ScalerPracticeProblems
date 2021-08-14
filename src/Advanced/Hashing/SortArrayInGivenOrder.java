package Advanced.Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortArrayInGivenOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = new int[] {12, 7};
		int[] arr2 = new int[] {7, 1, 6, 17, 2, 19, 10};
		
		int[] out = new SortArrayInGivenOrderSolution().solve(arr1, arr2);
		System.out.println(out);
	}

}


class SortArrayInGivenOrderSolution
{
	public int[] solve(int[] A, int[] B) {
		HashMap<Integer, Integer> sortCountMap = new HashMap<Integer, Integer>();
		int[] output = new int[A.length];
		Arrays.sort(A);
		for(int i=0; i<B.length; i++)
		{
			sortCountMap.put(B[i], 0);
		}
		
		for(int i=0; i<A.length; i++)
		{
			Integer elCount = sortCountMap.get(A[i]);
			
			if(elCount != null)
			{
				sortCountMap.put(A[i], elCount + 1);
			}
		}
		
		int outputIndex = 0;
		for(int i=0; i<B.length; i++)
		{
			Integer count = sortCountMap.get(B[i]);
			while(count > 0)
			{
				output[outputIndex] = B[i];
				outputIndex++;
				count--;
			}
		}
		
		for(int i=0; i<A.length; i++)
		{
			Integer elCount = sortCountMap.get(A[i]);
			
			if(elCount == null)
			{
				output[outputIndex] = A[i];
				outputIndex++;
			}
		}
		
		return output;
    }
}