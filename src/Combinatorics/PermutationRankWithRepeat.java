package Combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PermutationRankWithRepeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(new PermutationRankWithRepeatSolution2().findRank("bbbbaaaa"));
	}

}

class PermutationRankWithRepeatSolution2 {
    
    private int MOD = 1000003;
    public int findRank(String S) {
    
        // Initializations
        ArrayList<Integer> charCount = new ArrayList<Integer>(256);
        
        for(int i=0;i<256;i++) charCount.add(0);
        for (int i = 0; i < S.length(); i++) {
            int ch = (int)S.charAt(i);
            charCount.set(ch, charCount.get(ch)+1);
        }
        
        ArrayList<Integer> fact = new ArrayList<Integer>(); // fact[i] will contain i! % MOD
        initializeFactorials(S.length() + 1, fact);
        
        long rank =  1;
        
        for (int i = 0; i < S.length(); i++) {
            // find number of permutations placing character smaller than S[i] at ith position 
            // among characters from i to S.length 
            long less = 0;
            int remaining = S.length() - i - 1;
            for (int ch = 0; ch < S.charAt(i); ch++) {
                if (charCount.get(ch) == 0) continue;
                // Lets try placing ch as the first character in remaining characters
                // and check the number of permutation possible.
                charCount.set(ch, charCount.get(ch)-1);
                long numPermutation = fact.get(remaining);
                
                for (int c = 0; c < 128; c++) {
                    if (charCount.get(c) <= 1) continue; 
                    numPermutation = (numPermutation * inverseNumber(fact.get(charCount.get(c)))) % MOD;
                }
    
                charCount.set(ch, charCount.get(ch)+1);
                less = (less + numPermutation) % MOD;
            }
            
            rank = (rank + less) % MOD;
            // remove the current character from the set. 
            charCount.set((int)S.charAt(i), charCount.get(S.charAt(i))-1);
        }
        return (int)rank;

    }
    
    public void initializeFactorials(int totalLen, ArrayList<Integer> fact) {
        
        long factorial = 1;
        fact.add(1); // 0!= 1
        for (int curIndex = 1; curIndex < totalLen; curIndex++) {
            factorial = (factorial * curIndex) % MOD;
            fact.add((int)factorial);
        }
        return;
    }
    
    public long pow(long x, int y, int k){
        long result = 1;
        while(y > 0){
            if(y % 2 == 1) {
                result = (result * x) % k;
                y--;
            }
            y >>= 1;
            x = (x * x) % k;
        }
        return result;
    }
    long inverseNumber(int num) {

        // Inverse modulo : https://en.wikipedia.org/wiki/Modular_multiplicative_inverse
        // Calculate num ^ MOD-2  % MOD
        return pow(num, MOD-2 , MOD);
    }
}

class PermutationRankWithRepeatSolution
{
	public int findRank(String A) {
		int mod = 1000003;
		ArrayList<Character> strArr = new ArrayList<Character>();
		for(int i=0; i<A.length(); i++){
			strArr.add(A.charAt(i));
		}
		Collections.sort(strArr);
		
		int totalRank = 0;
		for(int i=0; i<A.length(); i++)
		{
			HashMap<Character ,Integer> charCount = new HashMap<Character, Integer>();
			for(int j=i+1; j<strArr.size(); j++)
			{
				Integer count = charCount.get(strArr.get(j));
				if(count == null)
				{
					charCount.put(strArr.get(j), 1);
				}
				else
				{
					charCount.put(strArr.get(j), count + 1);
				}
			}
			
			int productToDivide = 1;
			for(Map.Entry<Character, Integer> entry : charCount.entrySet())
			{
				productToDivide = productToDivide * fact(entry.getValue());
			}
			char c = A.charAt(i);
			int index = strArr.indexOf(c);
			int currentRank = index * (fact(A.length() - 1 - i) /productToDivide);
			totalRank = (totalRank + currentRank) % mod;
			strArr.remove(index);
		}
		
		return (totalRank + 1)%mod;
    }
	
	public int fact(int i)
	{
		int mod = 1000003;
		if(i<1)
			return 0;
		if(i==1)
			return 1;
		return i * (fact(i-1) % mod);
	}
}
