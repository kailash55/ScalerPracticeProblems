package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class AddOneToNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> list = new ArrayList<Integer>(
	            Arrays.asList(1, 9, 9, 9, 9, 9, 9));
		
		AddOneToNumberSolution2 s= new AddOneToNumberSolution2();
		ArrayList<Integer> out = s.plusOne(list);
		for(Integer i : out)
		{
			System.out.print(i);
		}
	}

}

class AddOneToNumberSolution2
{
	public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		ArrayList<Integer> outputArray = new ArrayList<Integer>();
		
		int lastElement = A.get(A.size()-1);
		lastElement++;
		
		outputArray.add(0,lastElement%10);
		
		int carry = lastElement/10;
		for(int i = A.size()-2; i>=0; i--)
		{
			int number = A.get(i) + carry;
			outputArray.add(0,number%10);
			carry = number/10;
		}
		
		outputArray.add(0,carry);
		
		ArrayList<Integer> withoutZero = new ArrayList<Integer>();
		boolean foundFirstSignificantBit = false;
		for(int i=0; i<outputArray.size(); i++)
		{
			if(!foundFirstSignificantBit && outputArray.get(i)>0) {
				foundFirstSignificantBit = true;
			}
			
			if(foundFirstSignificantBit)
				withoutZero.add(outputArray.get(i));
		}
		return withoutZero;
    }
	
}


class AddOneToNumberSolution
{
	public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		
		int sum = 0;
		int bitPlaceFactor = 1;
		for(int i=A.size()-1; i>=0; i--)
		{
			sum = sum + A.get(i) * bitPlaceFactor;
			bitPlaceFactor *= 10;
		}
		sum++;
		
		
		return splitIntToArray(sum);
    }
	
	private ArrayList<Integer> splitIntToArray(int number)
	{
		ArrayList<Integer> splittedArray = new ArrayList<Integer>();
		do
		{
			Integer lastDigit = number % 10;
			number = number / 10;
			splittedArray.add(0, lastDigit);
		}
		while(number!=0);
		return splittedArray;
	}
}
