package HashingProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationsOfAInB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder str
        = new StringBuilder();
		str.append("acaa");
		
		for(int i=0; i<100000000; i++)
		{
			str.append("acaa");
		}
		
		StringBuilder str2
        = new StringBuilder();
		str2.append("acaa");
		
		for(int i=0; i<100; i++)
		{
			str2.append("acaa");
		}
		
		int c = new PermutationsOfAInBSolution().solve3(str2.toString(), str.toString());
		System.out.println(c);
	}

}

class PermutationsOfAInBSolution
{

	public int solve3(String A, String B)
	{
		int count = 0;
		int n = A.length();
		HashMap<Character, Integer> amap = new HashMap<Character, Integer>();
		
		
		for(int i=0; i< A.length(); i++)
		{
			Integer existingCount = amap.get(A.charAt(i));
			if(existingCount == null)
			{
				amap.put(A.charAt(i), 1);
			}
			else
			{
				amap.put(A.charAt(i), existingCount+1);
			}
		}
		
		HashMap<Character, Integer> tmap = new HashMap<Character, Integer>();
		
		for (Map.Entry<Character,Integer> entry : amap.entrySet())
		{
			tmap.put(entry.getKey(), 0);
		}
		
		
		for(int i=0; i<B.length(); i++)
		{
			Integer existingCount = tmap.get(B.charAt(i));
			if(existingCount != null)
			{
				existingCount++;
				tmap.put(B.charAt(i), existingCount);
			}
			
			if(i-n>=0)
			{
				Integer firstElementCount = tmap.get(B.charAt(i-n));
				if(firstElementCount != null)
				{
					firstElementCount--;
					tmap.put(B.charAt(i-n), firstElementCount);
				}

			}
			
			boolean exist = true;
			for (Map.Entry<Character,Integer> entry : amap.entrySet())
			{
				Integer AStringCharCount = tmap.get(entry.getKey());
				if(entry.getValue() != AStringCharCount)
				{
					exist = false;
				}
			}
			
			if(exist)
				count++;
			
		}
		return count;
	}
	
	public int solve2(String A, String B)
	{
		int count = 0;
		int n = A.length();
		HashMap<Character, Integer> amap = new HashMap<Character, Integer>();
		
		for(int i=0; i< A.length(); i++)
		{
			Integer existingCount = amap.get(A.charAt(i));
			if(existingCount == null)
			{
				amap.put(A.charAt(i), 1);
			}
			else
			{
				amap.put(A.charAt(i), existingCount+1);
			}
		}
		
		int[] countstore = new int[B.length()];
		
//		for(int i=0; i<B.length(); i++)
//		{
//			
//		}
		
		int l=0;
		int r= l + n-1;
		
		while(r<B.length())
		{
			HashMap<Character, Integer> imap = new HashMap<Character, Integer>();
			for(int i=l; i<=r; i++)
			{
				Integer existingCount = imap.get(B.charAt(i));
				if(existingCount == null)
				{
					imap.put(B.charAt(i), 1);
				}
				else
				{
					imap.put(B.charAt(i), existingCount+1);
				}
			}
			
			boolean exist = true;
			for (Map.Entry<Character,Integer> entry : imap.entrySet())
			{
				Integer AStringCharCount = amap.get(entry.getKey());
				if(entry.getValue() != AStringCharCount)
				{
					exist = false;
				}
			}
			
			if(exist)
				count++;
			
			l++;
			r++;
		}
		return count;
	}
	
	public int solve(String A, String B) {
		int count = 0;
		int alen = A.length();
		char[] tempA = A.toCharArray();
		Arrays.sort(tempA);
		A = new String(tempA);
		
		for(int i=0; i<= B.length()-alen; i++)
		{
			String subStr = B.substring(i, i + alen);
			char[] tempB = subStr.toCharArray();
			Arrays.sort(tempB);
			subStr = new String(tempB);
			
			if(subStr.equals(A))
			{
				count++;
			}
		}
		return count;
    }
}
