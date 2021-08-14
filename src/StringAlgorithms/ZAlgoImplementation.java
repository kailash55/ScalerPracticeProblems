package StringAlgorithms;

public class ZAlgoImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] z = zAlgo("abcedabfabaabcabcedabc");
		System.out.println(z);
	}
	
	public static int[] zAlgo(String s)
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
				while(s.charAt(r) == s.charAt(r-l) && r<n)
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
					while(s.charAt(r) == s.charAt(r-1) && r<n)
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



