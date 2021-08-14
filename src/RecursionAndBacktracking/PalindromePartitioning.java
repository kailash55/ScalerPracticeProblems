package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;

public class PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class PalindromePartitioningSolution
{
	public ArrayList<ArrayList<String>> partition(String a) {
		
		
		return null;
	}
	
	public void rec(ArrayList<String> previousPartitions, int partitionIndex, ArrayList<ArrayList<String>>  palindromes)
	{
		
		
		String lastEl = previousPartitions.get(previousPartitions.size()-1);
		
		if(lastEl.length() == 1)
		{
			palindromes.add(0, new ArrayList<String>(Arrays.asList(lastEl)));
			return;
		}
		
		String part1 = lastEl.substring(0,1);
		String part2 = lastEl.substring(1, lastEl.length());
		
		boolean isPart1Palindrome = checkIfPalindrome(part1);
		boolean isPart2Palindrome = checkIfPalindrome(part2);
		
		if(!(isPart1Palindrome && isPart2Palindrome))
			return;
		
		previousPartitions.remove(previousPartitions.size()-1);
		previousPartitions.add(part1);
		previousPartitions.add(part2);
		
		ArrayList<String> copy = new ArrayList<>(previousPartitions);
		palindromes.add(copy);
		rec(previousPartitions, partitionIndex+1, palindromes);
		
		previousPartitions.remove(previousPartitions.size()-1);
		previousPartitions.remove(previousPartitions.size()-1);
		previousPartitions.add(lastEl);
		rec(previousPartitions, partitionIndex+1, palindromes);
	}

	private boolean checkIfPalindrome(String part1) {
		// TODO Auto-generated method stub
		return false;
	}
}
