package Advanced.Sorting;

import java.util.Arrays;

public class KthSmallestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92};
		System.out.println(new KthSmallestElementSolution().kthsmallest(arr, 9));
	}

}


class KthSmallestElementSolution
{
	public int kthsmallest(final int[] A, int B) {
		Arrays.sort(A);
		
		return A[B-1];
    }	
}