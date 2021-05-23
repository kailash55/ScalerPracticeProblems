package HashingProblems;

import java.util.HashMap;

public class PairWithGivenXor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v = new PairWithGivenXorSolution().solve(new int[] {3, 6, 8, 10, 15, 50}, 5);
		System.out.println(v);
	}

}

class PairWithGivenXorSolution
{
	public int solve(int[] A, int B) {
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<String, String> pairs = new HashMap<String, String>();
		
		int count = 0;
		for(int i=0; i<A.length; i++)
		{
			Integer prev = map.get(A[i]);
			
			if(prev!=null)
			{
				int min = Math.min(A[i], prev);
				int max = Math.max(A[i], prev);
				String existingPair = pairs.get(min+ "_" + max);
				if(existingPair == null)
				{
					count++;
					pairs.put(min+ "_" + max, "dum");
				}
			}
			else
			{
				map.put(B ^ A[i], A[i]);
			}
		}
		return count;
    }
}
