package Maths1;

import java.util.HashMap;

public class ExcelColumnTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ExcelColumnTitleSolution().convertToTitle(943566));
	}

}


class ExcelColumnTitleSolution {
	
	
	
    public String convertToTitle(int A) {
        
        HashMap<Integer, Character> indexToCharMap = new HashMap<Integer, Character>();
        for(int i=0; i<26; i++)
        {
            indexToCharMap.put(i+1, (char)((int)'A' + i));
        }
        
        String output = "";
        while(A!=0)
        {
            int lastDigit = A % 26;
            if(lastDigit == 0)
            {
            	lastDigit = 26;
            	//A++;
            }
            	
            output =  indexToCharMap.get(lastDigit) + output;
            A = A/26;
            if(lastDigit == 26)
            {
              A--;
            }
        }
        return output;
    }
}