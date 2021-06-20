package ProblemSolving6;

import java.util.ArrayList;
import java.util.Arrays;

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
		
		int minArrive = Integer.MAX_VALUE;
		int maxDepart = Integer.MIN_VALUE;
		

		for(int i=0; i<depart.size(); i++)
		{
			if(depart.get(i) > maxDepart)
			{
				maxDepart = depart.get(i);
			}
		}
		
		ArrayList<Integer> bookingArray = new ArrayList<Integer>();
		for(int i=0; i<=maxDepart; i++)
		{
			bookingArray.add(0);
		}
		
		for(int i=0; i<arrive.size(); i++)
		{
			int arriveTime = arrive.get(i);
			int currentBooking = bookingArray.get(arriveTime);
			bookingArray.set(arriveTime, currentBooking+1);
		}
		
		for(int i=0; i<depart.size(); i++)
		{
			int departTime = depart.get(i);
			if(departTime < maxDepart)
			{
			int currentBooking = bookingArray.get(departTime+1);
			bookingArray.set(departTime+1, currentBooking-1);
			}
		}
		
		if(bookingArray.get(0) > K)
			return false;
		
		for(int i=1; i<bookingArray.size(); i++)
		{
			bookingArray.set(i, bookingArray.get(i) + bookingArray.get(i-1));
			if(bookingArray.get(i) > K)
				return false;
		}
		return true;
    }
}