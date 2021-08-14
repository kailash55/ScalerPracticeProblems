package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberOfSquarefulArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(2,2,2));
		System.out.println(new NumberOfSquarefulArraysSolution().solve(a));
	}

}

class NumberOfSquarefulArraysSolution
{
	class Count
	{
		public Count(int c)
		{
			this.c = c;
		}
		public int c;
	}
	public int solve(ArrayList<Integer> A) {
		
		Count c = new Count(0);
		rec(A, new ArrayList<Integer>(), A.size(), c);
		return c.c;
    }
	
	public void rec(ArrayList<Integer> input, ArrayList<Integer> out, int n, Count c)
	{
		
		for(int i=0; i<input.size(); i++)
		{
			int in = input.get(i);
			out.add(in);
			input.remove(i);
			
			int lastEl = out.get(out.size()-1);
			int secondLastEl = out.size() == 1 ? 0 : out.get(out.size()-2);
				
			boolean isPrefectSquare = checkIfPerfectSquare(lastEl + secondLastEl);
			if(isPrefectSquare || out.size() == 1)
			{
				if(out.size() == n)
				{
					input.add(i, in);
					out.remove(out.size()-1);
					c.c++;
					return;
				}
				rec(input, out, n, c);
				input.add(i, in);
				out.remove(out.size()-1);
			}
			else
			{
				input.add(i, in);
				out.remove(out.size()-1);
			}
			
		}
	}

	private boolean checkIfPerfectSquare(int number) {
		// TODO Auto-generated method stub
		int divisorsCount = 0;
		for(int i=1; (i*i)<=number; i++)
		{
			int rem = number % i;
			if(rem == 0)
			{
				int q = number / i;
				if(q == i)
				{
					divisorsCount = divisorsCount + 1;
				}
				else
				{
					divisorsCount = divisorsCount + 2;
				}
			}
		}
		
		if(divisorsCount % 2 == 0)
			return false;
		else
			return true;
	}
}
