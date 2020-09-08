package DP;

public class MinPalindromicCut {

    public static int mpc(String str,int si,int ei,int[][] dp){

        if(isPalindrome(str,si,ei)){
            return 0;
        }
        if(dp[si][ei]!=0){
            return dp[si][ei];
        }
        
         int min = Integer.MAX_VALUE;
 
         for(int cp=si;cp<ei;cp++){
             int min1 = mpc(str, si, cp,dp);
             int min2 = mpc(str, cp+1, ei,dp);
 
             int mincut = min1+min2+1;
             if(min>mincut){
             min = mincut;
             }
             
         }

         dp[si][ei]=min;
         return min;
     }
 
     public static boolean isPalindrome(String str,int si,int ei){
         int l = si;
         int r = ei;
 
         while(l<r){
             if(str.charAt(l)!=str.charAt(r)){
                 return false;
 
             }
             l++;
             r--;
         }
         return true;
     }


     public static int mpctab(String str,int si,int ei){
         boolean[][] palindrome= new boolean[str.length()][str.length()];
         for(int gap = 0;gap<str.length();gap++){
            int i = 0;
            int j = i+gap;
            while(j<str.length()){
            if(gap==0){
                palindrome[i][j]=true;
            }
            else if(gap==1){
                palindrome[i][j] = str.charAt(i)==str.charAt(j);
            }
            else{
                if(str.charAt(i)==str.charAt(j) && palindrome[i+1][j-1]){
                    palindrome[i][j]=true;
                }

            }
            i++;
            j++;}
        }
    
        int[][] dp = new int[str.length()][str.length()];

        for(int gap = 0;gap<str.length();gap++){
            int i = 0;
            int j=i+gap;
            while(j<str.length()){
            if(gap==0){
                dp[i][j]=0;
            }

            else if(gap==1){
                if( palindrome[i][j]){
                    dp[i][j]=0;
                }
                else{
                    dp[i][j]=1;
                }
            }
            else{
                if(palindrome[i][j]==true){
                    dp[i][j]=0;
                    i++;
                    j++;
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for(int cp=i;cp<j;cp++){

                    

                    int fp = dp[i][cp];
                    int sp = dp[cp+1][j];

                    int factor = fp + sp +1; 

                    if(factor<min){
                        min = factor;
                    }
                }
                dp[i][j]=min;

                }
                i++;
                j++;
            }
        }
        return dp[0][str.length()-1];
    }
 
     public static void main(String[] args) {
         String str= "abccbc";
        System.out.println( mpc(str, 0, str.length()-1,new int[str.length()][str.length()]));
        System.out.println(mpctab(str, 0, str.length()-1));
     }

}