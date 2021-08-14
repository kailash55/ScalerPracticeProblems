package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class LetterPhone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LetterPhoneSolution().letterCombinations("012"));
	}

}

class LetterPhoneSolution
{
	HashMap<Character, String> keyMap = new HashMap<Character ,String>();
	
	public LetterPhoneSolution()
	{
		keyMap.put('0', "0");
		keyMap.put('1', "1");
		keyMap.put('2', "abc");
		keyMap.put('3', "def");
		keyMap.put('4', "ghi");
		keyMap.put('5', "jkl");
		keyMap.put('6', "mno");
		keyMap.put('7', "pqrs");
		keyMap.put('8', "tuv");
		keyMap.put('9', "wxyz");
	}
	
	public ArrayList<String> letterCombinations(String A) {
		
		ArrayList<String> stringGroups = new ArrayList<String>();
		for(int i=0; i<A.length(); i++)
		{
			char c = A.charAt(i);
			stringGroups.add(keyMap.get(c));
		}
		
		return letterCombinationsRec(stringGroups, 0);
    }
	
	public ArrayList<String> letterCombinationsRec(ArrayList<String> stringGroups, int currentIndex)
	{
		ArrayList<String> currentCombinations = new ArrayList<String>();
		String currentString = stringGroups.get(currentIndex);
		
		if(currentIndex == stringGroups.size()-1)
		{
			for(int i=0; i<currentString.length(); i++)
			{
				char currentChar = currentString.charAt(i);
				String currString = String.valueOf(currentChar);
				currentCombinations.add(currString);
			}
			
			return currentCombinations;
		}
		
		ArrayList<String> previousStringComb = letterCombinationsRec(stringGroups, currentIndex + 1);
		for(int i=0; i<currentString.length(); i++)
		{
			char currentChar = currentString.charAt(i);
			for(int j=0; j<previousStringComb.size(); j++)
			{
				String prev = new String(previousStringComb.get(j).toCharArray());
				String currString = String.valueOf(currentChar);
				currString = currString + prev;
				currentCombinations.add(currString);
			}
		}
		return currentCombinations;
	}
}
