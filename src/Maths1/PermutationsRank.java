package Maths1;

import java.util.Arrays;
import java.util.HashMap;

public class PermutationsRank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new PermutationsRankSolution().fact(1000));
		//System.out.println(new PermutationsRankSolution().findRank("ZCSFLVHXRYJQKWABGT"));
	}

}

class PermutationsRankSolution
{
	public int findRank(String s)
	{
		Long rank = (long) 0;
		for(int i=s.length(); i>0; i--)
		{
			String subStr = s.substring(s.length()-i, s.length());
			int charIndex = s.length() - i;
			int charRank = getCharRank(subStr, s.charAt(charIndex));
			
			Long indexRepetation = fact(i-1);
			Long charCombStart = indexRepetation * (charRank-1);
			rank = rank + charCombStart;	
		}
		return (int) ((rank+1) % 1000003);
	}
	
	public Long fact(int n)
	{
		if(n<=1)
			return (long) 1;
		return n * fact(n-1);
	}
	
	public int getCharRank(String s, char c)
	{
		s = sort(s);
		for(int i=0; i<s.length(); i++)
		{
			if(s.charAt(i) == c)
				return i+1;
		}
		return 0;
	}
	
	public String sort(String s)
	{
		
		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++)
		{
			Integer charCount = charCountMap.get(s.charAt(i));
			if(charCount == null)
			{
				charCountMap.put(s.charAt(i), 1);
			}
			else
			{
				charCountMap.put(s.charAt(i),charCount + 1);
			}
		}
		
		String output = "";
		
		for(int i=0; i<26; i++)
		{
			Character c = (char)(((int) 'A') + i);
			Integer charCount = charCountMap.get(c);
			if(charCount!=null)
			{
				char[] exmarks = new char[charCount];
				Arrays.fill(exmarks, c);
				output = output + new String(exmarks);
			}
		}
		
		for(int i=0; i<26; i++)
		{
			Character c = (char)(((int) 'a') + i);
			Integer charCount = charCountMap.get(c);
			if(charCount!=null)
			{
				char[] exmarks = new char[charCount];
				Arrays.fill(exmarks, c);
				output = output + new String(exmarks);
			}
		}
		return output;
	}
}
