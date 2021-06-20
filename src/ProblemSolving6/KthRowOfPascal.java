package ProblemSolving6;

import java.util.ArrayList;

public class KthRowOfPascal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new KthRowOfPascalSolution().getRow(7));
	}

}


class KthRowOfPascalSolution
{
	public int[] getRow(int A) {
		
		int[] row = new int[A+1];
		row[0] = 1;
		
		for(int i=1; i<=A; i++)
		{
			int temp = 0;
			int currentValue = 1;
			for(int j=0; j<=i; j++)
			{
				int previousValue = temp;
				currentValue = 0;
				if(j < A)
				{
					currentValue = row[j];
				}
				
				temp = currentValue;
				row[j] = previousValue + currentValue;
			}
		}
		return row;
    }
}
