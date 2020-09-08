package CB;

import java.util.Arrays;

public class DivisibleSumSubArray {

    static int subCount(int arr[], int n, int k) 
    { 
  
        // create auxiliary hash array to 
        // count frequency of remainders 
        int mod[] = new int[k]; 
        Arrays.fill(mod, 0); 
  
        // Traverse original array and compute cumulative 
        // sum take remainder of this current cumulative 
        // sum and increase count by 1 for this remainder 
        // in mod[] array 
        int cumSum = 0; 
        for (int i = 0; i < n; i++) { 
            cumSum += arr[i]; 
            System.out.print(cumSum+" ");
  
            // as the sum can be negative, taking modulo twice 
            mod[((cumSum % k) + k) % k]++; 
        } 

  
        // Initialize result 
        int result = 0; 
  
        // Traverse mod[] 
        for (int i = 0; i < k; i++) 
  
            // If there are more than one prefix subarrays 
            // with a particular mod value. 
            if (mod[i] > 1) 
                result += (mod[i] * (mod[i] - 1)) / 2; 

        
  
        // add the elements which are divisible by k itself 
        // i.e., the elements whose sum = 0 
        result += mod[0]; 
  
        return result; 
    }

    public static void main(String[] args) {
        int[] arr= {1,3,2,4,6};

        
        int ans = subCount(arr, arr.length, arr.length);
        System.out.println(ans);
    }
    
}