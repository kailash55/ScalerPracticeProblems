package multidimensionalArrays;

public class PatternPrinting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    
	        int A=2;
	        int[][] out = new int[A][A];
	        
	        int limit = A-2;
	        for(int i=0; i<A; i++)
	        {
	        	int c = i+1;;
	            for(int j=A-1-i; j<A; j++)
	            {
	            	out[i][j] = c;
	            	c--;
	            }
	        }
	        
	        System.out.println();
	    }

	

}
