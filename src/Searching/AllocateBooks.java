package Searching;

public class AllocateBooks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class AllocateBooksSolution
{
	public int books(int[] A, int B) {
		
		int totalPages = 0;
		for(int i=0; i<A.length; i++)
		{
			totalPages = totalPages + A[i];
		}
		
		int start = 0;
		int end = totalPages;
		
		while(start <= end)
		{
			int mid = (start + end) / 2;
			
			boolean satisfiesCondition = checkIfConditionSatisfies(A, B, mid);
			
			//if(satisfiesCondition)
		}
		return 0;
    }

	private boolean checkIfConditionSatisfies(int[] a, int b, int mid) {
		// TODO Auto-generated method stub
		return false;
	}
}
