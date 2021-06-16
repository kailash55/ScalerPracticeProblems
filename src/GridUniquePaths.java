
public class GridUniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new GridUniquePathsSolution().uniquePaths2(15,9));
	}

}

class GridUniquePathsSolution
{
	static int uniquePaths2(int m, int n)
    {
        // If either given row number is first or
        // given column number is first
        if (m == 1 || n == 1)
            return 1;
 
        // If diagonal movements are allowed then
        // the last addition is required.
        return uniquePaths2(m - 1, n) + uniquePaths2(m, n - 1);
        // + numberOfPaths(m-1, n-1);
    }
	
    public int uniquePaths(int A, int B) {
        
        if(A==1 || B==1)
            return 1;
        int total = 0;
        int r = 1;
        int c = 1;
        
        while(r<=A && c<=B)
        {
            if(r==1 && c==1)
            {
                total = 1;
                if(r<=A)
                	r++;
                if(c<=B)
                	c++;
                continue;
            }
            total = total * ((r-1) + (c-1));
            if(r<=A)
            	r++;
            if(c<=B)
            	c++;        }
        return total;
    }
}