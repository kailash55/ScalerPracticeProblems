package ProblemSolving3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class SumTheDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new SumTheDifferenceSolution().pow(2, 5, 10000);
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList());
		
		Random rand = new Random(); 
		for(int i=0; i<500; i++)
		{
			int n = rand.nextInt(1000);
			A.add(n);
			System.out.print(n + " ");
		}
		//System.out.println(A);
		System.out.println(new SumTheDifferenceSolution().solve(A));
	}

}

class SumTheDifferenceSolution
{
	public int solve(ArrayList<Integer> A) {
		
		Collections.sort(A);
		
		long count = 0;
		for(int i=0; i<A.size(); i++)
		{
			for(int j=i+1; j<A.size(); j++)
			{
				long pown =  pow(2, j-i-1,1000000007 );
				count = count + ((A.get(j) - A.get(i)) * pown) % 1000000007;
			}
		}
		return (int)((count)  % 1000000007);
    }
	
	public long pow(long x, int y, int k) {
        long result = 1;
        while (y > 0) {
            if (y % 2 == 1) {
                result = (result * x) % k;
                y--;
            }
            y >>= 1;
            x = (x * x) % k;
        }
        return result;
    }
}