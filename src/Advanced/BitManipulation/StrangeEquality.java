package Advanced.BitManipulation;

public class StrangeEquality {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new StrangeEqualitySolution().solve(45));
	}

}

class StrangeEqualitySolution
{
	public int solve(int A) {
		
		int power = 1;
		
		while(Math.pow(2, power) <= A)
		{
			power++;
		}
		
		for(int i=0; i<power; i++)
		{
			int j = 1 << i;
			A = A ^ j;
		}
		
		int or = 1 << power;
		A = A | or;
		return A;
    }
}
