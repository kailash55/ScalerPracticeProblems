package Advanced.BitManipulation;

public class DivideIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=3; i<100; i = i + 3)
		{
			for(int j=6; j>=0; j--)
			{
				if(((1<<j) & i) == 0)
				{
					System.out.print("0");
				}
				else
				{
					System.out.print("1");
				}
			}
			System.out.println("");
		}
	}

}

class DivideIntegersSol
{
	public int divide(int A, int B) {
		
        return 0;
    }
}
