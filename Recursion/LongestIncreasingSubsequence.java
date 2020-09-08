package Recursion;

/**
 * LongestIncreasingSubsequence
 */
public class LongestIncreasingSubsequence {

    static int max;

    public static int lis(int[] arr,int n){
        //base case (when size of the passe array is 1)
        if(n==1){
            return 1;
        }
        
        // res is to store the max length for each call and max_end_here is store the LIS of this level
        int res,max_end_here=1;

        for(int i = 1 ;i<n;i++){
           // calls LIS for array of size of i
            res=lis(arr,i);
            //checks if the previous index's element is smaller than the next index if yes then it updates the values
            if(arr[i-1]<arr[n-1] && max_end_here<res+1){
                max_end_here=res+1;
            }
        }


        // stores the max LIS so far
        if(max<max_end_here){
           max = max_end_here;
        }

        // returns to the res above;
        return max_end_here;
    }

    public static void main(String[] args) {
        int[] arr = {10,22,9,33,21,50,41,60,80,1};
        lis(arr,arr.length-1);
        System.out.println(max);
    }
}