package ProblemSolving2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ContiguousArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>(
				Arrays.asList(0,0,0));
		
		System.out.println(new ContiguousSolution().solve(a));
	}

}

class ContiguousSolution
{
	public int solve(ArrayList<Integer> A) {
        ArrayList<Integer> prefixArray = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        map.put(0, 0);
        int sum = 0;
        int maxLength = 0;
        
        for(int i=0; i<A.size(); i++)
        {
            sum = sum + (A.get(i) == 0 ? -1 : 1);
            Integer n = map.get(sum);
            
            if(n == null)
            {
                map.put(sum ,i+1);
            }
            else
            {
                int t = i-n;
                if(t > maxLength)
                {
                    maxLength = t;
                }
            }
        }
        return maxLength;
    }
}
