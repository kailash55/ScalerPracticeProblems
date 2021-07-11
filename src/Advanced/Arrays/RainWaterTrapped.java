package Advanced.Arrays;

import java.util.ArrayList;
import java.util.List;

public class RainWaterTrapped {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class RainWaterTrappedSolution
{
	public int trap(final List<Integer> A) {
		ArrayList<Integer> prefixMaxArr = new ArrayList<Integer>();
		prefixMaxArr.add(A.get(0));
		for(int i=1; i<A.size(); i++)
		{
			prefixMaxArr.add(Math.max(A.get(i), prefixMaxArr.get(i-1)));
		}
		
		ArrayList<Integer> postfixMaxArr = new ArrayList<Integer>();
		postfixMaxArr.add(A.get(A.size()-1));
		for(int i=A.size()-2; i>=0; i--)
		{
			postfixMaxArr.add(0, Math.max(A.get(i), postfixMaxArr.get(0)));
		}
		
		
		int waterContent = 0;
		for(int i=1; i<A.size()-1; i++)
		{
			int leftMax = prefixMaxArr.get(i);
			int rightMax = postfixMaxArr.get(i);
			
			int min = Math.min(leftMax, rightMax);
			
			waterContent += (min - A.get(i));
		}
		return waterContent;
    }
}
