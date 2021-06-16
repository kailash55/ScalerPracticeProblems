package HashingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IsDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> list = new ArrayList<String>(
				Arrays.asList("fine", "none", "no")) ;
		String B = "qwertyuiopasdfghjklzxcvbnm";
		IsDictionarySolution s = new IsDictionarySolution();
		int o = s.solve2(list, B);
		System.out.println(o);
	}

}


class IsDictionarySolution {
	
	public int solve2(ArrayList<String> A, String B) {
        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
        
        for(int i=0; i<B.length(); i++)
        {
            charMap.put(B.charAt(i), i);
        }
        
        for(int i=1; i<A.size(); i++)
        {
        	if(!compareString(A.get(i-1), A.get(i), charMap))
        		return 0;
        }
        return 1;
    }
	
	public boolean compareString(String a, String b, HashMap<Character, Integer> charMap)
	{
		for(int i=0; i<a.length(); i++)
		{
			int charAWeight = charMap.get(a.charAt(i));
			int charBWeight = -1;
			if(b.length()-1 >= i)
				charBWeight = charMap.get(b.charAt(i));
			
			if(charAWeight != charBWeight)
			{
				if(charBWeight < charAWeight)
					return false;
				else
					return true;
			}
		}
		
		return true;
	}
}

