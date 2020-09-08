package Array;

import java.io.*;
import java.util.*;

public class TripletSum {
    
    public static void targetSum(int[] arr , int target ){
        
        Arrays.sort(arr);
        
        for(int i = 0 ; i<arr.length ; i++){
            int s = i+1;
            int e = arr.length - 1;
            int x = arr[i];
            while(s<e){
                if(x + arr[s] + arr[e] == target){
                    System.out.println(x+" "+ arr[s] +" "+ arr[e]);
                    s++;
                    e--;
                }
                else if (x + arr[s] + arr[e] < target){
                    s++;
                }
                else {
                    e--;
                }
            }
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int[] runs = new int[N];
        for(int i = 0 ; i < runs.length ; i++){
            runs[i] = scn.nextInt();
        }
        int target = scn.nextInt();
    }
}