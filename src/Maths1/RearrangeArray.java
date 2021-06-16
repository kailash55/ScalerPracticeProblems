package Maths1;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>(
				Arrays.asList(4, 0, 2, 1, 3));
		new RearrangeArraySolution().arrange(a);
	}

}


class RearrangeArraySolution
{
	public void arrange(ArrayList<Integer> a) {	
		int n = a.size();
		for(int i=0; i<a.size(); i++)
		{
			int element = a.get(a.get(i)) % n;
			//a.set( a.get(i) , a.get(a.get(i)) / n);
			int newElement = a.get(i) + element * n;
			a.set(i, newElement);		
		}
		
		for(int i=0; i<a.size(); i++)
		{
			a.set(i, a.get(i)/n);
		}
		System.out.println();
	}
}