package Advanced.Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class ShaggyAndDistances {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class ShaggyAndDistancesSolution
{
	public int solve(int[] A) {
		boolean pairFound = false;
		HashMap<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();
		int minDist = Integer.MAX_VALUE;
		for(int i=0; i<A.length; i++)
		{
			int num = A[i];
			Integer[] pair = map.get(num);
			
			if(pair == null)
			{
				map.put(num, new Integer[] {i, Integer.MAX_VALUE});
			}
			else
			{
				pairFound = true;
				int prevIndex = pair[0];
				int prevDis = pair[1];
				int currentDistance = i - prevIndex;
				
				if(currentDistance < prevDis)
				{
					map.put(num, new Integer[] {i, currentDistance});
				}
				else
				{
					map.put(num, new Integer[] {i, prevDis});
				}
			}
			
			Integer[] nPair = map.get(num);
			
			if(nPair[1] < minDist)
			{
				minDist = nPair[1];
			}
		}
		
		if(pairFound)
			return minDist;
		else
			return -1;
    }
}
