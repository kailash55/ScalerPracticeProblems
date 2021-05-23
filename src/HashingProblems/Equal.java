package HashingProblems;

import java.util.HashMap;

public class Equal {
	public static void main(String args[])
	{
		EqualSolution e = new EqualSolution();
		int[] o = e.equal(new int[] {1, 1, 1, 1, 1 });
		System.out.println();
	}
}

class EqualSolution {
	public int[] equal(int[] A) {
		
		HashMap<Integer, Pairs> pairs = new HashMap<Integer, Pairs>();
		
		OutputPairs opairs =null;
		for(int i=0; i<A.length; i++)
		{
			for(int j=i+1; j<A.length; j++)
			{
				int sum = A[i] + A[j];
				Pairs prevPair = pairs.get(sum);
				Pairs newPair = new Pairs(i, j);
				
				if(prevPair==null)
				{
					pairs.put(sum, newPair);
				}
				else
				{
					if(prevPair.validForNew(newPair))
					{
						OutputPairs newOutputPair = new OutputPairs(prevPair.value1, prevPair.value2, newPair.value1, newPair.value2);
						if(opairs == null)
						{
							opairs = newOutputPair;
						}
						else 
						{
							opairs = opairs.comparePair(newOutputPair);
						}
					}
				}

			}
		}
		
		if(opairs == null)
			return new int[] {};
		return opairs.returnArray();
    }
	
	class Pairs
	{
//		@Override
//		public String toString() {
//			return "Pairs [value1=" + value1 + ", value2=" + value2 + "]";
//		}

		public Pairs(int a, int b)
		{
			if(a<=b)
			{
				value1 = a;
				value2 = b;
			}
			else
			{
				value1 = b;
				value2 = a;
			}
			
		}
		
		public boolean validForNew(Pairs pair)
		{
			return (pair.value1 != this.value1) && (pair.value2!=this.value1) && (pair.value1 != this.value2) && (pair.value2 != this.value2);
			//return (this.value1 < pair.value1) && (pair.value1 != this.value2) && (pair.value2 != this.value2);
		}
		
		public boolean equals(Pairs pair)
		{
			return (this.value1 == pair.value1) && (this.value2 == pair.value2);
		}
		public int value1;
		public int value2;
	}
	
	class OutputPairs
	{
		public OutputPairs(int a1, int b1, int a2, int b2)
		{
			this.pair1 = new Pairs(a1, b1);
			this.pair2 = new Pairs(a2, b2);
		}
		public Pairs pair1;
		public Pairs pair2;
		
		public int[] returnArray()
		{
			return new int[] {this.pair1.value1, this.pair1.value2, this.pair2.value1, this.pair2.value2};
		}
		
		public OutputPairs comparePair(OutputPairs pairToCompare)
		{
			if(this.pair1.value1 - pairToCompare.pair1.value1 < 0)
				return this;
			else if(this.pair1.value1 - pairToCompare.pair1.value1 > 0)
				return pairToCompare;
			
			if(this.pair1.value2 - pairToCompare.pair1.value2 < 0)
				return this;
			else if(this.pair1.value2 - pairToCompare.pair1.value2 > 0)
				return pairToCompare;
			
			if(this.pair2.value1 - pairToCompare.pair2.value1 < 0)
				return this;
			else if(this.pair2.value1 - pairToCompare.pair2.value1 > 0)
				return pairToCompare;
			
			if(this.pair2.value2 - pairToCompare.pair2.value2 < 0)
				return this;
			else if(this.pair2.value2 - pairToCompare.pair2.value2 > 0)
				return pairToCompare;
			else
				return this;
						
		}
	}
}
