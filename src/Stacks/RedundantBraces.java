package Stacks;

import java.util.Stack;

public class RedundantBraces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new RedundantBracesSolution().braces("(a+(a+b))"));
	}

}

class RedundantBracesSolution
{
	public int braces(String A) {
		
		Stack<Character> st = new Stack<Character>();
		
		for(int i=0; i<A.length(); i++)
		{
			char c = A.charAt(i);
			if(c == ')')
			{
				long count = 0;
				while(!st.isEmpty())
				{
					if(st.peek() == '(')
					{
						if(count <= 1)
							return 1;
						st.pop();
						st.push('n');
						break;
					}
					else
					{
						count++;
						st.pop();
					}
				}
			}
			else
			{
				st.push(c);
			}
		}
		return 0;
    }
}
