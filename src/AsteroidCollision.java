import java.util.Stack;

public class AsteroidCollision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] asteroids = new int[] {1, -2, -2 ,-2};
		int out[] = asteroidCollision(asteroids);
		for(int i=0; i<out.length; i++)
		{
			System.out.print(out[i] + " ");
		}
	}
	
	public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = asteroids.length;
        int i = 0;
        
        while(i < n)
        {
        	int currentAst = asteroids[i];
        	if(currentAst < 0 && i!=0)
        	{
        		removeFromStack(stack, currentAst);
        	}
        	else
        	{
        		stack.add(currentAst);
        	}
        	i++;
        }
        
        int out[] = new int[stack.size()];
        for(int j=0; j<stack.size(); j++)
		{
			out[j] = stack.get(j);
		}
        return out;
        
    }

	private static void removeFromStack(Stack<Integer> stack, int c) {
		// TODO Auto-generated method stub
		while(true)
		{
			if(c==0)
			{
				break;
			}
			if(stack.size() == 0 && Math.abs(c)>0)
			{
				stack.add(c);
				break;
			}
			
			int p = stack.get(stack.size() - 1);
			
			if(p > 0)
			{
				if(Math.abs(p) <= Math.abs(c))
				{
					stack.pop();
					if(Math.abs(p) == Math.abs(c))
					{
						c = 0;
						break;
					}
				}
				else
				{
					break;
				}
			}
			else
			{
				stack.add(c);
				break;
			}
		}
		
	}

}
