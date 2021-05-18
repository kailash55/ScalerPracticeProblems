package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GoodPair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GoodPairSolution2 s = new GoodPairSolution2();
		ArrayList<Integer> list = new ArrayList<Integer>(
	            Arrays.asList(1, 2, 3, 4));
		int c = s.solve(list, 7);
		System.out.println(c);
	}

}

class GoodPairSolution
{
	public int solve(ArrayList<Integer> A, int B) {
		int count = 0;
		for(int i=0; i<A.size(); i++)
		{
			for(int j=i+1; j<A.size(); j++)
			{
				if(((A.get(i)+A.get(j)) == B))
				{
					count++;
				}
			}
		}
		return count;
    }
}

class GoodPairSolution2
{
	public int solve(ArrayList<Integer> A, int B) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<A.size(); i++)
		{
			Integer s = map.get(A.get(i));
			if(s!=null)
				return 1;
			
			map.put(B-A.get(i), A.get(i));
		}
		return 0;
    }
}
