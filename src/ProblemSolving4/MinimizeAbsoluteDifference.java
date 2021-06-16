package ProblemSolving4;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimizeAbsoluteDifference {

	public static void main(String[] args) {
		
		//int c = Math.abs((-2) - (3));
		// TODO Auto-generated method stub
		ArrayList<Integer> l1 = new ArrayList<Integer>(Arrays.asList( 1, 4, 5, 8, 10));
		ArrayList<Integer> l2 = new ArrayList<Integer>(Arrays.asList( 6, 9, 15));
		ArrayList<Integer> l3 = new ArrayList<Integer>(Arrays.asList(2, 3, 6, 6));
		
		System.out.println(new MinimizeAbsoluteDifferenceSolution().solve2(l1, l2, l3));
	}

}

class MinimizeAbsoluteDifferenceSolution
{
	public int solve2(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
		
		int i=A.size()-1;
		int j=B.size()-1;
		int k=C.size()-1;
		
		int minimumDiff = Integer.MAX_VALUE;
		
		while(i!=-1 && j!=-1 && k!=-1)
		{
			int max_value = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));
			int min_value = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));
			
			int currentDiff = Math.abs(max_value - min_value);
			
			if(currentDiff < minimumDiff)
			{
				minimumDiff = currentDiff;
			}
			
			if(max_value == A.get(i))
				i--;
			else if(max_value == B.get(j))
				j--;
			else
				k--;
		}
		return minimumDiff;
	}
	
	public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
		ArrayList<Integer> array_1_2_com = new ArrayList<Integer>();
		ArrayList<Integer> array_1_2_com_index = new ArrayList<Integer>();
		
		int i = 0;
		int j = 0;
		while(true)
		{
			if(A.get(i) > B.get(j))
			{
				array_1_2_com.add(B.get(j));
				array_1_2_com_index.add(2);
				j++;
			}
			else
			{
				array_1_2_com.add(A.get(i));
				array_1_2_com_index.add(1);
				i++;
			}
			
			if(i==A.size())
			{
				for(int k=j; k<B.size(); k++)
				{
					array_1_2_com.add(B.get(k));
					array_1_2_com_index.add(2);
				}
				break;
			}
			
			if(j==B.size())
			{
				for(int k=i; k<A.size(); k++)
				{
					array_1_2_com.add(A.get(k));
					array_1_2_com_index.add(1);
				}
				break;
			}
		}
		
		
		
		
		ArrayList<Integer> all_com = new ArrayList<Integer>();
		ArrayList<Integer> all_com_index = new ArrayList<Integer>();
		
		int l = 0;
		int m = 0;
		while(true)
		{
			if(Math.abs(array_1_2_com.get(l)) > C.get(m))
			{
				all_com.add(C.get(m));
				all_com_index.add(3);
				m++;
			}
			else
			{
				all_com.add(array_1_2_com.get(l));
				all_com_index.add(array_1_2_com_index.get(l));
				l++;
			}
			
			if(l==array_1_2_com.size())
			{
				for(int k=m; k<C.size(); k++)
				{
					all_com.add(C.get(k));
					all_com_index.add(3);
				}
				break;
			}
			
			if(m==C.size())
			{
				for(int k=l; k<array_1_2_com.size(); k++)
				{
					all_com.add(array_1_2_com.get(k));
					all_com_index.add(array_1_2_com_index.get(k));
				}
				break;
			}
		}
		
		int indexSum = 0;
		int minDiff = Integer.MAX_VALUE;
		for(int n=0; n<all_com.size(); n++)
		{
			indexSum = indexSum + all_com_index.get(n);
			if(n > 2)
			{
				indexSum = indexSum - all_com_index.get(n-3);
			}
			
			if(n>=2 && indexSum == 6)
			{
				int diff = Math.abs(all_com.get(n) - all_com.get(n-2));
				if(diff < minDiff)
				{
					minDiff = diff;
				}
			}
		}
		
		return minDiff;
    }
}
