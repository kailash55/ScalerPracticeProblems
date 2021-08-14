package Advanced.Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class WaveArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

class WaveArraySolution
{
	public int[] wave(int[] A) {
		Arrays.sort(A);
		
		for(int i=0; i<A.length; i++)
		{
			if(i+1 <= A.length-1)
			{
				A[i] = A[i] ^ A[i+1];
				A[i+1] = A[i] ^ A[i+1];
				A[i] = A[i] ^ A[i+1];
			}
		}
		return A;
    }
}
