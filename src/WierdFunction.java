import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WierdFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Math.abs(4-5);
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(4,2,5,1));
		System.out.println(new WierdFunctionSolution().sum(4, a));
	}

}


class WierdFunctionSolution {
    public int sum(int A, ArrayList<Integer> B) {
        //Collections.sort(B);
        
    	
        ArrayList<Integer> prefix = new ArrayList<Integer>();
        prefix.add(0);
        
        for(int i=1; i<=B.size(); i++)
        {
            int prev = prefix.get(i-1);
            int curr = B.get(i-1);
            prefix.add(curr + prev);
        }
        
        int total = 0;
        for(int i=0; i<B.size(); i++)
        {
            int j = search(B, i+1, B.size()-1, B.get(i));
            if((B.get(j) - B.get(i)) > 1)
            {
            	int sum = prefix.get(A) - prefix.get(j);
                int mul = B.get(i) * ((A-(j+1)) + 1);
                total = total +(sum + (mul * -1));
            }
            
        }
        
        return total;
    }
    
    
    public int search(ArrayList<Integer> B, int start, int end, int number)
    {
        int mid = (start + end) / 2;
        if(start >= end)
        {
            return mid;
        }
        
        
        int diff  = B.get(mid) - number;
        
        if(diff > 1)
        {
            return search(B, 0, mid, number);
        }
        else
        {
            return search(B, mid+1, end, number);
        }
    }
}
