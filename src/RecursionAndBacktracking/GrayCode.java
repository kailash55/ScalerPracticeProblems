package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;

public class GrayCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new GrayCodeSolution().grayCode(3)); 
	}

}

class GrayCodeSolution
{
	public ArrayList<Integer> grayCode(int a) {
		ArrayList<ArrayList<Integer>> outBits = grayCodeRec(a);
		
		ArrayList<Integer> out = new ArrayList<Integer>();
		
		for(int i=0; i<outBits.size(); i++)
		{
			int dec = 0;
			ArrayList<Integer> currentBitSequence = outBits.get(i);
			
			for(int j=currentBitSequence.size()-1; j>=0; j--)
			{
				int pow = currentBitSequence.size() - 1 - j;
				dec = dec + ((1 << pow) * currentBitSequence.get(j));
			}
			out.add(dec);
		}
		
		return out;
	}

	private ArrayList<ArrayList<Integer>> grayCodeRec(int a) {
		if(a==1)
		{
			ArrayList<ArrayList<Integer>> base = new ArrayList<ArrayList<Integer>>();
			base.add(new ArrayList<Integer>(Arrays.asList(0)));
			base.add(new ArrayList<Integer>(Arrays.asList(1)));
			return base;
		}
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> prev = grayCodeRec(a-1);
		
		for(int i=0; i<prev.size(); i++)
		{
			ArrayList<Integer> curr = new ArrayList<Integer>(prev.get(i));
			curr.add(0,0);
			current.add(curr);
		}
		
		for(int i=prev.size()-1; i>=0; i--)
		{
			ArrayList<Integer> curr = new ArrayList<Integer>(prev.get(i));
			curr.add(0,1);
			current.add(curr);
		}
		return current;
	}
}
 