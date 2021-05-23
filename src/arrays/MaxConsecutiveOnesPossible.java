package arrays;

public class MaxConsecutiveOnesPossible {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MaxConsecutiveOnesPossibleSolution
{
	public int solve(String A) {
		
		int con_start = -1;
		int con_end = -1;
		int ccount = 0;
		
		int con_start_new = -1;
		int con_end_new = -1;
		int ccount_new = 0;
		boolean countNew = false;
		
		int max_count = 0;
		
		boolean used = false;
		for(int i=0; i<A.length(); i++)
		{
			char c = A.charAt(i);
			if(c=='1')
			{
				if(con_start==-1)
				{
					con_start = i;
				}
				ccount++;
				
				if(countNew)
				{
					if(con_start_new==-1)
					{
						con_start_new = i;
					}
					ccount_new++;
				}
			}
			
			if(c=='0')
			{
				if(!used)
				{
					ccount++;
					countNew = true;
					used = false;
				}
				else 
				{
					
					if(ccount>max_count)
					{
						max_count= ccount;
					}
					ccount = 0;
					
					con_start = con_start_new;
					
				}
			}
		}
		return 0;  
    }
}
