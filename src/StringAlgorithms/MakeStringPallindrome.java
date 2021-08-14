package StringAlgorithms;

public class MakeStringPallindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new MakeStringPallindromeSolution().solve("layal"));
	}

}

class MakeStringPallindromeSolution
{
	public int solve(String A) {
		
		int l=0;
		int r=A.length()-1;
		
		int count = 0;
		
		while(l<r)
		{
			if(A.charAt(l) == A.charAt(r))
			{
				count++;
				r--;
				l++;
			}
			else
			{
				if(l!=0)
					l--;
				else
					r--;
				count=0;
			}
		}
		
		count *= 2;
		if(l==r)
		{
			count++;
		}
		
		return A.length()-count;
    }
}
