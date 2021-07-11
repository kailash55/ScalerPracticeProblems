package Advanced.BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;

public class DifferentBitsSumPairwise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> lst = new ArrayList<Integer>
		(Arrays.asList(1,3,5));
		System.out.println(new DifferentBitsSumPairwiseSolution().cntBits(lst));
	}

}


class DifferentBitsSumPairwiseSolution
{
	public int cntBits(ArrayList<Integer> A) {
		long mod = (long) (Math.pow(10, 7) + 7);
		long total = 0;
		for(int i=0; i<A.size(); i++)
		{
			for(int j=0; j<A.size(); j++)
			{
				int xor = A.get(i) ^ A.get(j);
				int setBits = coutnSetBits(xor);
				total = total + setBits % mod;
			}
		}
		return (int) total;
    }
	
	public int coutnSetBits(int number)
	{
		int c = 0;
		while(number > 0 )
		{
			number = number & (number -1);
			c++;
		}
		return c;
	}
}