package Recursion;

public class CheckPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new CheckPalindromeSolution().solve("POAP"));
	}

}

class CheckPalindromeSolution
{
	public int solve(String A) {
		return isPalindrome(A, 0, A.length()-1) ? 1 : 0;
    }
	
	public boolean isPalindrome(String A, int l, int r)
	{
		if(l>r)
			return true;
		
		return (Character.toUpperCase(A.charAt(l)) == Character.toUpperCase(A.charAt(r))) && isPalindrome(A, l+1, r-1);
	}
}
