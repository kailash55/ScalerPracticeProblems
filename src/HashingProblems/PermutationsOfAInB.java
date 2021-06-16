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
		
		for(int i=0; i<1000000; i++)
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
		
		int c = new PermutationsOfAInBSolution().solve(str2.toString(), str.toString());
		System.out.println(c);
	}

}

class PermutationsOfAInBSolution
{
    public int solve(String A, String B)
	{
		int count = 0;
		int n = A.length();
		HashMap<Character, Long> amap = new HashMap<Character, Long>();
		
		
		for(int i=0; i< A.length(); i++)
		{
			Long existingCount = amap.get(A.charAt(i));
			if(existingCount == null)
			{
				amap.put(A.charAt(i), (long) 1);
			}
			else
			{
				amap.put(A.charAt(i), existingCount+1);
			}
		}
		
		HashMap<Character, Long> tmap = new HashMap<Character, Long>();
		
		for (Map.Entry<Character,Long> entry : amap.entrySet())
		{
			tmap.put(entry.getKey(), (long) 0);
		}
		
		
		for(int i=0; i<B.length(); i++)
		{
			Long existingCount = tmap.get(B.charAt(i));
			if(existingCount != null)
			{
				existingCount++;
				tmap.put(B.charAt(i), existingCount);
			}
			
			if(i-n>=0)
			{
				Long firstElementCount = tmap.get(B.charAt(i-n));
				if(firstElementCount != null)
				{
					firstElementCount--;
					tmap.put(B.charAt(i-n), firstElementCount);
				}

			}
			
			boolean exist = true;
			for (Map.Entry<Character,Long> entry : amap.entrySet())
			{
				Long AStringCharCount = tmap.get(entry.getKey());
				if(!entry.getValue().equals(AStringCharCount))
				{
					exist = false;
				}
			}
			
			if(exist)
				count++;
			
		}
		return count;
	}
	
}
