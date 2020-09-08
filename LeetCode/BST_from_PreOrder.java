package LeetCode;

import java.util.Stack;

public class BST_from_PreOrder {

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

    // -------------------------------------METHOD 1
    // O(n^2)------------------------------------------

    public TreeNode bstFromPreorder(int[] preorder) {
        return constructTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode constructTree(int[] preorder, int l, int r) {
        if (l > r) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[l]);

        if (l == r) {
            return root;
        }

        int idx = l + 1;
        while (idx <= r && preorder[idx] < preorder[l]) {
            idx++;
        }
        root.left = constructTree(preorder, l + 1, idx - 1);
        root.right = constructTree(preorder, idx, r);
        return root;
    }

    // ----------------------------------- METHOD_2 O(n)
    // ------------------------------------------

    TreeNode getNewNode(int val) {
        TreeNode newNode = new TreeNode();
        newNode.val = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

   
    // int pos is to keep track of position in our preoder array
    // it has no such significance even if we are returning it 
    // the tracking can be done by using a static variable also

    int construct_BST(int[] preorder, int n, int pos, TreeNode curr, int left, int right) {
        
        // if the whole preorder array is traversed  or
        // the element does not fall in the range 
        if (pos == n || preorder[pos] < left || preorder[pos] > right) {
            return pos;
        }

        if (preorder[pos] < curr.val) {
            curr.left = getNewNode(preorder[pos]);
            pos += 1;
            pos = construct_BST(preorder, n, pos, curr.left, left, curr.val - 1);
        }

        // we will check again
        // if the whole preorder array is traversed  or
        // the element does not fall in the range 
        if (pos == n || preorder[pos] < left || preorder[pos] > right) {
            return pos;
        }

        curr.right = getNewNode(preorder[pos]);
        pos += 1;
        pos = construct_BST(preorder, n, pos, curr.right, curr.val + 1, right);

        return pos;

    }

    public TreeNode bstFromPreorder2(int[] preorder) {
        int n = preorder.length;
        if (n == 0) {
            return null;
        }

        TreeNode root = getNewNode(preorder[0]);

        if (n == 1) {
            return root;
        }

        // construction of BST
        construct_BST(preorder, n, 1, root, Integer.MIN_VALUE, Integer.MAX_VALUE);

        return root;
    }


    
    // THERE IS A MISTAKE IN THE CODE BELOW

    class Index {
        int index = 0;
    }

    Index index = new Index();

    public TreeNode bstFromPreorder3(int[] preorder) {
        return constructTreeUtil(preorder, index, preorder[0], Integer.MIN_VALUE, Integer.MAX_VALUE, preorder.length);
    }

    TreeNode constructTreeUtil(int pre[], Index preIndex, int key, int min, int max, int size) {

        // Base case
        if (preIndex.index > size) {
            return null;
        }

        TreeNode root = null;

        // If current element of pre[] is in range, then
        // only it is part of current subtree
        if (key > min && key < max) {

            // Allocate memory for root of this
            // subtree and increment *preIndex
            root = new TreeNode(key);
            preIndex.index = preIndex.index + 1;

            if (preIndex.index < size) {

                // Construct the subtree under root
                // All nodes which are in range {min .. key}
                // will go in left subtree, and first such
                // node will be root of left subtree.
                root.left = constructTreeUtil(pre, preIndex, pre[preIndex.index], min, key, size);

                // All nodes which are in range {key..max}
                // will go in right subtree, and first such
                // node will be root of right subtree.
                root.right = constructTreeUtil(pre, preIndex, pre[preIndex.index], key, max, size);
            }
        }

        return root;
    }

    /************ LEAST LINES OF CODE *****************/

    int i = 0;

    public TreeNode bstFromPreorder4(int[] A) {
        return bstFromPreorder(A, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder(int[] A, int bound) {
        if (i == A.length || A[i] > bound)
            return null;
        TreeNode root = new TreeNode(A[i++]);
        root.left = bstFromPreorder(A, root.val);
        root.right = bstFromPreorder(A, bound);
        return root;
    }

}

// ----------------------------------- METHOD_2 O(n)
// ------------------------------------------
// ----------------------------------- USING STACK
// ------------------------------------------

class Node {

    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class BinaryTree {

    // The main function that constructs BST from pre[]
    Node constructTree(int pre[], int size) {

        // The first element of pre[] is always root
        Node root = new Node(pre[0]);

        Stack<Node> s = new Stack<Node>();

        // Push root
        s.push(root);

        // Iterate through rest of the size-1 items of given preorder array
        for (int i = 1; i < size; ++i) {
            Node temp = null;

            /*
             * Keep on popping while the next value is greater than stack's top value.
             */
            while (!s.isEmpty() && pre[i] > s.peek().data) {
                temp = s.pop();
            }

            // Make this greater value as the right child
            // and push it to the stack
            if (temp != null) {
                temp.right = new Node(pre[i]);
                s.push(temp.right);
            }

            // If the next value is less than the stack's top
            // value, make this value as the left child of the
            // stack's top node. Push the new node to stack
            else {
                temp = s.peek();
                temp.left = new Node(pre[i]);
                s.push(temp.left);
            }
        }

        return root;
    }
}
