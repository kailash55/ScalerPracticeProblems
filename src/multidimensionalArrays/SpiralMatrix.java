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
		
		int[][] m = generateSimpleMatrix(n);
		
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
				System.out.print(m[topRow][i]+" ");
				spiralMatrix[spiral_i][spiral_j] = m[topRow][i];
				//spiral_j++;
				if(spiral_j == n-1)
				{
					spiral_i++;
					spiral_j=0;
				}
				else {
					spiral_j++;
				}
				spiralIndexCount++;
				
			}
			topRow++; topColStart++; topColEnd--;
			
			
			for(int i=rightRowStart; i<=rightRowEnd; i++)
			{
				System.out.print(m[i][rightCol]+" ");
				spiralMatrix[spiral_i][spiral_j] = m[i][rightCol];
				if(spiral_j == n-1)
				{
					spiral_i++;
					spiral_j=0;
				}
				else {
					spiral_j++;
				}				
				spiralIndexCount++;
			}
			rightCol--; rightRowStart++; rightRowEnd--;
			
			
			for(int i=bottomColStart; i>= bottomColEnd; i--)
			{
				System.out.print(m[bottomRow][i]+" ");
				spiralMatrix[spiral_i][spiral_j] = m[bottomRow][i];
				if(spiral_j == n-1)
				{
					spiral_i++;
					spiral_j=0;
				}
				else {
					spiral_j++;
				}	
				spiralIndexCount++;
			}
			bottomRow--; bottomColStart--; bottomColEnd++;
			
			
			for(int i=leftRowStart; i>=leftRowEnd; i--)
			{
				System.out.print(m[i][leftCol]+" ");
				spiralMatrix[spiral_i][spiral_j] = m[i][leftCol];
				if(spiral_j == n-1)
				{
					spiral_i++;
					spiral_j=0;
				}
				else {
					spiral_j++;
				}	
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
