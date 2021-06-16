package Maths1;

import java.util.HashMap;

public class ExcelColumnNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ExcelColumnNumberSolution().titleToNumber("Q"));
	}

}

class ExcelColumnNumberSolution {
    public int titleToNumber(String A) {
        int asciStart = (int) 'A';
        HashMap<Character, Integer> charIndexMap = new HashMap<Character, Integer>();
        for(int i=asciStart; i< asciStart+26; i++)
        {
            charIndexMap.put((char) i, 26 - ((int)'Z' - i));
        }
        
        double total = 0;
        for(int i=A.length()-1; i>=0; i--)
        {
            int power = A.length()-1 - i;
            total = total + (charIndexMap.get(A.charAt(i)) * Math.pow(26, power));
        }
        
        return (int) total;
    }
}
