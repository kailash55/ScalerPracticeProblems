package ProblemSolving6;

import java.util.ArrayList;
import java.util.HashMap;

public class DuplicateRowsInBinaryMatrix {

	public static void main(String[] args) {
		
	}
}

class DuplicateRowsInBinaryMatrixSolution
{
	public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
		
		HashMap<ArrayList<Integer>, String> map = new HashMap<ArrayList<Integer>, String>();
		
		ArrayList<Integer> outArray = new ArrayList<Integer>();
		for(int i=0; i<A.size(); i++)
		{
			if(map.get(A.get(i)) == null)
			{
				map.put(A.get(i), "");
			}
			else
			{
				outArray.add(i+1);
			}
		}
		
		return outArray;
    }
}
