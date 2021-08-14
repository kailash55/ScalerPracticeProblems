package Advanced.BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;

public class SingleNumber3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class SingleNumber3Solution
{
	public ArrayList<Integer> solve(ArrayList<Integer> A) {
		
		int i = 0;
		for(i=0; i<32; i++)
		{
			int zeroCount = 0;
			for(int j=0; j<A.size(); j++)
			{
				int number = A.get(j);
				int andNumber = 1 << i;
				
				if((number & andNumber) == 0)
					zeroCount++;
			}
			
			if((zeroCount & 1) == 1 )
			{
				break;
			}
		}
		
		int oneXor = 0;
		int zeroXor = 0;
		
		for(int j=0; j<A.size(); j++)
		{
			int number = A.get(j);
			int andNumber = 1 << i;
			
			if((number & andNumber) == 0)
			{
				zeroXor = zeroXor ^ number;
			}
			else
			{
				oneXor = oneXor ^ number;
			}
		}
		
		ArrayList<Integer> out = new ArrayList<Integer>
		(Arrays.asList(Math.min(oneXor, zeroXor), Math.max(oneXor, zeroXor))) ;
		return out;
    }
}
