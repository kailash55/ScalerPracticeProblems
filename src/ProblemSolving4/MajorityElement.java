package ProblemSolving4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l = new ArrayList<Integer>(
				Arrays.asList(100));
		System.out.println(new MajorityElementSolution().majorityElement(l));
	}

}

class MajorityElementSolution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int majorityElement(final List<Integer> A) {
        
        HashMap<Integer,Integer> countMap = new HashMap<Integer,Integer>();
        
        for(int i=0; i<A.size();i++)
        {
            int number = A.get(i);
            Integer existingCount = countMap.get(number);
            
            if(existingCount == null)
            {
                countMap.put(number,1);
            }
            else
            {
                countMap.put(number,existingCount + 1);
            }
        }
        

        for (Integer key : countMap.keySet()) {
            Integer value = countMap.get(key);
            if(value > (A.size()/2))
            {
                return key;
            }
        }
   
        
        return 0;
    }
}

