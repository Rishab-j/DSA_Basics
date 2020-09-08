package MIT;

public class NextGreaterElementinBST {

    class Node {

        int data;
        Node left, right, parent;

        Node(int d) {
            data = d;
            left = right = parent = null;
        }
    }

    static Node head;

    Node insert(Node root, int data) {

        if (root == null) {
            return (new Node(data));
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
            root.left.parent = root;
        } else {
            root.right = insert(root.right, data);
            root.right.parent = root;
        }

        return root;
    }

    Node minValue(Node node) {
        Node current = node;

        while (node.left != null) {
            current = current.left;
        }
        return current;
    }


    
    // The Algorithm is divided into two cases on the basis of right subtree of the input node being empty or not.

    // Input: node, root // node is the node whose Inorder successor is needed.
    // output: succ // succ is Inorder successor of node.

    // 1) If right subtree of node is not NULL, then succ lies in right subtree. Do following.
    // Go to right subtree and return the node with minimum key value in right subtree.
    // 2) If right sbtree of node is NULL, then succ is one of the ancestors. Do following.
    // Travel up using the parent pointer until you see a node which is left child of it’s parent. The parent of such a node is the succ.

    Node nextGreater(Node root, Node n) {
        // step 1 of the above algorithm
        if (n.right != null) {
            return minValue(n.right);
        }

        // step 2 of the above algorithm
        Node p = n.parent;
        while (p != null && n == p.right) {
            n = p;
            p = p.parent;
        }
        return p;
    }

    public static void main(String[] args) { 
        NextGreaterElementinBST tree = new NextGreaterElementinBST(); 
        Node root = null, temp = null, suc = null, min = null; 
        root = tree.insert(root, 20); 
        root = tree.insert(root, 8); 
        root = tree.insert(root, 22); 
        root = tree.insert(root, 4); 
        root = tree.insert(root, 12); 
        root = tree.insert(root, 10); 
        root = tree.insert(root, 14); 
        temp = root.left.right.right; 
        suc = tree.nextGreater(root, temp); 
        if (suc != null) { 
            System.out.println("Inorder successor of " + temp.data +  
                                                      " is " + suc.data); 
        } else { 
            System.out.println("Inorder successor does not exist"); 
        } 
    } 

}