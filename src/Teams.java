
public class Teams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2 s = new Solution2();
		System.out.println(s.solve("00011011"));
	}

}

class Solution2
{
	public int solve(String str)
	{
		int count = 0;
		int subStrCount = 0;
		for (int i = 0; i < str.length(); i++) {
    	    if (str.charAt(i) == '1') {
    	        count = count + 1;
    	    }
    	    else {
    	    	count = count - 1;
    	    }
    	    if(count==0)
    	    {
    	    	subStrCount++;
    	    }
    	}
		return subStrCount;
	}
}

class Solution3 {
    public int solve(String A) {
    	int len = A.length();
    	A = A + "n";
    	
    	int count = 0;
    	for(int i=0; i<len-1; i++)
    	{
    		for(int j=i+1; j<len; j++)
    		{
    			String subStr = A.substring(i,j+1);
    			int onesCount = countChar(subStr, '1');
    			int zerosCount = countChar(subStr, '0');
    			
    			if(onesCount == zerosCount)
    			{
    				count++;
    			}
    		}
    	}
    	return count;
    }
    
    public int countChar(String str, char c)
    {
    	int count = 0;
    	for (int i = 0; i < str.length(); i++) {
    	    if (str.charAt(i) == c) {
    	        count++;
    	    }
    	}
    	return count;
    }
}

