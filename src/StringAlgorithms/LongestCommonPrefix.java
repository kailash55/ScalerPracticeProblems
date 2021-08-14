package StringAlgorithms;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println
		(
				new LongestCommonPrefixSolution()
				.longestCommonPrefix
				(
					new String[]
							{
									"abab"
							}
				)
		);
	}

}

class LongestCommonPrefixSolution
{
	public String longestCommonPrefix(String[] A) {
		if(A.length == 1)
		{
			return A[0];
		}
		A[0] = A[0] + "$";
		String s = "";
		int[] prefixArr = new int[A.length+1];
		
		StringBuilder sb = new StringBuilder(s);
		for(int i=0; i<A.length; i++)
		{
			sb.append(A[i]);
			prefixArr[i+1] = prefixArr[i] + A[i].length() ;
		}
		 
		s = sb.toString();
		
		int[] z = zAlgo(s);
		
		int minCommonLength = Integer.MAX_VALUE;
		for(int i=2; i<prefixArr.length; i++)
		{
			int c = z[prefixArr[i-1]];
			if(c < minCommonLength && c > 0)
			{
				minCommonLength = c;
			}
		}
		
		
		return A[0].substring(0, minCommonLength);
    }
	
	public int[] zAlgo(String s)
	{
		int[] zOut = new int[s.length()];
		zOut[0] = s.length();
		int i=0;
		int l=0;
		int r=0;
		int n = s.length();
		int j = 0;
		
		for(i=1; i<n; i++)
		{
			if(i > r)
			{
				l=i; r=i;
				while(r<n && s.charAt(r) == s.charAt(r-l))
				{
					r++;
				}
				
				zOut[i] = r-l;
				r--;
			}
			else
			{
				j = i-l;
				if(zOut[j] < r-i+1)
				{
					zOut[i] = zOut[j];
				}
				else
				{
					l = i;
					while(r<n && s.charAt(r) == s.charAt(r-l))
					{
						r++;
					}
					
					zOut[i] = r-l;
					r--;
				}
			}
		}
		return zOut;
	}
}
