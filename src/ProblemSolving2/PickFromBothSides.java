package ProblemSolving2;

import java.util.ArrayList;
import java.util.Arrays;

public class PickFromBothSides {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
		System.out.println(new PickFromBothSidesSolutin().solve(list, 6));
	}

}

class PickFromBothSidesSolutin
{
public int solve(ArrayList<Integer> A, int B) {
		
	
		ArrayList<Integer> prefixSum = new ArrayList<Integer>();
		int sum = 0;
		for(int i=0; i<A.size(); i++)
		{
			sum = sum + A.get(i);
			prefixSum.add(sum);
		}
	
		int max = Integer.MIN_VALUE;
		for(int i=0; i<=B; i++)
		{
			int leftSum = (i==0) ? 0 : prefixSum.get(i-1);
			int intRightIndexStart = A.size()-(B-i)-1;
			int rightSum = prefixSum.get(A.size()-1) - ((intRightIndexStart < 0) ? 0 :prefixSum.get(intRightIndexStart));
			
			int tot = leftSum + rightSum;
			if(tot > max)
			{
				max = tot;
			}
		}
		return max;
    }
}
