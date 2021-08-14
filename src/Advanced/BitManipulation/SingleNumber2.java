package Advanced.BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleNumber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 3, 3, 2, 2, 3, 1, 1));
		System.out.println(new SingleNumber2Solution().singleNumber(A));
	}

}

class SingleNumber2Solution
{
	public int singleNumber(final List<Integer> A) {
		
		int outputNumber = 0;
		for(int i=0; i<32; i++)
		{
			int oneCount = 0;
			for(int j=0; j<A.size(); j++)
			{
				int number = A.get(j);
				int bit = (number & (1 << i)) == 0 ? 0 : 1;
				if(bit == 1)
				{
					oneCount++;
				}
			}
			
			int numberToOr = 0;
			if(oneCount % 3 != 0)
			{
				numberToOr = 1 << i;
			}
			
			outputNumber = outputNumber | numberToOr;
		}
		return outputNumber;
    }
}