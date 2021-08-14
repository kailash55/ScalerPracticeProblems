package RecursionAndBacktracking;

import java.util.ArrayList;

public class GenerateAllParenthesesII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new GenerateAllParenthesesIISolution().generateParenthesis(5));
		System.out.println(new GenerateAllParenthesesIISolution().generateParenthesis(5).size());
	}

}

class GenerateAllParenthesesIISolution
{
	public ArrayList<String> generateParenthesis(int A) {
		
		int totalParan = A * 2;
		int count = A-1;
		int index = 1;
		int arr[] = new int[totalParan];
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		sb.append("(");
		sb2.append("(");
		ArrayList<String> output = new ArrayList<String>();
		rec(arr, index, count, sb, output);
		return output;
    }
	
	public void rec(int[] arr, int index, int count,StringBuilder sb,ArrayList<String> output)
	{
		if(index == arr.length)
		{
			if(count == 0)
			{
				boolean isValid = checkIfValid(sb);
				
				if(isValid)
				output.add(sb.toString());
			}
			return;
		}
		if(count > 0 && index<=arr.length-2)
		{
			sb.append("(");
			count--;
			rec(arr, index+1, count,sb ,output);
			count++;
			sb.deleteCharAt(sb.length()-1);
		}
		sb.append(")");
		rec(arr, index+1, count,sb,output);
		sb.deleteCharAt(sb.length()-1);
	}

	private boolean checkIfValid(StringBuilder sb) {
		// TODO Auto-generated method stub
		StringBuilder sb2 = new StringBuilder();
		sb2.append("(");
		for(int i=1; i<sb.length(); i++)
		{
			if(sb.charAt(i) == ')')
			{
				sb2.append(")");
				if(sb2.length()>=2)
				{
					if(sb2.charAt(sb2.length()-2) == '(')
					{
						sb2.delete(sb2.length()-2, sb2.length());
						
					}
				}
			}
			else
			{
				sb2.append("(");
			}
		}
		return (sb2.length() == 0);
	}
}
