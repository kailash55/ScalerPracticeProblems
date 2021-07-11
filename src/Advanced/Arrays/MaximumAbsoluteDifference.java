package Advanced.Arrays;

import java.util.ArrayList;

public class MaximumAbsoluteDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MaximumAbsoluteDifferenceSolution
{
	public int maxArr(ArrayList<Integer> A) {
		
		ArrayList<Integer> cond1Arr = new ArrayList<Integer>();
		int maxOfCond1 = Integer.MIN_VALUE;
		int minOfCond1 = Integer.MAX_VALUE;
		for(int i=0; i<A.size(); i++)
		{
			int newValue = A.get(i) + i;
			cond1Arr.add(newValue);
			
			if(newValue > maxOfCond1)
				maxOfCond1 = newValue;
			
			if(newValue < minOfCond1)
				minOfCond1 = newValue;	
		}
		int cond1Diff = maxOfCond1 - minOfCond1;
		
		ArrayList<Integer> cond2Array = new ArrayList<Integer>();
		int maxOfCond2 = Integer.MIN_VALUE;
		int minOfCond2 = Integer.MAX_VALUE;
		for(int i=0; i<A.size(); i++)
		{
			int newValue = A.get(i) - i;
			cond2Array.add(newValue);
			
			if(newValue > maxOfCond2)
				maxOfCond2 = newValue;
			
			if(newValue < minOfCond2)
				minOfCond2 = newValue;	
		}
		int cond2Diff = maxOfCond2 - minOfCond2;
		return Math.max(cond1Diff, cond2Diff);
    }
}
