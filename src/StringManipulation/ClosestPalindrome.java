package StringManipulation;

public class ClosestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class ClosestPalindromeSolution
{
	public String solve(String A) {
		int l=0;
		int r=A.length()-1;
		
		int c = 0;
		while(l<r)
		{
			if(A.charAt(l) != A.charAt(r))
				c++;
			
			l++;
			r++;
		}
		
		if(c==1)
			return "YES";
		else if(c==0)
		{
			if(A.length() % 2 == 0)
				return "NO";
			else
				return "YES";
		}
		else
		{
			return "NO";
		}
	
    }
}
