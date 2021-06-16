package StringManipulation;

public class IsAlpha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c = Character.toLowerCase('9');
		System.out.println();
	}

}

class IsAlphaSolution
{
	public int solve(char[] A) {
		
		for(int i=0; i<A.length; i++)
		{
			
			if(!(isAlpha(A[i]) || isNumberic(A[i])))
				return 0;
		}
		return 1;
    }
	
	public boolean isAlpha(char c)
	{
		c = Character.toLowerCase(c);
		return !((int)c < 97 || (int)c > 122);
	}
	
	public boolean isNumberic(char c)
	{
		int i = Character.getNumericValue(c);
		return (i!=-1);
	}
}
