package multidimensionalArrays;

public class AntiDiagnals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
		new AntiDiagnalsSolution().diagonal(input);
	}

}

class AntiDiagnalsSolution
{
	public int[][] diagonal(int[][] A) {
		
		int columnLength = A[0].length;
		int[][] output = new int[(columnLength*2)-1][];
		
		int outputArrayEntryCount = 0;
		for(int i=0; i<columnLength; i++)
		{
			int row = 0;
			int col = i;
			
			int[] diagnol = new int[i+1];
			int diagnolEntryCount = 0;
			while(col>=0)
			{
				diagnol[diagnolEntryCount] = A[row][col];
				diagnolEntryCount++;
				row++;
				col--;
			}
			
			output[outputArrayEntryCount] = diagnol;
			outputArrayEntryCount++;
		}
		
		outputArrayEntryCount = (columnLength*2)-2;
		for(int i= columnLength-1; i>=1; i--)
		{
			int row = i;
			int col = columnLength - 1;
			
			int[] diagnol = new int[columnLength-i];
			int diagnolEntryCount = 0;
			
			while(row <= columnLength-1)
			{
				diagnol[diagnolEntryCount] = A[row][col];
				diagnolEntryCount++;
				
				row++;
				col--;
			}
			output[outputArrayEntryCount] = diagnol;
			outputArrayEntryCount--;
		}
		return output;
    }
}
