package Advanced.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CountRightTriangles {
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 1, 2));
		ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(1, 2, 1 ));
		
		System.out.println(new CountRightTrianglesSolution().solve(A, B));
	}
}

class CountRightTrianglesSolution
{
	public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		int mod = 1000 * 1000 * 1000 + 7;
		HashMap<Integer, Long> xMap = new HashMap<Integer, Long>();
		HashMap<Integer, Long> yMap = new HashMap<Integer, Long>();
		
		for(int i=0; i<A.size(); i++)
		{
			Long xAxisCount = xMap.get(A.get(i));
			if(xAxisCount == null)
			{
				xMap.put(A.get(i), 1l);
			}
			else
			{
				xMap.replace(A.get(i), xAxisCount+1);
			}
			
			Long yAxisCount = yMap.get(B.get(i));
			if(yAxisCount == null)
			{
				yMap.put(B.get(i), 1l);
			}
			else
			{
				yMap.replace(B.get(i), yAxisCount+1);
			}
		}
		
		long totalTriangles = 0;
		for(int i=0; i<A.size(); i++)
		{
			Long totalPointsOnXaxis = xMap.get(A.get(i)) - 1;
			Long totalPointsOnYaxis = yMap.get(B.get(i)) - 1;
			
			totalTriangles = ((totalTriangles % mod) + ((totalPointsOnXaxis % mod) * (totalPointsOnYaxis % mod)) % mod) % mod;
		}
		return (int) totalTriangles;
    }
}
