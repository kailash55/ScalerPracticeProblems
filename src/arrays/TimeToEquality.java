package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class TimeToEquality {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>(
	            Arrays.asList(1,2,5,6,3,2));
		int max = new TimeToEqualitySolution().findMax(list);
		System.out.println(max);
	}

}

class TimeToEqualitySolution
{
	public int solve(ArrayList<Integer> A) {
		int maxNumber = findMax(A);
		int secCount = 0;
		for(int i=0; i<A.size(); i++)
		{
			secCount = secCount + (maxNumber - A.get(i));
		}
		return secCount;
    }
	
	public int findMax(ArrayList<Integer> A)
	{
		int largestNumber = 0;
		for(int i=0; i<A.size(); i++)
		{
			if(A.get(i) > largestNumber)
			{
				largestNumber = A.get(i);
			}
		}
		return largestNumber;
	}
}
