
public class TotalBitAddition {

	public static void main(String[] args) {
		System.out.println(new TotalBitAdditionSolution().solve(2147483647));
	}
}

class TotalBitAdditionSolution
{

	
	public int solve(int number)
	{
		long totalBits = countTotalBitsInNumber(number);
		number++;
		
		long totalAddBits = 0;
		for(long i=1; i<=totalBits; i++)
		{
			long numberToDivide = 1 << i;
			long totalBitsTillDivide = (number - (number%numberToDivide)) / 2;
			long remainder = number % numberToDivide;
			long remainderBits = 0;
			if(remainder > (numberToDivide/2))
			{
				remainderBits =  remainder - (numberToDivide/2);
			}
			totalAddBits = totalAddBits + totalBitsTillDivide + remainderBits;
		}
		
		return (int)(totalAddBits % 1000000007);
	}
	
	public long countTotalBitsInNumber(int A) {
        
		// log function in base 2
        // take only integer part
        return (long)(Math.log(A) /
                     Math.log(2) + 1);
    }
}


