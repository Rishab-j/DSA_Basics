package Recursion;

import java.util.ArrayList;

/**
 * NokiaKeypad
 */
public class NokiaKeypad {

    public static void keyPad(String[] keys, String code, String ans) {
        if (code.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = code.charAt(0);
        int cc = ch - '0';
        String roq = code.substring(1);
        for (int i = 0; i < keys[cc].length(); i++) {

            char ch1 = keys[cc].charAt(i);
            keyPad(keys, roq, ans + ch1);
        }
    }

    public static ArrayList<String> nokia(String[] keys, String code) {

        if (code.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add(" ");
            return base;
        }

        char ch = code.charAt(0);
        int cc = ch - '0';
        String roq = code.substring(1);

        ArrayList<String> recAns = nokia(keys, roq);
        ArrayList<String> myAns = new ArrayList<>();
        for (String rstr : recAns) {
            for (int i = 0; i < keys[cc].length(); i++) {
                char ch1 = keys[cc].charAt(i);
                myAns.add(ch1 + rstr);
            }
        }
        return myAns;
    }

    public static void main(String[] args) {
        String[] keys = { ".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wx", "yz" };
        String code = "12";
        // System.out.println(nokia(keys,code));
        keyPad(keys, code, "");
    }
}