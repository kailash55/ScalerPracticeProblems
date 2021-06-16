package StringManipulation;

import java.util.ArrayList;

public class AmazingSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new AmazingSubstringSolution().solve("ABEC"));
	}

}


class AmazingSubstringSolution {
    public int solve(String A) {
        
        long total = 0;
        for(int i=0; i<A.length(); i++)
        {
            if(isVowel(A.charAt(i)))
            {
                total = total + (A.length()-i);
            }
        }
        
        return (int) (total % 10003);
    }
    
    public boolean isVowel(char c)
    {
        ArrayList<Character> arrlist = new ArrayList<Character>(5);
        arrlist.add('a');
        arrlist.add('e');
        arrlist.add('i');
        arrlist.add('o');
        arrlist.add('u');
        
        if(arrlist.contains(Character.toLowerCase(c)))
            return true;
        else
            return false;
    }
}
