package Advanced.ArraysAndMaths;

public class FirstMissingInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int o = new FirstMissingIntegerSolution().firstMissingPositive(new int[] {1,1,1});
		System.out.println(o);
	}

}

class FirstMissingIntegerSolution
{
	public int firstMissingPositive(int[] A) {
		
		int n = A.length;
		
		for(int i=0; i<A.length; i++)
		{
			while(A[i] > 0 && A[i] <=n && (A[i] != i+1))
			{
				if(A[A[i]-1] == A[i])
				{
					break;
				}
				
				int temp = A[A[i]-1];
				A[A[i]-1] = A[i];
				A[i] = temp;
				
			}
		}
		
		for(int i=0; i<A.length; i++)
		{
			if(A[i] != i+1)
			{
				return (i+1);
			}
		}
		return n+1;
    }
}
