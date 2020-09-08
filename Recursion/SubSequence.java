package Recursion;

import java.util.ArrayList;

/**
 * SubSequence
 */
public class SubSequence {

    public static void subSequence(String str , String ans){
        
        if(str.length()==0){
            System.out.println(ans);
            return ;
        }

        char ch = str.charAt(0);
        String roq = str.substring(1);
        subSequence(roq, ans);
        subSequence(roq, ch+ans);
    }

    public static ArrayList<String> sub(String str){
        if(str.length()==0){
            ArrayList<String> base = new ArrayList<>();
            base.add(" ");
            return base;
        }
        
        char ch = str.charAt(0);
        String roq = str.substring(1);
        ArrayList<String> recAns = sub(roq);
        ArrayList<String> myAns = new ArrayList<>();
        for(String rstr:recAns){
            myAns.add(rstr);
            myAns.add(ch+rstr);
        }
        return myAns;
    }

    

        public static ArrayList<String> subascii(String str){
            if(str.length()==0){
                ArrayList<String> base = new ArrayList<>();
                base.add(" ");
                return base;
            }
            
            char ch = str.charAt(0);
            String roq = str.substring(1);
            ArrayList<String> recAns = subascii(roq);
            ArrayList<String> myAns = new ArrayList<>();
            for(String rstr:recAns){
                myAns.add(rstr);
                myAns.add(ch+rstr);
                myAns.add((int)ch + rstr);
            }
            return myAns;
        }
    
    public static void main(String[] args) {
        String s = "abc";
        //System.out.println(sub(s));
        //System.out.println(subascii(s));
        subSequence(s, "");
    
    }
}