package StringManipulation;

import java.util.ArrayList;

public class ReverseTheString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ReverseTheStringSolution().solve("    this   is     text    ");
	}

}

class ReverseTheStringSolution
{
	public String trimMultipleSpaces(String A)
	{
		A = A.trim();
		String[] splittedWithSpace = A.split(" ");
		ArrayList<String> splittedString  = new ArrayList<String>();
		
		for(int i=0; i<splittedWithSpace.length; i++)
		{
			if(!(splittedWithSpace[i].equals("")))
			{
				String s = splittedWithSpace[i].trim();
				splittedString.add(s);
			}
		}
		
		String r = String.join(" ", splittedString);
		return r;
	}
	
	public String reverse(String A, int l, int r)
	{
		StringBuilder sb = new StringBuilder(A);
		while(l<r)
		{
			char leftChar = sb.charAt(l);
			char rightChar = sb.charAt(r);
			sb.setCharAt(l, rightChar);
			sb.setCharAt(r, leftChar);
			l++; r--;
		}
		return sb.toString();
	}
	public String solve(String A) {
		A = trimMultipleSpaces(A);
		int l = 0;
		int r = A.length()-1;
		
		A = reverse(A, l, r);
		
		StringBuilder sb = new StringBuilder(A);
		sb.append(" ");
		int lastEmpty = -1;
		for(int i=0; i<sb.length(); i++)
		{
			if(sb.charAt(i) == ' ')
			{
				int l2 = lastEmpty+1;
				int r2 = i-1;
				
				while(l2<r2)
				{
					char leftChar = sb.charAt(l2);
					char rightChar = sb.charAt(r2);
					sb.setCharAt(l2, rightChar);
					sb.setCharAt(r2, leftChar);
					l2++; r2--;
				}
				
				lastEmpty = i;
			}
		}
		return sb.toString().trim();
    }
	
	
}
