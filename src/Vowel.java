
public class Vowel {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VovelSolution s = new VovelSolution();
		System.out.println(s.solve("interviewbit"));
	}
}

class VovelSolution
{
	public String solve(String str)
	{
		String output="";
		for (int i = 0; i < str.length(); i++) {
    	    if ("aeiou".indexOf(str.charAt(i))!= -1 ) {
    	        output = output + str.charAt(i);
    	    }
    	}
		return output;
	}
}
