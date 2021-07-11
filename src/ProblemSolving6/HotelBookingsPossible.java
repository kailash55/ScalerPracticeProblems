package ProblemSolving6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class HotelBookingsPossible {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arrive = new ArrayList<Integer>(Arrays.asList(1, 2, 3 ));
		ArrayList<Integer> depart = new ArrayList<Integer>(Arrays.asList(2, 3, 4 ));
		
		System.out.println(new HotelBookingsPossibleSolution().hotel(arrive, depart, 1));
	}

}


class HotelBookingsPossibleSolution
{
	public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
		
		ArrayList<Integer> combinedBooking = new ArrayList<Integer>();
		
		for(int i=0; i<arrive.size(); i++)
		{
			combinedBooking.add(arrive.get(i));
		}
		
		for(int i=0; i<depart.size(); i++)
		{
			combinedBooking.add(depart.get(i) * -1);
		}
		
		Collections.sort(combinedBooking, new AbsoluteComparatory());
		
		int totalBookings = 0;
		for(int i=0; i<combinedBooking.size();i++)
		{
			if(combinedBooking.get(i) >= 0)
			{
				totalBookings++;
			}
			else
			{
				totalBookings--;
			}
			
			if(totalBookings > K)
				return false;
		}
		
		return true;
    }
	
	class AbsoluteComparatory implements Comparator<Integer> {
	    // Used for sorting in ascending order of
	    // roll number
	    public int compare(Integer a, Integer b)
	    {
	        return Math.abs(a) - Math.abs(b);
	    }
	}
}