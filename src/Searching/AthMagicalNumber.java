package Searching;

public class AthMagicalNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new AthMagicalNumberSolution().solve(33488383, 565, 29473));
	}

}

class AthMagicalNumberSolution
{
	int mod = 1000 * 1000 * 1000 + 7;
	public int solve(int A, int B, int C) {
		
		long start = Math.min(B, C);
		long end = Math.min(B, C) * A;
		long o = 0;
		while(start <= end)
		{
			long mid = (start + end)/2;
			long totalMagicalNumbers = getTotalMagicalNumbers(mid, B, C);
			
//			if(totalMagicalNumbers == A)
//			{
//				o = getBelowMagicalNumber(mid, B, C);
//				break;
//			}
			if(totalMagicalNumbers < A)
			{
				start = mid + 1;
			}
			else {
				o = getBelowMagicalNumber(mid, B, C);
				end = mid - 1;
			}
		}
		return (int) o;
    }

	private long getBelowMagicalNumber(long mid, int b, int c) {
		// TODO Auto-generated method stub
		int remainderB = (int) (mid % b);
		int remainderC = (int) (mid % c);
		
		if(remainderB <= remainderC)
		{
			return mid - remainderB;
		}
		else {
			return mid - remainderC;
		}
	}

	private long getTotalMagicalNumbers(long mid, int b, int c) {
		// TODO Auto-generated method stub
		long ml = (long) mid;
		long bl = (long) b;
		long cl = (long) c;
		
		long cntB = (ml/bl);
		long cntC = (ml/cl);
		long lcm = lcm(bl,cl);
		long cntBC = ml/lcm;
		
		long o = cntB + cntC - cntBC;
		return (o);
		//return (((mid/b)%mod) + ((mid/c)%mod) - ((mid/lcm(b,c))%mod))%mod;
	}
	
	// Recursive method to return gcd of a and b
    static long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
     
    // method to return LCM of two numbers
    static long lcm(long a, long b)
    {
        return (a / gcd(a, b)) * b;
    }
}
