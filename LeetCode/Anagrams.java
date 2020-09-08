package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Anagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) {
            return result;
        }

        int[] pchars = new int[26];
        for (char c : p.toCharArray()) {
            pchars[c - 'a'] += 1;
        }

        int start = 0;
        for (int i = 0; i < p.length(); i++) {
            pchars[s.charAt(i) - 'a'] -= 1;
        }

        int mismatch = 0;
        for (int pc : pchars) {
            if (pc != 0)
                mismatch += 1;
        }

        if (mismatch == 0) {
            result.add(start);
        }
        start++;

        while (start <= s.length() - p.length()) {
            int idx1 = s.charAt(start - 1) - 'a';
            int idx2 = s.charAt(start + p.length() - 1) - 'a';
            pchars[idx1] += 1;

            if (pchars[idx1] == 1) {
                mismatch += 1;
            } else if (pchars[idx1] == 0) {
                mismatch -= 1;
            }

            pchars[idx2] -= 1;
            if (pchars[idx2] == -1) {
                mismatch += 1;
            } else if (pchars[idx2] == 0) {
                mismatch -= 1;
            }

            if (mismatch == 0) {
                result.add(start);
            }
            start++;
        }
        return result;
    }


    //------------ EASY -----------

    public List<Integer> findAnagrams_easy(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length() > s.length()){
            return result;
        }
        

        int[] pchars = new int[26];
        for(char c:p.toCharArray()){
            pchars[c-'a'] += 1; 
        }
        
        int start = 0;
        for(int i = 0;i<p.length();i++){
            pchars[s.charAt(i)-'a'] -=1;
        }
    
        boolean mismatch = true; // here is the difference
        for(int pc:pchars){
            if(pc!=0)
            {
                mismatch = false;
                break;
            }   
        }
    
        if(mismatch){
            result.add(start);
        }
        start++;
        
        
        while(start<=s.length() - p.length()){
            int idx1 = s.charAt(start-1)-'a';
            int idx2 = s.charAt(start+p.length()-1)-'a';
            pchars[idx1]+=1;
            pchars[idx2]-=1;
            
              mismatch = true;
            for(int pc:pchars){
                if(pc!=0)
                {
                    mismatch = false;
                    break;
                }   
            }
    
            if(mismatch){
                result.add(start);
            }
            start++;
            }
     return result;
    }
    





}