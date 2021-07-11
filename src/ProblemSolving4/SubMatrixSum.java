package ProblemSolving4;

public class SubMatrixSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] A = new int[][] {
				{1, 2, 3, -1, 6},
		};
		
		int[] B = new int[]{1};
		int[] C = new int[]{2};
		int[] D = new int[]{1};
		int[] E = new int[]{2};
		
		new SubMatrixSumSolution().solve(A, B, C, D, E);
	}

}

class SubMatrixSumSolution
{
	public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
	    long[][] prefixMatrix = new long[A.length][A[0].length];
		for(int i=0; i<A.length; i++)
		{
			for(int j=1; j<A[0].length; j++)
			{
				prefixMatrix[i][j] = ((A[i][j] % 1000000007) + (A[i][j-1] % 1000000007)) % 1000000007;
			}
		}
		
		for(int j=0; j<A[0].length; j++)
		{
			for(int i=1; i<A.length; i++)
			{
				prefixMatrix[i][j] = ((prefixMatrix[i][j]  + prefixMatrix[i-1][j]) + 1000000007)  % 1000000007;
			}
		}
		
		int[] out = new int[B.length];
		for(int q=0; q<B.length; q++)
		{
			int a= B[q]-1, b = C[q]-1, c = D[q]-1, d = E[q]-1;
			long totalSum = prefixMatrix[c][d];
			
			long aboveSum = 0;
			if(a != 0)
			{
				aboveSum = prefixMatrix[a-1][d];
				if(b!=0)
				{
					aboveSum = (aboveSum - prefixMatrix[a-1][b-1])%1000000007;
				}
			}
			
			long leftSum = 0;
			if(b != 0)
			{
				leftSum = prefixMatrix[c][b-1];
				if(a!=0)
				{
					leftSum = (leftSum - prefixMatrix[a-1][b-1]) % 1000000007;
				}
			}
			
			long o  = totalSum - ((aboveSum % 1000000007)  + (leftSum % 1000000007));
			if(a!=0 && b!=0)
			{
				o = (o  - A[a-1][b-1])%1000000007;
			}
			
			
			while(o < 0)
                o += 1000000007;
            o = o % 1000000007;
            out[q] = (int)o;
		}
		return out;
    }
}
