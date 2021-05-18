package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MultipleLeftRotations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>(
	            Arrays.asList(1, 2, 3, 4, 5));
		ArrayList<Integer> list2 = new ArrayList<Integer>(
	            Arrays.asList(7, 3));
		
		new MultipleLeftRotationsSolution().solve(list, list2);
	}

}

class MultipleLeftRotationsSolution
{
	public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		for(Integer positionsToRotate : B)
		{
			output.add(rotateLeft(A, positionsToRotate));
		}
		
		return output;
    }
	
	public ArrayList<Integer> rotateLeft(ArrayList<Integer> A, int postionsToRotate)
	{
		ArrayList<Integer> arrCopy = new ArrayList<Integer>();
		for(Integer i : A)
			arrCopy.add(i);
		
		
		for(int i=0; i<arrCopy.size(); i++)
		{
			int newPosition = i - postionsToRotate;
			if(newPosition < 0)
			{
				int mod = newPosition % arrCopy.size();
				if(mod == 0)
				{
					newPosition = 0;
				}
				else
				{
					newPosition = arrCopy.size()  + mod;
				}
			}
				
			
			arrCopy.set(newPosition, A.get(i));
		}

		return arrCopy;
	}
}
