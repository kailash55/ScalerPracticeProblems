
public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionMergeSort s = new SolutionMergeSort();
		int[] arr = new int[] {1,2,3,0,0,0};
		s.merge(arr, 3, new int[] {2,5,6}, 3);
		
		
		for(int i=0; i<arr.length; i++)
        {
        	System.out.print(arr[i] + " ");
        }
	}

}

class SolutionMergeSort {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
    	int nums1Index = 0;
    	int nums2Index = 0;
    	
    	if(n==0)
    	{
    		return;
    	}
    	while(nums1Index<nums1.length && nums2Index<nums2.length)
    	{
    		
    		if(m==0 || (nums1[nums1Index] == 0 && nums1Index>m-1))
    		{
    			nums1[nums1Index] = nums2[nums2Index];
    			nums2Index++;
    			nums1Index++;
    			continue;
    		}
    		
    		if(nums1[nums1Index] >= nums2[nums2Index])
    		{
    			shift(nums1, nums1Index, nums2[nums2Index]);
    			nums2Index++;
    		}
    		nums1Index++;
    	}
    	
    	
    }

	private void shift(int[] arr, int position, int numberToEnter) {
		// TODO Auto-generated method stub
		for(int i=arr.length-2; i >=position; i--)
    	{
    		arr[i+1] = arr[i];
    	}
    	arr[position] = numberToEnter;
	}
}
