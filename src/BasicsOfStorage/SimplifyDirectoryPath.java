package BasicsOfStorage;

import java.util.ArrayList;

public class SimplifyDirectoryPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new SimplifyDirectoryPathSolution().simplifyPath("/home/"));
	}

}

class SimplifyDirectoryPathSolution
{
	public String simplifyPath(String A) {
		String[] splitted = A.split("/");
		ArrayList<String> stack = new ArrayList<String>();
		
		for(int i=0; i<splitted.length; i++)
		{
			if(splitted[i].equals(".."))
			{
				if(stack.size() > 0)
					stack.remove(stack.size() - 1);
			}
			else if(splitted[i].equals(".") || splitted[i].isBlank() || splitted[i].isEmpty())
			{
				
			}
			else
			{
				stack.add(splitted[i]);
			}
		}
		
		return "/"+String.join("/", stack);
    }
}


