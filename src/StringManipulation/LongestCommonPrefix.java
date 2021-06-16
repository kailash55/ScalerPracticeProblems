package StringManipulation;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Integer.MAX_VALUE
		ArrayList<String> list = new ArrayList<String>(
	            Arrays.asList("abcd"));
		String maxIndex = new LongestCommonPrefixSolution().longestCommonPrefix(list);
		System.out.println(maxIndex);
	}

}

class LongestCommonPrefixSolution
{
	public String longestCommonPrefix(ArrayList<String> A) {
		
		if(A.size() == 0)
			return "";
		
		if(A.size() == 1)
			return A.get(1);
		
		int j=0;
		
		int maxPosCommonInd = 0;
		boolean indexEqual =  Character.toUpperCase(A.get(0).charAt(maxPosCommonInd)) == Character.toUpperCase(A.get(1).charAt(maxPosCommonInd));
		boolean endOccured = ((A.get(0).length() - 1) < maxPosCommonInd) || ((A.get(1).length() - 1) < maxPosCommonInd);
		
		while(indexEqual && !endOccured)
		{
			maxPosCommonInd++;
			
			endOccured = ((A.get(0).length() - 1) < maxPosCommonInd) || ((A.get(1).length() - 1) < maxPosCommonInd);
			if(endOccured)
				break;
			
			indexEqual = A.get(0).charAt(maxPosCommonInd) == A.get(1).charAt(maxPosCommonInd);
			if(!indexEqual)
				break;
			
		}
		
		maxPosCommonInd = maxPosCommonInd-1;
		int i=2;
		
		String firstString = A.get(0);
		while(i<A.size() && maxPosCommonInd>=0)
		{
			String s = A.get(i);
			
			if(s.length()-1 < maxPosCommonInd)
			{
				maxPosCommonInd = s.length()-1;
			}
			if(Character.toUpperCase(s.charAt(maxPosCommonInd)) == Character.toUpperCase(firstString.charAt(maxPosCommonInd)))
			{
				i++;
				continue;
			}
			else
			{
				maxPosCommonInd--;
			}
		}
		
		if(maxPosCommonInd<0)
			return "";
		return firstString.substring(0, ++maxPosCommonInd);
    }
}
