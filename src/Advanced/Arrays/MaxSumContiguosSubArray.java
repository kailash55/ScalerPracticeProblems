package Advanced.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumContiguosSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1967513926, 1540383426, -1303455736, -521595368));
		System.out.println(new MaxSumContiguosSubArraySolution().maxSubArray(arr));
	}

}

class MaxSumContiguosSubArraySolution
{
	public ArrayList<Integer> maxSubArray(final List<Integer> A) {
		
		long maxSum = 0;
		int maxIndexCount = 0;
		int maxIndexStart = 0;
		long currentSum = 0;
		int indexCount = 0;
		int indexStart = 0;
		
		for(int i=0; i<A.size(); i++)
		{
			
			if(A.get(i) < 0)
			{
				currentSum = 0;
				indexCount = 0;
				indexStart = 0;
				continue;
			}
			
			currentSum = currentSum + A.get(i);
			indexCount++;
			if(indexCount == 1)
			{
				indexStart = i;
			}
			if(currentSum > maxSum)
			{
				maxSum = currentSum;
				maxIndexCount = indexCount;
				maxIndexStart = indexStart;
			}
			else if(currentSum == maxSum)
			{
				if(indexCount > maxIndexCount)
				{
					maxSum = currentSum;
					maxIndexCount = indexCount;
					maxIndexStart = indexStart;
				}
			}
		
		}
		
		ArrayList<Integer> out = new ArrayList<Integer>();
		for(int i=0; i<maxIndexCount; i++)
		{
			out.add(A.get(maxIndexStart));
			maxIndexStart++;
		}
		return out;
    }
}