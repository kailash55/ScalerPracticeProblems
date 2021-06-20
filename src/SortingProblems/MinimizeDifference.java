package SortingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class MinimizeDifference {

	
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(9,9,9));
		int o = new MinimizeDifferenceSolution().solve(arr,9);
		System.out.print(o);
	}
}



class MinimizeDifferenceSolution {
    public int solve(ArrayList<Integer> A, int B) {
        
    	int diff = Integer.MAX_VALUE;
    	int minValue = Integer.MAX_VALUE;
    	int maxValue = Integer.MIN_VALUE;
    	
    	boolean leftMovePossible = true;
    	boolean rightMovePossible = true;
    			
    	HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
    	
    	for(int i=0; i<A.size(); i++)
    	{
    		Integer number = countMap.get(A.get(i));
    		if(number == null)
    			countMap.put(A.get(i), 1);
    		else
    			countMap.put(A.get(i), number + 1);
    		
    		if(A.get(i) < minValue)
    			minValue = A.get(i);
    		
    		if(A.get(i) > maxValue)
    			maxValue = A.get(i);
    	}
    	
    	diff = maxValue - minValue;
    	while((B > 0) && (diff > 0) && (leftMovePossible || rightMovePossible))
		{
    		int countMin = countMap.get(minValue);
        	int countMax = countMap.get(maxValue);
        	
        	if(countMin <= countMax && leftMovePossible)
        	{
        		if(B >= countMin)
        		{
        			minValue = minValue + 1;
        			Integer newMinValueCount = countMap.get(minValue);
        			countMap.put(minValue,( newMinValueCount == null ? 0 : newMinValueCount) + countMin);
        			B = B - countMin;
        		}
        		else
        		{
        			leftMovePossible = false;
        		}
        	}
        	else
        	{
        		if(B >= countMax)
        		{
        			maxValue = maxValue - 1;
        			Integer newMaxValueCount = countMap.get(maxValue);
        			countMap.put(maxValue,( newMaxValueCount == null ? 0 : newMaxValueCount) + countMax);
        			B = B - countMax;
        		}
        		else
        		{
        			rightMovePossible = false;
        		}
        	}
        	
        	int currentDiff = maxValue - minValue;
        	if(currentDiff  < diff)
        	{
        		diff = currentDiff;
        	}
		}
    	
    	
    	
    	return diff;
    }
}
 
