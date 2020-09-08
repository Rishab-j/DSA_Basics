package MIT;

public class BST {

    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    BST() {  
        root = null;  
    } 

    public void insert(int key) {
        root = insertRec(root, key);
    }

    public Node insertRec(Node root, int key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else {
            root.right = insertRec(root.right, key);
        }

        /* return the (unchanged) node pointer */
        return root;
    }

    public Node search(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.key == key)
            return root;

        // val is greater than root's key
        if (root.key > key)
            return search(root.left, key);

        // val is less than root's key
        return search(root.right, key);
    }

    public void inorder()  { 
        inorderRec(root); 
     } 
   
     // A utility function to do inorder traversal of BST 
     public void inorderRec(Node root) { 
         if (root != null) { 
             inorderRec(root.left); 
             System.out.println(root.key); 
             inorderRec(root.right); 
         } 
     } 

     /** ---------------------NEXT GREATER ELEMENT IN ANOTHER FILE -------------------------*/

     /**---------------------------- DELETE A NODE NOT DONE -------------------------------- */

    public static void main(String[] args) {

        BST tree = new BST(); 

        tree.insert(50); 
        tree.insert(30); 
        tree.insert(20); 
        tree.insert(40); 
        tree.insert(70); 
        tree.insert(60); 
        tree.insert(80); 


        tree.inorder();
    }

}