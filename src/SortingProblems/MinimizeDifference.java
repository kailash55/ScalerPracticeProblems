package SortingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinimizeDifference {

	
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(2, 6, 3, 9, 8));
		int o = new MinimizeDifferenceSolution().solve(arr, 3);
		System.out.print(o);
	}
}



class MinimizeDifferenceSolution {
    public int solve(ArrayList<Integer> A, int B) {
        
    	int lowestDifference = Integer.MAX_VALUE;
        Collections.sort(A);
        int l=0;
        int r=A.size()-1;
        
        boolean leftCanMove = true;
        boolean rightCanMove = true;
        
        while(B>0 && lowestDifference > 0 && (leftCanMove || rightCanMove))
        {
            int leftDiff = A.get(l+1) - A.get(l);
            int rightDiff = A.get(r)  - A.get(r-1);
            
            int leftTotalDiff = leftDiff * (l+1);
            int rightTotalDiff = rightDiff * (A.size()-r);
            
            if(((l+1) <= (A.size()-r)) && leftCanMove)
            {
                if(leftDiff > 0)
                {
                    if(B >= (l+1))
                    {
                        A.set(l, A.get(l)+1);
                        B = B - (l+1);
                    }
                    else
                    {
                    	leftCanMove = false;
                    }
                }
                else
                {
                    l++;
                }
            }
            else
            {
                if(rightDiff > 0)
                {
                    if(B >= A.size()-r)
                    {
                        A.set(r, A.get(r)-1);
                        B = B - (A.size()-r);
                    }
                    else
                    {
                    	rightCanMove = false;
                    }
                }
                else
                {
                    r--;
                    continue;
                }
            }
            
            
            int diff = A.get(r) - A.get(l);
            if(diff < lowestDifference)
            {
            	lowestDifference = diff;
            }
        }
        
        return lowestDifference;
    }
}
 
