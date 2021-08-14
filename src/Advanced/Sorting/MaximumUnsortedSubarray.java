package Advanced.Sorting;

import java.util.Arrays;

public class MaximumUnsortedSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MaximumUnsortedSubarraySolution
{
	public int[] subUnsort(int[] A) {
		int[] arrCopy = A.clone();
		Arrays.sort(A);
		
		int[] output = new int[2];
		boolean leftFound = false;
		boolean rightFound = false;
		
		for(int i=0; i<A.length; i++)
		{
			if(A[i] != arrCopy[i])
			{
				output[0] = i;
				leftFound = true;
				break;
			}
		}
		
		for(int i=A.length-1; i>=0; i--)
		{
			if(A[i] != arrCopy[i])
			{
				output[1] = i;
				rightFound = true;
				break;
			}
		}
		
		if(!leftFound && !rightFound)
		{
			return new int[] {-1};
		}
		else
		{
			return output;
		}
    }
}
