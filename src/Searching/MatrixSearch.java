package Searching;

public class MatrixSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = {{1}};
		System.out.println(new MatrixSearchSolution().searchMatrix(A, 1));
	}

}

class MatrixSearchSolution
{
	public int searchMatrix(int[][] A, int B) {
		int row = searchRow(A, 0, A.length-1, B);
		
		if(row == -1)
			return 0;
		
		int column = searchColumn(A[row], 0, A[row].length-1, B);
		
		if(column == -1)
			return 0;
		else
			return 1;
    }

	private int searchColumn(int[] a, int start, int end, int b) {
		
		if(start > end)
			return -1;
		// TODO Auto-generated method stub
		int mid = (start + end) / 2;
		
		if(a[mid] == b)
			return mid;
		else if(a[mid] > b)
			return searchColumn(a, start, mid-1, b);
		else
			return searchColumn(a, mid+1, end, b);
	}

	private int searchRow(int[][] a, int start, int end, int b) {
		// TODO Auto-generated method stub
		
		if(start > end)
			return -1;
		
		int mid = (start + end) / 2;
		int l = a[mid].length;
		int firstEl = a[mid][0];
		int lastEl = a[mid][l-1];
		
		if(firstEl <= b && lastEl >= b)
		{
			return mid;
		}
		else if(firstEl > b)
		{
			return searchRow(a, start, mid-1, b);
		}
		else
		{
			return searchRow(a, mid+1, end, b);
		}
	}
}
