package Advanced.Sorting;

public class MergeSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MergeSortedArraysSolution
{
	public int[] solve(final int[] A, final int[] B) {
		int[] newArr = new int[A.length + B.length];
		int l=0;
		int r=0;
		int ind=0;
		while(l<A.length && r<B.length)
		{
			if(B[r] < A[l])
			{
				newArr[ind] = B[r];
				r++;
			}
			else
			{
				newArr[ind] = A[l];
				l++;
			}
			ind++;
		}
		
		while(l<A.length)
		{
			newArr[ind] = A[l];
			l++;
			ind++;
		}
		
		while(r < B.length)
		{
			newArr[ind] = B[r];
			r++;
			ind++;
		}
		return newArr;
    }
}
