package multidimensionalArrays;

public class RotateMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
		new RotateMatrixSolution().solve(matrix);
		System.out.println();
	}

}


class RotateMatrixSolution
{
	public void solve(int[][] A) {
		
		int[][] copyArr = new int[A.length][A.length];
		for(int i=0; i< A.length; i++)
		{
			for(int j=0; j<A.length; j++)
			{
				copyArr[i][j] = A[i][j];
			}
		}
		
		int n = A.length;
		
		for(int i=0; i<A.length; i++)
		{
			for(int j=0; j<A.length; j++)
			{
				A[i][j] = copyArr[j][i];
			}
		}
		
		for(int i=0; i<A.length; i++)
		{
			for(int j=0; j<(A.length/2); j++)
			{
				int temp = A[i][j];
				A[i][j] = A[i][A.length-j-1];
				A[i][A.length-j-1] = temp;
			}
		}
		
    }
}