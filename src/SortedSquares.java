public class SortedSquares
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedSquaresSol s = new SortedSquaresSol();
		int[] output = s.sortedSquares(new int[] {-5,-3,-2,-1});
		for(int i=0;i<output.length;i++)
		{
			System.out.print(output[i]+ " ");
		}
	}
}

class SortedSquaresSol {

	public int[] sortedSquares(int[] nums) {
    
		int negativeIndexEnd = -1;
		boolean positiveFound = false;
		int s1[] = new int[nums.length];
		for(int i=0; i<nums.length; i++)
		{
			if(nums[i] >=0 ) {
				negativeIndexEnd = i-1;
				positiveFound = true;
				break;
			}
		}
		
		if(negativeIndexEnd == -1 )
		{
			if(positiveFound) {
				for(int i=0; i< nums.length; i++)
				{
					s1[i] = nums[i] * nums[i];
				}
			}
			else
			{
				for(int i=nums.length-1, j=0; i>=0 ; i--, j++)
				{
					s1[j] = nums[i] * nums[i];
				}
			}
			return s1;
		}
		
		
		int positiveIndexHead = negativeIndexEnd + 1;
		int sortedArrayIndex = 0;
		int[] sortedArray = new int[nums.length];
		
		while(sortedArrayIndex < nums.length)
		{
			if(negativeIndexEnd>=0 && (positiveIndexHead > nums.length-1 || ((nums[positiveIndexHead] >= Math.abs(nums[negativeIndexEnd])))))
			{
				sortedArray[sortedArrayIndex] = nums[negativeIndexEnd] * nums[negativeIndexEnd];
				sortedArrayIndex++;
				negativeIndexEnd--;
			}
			else
			{
				sortedArray[sortedArrayIndex] = nums[positiveIndexHead] * nums[positiveIndexHead];
				sortedArrayIndex++;
				positiveIndexHead++;
			}
		}
		
		return sortedArray;
		
	}
}
