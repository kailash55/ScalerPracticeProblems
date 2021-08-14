package Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class MaximumFrequencyStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
		arrayList.add(new ArrayList<Integer>(Arrays.asList(1,2)));
		arrayList.add(new ArrayList<Integer>(Arrays.asList(2,0)));
		arrayList.add(new ArrayList<Integer>(Arrays.asList(1,2)));
		arrayList.add(new ArrayList<Integer>(Arrays.asList(1,7)));
		arrayList.add(new ArrayList<Integer>(Arrays.asList(2,0)));
		arrayList.add(new ArrayList<Integer>(Arrays.asList(2,0)));
		arrayList.add(new ArrayList<Integer>(Arrays.asList(1,4)));
		arrayList.add(new ArrayList<Integer>(Arrays.asList(1,1)));
		arrayList.add(new ArrayList<Integer>(Arrays.asList(1,7)));
		//arrayList.add(new ArrayList<Integer>(Arrays.asList(1,6)));
		//arrayList.add(new ArrayList<Integer>(Arrays.asList(2,6)));
		
		System.out.println(new MaximumFrequencyStackSolution().solve(arrayList));
	}

}


class MaximumFrequencyStackSolution
{
	public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
		
		ArrayList<Integer> out = new ArrayList<Integer>();
		HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Stack<Integer>> freqStackMap = new HashMap<Integer, Stack<Integer>>();
		Stack<Integer> freqStack = new Stack<Integer>();
 		
		for(int i=0; i<A.size(); i++)
		{
			if(A.get(i).get(0) == 1)
			{
				int number = A.get(i).get(1);
				Integer freq = freqMap.get(number);
				if(freq == null)
					freq = 0;
				Integer newFreq = freq + 1;
				freqMap.put(number, newFreq);
				
				Stack<Integer> st = freqStackMap.get(newFreq);
				if(st == null)
				{
					st = new Stack<Integer>();
					freqStackMap.put(newFreq, st);
				}
				st.push(number);
				
				if(freqStack.isEmpty() || newFreq > freqStack.peek())
				{
					freqStack.add(newFreq);
				}	
				
				out.add(-1);
			}
			else
			{
				Stack<Integer> st = freqStackMap.get(freqStack.peek());
				Integer v = st.pop();
				Integer freq = freqMap.get(v);
				freqMap.put(v, freq-1);
				out.add(v);
				if(st.isEmpty())
				{
					freqStack.pop();
				}
			}
		}
		
		return out;
    }
}
