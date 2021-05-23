package HashingProblems;

public class SubarrayWithGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SubarrayWithGivenSumSolution().solve(new int[] { 1, 1000000000}, 1000000000);
	}

}

class SubarrayWithGivenSumSolution
{
	public int[] solve(int[] A, int B) {
		int n = A.length;
		int[] output = null;
		int l = 0;
		int r = 0;
		int total = A[l];
		while(r<n && l<=r)
		{
			
			if(total==B)
			{
				output = new int[r-l+1];
				int oindex = 0;
				for(int i=l; i<=r; i++)
				{
					output[oindex] = A[i];
					oindex++;
 				}
				return output;
			}
			
			if(total<B)
			{
				r++;
				if(r<n)
					total = total + A[r];
			}
			
			if(total>B)
			{
				total = total - A[l];
				l++;
					
			}
		}
		
		output = new int[] {-1};
		return output;
    }
	
	
}
 