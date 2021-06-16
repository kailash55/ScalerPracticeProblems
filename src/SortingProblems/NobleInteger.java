package SortingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NobleInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(-4, -2, 0, -1, -6 ));
		System.out.println(new NobleIntegerSolution().solve(list));
	}

}

class NobleIntegerSolution
{
	public int solve(ArrayList<Integer> A) {
	        
	        Collections.sort(A);
	        ArrayList<Integer> uniqueSorted = new ArrayList<Integer>();
	        uniqueSorted = A;
//	        uniqueSorted.add(A.get(0));
//	        
//	        for(int i=1; i< A.size(); i++)
//	        {
//	            if(A.get(i) != A.get(i-1))
//	            {
//	                uniqueSorted.add(A.get(i));
//	            }
//	        }
	        
	        for(int i=0; i< uniqueSorted.size(); i++)
	        {
	        	if((i+1 < uniqueSorted.size()) && uniqueSorted.get(i) == uniqueSorted.get(i+1))
	        	{
	        		continue;
	        	}
	            if(A.get(i) == (uniqueSorted.size()-1-i))
	            {
	                return 1;
	            }
	        }
	        
	        return -1;
	    }
}
