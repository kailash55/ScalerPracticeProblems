package arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
        Integer max = Integer.MIN_VALUE;
        Integer min = Integer.MAX_VALUE;
        
        for(int i=0; i<arr.size(); i++)
        {
            if(arr.get(i) > max)
                max = arr.get(i);
            
            if(arr.get(i) < min)
                min = arr.get(i);
        }
        
        long maxTotal = 0;
        long minTotal = 0;
        
        boolean minExc = false;
        boolean maxExc = false;
        for(int i=0; i<arr.size(); i++)
        {
            
            if(arr.get(i).equals(min) && !minExc)
            {
                //maxTotal = maxTotal + arr.get(i);
                minExc = true;
            }
            else
            {
                maxTotal = maxTotal + arr.get(i);
            }
                
            
            if(arr.get(i).equals(max) && !maxExc)
            {
                //minTotal = minTotal + arr.get(i);
                maxExc = true;
            }
            else
            {
                minTotal = minTotal + arr.get(i);
            }
                
        }
        
        System.out.print(minTotal + " " + maxTotal);
    }

}

public class MinMax {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
