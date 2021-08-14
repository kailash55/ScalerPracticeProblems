package Stacks;

import java.util.ArrayList;
import java.util.Stack;

public class PassingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class PassingGameSolution
{
	public int solve(int A, int B, ArrayList<Integer> C) {
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(B);
		
		for(int i=0; i<C.size(); i++)
		{
			if(C.get(i) !=0)
			{
				stack.push(C.get(i));
			}
			else
			{
				stack.pop();
			}
		}
		return stack.peek();
    }
}
