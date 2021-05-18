
public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.duplicateZeros(new int[] {1,0,2,3,0,4,5,0});
	}
}

class Solution {
    public void duplicateZeros(int[] arr) {
        for(int i=0; i< arr.length; i++)
        {
        	if(arr[i] == 0) 
        	{
        		shiftForZero(i, arr);
        		i=i+1;
        	}
        }
        
        for(int i=0; i<arr.length; i++)
        {
        	System.out.print(arr[i] + " ");
        }
    }
    
    private void shiftForZero(int position, int[] arr)
    {
    	for(int i=arr.length-2; i >=position; i--)
    	{
    		arr[i+1] = arr[i];
    	}
    	arr[position] = 0;
    }
}


