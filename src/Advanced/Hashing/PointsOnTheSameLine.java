package Advanced.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PointsOnTheSameLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> l1 = new ArrayList<Integer>(Arrays.asList(2, 1, -7, 4, 1, -2, -7, 5));
		ArrayList<Integer> l2 = new ArrayList<Integer>(Arrays.asList(-6, -7, 3, -10, 7, -10, 1, 2));
		System.out.println(new PointsOnTheSameLineSolution().solve(l1, l2));
	}

}

class PointsOnTheSameLineSolution
{
	class Fraction
	{
		int num;
		int denom;
		public Fraction(int num, int denom)
		{
			this.num = num;
			this.denom = denom;
		}
		
		
	}
	
	public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		int n = A.size();
		int maxPoints = Integer.MIN_VALUE;
		for(int i=0; i<A.size(); i++)
		{
			int localMax = Integer.MIN_VALUE;
			HashMap<String, Integer> slopesMap = new HashMap<String, Integer>();
			for(int j=i+1; j<A.size(); j++)
			{
				String slope = "";
				if(A.get(i) == A.get(j))
				{
					slope = "i";
				}
				else
				{
					slope = calculateSlope(A.get(i), B.get(i), A.get(j), B.get(j));
				}
				
				
				Integer slopeCount = slopesMap.get(slope);
				if(slopeCount == null)
				{
					slopeCount = 1;
				}
				else
				{
					slopeCount += 1;
				}
				
				slopesMap.put(slope, slopeCount);
				
				if(slopeCount.intValue() > localMax)
				{
					localMax = slopeCount;
				}
				
			}
			
			if(localMax > maxPoints)
			{
				maxPoints = localMax;
			}
		}
		return maxPoints + 1;
    }
	
	public String calculateSlope(int x1, int y1, int x2, int y2)
	{
		int n1 = x2 > x1 ? (y2-y1) : (y1-y2);
		int n2 = x2 > x1 ? (x2-x1) : (x1-x2);
		int gcd = gcd(n1, n2);
		n1 = n1/gcd;
		n2 = n2/gcd;
		return n1+ "_" + n2;
	}
	
	static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}
