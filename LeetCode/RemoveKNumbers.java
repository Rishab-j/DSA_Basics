package LeetCode;

import java.util.Stack;

public class RemoveKNumbers {

    public static String removeKNumbers(String nums, int k) {
        if (nums.length() == 0) {
            return "0";
        }
        if (nums.length() == k) {
            return "0";
        }

        StringBuilder ans = new StringBuilder(nums);
        for (int i = 0; i < k; i++) {
            int j = 0;
            while (j < ans.length() - 1 && ans.charAt(j) <= ans.charAt(j + 1)) {
                j++;
            }
            ans.delete(j, j + 1);
        }

        while (ans.length() > 0 && ans.charAt(0) == 0) {
            ans.delete(0, 1);
        }
        return ans.toString();
    }

    public static String removeKNumbers_Stacks(String nums, int k) {

        if (nums.length() == 0 || nums.length() == k) {
            return "0";
        }

        int size = nums.length();
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int i = 0;
        while (i < size) {

            while (k > 0 && !stack.isEmpty() && stack.peek() > nums.charAt(i)) { // if the top element at stack is bigger than the upcoming element then pop from stack
                stack.pop();
                k--; // since we removed one 
            }

            stack.push(nums.charAt(i));
            i++;
        }

        while (k > 0) { // this handles the case such as num = 112 ,so ans would be = 11
            stack.pop();
            k--;
        }

        while (stack.size() != 0) { // pop form stack and append to string ans one by one
            ans.append(stack.pop());
        }

        ans.reverse(); 

        while (ans.length() > 1 && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }

        return ans.toString();

    }

    public static void main(String[] args) {
        String nums = "112";
        int k = 1;
        String ans = removeKNumbers(nums, k);
        System.out.println(ans);
        String ans2 = removeKNumbers_Stacks(nums, k);
        System.out.println(ans2);
    }

}