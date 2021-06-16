package Recursion;

public class SumOfDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(new SumOfDigitsSolution().solve(462));
		
		System.out.println(SumOfDigitsSolution.numberOfPaths(5, 4));
	}

}

class SumOfDigitsSolution
{
	
	static int numberOfPaths(int m, int n)
    {
        // If either given row number is first or
        // given column number is first
        if (m == 1 || n == 1)
            return 1;
 
        // If diagonal movements are allowed then
        // the last addition is required.
        return numberOfPaths(m - 1, n) + numberOfPaths(m, n - 1);
        // + numberOfPaths(m-1, n-1);
    }
	
	public int solve(int A) {
		return addDigits(A);
    }
	
	public int addDigits(int n)
	{
		if(n/10 == 0)
			return n;
		
		int lastDigit = n % 10;
		
		return (lastDigit + addDigits(n/10));
	}
}
