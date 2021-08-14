package Advanced.Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class CompareSortedSubarrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[] {1, 7, 11, 8, 11, 7, 1};
		int[][] B = new int[][] {
			{0, 2, 4, 6}
		};
		new CompareSortedSubarraysSolution().solve(A, B);
	}

}

class CompareSortedSubarraysSolution
{
	public int[] solve(int[] A, int[][] B) {
		long mod = 1000000;
		long[] longArr = new long[A.length];
		HashSet<Long> lset = new HashSet<Long>();
		HashMap<Integer, Long> map = new HashMap<Integer, Long>();
		
		for(int i=0; i<A.length; i++)
		{
			Integer num = A[i];
			Long h = map.get(num);
			
			if(h == null)
			{
				Random rd = new Random();
				h = rd.nextLong();
				while(lset.contains(h) || h<0)
				{
					h = rd.nextLong();
				}
				map.put(num, h);
			}
			
			h = h%mod;
			if(i == 0)
			{
				longArr[i] = h%mod;
			}
			else
			{
				//longArr[i] = ((h % mod) + (longArr[i-1]%mod))%mod;
				longArr[i] = (h % mod);
			}
			
		}
		
		long[] prefix = new long[longArr.length+1];
		for(int i=1; i<prefix.length; i++)
		{
			prefix[i] = longArr[i-1] + prefix[i-1];
		}
		
		int[] out = new int[B.length];
		for(int i=0; i<B.length; i++)
		{
			int[] q = B[i];
			long sum1 = prefix[q[1]+1] - prefix[q[0]];
			long sum2 = prefix[q[3]+1] - prefix[q[2]];
			
			if(sum1 == sum2)
			{
				out[i] = 1;
			}
			else
			{
				out[i] = 0;
			}
		}
		return out;
    }
}
