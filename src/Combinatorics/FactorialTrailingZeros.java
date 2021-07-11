package Combinatorics;

public class FactorialTrailingZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new FactorialTrailingZerosSolution().trailingZeroes(15));
	}

}

class FactorialTrailingZerosSolution
{
	public int trailingZeroes(int A) {
		
		int power = 1;
		long number = (long) Math.pow(5, power);
		long total = 0;
		while(number <= A)
		{
			total = total + (A/number);
			power++;
			number = (long) Math.pow(5, power);
		}
		return (int) total;
    }
}