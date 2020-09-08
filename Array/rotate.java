package Array;

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static void rotate(int[] arr,int r){
        
        for(int j=0;j<r;j++){
        for(int i=0;i<arr.length-1;i++){
            int temp=arr[i];
            arr[i]=arr[i+1];
            arr[i+1]=temp;
        }
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
    
	public static void main (String[] args) {
		//code
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for(int i = 0 ; i < n ; i++){
		    int size = scn.nextInt();
		    int r = scn.nextInt();
		    int[] arr=new int[size];
		    for(int j = 0 ; j < size; j++){
		        arr[j]=scn.nextInt();
		    }
		    rotate(arr,r);
		}
    
    // GFG SOLUTION
    // more accurate
    
    int test = scn.nextInt();
	         while(test-->0)
	         {
	             int N = scn.nextInt();
	             int D = scn.nextInt();
	             int a[]= new int[N];
	             for(int i=0; i<N; i++)
	             {
	                a[i] = scn.nextInt();
	             }
	             StringBuffer s = new StringBuffer();
	             for(int i=D; i<N; i++ )
	             {
	                 s.append(a[i]+" ");
	             }
	             for(int i=0;i<D;i++)
	             {
	                 s.append(a[i]+" ");
	             }
	             System.out.println(s);
	         }
    }
}