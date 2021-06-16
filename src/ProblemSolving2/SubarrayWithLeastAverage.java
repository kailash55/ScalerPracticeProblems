package ProblemSolving2;

import java.util.ArrayList;
import java.util.Arrays;

public class SubarrayWithLeastAverage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<Integer>
		(Arrays.asList(15, 7, 11, 7, 9, 8, 18, 1, 16, 18, 6, 1, 1, 4, 18));
		System.out.println(new SubarrayWithLeastAverageSolution().solve(A, 6));
	}

}


class SubarrayWithLeastAverageSolution
{
	public int solve(ArrayList<Integer> A, int B) {
		
		int sum = 0;
        int minAverage = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i=0; i< A.size(); i++)
        {
            sum = sum + A.get(i);
            
            if(i>=B)
            {
                sum = sum - A.get(i-B);
            }
            
            if(i>=(B-1))
            {
	            int average = sum/B;
	            if(average <= minAverage)
	            {
	                minAverage = average;
	                minIndex = i-(B-1);
	            }
            }
        }
        
        return minIndex;
	}
}