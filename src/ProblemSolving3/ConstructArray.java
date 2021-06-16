package ProblemSolving3;

import java.util.ArrayList;

public class ConstructArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ConstructArraySolution().solve(5, 20, 50));
	}

}

class ConstructArraySolution
{
	public ArrayList<Integer> solve(final int A, final int B, final int C) {
		
		int diff = C - B;
		int minDiffDivisor = 1;
		int minDiff = Math.abs(diff - A);
		
		ArrayList<Integer> quoteints = new ArrayList<Integer>();
		
		for(int i=2; Math.pow(i, 2) <= C; i++)
		{
			if(diff%i == 0)
			{
				
				quoteints.add(i);
				quoteints.add(diff/i);
			}
		}
		
		for(int j=0; j< quoteints.size(); j++)
		{
			int i = quoteints.get(j);
			int quo = diff / i;
			if(quo > A)
				continue;
			int quoDiff = Math.abs(quo - A);
			
			if(quoDiff < minDiff)
			{
				minDiff = quoDiff;
				minDiffDivisor = i;
			}
		}
		
		int start = 0;
		if(C - (minDiffDivisor * A) < 0)
		{
			start = 0;
		}
		else
		{
			start = C - (minDiffDivisor * A);
		}
		
		ArrayList<Integer> out = new ArrayList<Integer>();
		
		while(out.size()<=A)
		{
			out.add(start);
			start = start + minDiffDivisor;
		}
		return out;
    }
}

