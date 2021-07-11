package Advanced.ArraysAndMaths;

import java.util.ArrayList;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(5,9));
		intervals.add(new Interval(13,18));
		intervals.add(new Interval(22,25));
		
		System.out.println(new MergeIntervalsSolution().insert(intervals, new Interval(23,29)));
	}

}

////**
  //Definition for an interval.
 class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
 

class MergeIntervalsSolution
{
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		
		ArrayList<Integer> intervalArr = getCombinedArray(intervals, newInterval);
		ArrayList<Integer> mergedIntervalArr = new ArrayList<Integer>();
		
		boolean oldIntervalLeft = false;
		boolean newIntervalLeft = false;
		boolean oldIntervalRight = true;
		boolean newIntervalRight = false;
		
		boolean newIntervalLeftFound = false;
		boolean rightFound = false;
		
		for(int i=0; i<intervalArr.size(); i++)
		{
			if(!newIntervalLeftFound)
			{
				if(intervalArr.get(i) < 0)
				{
					newIntervalLeftFound = true;
					if(i % 2 == 0)
					{
						mergedIntervalArr.add(0 - intervalArr.get(i));
					}
					continue;
				}
				else
				{
					mergedIntervalArr.add(intervalArr.get(i));
					continue;
				}
			}
			
			if(newIntervalLeftFound && !rightFound)
			{
				if(intervalArr.get(i) < 0)
				{
					if(i % 2 != 0)
					{
						mergedIntervalArr.add(0 - intervalArr.get(i));
					}
					rightFound = true;
					continue;
				}
			}
			
			if(newIntervalLeftFound && rightFound)
			{
				mergedIntervalArr.add(intervalArr.get(i));
			}
			
		}
		
		ArrayList<Interval> out = new ArrayList<Interval>();
		for(int i=0; i<mergedIntervalArr.size();i=i+2)
		{
			out.add(new Interval(mergedIntervalArr.get(i), mergedIntervalArr.get(i+1)));
		}
		return out;
    }
	
	public ArrayList<Integer> getCombinedArray(ArrayList<Interval> intervals, Interval newInterval)
	{
		ArrayList<Integer> intervalArr = new ArrayList<Integer>();
		
		boolean putLeft = true;
		boolean putRight = true;
		int[] newIntArr = new int[] {Math.min(newInterval.start, newInterval.end), Math.max(newInterval.start, newInterval.end)};
		int newIntArrIndex = 0;
		for(int i=0; i<intervals.size(); i++)
		{
			int j=0;
			while(j<2)
			{
				if(j==0)
				{
					if(newIntArrIndex <2 && intervals.get(i).start > newIntArr[newIntArrIndex])
					{
						intervalArr.add(0 - newIntArr[newIntArrIndex]);
						newIntArrIndex++;
					}
					else
					{
						intervalArr.add(intervals.get(i).start);
						j++;
					}
				}
				else
				{
					if(newIntArrIndex <2  && intervals.get(i).end > newIntArr[newIntArrIndex])
					{
						intervalArr.add(0 - newIntArr[newIntArrIndex]);
						newIntArrIndex++;
					}
					else
					{
						intervalArr.add(intervals.get(i).end);
						j++;
					}
				}
			}
		}
		
		for(int i=newIntArrIndex; i<2; i++)
		{
			intervalArr.add(0 - newIntArr[i]);
		}
		return intervalArr;
	}
}
