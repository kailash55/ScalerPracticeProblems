package SortingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a  = new ArrayList<Integer>(Arrays.asList(8, 89));
		System.out.println(new LargestNumberSolution().largestNumber(a));
	}

}


class LargestNumberSolution
{
	public String largestNumber(final List<Integer> A) {
		Collections.sort(A, new LexicoComparatory());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<A.size(); i++)
		{
			sb.append(A.get(i));
		}
		
		String o = removePreZero(sb);
		return o;
    }
	
	private String removePreZero(StringBuilder sb) {
		// TODO Auto-generated method stub
		int firtNonZeroIndex = -1;
		for(int i=0; i<sb.length(); i++)
		{
			if(sb.charAt(i) != '0')
			{
				firtNonZeroIndex = i;
				break;
			}
				
		}
		
		if(firtNonZeroIndex == -1)
			return "0";
		else
			return sb.substring(firtNonZeroIndex);
	}

	class LexicoComparatory implements Comparator<Integer> {
	    // Used for sorting in ascending order of
	    // roll number
	    public int compare(Integer a, Integer b)
	    {
	    	String as = String.valueOf(a);
	    	String bs = String.valueOf(b);
	    	
	    	int c = Integer.valueOf(as + bs);
	    	int d = Integer.valueOf(bs + as);
	    	if(c > d)
	         return -1;
	    	else if(d > c)
	    	 return 1;
	    	else
	    	 return 0;
	    }
	}
}