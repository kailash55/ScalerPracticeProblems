package Maths1;

public class CheckPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new CheckPalindromeSolution().isPalindrome(1000010));
	}

}

class CheckPalindromeSolution
{
	public int isPalindrome(int A) {
		
		if(A < 0 )
			return 0;
		if(A==0)
			return 1;
		int noOfDigits = noOfDigits(A);
		int i = 0;
		while(A>9 && i<noOfDigits/2)
		{
			int pow = (noOfDigits-1) - i; 
			int firstNumber = A / (int) Math.pow(10, pow);
			firstNumber = firstNumber % 10;
			
			int lastNumber = A % (int) Math.pow(10, i+1);;
			lastNumber = lastNumber / (int) Math.pow(10, i);

			if(firstNumber != lastNumber)
				return 0;
			else
				i++;
		}
		return 1;
    }

	
	
	public int noOfDigits(int A)
	{
		
		int count = 0;
		while(A>0)
		{
			A = A/10;
			count++;
		}
		
		return count;
	}
}
