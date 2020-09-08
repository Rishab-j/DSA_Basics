package LeetCode;

/**
 * MaximumSumCircularSubArray
 */
public class MaximumSumCircularSubArray {

    public static int maxSubarraySumCircular_mymethod(int[] A) {
        
        // this method only find the maximum sum in the circular array not the maximum subarray

        int max_so_far = A[0];
        int max_ending_here = A[0];
        int n = A.length;
        int cl = 2 * n - 2; // 5
        // int[] arr = {5,-3,5};
        for (int i = 1; i <= cl; i++) {
            int idx = i % n;
            max_ending_here = Math.max(A[idx], max_ending_here+A[idx]);
            max_so_far = Math.max(max_ending_here, max_so_far);
        }
        return max_so_far;
    }

    public static int maxSubarraySumCircular(int[] A) {
        if(A.length == 0) return 0;
        int sum = A[0];
        int maxSoFar = A[0];
        int maxTotal = A[0];
        int minTotal = A[0];
        int minSoFar = A[0];
        for(int i = 1; i < A.length; i++){
            int num = A[i];
            maxSoFar = Math.max(num, maxSoFar + num);
            maxTotal = Math.max(maxSoFar, maxTotal);
            
            minSoFar = Math.min(num, minSoFar + num);
            minTotal = Math.min(minTotal, minSoFar);
            
            sum += num;
        }

        // case when all numbers are negative

        if(sum == minTotal) return maxTotal;
        return Math.max(sum - minTotal, maxTotal);
        
    }

    public static void main(String[] args) {
        int[] arr = { 5, -3, 5 };
        int ans = maxSubarraySumCircular(arr);
        System.out.println(ans);
    }
}