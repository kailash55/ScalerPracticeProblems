package Stacks;

import java.util.HashMap;
import java.util.Stack;

public class BalancedParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class BalancedParanthesisSolution
{
	public int solve(String A) {
		
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put(']', '[');
		map.put('}', '{');
		map.put(')', '(');
		
		Stack<Character> stack = new Stack<Character>();
		stack.push(A.charAt(0));
		
		for(int i=1; i<A.length(); i++)
		{
			
			char c = A.charAt(i);
			Character opp = map.get(c);
			
			if(opp == null)
			{
				stack.push(c);
			}
			else
			{
				if(opp.equals(stack.peek()))
				{
					stack.pop();
				}
				else
				{
					stack.push(c);
				}
			}
		}
		return (stack.isEmpty() ? 1 : 0);
    }
}
