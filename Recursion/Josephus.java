package Recursion;

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static int circleOfDeath(int n , int k){
        if (n == 1) {
             return 1;
        }
        
        else
            return (circleOfDeath(n - 1, k) + k-1) % n + 1; 
        
    }
	public static void main (String[] args) {
		//code
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for(int i=0;i<t;i++){
		int n = scn.nextInt();
		int k = scn.nextInt();
		System.out.println(circleOfDeath(n,k));
		}
		
	}
}