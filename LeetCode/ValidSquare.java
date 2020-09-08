package LeetCode;

public class ValidSquare {

    public static boolean validSquare(int n){
        
        if(n==0) return true;
        if(n<0) return false;

        long s = 1;
        long e = n;
        while(s<=e){
            long mid = (s + e)/2;
            if(mid*mid==n) return true;
            if(mid*mid>n) e = mid -1;
            else s= mid +1;
        }

        return false;
    }


    // IDK WHY THIS CODE GIVING WRONG ANSWERS
    
    public boolean binarySearch(int s,int e,int n){
        
        if(e==0 || e==1)
            return true;
        
        if(e>s){
        
        int mid = s+(e-s)/2;
            
        if(s*s==n){
            return true;
        }
        
        if(e*e==n){
            return true;
        }
        
        if(mid*mid==n){
            return true;
        }
        
        if(mid*mid>n){
            
            e=mid-1;
           boolean ans =  binarySearch(s,e,n);
            if(ans){
                return true;
            }
        }
        else{
            s=mid+1;
            
            boolean ans =  binarySearch(s,e,n);
            if(ans){
                return true;
            }
        }
    }
        return false;
    }


    public static void main(String[] args) {
        
        boolean ans=validSquare(25);
        System.out.println(ans);
    }
    
}