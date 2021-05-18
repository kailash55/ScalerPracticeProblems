import java.io.IOException;

public class BitAddition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitAdditionSolution s = new BitAdditionSolution();
		String out = s.addBinary("1010110111001101101000", "1000011011000000111100110");
		System.out.print(out);
	}

}

class BitAdditionSolution {
	class BitAdditionResult
	{
		public int value;
		public int carry;
	}
	
    public String addBinary(String A, String B){
        
        String moreBitsNumber="";
        String lessBitsNumber="";
        
        if(A.length() > B.length()){
            moreBitsNumber = A;
            lessBitsNumber = B;
        }
        else
        {
            moreBitsNumber = B;
            lessBitsNumber = A;
        }
        
        int moreBitsNumberSize= moreBitsNumber.length();
        int lessBitsNumberSize = lessBitsNumber.length();
        
        int carry=0;
        
        String outputString = "";
        for(int i=0; i< moreBitsNumberSize; i++)
        {
            int bit1Index = moreBitsNumberSize-1-i;
            int number1Bit = moreBitsNumber.charAt(bit1Index) == '1' ? 1:0;
            
            int bit2Index = lessBitsNumberSize-1-i;
            int number2Bit = 0;
            if(bit2Index>=0){
                number2Bit = lessBitsNumber.charAt(bit2Index) == '1' ? 1:0;
            }
            
            
            BitAdditionResult result = bitAddition(number1Bit, number2Bit);
            if(carry==1) {
            	BitAdditionResult carryAddResult = bitAddition(result.value, carry);
            	outputString = String.valueOf(carryAddResult.value) + outputString;
            	carry = result.carry | carryAddResult.carry;
            }
            else
            {
            	outputString = String.valueOf(result.value) + outputString;
            	carry = result.carry;
            }
            
        }
        
        if(carry == 1) {
        	outputString = "1" + outputString;
        }
        
        return outputString;
    }
    
    private BitAdditionResult bitAddition(int bit1, int bit2)
    {
    	BitAdditionResult result = new BitAdditionResult();
    	result.value = bit1 ^ bit2;
    	result.carry = bit1 & bit2;
    	return result;
    }
    
    
}
