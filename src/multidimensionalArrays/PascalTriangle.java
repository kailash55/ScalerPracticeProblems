package multidimensionalArrays;

public class PascalTriangle {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PascalTrianlgeSolution().solve(5);
	}
}

class PascalTrianlgeSolution
{
	public int[][] solve(int A) {
		
		if(A==0)
			return new int[][] {};
			
		int[][] output = new int[A][];
		output[0] = new int[] {1};
		
		for(int i=1; i<A; i++)
		{
			int[] pascalRow = new int[i+1];
			for(int j=0; j<=i; j++)
			{
				int firstValueIndex = j-1;
				int secondValueIndex = j;
				
				int firstValue=0;
				int secondValue = 0;
				
				if(firstValueIndex<0) 
					firstValue = 0;
				else 
					firstValue = output[i-1][firstValueIndex];
				
				if(secondValueIndex >= i)
					secondValue = 0;
				else
					secondValue = output[i-1][secondValueIndex];
					
				
				pascalRow[j] = firstValue + secondValue;
			}
			output[i] = pascalRow;
		}
		return output;
    }
}
