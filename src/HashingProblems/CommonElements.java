package HashingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CommonElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list1 = new ArrayList<Integer>(
	            Arrays.asList(2, 1, 4, 10));
		ArrayList<Integer> list2 = new ArrayList<Integer>(
	            Arrays.asList(3, 6, 2, 10, 10));
		
		ArrayList<Integer> output = new CommonElementsSolution().solve(list1, list2);
		System.out.println(output);
	}

}

class CommonElementsSolution
{
	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		
		ArrayList<Integer> output = new ArrayList<Integer>();
		HashMap<Integer, Integer> numbersCountMap = new HashMap<Integer, Integer>();
		
		for(int i=0; i<A.size(); i++)
		{
			Integer existingNumberCount = numbersCountMap.get(A.get(i));
			
			if(existingNumberCount == null)
			{
				numbersCountMap.put(A.get(i), 1);
			}
			else
			{
				numbersCountMap.put(A.get(i), existingNumberCount+1);
			}
			
		}
		
		for(int i=0; i<B.size(); i++)
		{
			Integer existingInFirstArrayCount = numbersCountMap.get(B.get(i));
			
			if(existingInFirstArrayCount!=null)
			{
				output.add(B.get(i));
				int newCount = existingInFirstArrayCount - 1;
				if(newCount == 0)
				{
					numbersCountMap.remove(B.get(i));
				}
				else
				{
					numbersCountMap.put(B.get(i), newCount);
				}
			}
		}
		return output; 
    }
}
