package LeetCode;

public class PermutationsInString {
    
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length()){
            return false;
        }
        
        int[] alpha = new int[26];
        for(char c : s1.toCharArray()){
            alpha[c-'a'] += 1;
        }
        
        int start = 0;
        for(int i = 0;i<s1.length();i++){
            alpha[s2.charAt(i)-'a'] -= 1;
        }
        
        boolean mismatch = true;
        for(int ch : alpha){
            if(ch!=0){
                mismatch = false;
                break;
            }
        }
        
        if(mismatch){
            return true;
        }
        start++;
        
        while(start <= s2.length() - s1.length()){
            int idx1 = s2.charAt(start-1)-'a';
            int idx2 = s2.charAt(start+s1.length()-1)-'a';
            alpha[idx1] +=1;
            alpha[idx2] -=1;
            
            mismatch = true;
            for(int ch : alpha){
                if(ch!=0){
                    mismatch = false;
                    break;
                }
            }
        
         if(mismatch==true){
            return true;
        }
        start++;
        }
        return false; 
        }
        


}