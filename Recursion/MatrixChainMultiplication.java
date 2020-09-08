package Recursion;

public class MatrixChainMultiplication {

    public static int mcm(int[] arr,int si,int ei){

        if(ei-si==1){

            return 0;
            
        }
        int min = Integer.MAX_VALUE;
        //int[] arr = {10,20,30,40,50,60};
        for(int bp=si+1;bp<ei;bp++){
            int mcm1 = mcm(arr, si, bp);
            int mcm2 = mcm(arr, bp, ei);
            int product = arr[si] * arr[bp] * arr[ei];
            int sumatthislevel = mcm1 + mcm2 + product;
            if(min > sumatthislevel){
                min = sumatthislevel;
            }

        }

        return min;
    }

    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60};
        System.out.println(mcm(arr, 0, arr.length-1)); 
    }
}