package HashingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SubArrayWithZeroSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>(
	            Arrays.asList(5,6,7,9,-8,-8,5,9));
		new SubArrayWithZeroSumSolution().solve(list);
	}

}

class SubArrayWithZeroSumSolution
{
	public int solve(int[] A) {
		
		for(int i=0; i<A.length; i++)
		{
			int total=A[i];
			if(A[i]==0)
				return 1;
			for(int j=i+1; j< A.length; j++)
			{
				if(A[j]==0)
					return 1;
				total = total + A[j];
				if(total == 0)
					return 1;
			}
		}
		return 0;
    }
	
	public int solve(ArrayList<Integer> A) {
        
        HashMap<Long, Long> mp = new HashMap<Long, Long>();
        
        long sum = 0;
        mp.put(sum, new Long(1));
        for(int x:A){
            sum += x;
            if(mp.get(sum) != null) return 1;
            else
            {
                mp.put(sum, new Long(1));
            }
        }
        
        return 0;
        
    }
}
