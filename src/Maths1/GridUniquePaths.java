package Maths1;

public class GridUniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new GridUniquePathsSolution().uniquePaths(-5, -8));
	}

}

class GridUniquePathsSolution
{
	public int uniquePaths(int A, int B) {
		
		if(A<=1 || B<=1)
			return 1;
		
		return uniquePaths(A-1, B) + uniquePaths(A, B-1);
	}
}
