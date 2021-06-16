package ProblemSolving2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>
									(Arrays.asList(1, 2, 3, 4, 2, 7, 1, 3, 6));
		
		System.out.println(new SlidingWindowMaximumSolution().slidingMaximum(list, 6));
	}

}

class SlidingWindowMaximumSolution
{
	public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
		
		LinkedList<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> outputList = new ArrayList<Integer>();
		
		for(int i=0; i<A.size(); i++)
		{
			int currentNumber = A.get(i);
			
			if(q.size() > 0) {
				
				int queueTailNumber = A.get(q.getLast());
			
				while(currentNumber > queueTailNumber && q.size() != 0)
				{
					q.removeLast();
					if(q.size()==0)
						break;
					queueTailNumber = A.get(q.getLast());
				}
			}
			q.add(i);
			
			if(i-q.getFirst() >= B)
			{
				q.removeFirst();
			}
			
			
			if(i >= B-1)
			{
				outputList.add(A.get(q.getFirst()));
			}
		}
		return outputList;
    }
}
