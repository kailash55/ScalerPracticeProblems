package Advanced.BitManipulation;

import java.util.ArrayList;
import java.util.Collections;

public class MinXorValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MinXorValueSolution
{
	public int findMinXor(ArrayList<Integer> A) {
		Collections.sort(A);
		
		int minimumXorValue = Integer.MAX_VALUE;
		for(int i=1; i<A.size(); i++)
		{
			int xor = A.get(i) ^ A.get(i-1);
			if(xor < minimumXorValue)
			{
				minimumXorValue = xor;
			}
		}
		
		return minimumXorValue;
    }
}
