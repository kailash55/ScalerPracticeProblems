package Advanced.Hashing;

import java.util.HashMap;

public class SubArrayWithZeroSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class SubArrayWithZeroSumSolution
{
public int solve(int[] A) {
        
        
        HashMap<Long,Integer> map = new HashMap<Long, Integer>();
        map.put(0l, 0);
        map.put((long) A[0], 0);
        
        long sum = A[0];
        for(int i=1; i<A.length; i++)
        {
            sum = sum + A[i];
            Integer sumExist = map.get(sum);
            
            if(sumExist == null)
            {
                map.put(sum, 0);
            }
            else
            {
                return 1;
            }
        }
        
        return 0;
    }
}
