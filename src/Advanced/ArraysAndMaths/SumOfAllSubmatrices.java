package Advanced.ArraysAndMaths;

import java.util.ArrayList;

public class SumOfAllSubmatrices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[][] 
				{
					{8, 9, 9, 1, 7},
					{5, 5, 10, 1, 0},
					{7, 7, 5, 8, 6},
					{7, 3, 7, 9, 2},
					{7, 7, 8, 10, 6}
				};
		
				System.out.println(new SumOfAllSubmatricesSolution().solve(arr));
				
	}

}

class SumOfAllSubmatricesSolution
{
	public int solve(int[][] A) {
		
		int sum = 0;
		for(int i=0; i<A.length; i++)
		{
			for(int j=1; j<A[0].length; j++)
			{
				//sum = sum + (A[i][j] * ((i*j) + ());
			}
		}
		
	
		return sum;
    }
}
