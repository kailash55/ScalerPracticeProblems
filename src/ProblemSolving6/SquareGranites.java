package ProblemSolving6;

public class SquareGranites {
	public static void main(String[] args) {
		System.out.println(new SquareGranitesSolution().solve(6, 6, 4));
	}
}

class SquareGranitesSolution
{
	public int solve(int A, int B, int C) {
		Double AD = (double) A;
		Double BD = (double) B;
		Double CD = (double) C;
				
        return (int)Math.ceil(Math.ceil(AD/CD) * Math.ceil(BD/CD));
    }
}
