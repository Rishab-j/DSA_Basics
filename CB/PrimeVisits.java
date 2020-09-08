package CB;

import java.util.Scanner;

public class PrimeVisits {

    public static void primeSieve(int[] arr){
        
        // first mark all odd no. as prime
        for(int i=3 ; i<=1000000 ;i=i+2){
            arr[i]=1;
        }

        for(int p = 2 ;p*p<=1000000;p++){ // check only till sqrt(n)
            if(arr[p]==1){ // if the no. is prime only then mark its multiple false
                for(int  j = p*p ; j<=1000000; j=j+p){
                    arr[j]=0;
                }
            }
        }

        //special cases
        arr[2]=1;
        arr[1]=arr[0]=0;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int [1000005];
        primeSieve(arr);
        

        
        int t  = scn.nextInt();

        int[] csum = new int[arr.length];

        for(int i = 1;i<csum.length ; i++ ){
            csum[i] = csum[i-1] + arr[i];
        }
        


        while(t-->0){
            int a = scn.nextInt();
            int b = scn.nextInt();

            int ans = csum[b] - csum[a-1];
            System.out.println(ans);
        }

        
    }
}