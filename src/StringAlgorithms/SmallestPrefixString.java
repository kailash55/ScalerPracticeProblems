package StringAlgorithms;

import java.util.Arrays;
import java.util.HashMap;

public class SmallestPrefixString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new SmallestPrefixStringSolution().smallestPrefix("tom", "riddle"));
	}

}

class SmallestPrefixStringSolution
{
	public String smallestPrefix(String A, String B) {
		
		int i=1;
		while(i<A.length())
		{
			if(A.charAt(i) < B.charAt(0))
			{
				i++;
			}
			else
			{
				break;
			}
		}
		
		A = A.substring(0, i);
		return A + B.charAt(0);
    }
}
