package DP;

/**
 * PalindromicSubstring
 */
public class PalindromicSubstring {

    public static void palindrome(String str){
        boolean[][] dp = new boolean[str.length()][str.length()];
        int count = 0;
        for(int diag = 0;diag<str.length();diag++){
            int si=0;
            int ei=diag;
            
            while(ei<str.length()){
                if(ei-si==0){
                    dp[si][ei]=true;
                    count++;
                }
                else if(ei-si==1){
                    if(str.charAt(si)==str.charAt(ei)){
                        dp[si][ei]=true;
                        count++;
                    }
                    
                }
                else{
                    if(str.charAt(si)==str.charAt(ei) && dp[si+1][ei-1]==true){
                        dp[si][ei]=true;
                        count++;
                    }
                }
                si++;
                ei++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        String str = "abccbc";
        palindrome(str);
    }
}