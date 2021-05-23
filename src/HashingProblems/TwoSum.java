package HashingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>(
	            Arrays.asList(2, 7, 11, 15));
		ArrayList<Integer> output = new TwoSumSolution().twoSum(list, 9);
		System.out.println();
	}

}


class TwoSumSolution
{
	public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<A.size(); i++)
		{
			Integer opp = map.get(A.get(i));
			if(opp!=null)
			{
				output.add(opp+1);
				output.add(i+1);
				return output;
			}
			
			int diff = B - A.get(i);
			Integer prev = map.get(diff);
			if(prev == null || prev>i)
			{
				map.put(diff, i);
			}
		}
		
		return output;
    }
}