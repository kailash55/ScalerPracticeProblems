package Advanced.Sorting;

public class InversionCountInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 1,4,3,2,5,7,10,6,11,15,12,16
		int[] arr = new int[] {1,4,3,2,5,7,10,6,11,15,12,16};
		System.out.println(new InversionCountInAnArraySolution().solve(arr));
	}

}

class InversionCountInAnArraySolution
{
	public int solve(int[] A) {
		return sort(A, 0, A.length-1);
    }
	
	public int sort(int[] arr, int start, int end)
	{
		int mod = (1000 * 1000 * 1000 ) + 7;
		if(start >= end)
		{
			return 0;
		}
		int mid = (start + end)/2;
		
		int leftCount = sort(arr, start, mid);
		int rightCount = sort(arr, mid+1, end);
		int mergeCount = mergeAndCount(arr, start, mid, end);
		return ((leftCount%mod) + (rightCount%mod) + (mergeCount%mod)) % mod;
	}

	private int mergeAndCount(int[] arr, int start, int mid, int end) {
		// TODO Auto-generated method stub
		int invCount = 0;
		int[] newArr = new int[end - start + 1];
		int l = start;
		int r = mid+1;
		int ind = 0;
		while(l <= mid && r <=end)
		{
			if(arr[r] < arr[l])
			{
				newArr[ind] = arr[r];
				r++;
				invCount += (mid+1-l);
			}
			else
			{
				newArr[ind] = arr[l];
				l++;
			}
			ind++;
		}
		
		while(l<=mid)
		{
			newArr[ind] = arr[l];	
			l++;
			ind++;
		}
		
		while(r<=end)
		{
			newArr[ind] = arr[r];
			r++;
			ind++;
		}
		
		for(int i=0; i<newArr.length; i++)
		{
			arr[start+i] = newArr[i];
		}
		return invCount;
	}
}
