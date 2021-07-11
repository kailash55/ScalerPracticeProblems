package Advanced.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class AddOneToNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(9, 9, 9, 9, 9));
		System.out.println(new AddOneToNumberSolution().plusOne(arr));
	}

}

class AddOneToNumberSolution
{
	public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		ArrayList<Integer> out = new ArrayList<Integer>();
		int carry=1;
		int nonZeroIndex = 0;
		for(int i=A.size()-1; i>=0; i--)
		{
			int currentNumber = A.get(i);
			if(carry == 1)
			{
				currentNumber = currentNumber + 1;
				
				if(currentNumber == 10)
				{
					carry = 1;
					currentNumber = 0;
				}
				else
				{
					//nonZeroIndex = i;
					carry = 0;
				}
			}
			if(currentNumber!=0)
			{
				nonZeroIndex = i;
			}
			out.add(0, currentNumber);
		}
		
		if(carry == 1)
		{

			out.add(0,1);
			nonZeroIndex = 0;
		}
			
		
		ArrayList<Integer> finalOut = new ArrayList<Integer>();
		for(int i=nonZeroIndex; i<out.size(); i++)
		{
			finalOut.add(out.get(i));
		}
		return finalOut;
    }
}
