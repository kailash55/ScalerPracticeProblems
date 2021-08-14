package Advanced.BitManipulation;

public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ReverseBitsSolution().reverse(3));
	}

}

class ReverseBitsSolution
{
	public long reverse(long a) {
		long rev = 0;
		for(int i=0; i<32; i++)
		{
			long lastBit = ((a & (1<<i)) == 0) ? 0 : 1;
			rev = rev << 1;
			rev = rev | lastBit;
		}
		return rev;
	}
}
