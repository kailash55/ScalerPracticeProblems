package HashingProblems;

import java.util.HashMap;

public class ChangeDateFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ChangeDateFormatSolution().solve("2nd Feb 2013"));
	}

}

class ChangeDateFormatSolution
{
	public String solve(String A) {
		
		
		String[] monts = new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		HashMap<String, String> monthMap = new HashMap<String, String>();
		
		for(int i=0; i< monts.length; i++)
		{
			String monthNumber = "";
			if((i+1)/10 == 0)
				monthNumber = "0"+String.valueOf(i+1);
			else
				monthNumber = String.valueOf(i+1);
			monthMap.put(monts[i], monthNumber);
		}
		
		String[] splitted = A.split(" ");
		
		String day = splitted[0].trim().substring(0, splitted[0].length()-2);
		if(day.length()==1)
			day = "0"+day;
		String month = monthMap.get(splitted[1]);
		String year = splitted[2];
		return year+"-"+month+"-"+day;
    }
}
