package Recursion;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new FibonacciSolution().findAthFibonacci(9));
	}

}

class FibonacciSolution
{
	public int findAthFibonacci(int A) {
		if(A==0)
			return 0;
		if(A==1 || A==2)
			return 1;
		
		return findAthFibonacci(A-1) + findAthFibonacci(A-2);
    }
}
