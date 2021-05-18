package multidimensionalArrays;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] spiralMatrix = new SpiralMatrixSolution().generateMatrix(80);
		System.out.println("");
	}

}

class SpiralMatrixSolution
{
	public int[][] generateMatrix(int n) {
		
		int topRow = 0;
		int topColStart = 0;
		int topColEnd = n-1;
		
		int rightCol = n-1;
		int rightRowStart = 1;
		int rightRowEnd = n-1;
		
		int bottomRow = n-1;
		int bottomColStart = n-2;
		int bottomColEnd = 0;
		
		int leftCol = 0;
		int leftRowStart = n-2;
		int leftRowEnd = 1;
		
		int spiralIndexCount = 1;
		int spiralIndexMaxCount = (int)Math.pow(n, 2);
		int spiral_i = 0;
		int spiral_j = 0;
		int[][] spiralMatrix = new int[n][n];
		
		while(spiralIndexCount <= spiralIndexMaxCount)
		{
			//top loop
			for(int i=topColStart; i<=topColEnd; i++)
			{
				spiralMatrix[topRow][i] = spiralIndexCount;
				spiralIndexCount++;
				
			}
			topRow++; topColStart++; topColEnd--;
			
			
			for(int i=rightRowStart; i<=rightRowEnd; i++)
			{
				spiralMatrix[i][rightCol] = spiralIndexCount;	
				spiralIndexCount++;
			}
			rightCol--; rightRowStart++; rightRowEnd--;
			
			
			for(int i=bottomColStart; i>= bottomColEnd; i--)
			{
				spiralMatrix[bottomRow][i] = spiralIndexCount;	
				spiralIndexCount++;
			}
			bottomRow--; bottomColStart--; bottomColEnd++;
			
			
			for(int i=leftRowStart; i>=leftRowEnd; i--)
			{
				spiralMatrix[i][leftCol] = spiralIndexCount;		
				spiralIndexCount++;
			}
			leftCol++; leftRowStart--; leftRowEnd++;
		}
		
		
		return spiralMatrix;
    }
	
	public int[][] generateSimpleMatrix(int n)
	{
		int[][] matrix = new int[n][n];
		int number = 1;
		
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				matrix[i][j] = number;
				number++;
			}
		}
		return matrix;
	}
}
