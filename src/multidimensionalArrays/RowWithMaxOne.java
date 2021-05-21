package multidimensionalArrays;

public class RowWithMaxOne {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

class RowWithMaxOneSolution
{
	public int solve(int[][] a) {
        
		int maxOneRow = -1;
		int firstZeroColumnIndex = a[0].length-1;
		for(int i=0; i<a.length; i++)
		{
			for(int j=firstZeroColumnIndex; j>=0; j--)
			{
				if(a[i][j] == 1)
				{
					maxOneRow = i;	
				}
				else
				{
					firstZeroColumnIndex = j;
					break;
				}
			}
		}
		return maxOneRow;
    }
}