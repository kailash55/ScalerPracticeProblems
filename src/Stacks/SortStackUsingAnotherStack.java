package Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SortStackUsingAnotherStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(5, 4, 3, 2, 1));
		System.out.println(new SortStackUsingAnotherStackSolution().solve(A));
	}

}

class SortStackUsingAnotherStackSolution
{
	public ArrayList<Integer> solve(ArrayList<Integer> A) {
		
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		
		for(int i=0;i<A.size();i++)
		{
			if(stack.isEmpty())
				stack.push(A.get(i));
			else
			{
				while(!stack.isEmpty())
				{
					int peek = stack.peek();
					if(A.get(i) < peek)
					{
						int n = stack.pop();
						stack2.push(n);
					}
					else {
						break;
					}
				}
				
				stack.push(A.get(i));
				while(!stack2.isEmpty())
				{
					stack.push(stack2.pop());
				}
			}
			
		}
		
		ArrayList<Integer> out = new ArrayList<Integer>();
		while(!stack.isEmpty())
		{
			out.add(0, stack.pop());
		}
		return out;
    }
}
