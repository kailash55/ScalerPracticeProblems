package Advanced.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> A = new ArrayList<String>(Arrays.asList("abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba", "abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa", "babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab", "bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb", "abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab", "aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba", "abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa", "aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb"));
		System.out.println(new AnagramsSolution().anagrams(A));
	}

}

class AnagramsSolution
{
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
		
		int mod = 10000000;
		HashMap<Integer, Integer> charHashMap = new HashMap<Integer, Integer>();
		HashSet<Integer> used = new HashSet<Integer>();
		
		for(int i=0; i<26; i++)
		{
			Random rd = new Random();
			int h = (rd.nextInt() % mod);
			while(used.contains(h) || h<0)
			{
				h = (rd.nextInt() % mod);
			}
			used.add(h);
			charHashMap.put(i, h);
		}
		
		ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
		HashMap<String,Integer> anagramListIndex = new HashMap<String, Integer>();
		for(int i=0; i<A.size(); i++)
		{
			String currString = A.get(i);
			int stringSum = 0;
			int hashSum = 0;
			for(int j=0; j<currString.length(); j++)
			{
				stringSum = stringSum + ((int)currString.charAt(j));
				hashSum = hashSum + charHashMap.get((int)currString.charAt(j) - 'a');
			}
			String concat = stringSum + "_" +hashSum;
			Integer index = anagramListIndex.get(concat);
			if(index == null)
			{
				ArrayList<Integer> pairs = new ArrayList<Integer>();
				pairs.add(i+1);
				out.add(pairs);
				anagramListIndex.put(concat, out.size()-1);
			}
			else
			{
				ArrayList<Integer> pairs = out.get(index);
				pairs.add(i+1);
			}
			
			
		}
		
		return out;
    }
}
