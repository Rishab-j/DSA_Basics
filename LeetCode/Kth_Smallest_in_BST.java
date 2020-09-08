package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Kth_Smallest_in_BST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public int KthSmallest(TreeNode root,int k){
        // nums[0] = counter
        // nums[0] = value at that counter
        int[] nums = new int[2];  // helper class jaisa h ye

        inorder(root,k,nums);

        return nums[1];

    }

    public void inorder(TreeNode root,int k,int[] nums){

        if(root==null){
            return;
        }

        inorder(root.left, k, nums);
        // after reaching the left most node we have found our smallest element so increase the counter
        ++nums[0];  
        if(nums[0]==k){
            nums[1] = root.val;
            return;
        }
        inorder(root.right, k, nums);


    }

    //-------------------------------------------------
    //Method-2

    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
      }
    
      public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
      }


    // ------------------------------------------
    // Method 3 
    
    public int kthSmallest_iterative(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    
        while (true) {
          while (root != null) {
            stack.add(root);
            root = root.left;
          }
          root = stack.removeLast();
          if (--k == 0) return root.val;
          root = root.right;
        }
      }


    public static void main(String[] args) {
        
       // int[] arr = {5,3,6,2,4, null, null, 1 };

    }
}