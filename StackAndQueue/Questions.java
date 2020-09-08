package StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class Questions {

    public static boolean validParentheses(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (st.size() == 0) { // ye wo case h jbb stack empty h but closing brackets aa jaate h
                                      // mtlb closing brackets are more than opening
                    return false;
                } else if (st.peek() == '(' && ch != ')') {
                    return false;
                } else if (st.peek() == '{' && ch != '}') {
                    return false;
                } else if (st.peek() == '[' && ch != ']') {
                    return false;
                } else
                    st.pop(); // jbb sbb kuch shi h pop krdo
            }
        }

        return st.size() == 0 ? true : false; // loop khtm hone ke baad bhi agr stack mei opening brackets h to false ni
                                              // to true
    }

    // isme agr new element chota h top elemnt se to pop krke ans ke popped index pe
    // new element ka idx daal do

    public static int[] nextSmallerOnRight(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        // Arrays.fill(ans,arr.length);

        for (int i = 0; i < arr.length; i++) {
            while (st.size() != 0 && arr[st.peek()] > arr[i]) {
                int idx = st.pop();
                ans[idx] = i;
            }
            st.push(i);

        }

        while (st.size() != 0) {
            int idx = st.pop();
            ans[idx] = arr.length;
        }

        return ans;
    }

    public static int[] nextSmallerOnLeft(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        Arrays.fill(ans, -1);

        for (int i = arr.length - 1; i >= 0; i--) {
            while (st.size() != 0 && arr[st.peek()] > arr[i]) {
                int idx = st.pop();
                ans[idx] = i;
            }
            st.push(i);

        }

        // while(st.size()!=0){
        // int idx=st.pop();
        // ans[idx]=arr.length;
        // }

        return ans;

    }

    public static int[] nextGreaterOnLeft(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        Arrays.fill(ans, -1);

        for (int i = arr.length - 1; i >= 0; i--) {
            while (st.size() != 0 && arr[st.peek()] < arr[i]) {
                int idx = st.pop();
                ans[idx] = i;
            }
            st.push(i);

        }

        // while(st.size()!=0){
        // int idx=st.pop();
        // ans[idx]=arr.length;
        // }

        return ans;

    }

    // Steps: Idea is make a stack of index and allowing only those index whose data
    // is smaller then the top element of stack
    // 1. make a stack of integer
    // 2. make an array ans
    // 3. start a loop from i = 0 to arr.length on given arr
    // in this loop we check if our stack is empty or if the top elemnt is greater
    // or smaller
    // if stack is empty then push the i in stack
    // or push if the data in i is smaller then the data at idx on top of stack
    // else
    // pop the top element which is actually the "idx" of smaller data and put i in
    // arr[idx]
    // repeat until the arr[i] is big
    // 4. at end pop all the remaining indices and put arr.length at arr[idx]

    public static int[] nextGreaterOnRight(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        // Arrays.fill(ans,arr.length);

        for (int i = 0; i < arr.length; i++) {
            while (st.size() != 0 && arr[st.peek()] < arr[i]) {
                int idx = st.pop();
                ans[idx] = i;
            }
            st.push(i);

        }

        while (st.size() != 0) {
            int idx = st.pop();
            ans[idx] = arr.length;
        }

        return ans;

    }

    // Histogram 
    
    public static int largestRectangleArea(int[] heights) {
        int[] nsol = nextSmallerOnLeft(heights);
        int[] nsor = nextSmallerOnRight(heights);

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = nsor[i] - nsol[i] - 1;
            int area = heights[i] * width;

            max = Math.max(max, area);
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "(([{}]))()((()))}}";
        System.out.println(validParentheses(str));
        int[] arr = { 9, 6, 4, 1, -1, 3, 5, 8, 2, 4, 1, -1, 6, 8, 6, 5, 4, 9, 8, 30, 6 };
        int[] ans = nextGreaterOnRight(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();

        int[] ans2 = nextGreaterOnLeft(arr);
        for (int i = 0; i < ans2.length; i++) {
            System.out.print(ans2[i] + " ");
        }
        System.out.println();

        int[] ans4 = nextSmallerOnLeft(arr);
        for (int i = 0; i < ans4.length; i++) {
            System.out.print(ans4[i] + " ");
        }
        System.out.println();

        int[] ans3 = nextSmallerOnRight(arr);
        for (int i = 0; i < ans3.length; i++) {
            System.out.print(ans3[i] + " ");
        }
        System.out.println();
    }

    static class MyQueue {

        Stack<Integer> st; // push,peek,pop
        Stack<Integer> reverse;

        public MyQueue() {
            st = new Stack<>();
            reverse = new Stack<>();
        }

        public void push(int x) {
            reverseStack(st, reverse);
            st.push(x);
            reverseStack(reverse, st);
        }

        private void reverseStack(Stack<Integer> one, Stack<Integer> two) {
            while (one.size() != 0) {
                two.push(one.pop());
            }
        }

        public int pop() {
            return st.pop();
        }

        public int peek() {
            return st.peek();
        }

        public boolean empty() {
            return st.size() == 0;
        }
    }

}