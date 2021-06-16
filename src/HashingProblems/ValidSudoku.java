package HashingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> list = new ArrayList<String>(
	            Arrays.asList("..5.....6", "....14...", ".........", ".....92..", "5....2...", ".......3.", "...54....", "3.....42.", "...27.6.."));
		
		for(int i=0; i<9; i++)
		{
			for(int j=0; j<9; j++)
			{
				System.out.print(list.get(i).charAt(j) + " ");
			}
			System.out.println();
		}
		System.out.println(new ValidSudokuSolution().isValidSudoku(list));
	}

}

class ValidSudokuSolution
{
	public int isValidSudoku(final List<String> A) {
		int size = 9;
		for(int i=0; i<size; i++)
		{
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int j=0; j<size; j++)
			{
				if(A.get(i).charAt(j) != '.')
				{
					Integer number = map.get(Character.getNumericValue(A.get(i).charAt(j)));
					if(number != null)
					{
						return 0;
					}
					else
					{
						map.put(Character.getNumericValue(A.get(i).charAt(j)), Integer.MIN_VALUE);
					}
				}
			}
		}
		
		for(int i=0; i<size; i++)
		{
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int j=0; j<size; j++)
			{
				if(A.get(j).charAt(i) != '.')
				{
					Integer number = map.get(Character.getNumericValue(A.get(j).charAt(i)));
					if(number != null)
					{
						return 0;
					}
					else
					{
						map.put(Character.getNumericValue(A.get(j).charAt(i)), Integer.MIN_VALUE);
					}
				}
			}
		}
		
		
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				if(!validSubMatrix(A, i, j))
				{
					return 0;
				}
			}
		}
		
		return 1;
    }

	private boolean validSubMatrix(List<String> A, int i, int j) {
		i = 3*i;
		j = 3*j;
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int k=i; k<i+3; k++)
		{
			for(int l=j; l< j+3; l++)
			{
				if(A.get(k).charAt(l) != '.')
				{
					Integer number = map.get(Character.getNumericValue(A.get(k).charAt(l)));
					if(number != null)
					{
						return false;
					}
					else
					{
						map.put(Character.getNumericValue(A.get(k).charAt(l)), Integer.MIN_VALUE);
					}
				}
			}
		}
		return true;
	}
	
}

