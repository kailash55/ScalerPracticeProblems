package multidimensionalArrays;

public class MatrixSearch {

	public static void main(String args[])
	{
		int[][] mat = new int[][] {
			{3, 3, 3},
			{3, 3, 3},
			{3, 3, 3}
		};
		
		int o = new MatrixSearchSolution().solve(mat, 3);
		System.out.println(o);
	}
}

class MatrixSearchSolution
{
	public int solve(int[][] A, int B) {
		
		int rowLength = A.length;
		int colLength = A[0].length;
		
//		int row = searchRow(A, B, 0, rowLength -1);
//		if(row==-1)
//			return -1;
		int row= -1;
		int col = -1;
		for(int i=0; i<A.length; i++)
		{
			int column = searchNumberInRow(A[i], B, 0 , colLength-1);
			if(column!=-1)
			{
				row = i;
				col = column;
				break;
			}
				
		}
		
	
		if(col==-1)
			return -1;
		
		int out = searchBackwardForMin(A, B, row, col);
		
		
		return out;
    }
	
	public int searchRow(int[][] A, int B, int startRow, int endRow)
	{
		int rowLength = A.length;
		int colLength = A[0].length;
		
		if(startRow>endRow)
		{
			return -1;
		}
		
		int midRow = (startRow +  (endRow))/2;
		
		if(A[midRow][0] <= B && A[midRow][colLength-1] >= B)
		{
			return midRow;
		}
		
		if(A[midRow][0] > B)
		{
			return searchRow(A, B, 0, midRow-1);
		}
		
		if(A[midRow][colLength-1] < B)
		{
			return searchRow(A, B, midRow+1, rowLength-1);
		}
		
		return -1;
	}
	
	public int searchNumberInRow(int[] a, int b, int startIndex, int endIndex)
	{
		int len = a.length;
		
		if(startIndex>endIndex)
		{
			return -1;
		}
		int mid = (startIndex + endIndex) / 2;
		
		if(a[mid] == b)
			return mid;
		
		if(b<a[mid])
			return searchNumberInRow(a, b, 0, mid-1);
		
		if(b>a[mid])
			return searchNumberInRow(a, b, mid+1, endIndex);
		
		return -1;
	}

	private int searchBackwardForMin(int[][] a, int b, int i, int j) {
		// TODO Auto-generated method stub
		
		if(i==0 && j==0) {
			return (i+1)*1009 +(j+1);
		}
		
		while(!(i<=0 && j==0))
		{
			
			int pJ = j-1;
			int pi = i;
			
//			if(pi==0 && pJ ==0)
//				return 0;
			
			if(pJ==0 && pi!=0)
			{
				pJ=a[0].length-1;
				pi--;
			}
			
			
			if(b != a[pi][pJ])
				return (i+1)*1009 +(j+1);
			
			if(i+j <= 0 )
			{
				return (i+1)*1009 +(j+1); 
			}
			j--;
			
			if(i+j <= 0 )
			{
				return (i+1)*1009 +(j+1); 
			}
			if(j==0)
			{
				j=a[0].length-1;
				i--;
			}
			
			
		}
		return 0;
	}
	
	class SearchDTO
	{
		public SearchDTO(int r, int c)
		{
			row = r;
			col = c;
		}
		int row;
		int col;
	}
}