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
		int mod = 1000 * 1000 * 1000 + 7;
		long totalBits = 0;
		for(int i=0; i<32; i++)
		{
			long count0 = 0;
			long count1 = 0;
			
			for(int j=0; j<A.size(); j++)
			{
				int number = A.get(j);
				int numberToAnd = 1 << i;
				int andResult = number & numberToAnd;
				if(andResult == 0)
				{
					count0++;
				}
				else
				{
					count1++;
				}
			}
			
			totalBits = (totalBits + (((count0 * count1) * 2) % mod)) % mod;
		}
		return ((int)totalBits);
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