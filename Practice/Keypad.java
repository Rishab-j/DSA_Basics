package Practice;

/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Keypad
{
    public static ArrayList<String> keypad(String[] codes,String n){
        if(n.length()==0){
            ArrayList<String> baseRes=new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }
        
        char ch=n.charAt(0);
        String roq=n.substring(1);
        int idx=ch - '0';
        String code=codes[idx];
        
        ArrayList<String> myAns=new ArrayList<>();
        ArrayList<String> recAns=keypad(codes,roq);
        
        for(int i=0;i<code.length();i++){
            for(String str:recAns){
                myAns.add(code.charAt(i)+str);
            }
        }
        return myAns;
    }
    public static void main(String[] args) {
		//Scanner scn=new Scanner(System.in);
		String n="12";
		String[] codes={".,?","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		ArrayList<String> ans= keypad(codes,n);
		System.out.print(ans);
	}
}
