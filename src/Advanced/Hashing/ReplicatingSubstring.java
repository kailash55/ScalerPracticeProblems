package Advanced.Hashing;

import java.util.HashMap;
import java.util.Map;

public class ReplicatingSubstring {

	public static void main(String[] args) {
		
	}
}

class ReplicatingSubstringSolution
{
	public int solve(int A, String B) {
		HashMap<Character, Integer> charCountMap = new HashMap<Character,Integer>();
		
		for(int i=0; i<B.length(); i++)
		{
			Integer charCount = charCountMap.get(B.charAt(i));
			if(charCount == null)
				charCountMap.put(B.charAt(i), 1);
			else
				charCountMap.put(B.charAt(i), charCount+1);
		}
		
		for(Map.Entry<Character, Integer> entry : charCountMap.entrySet())
		{
			if(entry.getValue() % A != 0)
			{
				return -1;
			}
		}
		return 1;
    }
}
