package Searching;

public class SmallestGoodBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new SmallestGoodBaseSolution().solve("1000000000000000000"));
		
		//999999999999999945 1
		
		//System.out.println(new SmallestGoodBaseSolution().convertBaseToDecimal(999999999999999945l, 1));
	}

} 

class SmallestGoodBaseSolution
{
	public String solve(String A) {
		long start = 2;
		long end = Long.parseLong(A);
		long number = 0;
		
		for(int i=0; i<64; i++)
		{
			long output = checkIfPosible(i, A, start, end);
			
			if(output != -1)
			{
				end = output;
				number = output;
			}
		}
		return Long.toString(number);
    }

	private long checkIfPosible(int b, String a, long start, long end) {
		// TODO Auto-generated method stub
		long al = Long.parseLong(a);
		while(start <= end)
		{
			long mid = start + ((end - start) / 2);
			
			long value = convertBaseToDecimal(mid, b);
			
			if(value == al)
			{
				return mid;
			}
			else if(al > value)
			{
				start = mid + 1;
			}
			else
			{
				end = mid -1;
			}
		}
		return -1;
	}

	public long convertBaseToDecimal(long mid, long a) {
		// TODO Auto-generated method stub
		long number = 0;
		long p = 1;
		for(int i=0; i<=a; i++)
		{
			number = (long) (number + p);
			p = p * mid;
		}
		return number;
	}
}
