package Combinatorics;

public class MaximumIntersectionPoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new MaximumIntersectionPointsSolution().getIntersection(1000, 1000));
	}

}

class MaximumIntersectionPointsSolution
{
	public int getIntersection(int A, int B) {
		int lineIntersectionPoints = sumOfN(A-1);
		int lineCircleIntersection = (A * (B*2));
		int circleIntersection = B* (B-1);
				
		return lineIntersectionPoints + lineCircleIntersection + circleIntersection;
    }
	
	public int sumOfN(int n)
	{
		return (n * (n+1))/2;
	}
}
