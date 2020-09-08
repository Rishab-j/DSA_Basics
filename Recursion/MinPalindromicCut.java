package Recursion;

public class MinPalindromicCut {

    public static int mpc(String str,int si,int ei){

       if(isPalindrome(str,si,ei)){
           return 0;
       }
       
        int min = Integer.MAX_VALUE;

        for(int cp=si;cp<ei;cp++){
            int min1 = mpc(str, si, cp);
            int min2 = mpc(str, cp+1, ei);

            int mincut = min1+min2+1;
            if(min>mincut){
            min = mincut;
            }
            
        }
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

    public static void main(String[] args) {
        String str= "abccbc";
       System.out.println( mpc(str, 0, str.length()-1));
    }
}