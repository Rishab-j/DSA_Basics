package BinaryTrees;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTree {

    private class Node {
        int data;
        Node left;
        Node right;
    }

    Node root = null;
    int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {

        return size == 0;
    }

    public BinaryTree() {
        this.root = construct(null, false, new Scanner(System.in));
    }

    // for pre order
    // public BinaryTree(int[] pre,int[] in){
    // this.root = constructPre(pre, 0, pre.length-1, in, 0, in.length-1);
    // }
    // for post order
    public BinaryTree(int[] post, int[] in) {
        this.root = constructPost(post, 0, post.length - 1, in, 0, in.length - 1);
    }

    private Node constructPre(int[] pre, int psi, int pli, int[] in, int isi, int ili) {
        if (psi > pli || isi > ili) {
            return null;
        }
        Node node = new Node();
        node.data = pre[psi];

        int idx = -1;
        for (idx = isi; idx <= ili; idx++) {
            if (pre[psi] == in[idx]) {
                break;
            }
        }

        int nle = idx - isi; // no. of left elements
        node.left = constructPre(pre, psi + 1, psi + nle, in, isi, idx - 1);
        node.right = constructPre(pre, psi + nle + 1, pli, in, idx + 1, ili);

        return node;
    }

    private Node constructPost(int[] post, int psi, int pli, int[] in, int isi, int ili) {
        if (psi > pli || isi > ili) {
            return null;
        }
        Node node = new Node();
        node.data = post[pli];

        int idx = -1;
        for (idx = isi; idx <= ili; idx++) {
            if (post[pli] == in[idx]) {
                break;
            }
        }

        int nre = ili - idx; // no. of right elements
        node.left = constructPost(post, psi, pli - nre - 1, in, isi, idx - 1);
        node.right = constructPost(post, pli - nre, pli - 1, in, idx + 1, ili);

        return node;
    }

    private Node construct(Node node, boolean ilc, Scanner scn) {

        if (node == null) {
            System.out.println("Enter data for root node: ");
        } else {
            if (ilc == true) {
                System.out.println("Enter data for left child of " + node.data);
            } else {
                System.out.println("Enter data for right child of " + node.data);
            }
        }

        int data = scn.nextInt();
        Node child = new Node();
        child.data = data;
        this.size++;
        System.out.println("Does " + child.data + " has a left child?");
        boolean hlc = scn.nextBoolean();
        if (hlc) {
            child.left = construct(child, true, scn); // childs left
        }

        System.out.println("Does " + child.data + " has a right child?");
        boolean hrc = scn.nextBoolean();
        if (hrc) {
            child.right = construct(child, false, scn);// childs right
        }
        return child;
    }

    public void display() {
        display(root);
    }

    private void display(Node node) {
        if (node == null) {
            return;
        }
        String str = "";
        str += node.left != null ? node.left.data : " . ";
        str += "<-" + node.data + "->";
        str += node.right != null ? node.right.data : " . ";
        System.out.println(str);
        display(node.left);
        display(node.right);

    }

    public int size2() {
        return size2(root);
    }


    private int size2(Node node) {
        if (node == null) {
            return 0;
        }
        int lsize = size2(node.left);
        int rsize = size2(node.right);

        return lsize + rsize + 1;
    }

    public int max() {
        return max(root);
    }

    private int max(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int maxl = max(node.left);
        int maxr = max(node.right);

        int max = Math.max(maxl, maxr);
        return Math.max(node.data, max);

    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1; // we are counting height in terms of edges if we were counting in terms of node
                       // then we would return 0
        }
        int l = height(node.left);
        int r = height(node.right);

        int height = Math.max(l, r);
        return height + 1;

    }

    public boolean find(int data) {
        return find(root, data);
    }

    private boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (node.data == data) {
            return true;
        }

        boolean left = find(node.left, data);
        if (left) {
            return true;
        }

        boolean right = find(node.right, data);
        if (right) {
            return true;
        }

        return false; // na khud mei mila na left mei mila na hi right mei mila tbb return false

    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");

    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        preOrder(node.left);
        System.out.print(node.data + " ");
        preOrder(node.right);

    }

    public void levelOrder() {
        levelOrder(root);
    }

    private void levelOrder(Node node) {

        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(node);
        while (queue.size() > 0) {
            Node child = queue.removeFirst();
            System.out.print(child.data + " ");
            if (child.left != null)
                queue.addLast(child.left);
            if (child.right != null)
                queue.addLast(child.right);
        }
    }

    private static class IPair {
        Node node;
        boolean print = false;
        boolean lcall = false;
        boolean rcall = false;

        public IPair(Node node) {
            this.node = node;
        }
    }

    public void preOrderIterative() {

        LinkedList<IPair> stack = new LinkedList<>(); // stack is chosen because we do the dry run of recursion in a stack
        stack.addFirst(new IPair(root));
        while (stack.size() > 0) {
            IPair ip = stack.getFirst();

            if (ip.node == null) {
                stack.removeFirst();
                continue;
            }
            if (ip.print == false) { // first it will print if not printed
                ip.print = true;
                System.out.print(ip.node.data + " ");
            } else if (ip.lcall == false) {// after printing the loop will run again at the same point since the
                                           // printing task was done now it will add the left child , and the loop will
                                           // run again since the stack woudn't be empty now at the top of stack a new
                                           // node would be present so it will check its printing condition and so on
                ip.lcall = true;
                stack.addFirst(new IPair(ip.node.left));
            } else if (ip.rcall == false) {// after the left call the loop will run again at same point
                ip.rcall = true;
                stack.addFirst(new IPair(ip.node.right));
            } else { // after every task the node would be removed from the stack
                stack.removeFirst();

            }

        }

    }

    public void postOrderIterative() {

        LinkedList<IPair> stack = new LinkedList<>();
        stack.addFirst(new IPair(root));
        while (stack.size() > 0) {
            IPair ip = stack.getFirst();

            if (ip.node == null) {
                stack.removeFirst();
                continue;
            }

            if (ip.lcall == false) {
                ip.lcall = true;
                stack.addFirst(new IPair(ip.node.left));
            } else if (ip.rcall == false) {
                ip.rcall = true;
                stack.addFirst(new IPair(ip.node.right));
            } else if (ip.print == false) {
                ip.print = true;
                System.out.print(ip.node.data + " ");
            } else { // after every task the node would be removed from the stack
                stack.removeFirst();

            }

        }

    }

    public void inOrderIterative() {

        LinkedList<IPair> stack = new LinkedList<>();
        stack.addFirst(new IPair(root));
        while (stack.size() > 0) {
            IPair ip = stack.getFirst();

            if (ip.node == null) {
                stack.removeFirst();
                continue;
            }

            if (ip.lcall == false) {
                ip.lcall = true;
                stack.addFirst(new IPair(ip.node.left));
            } else if (ip.print == false) {
                ip.print = true;
                System.out.print(ip.node.data + " ");
            } else if (ip.rcall == false) {
                ip.rcall = true;
                stack.addFirst(new IPair(ip.node.right));
            } else { // after every task the node would be removed from the stack
                stack.removeFirst();

            }

        }

    }

    public void singleChild() {
        singleChild(root, root.left);
        singleChild(root, root.right);
    }

    private void singleChild(Node parent, Node child) {
        if (child == null) {
            return;
        }

        if (parent.left == child && parent.right == null || (parent.right == child && parent.left == null)) {
            System.out.print(child.data + " ");
        }

        singleChild(child, child.left);
        singleChild(child, child.right);
    }

    public void removeLeaf() {
        removeLeaf(root, root.left);
        removeLeaf(root, root.right);
    }

    private void removeLeaf(Node parent, Node child) {
        if (child == null) {
            return;
        }

        if (child.left == null && child.right == null) {// agr child ke left right null means it is the leaf
            if (parent.left == child) { // to remove we have to find which node of parent was the child
                parent.left = null;
            }
            if (parent.right == child) {
                parent.right = null;
            }
            return;
        }

        removeLeaf(child, child.left);
        removeLeaf(child, child.right);

    }

    public void nodeToRootPath(int data) {
        ArrayList<Integer> path = nodeToRootPath(root, data);
        System.out.println(path);
    }

    private ArrayList<Integer> nodeToRootPath(Node node, int data) {

        if (node.data == data) {
            ArrayList<Integer> Path = new ArrayList<>();

            Path.add(node.data);
            return Path;
        }

        if (node.left != null) {

            ArrayList<Integer> left = nodeToRootPath(node.left, data);

            if (left != null) {
                left.add(node.data);
                return left;
            }
            // return left; pehle maine yaha pe return left lga rkha tha
            // yaha return lgane se mera function bina hi right ki call check kre pichle
            // level pe return ho rha tha
        }

        if (node.right != null) {

            ArrayList<Integer> right = nodeToRootPath(node.right, data);

            if (right != null) {
                right.add(node.data);
                return right;
            }

        }
        return null;

    }

    public void rootToLeafPath(int target) {
        rootToLeafPath(root, target, "", 0);
    }

    private void rootToLeafPath(Node node, int target, String psf, int ssf) {

        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            if (ssf + node.data < target) {
                System.out.println(psf + " " + node.data);
            }
        }

        rootToLeafPath(node.left, target, psf + " " + node.data, ssf + node.data);
        rootToLeafPath(node.right, target, psf + " " + node.data, ssf + node.data);
    }

    public int diameter(){
        return diameter(root);
    }

    private int diameter(Node node){
        if(node==null){
            return 0;
        }
        int ld=diameter(node.left);
        int rd=diameter(node.right);

        // below region is post-order region of diameter call whose complexity is O(n)
        // below function are also recursive of O(n) complexity 
        // since these functions are called uss node pe ek euler dobara chl jaaega
        // mtlb ki ek node ke lie uska diameter ke lie and height ke lie 2 baar O(n) chlega 
        // so this diameter function would have O(n^2) complexity

        int lh = height(node.left);
        int rh = height(node.right);

        int factor = lh+rh+2;

        return Math.max(factor,Math.max(ld,rd));

    }

    class DiaPair{
        int height;
        int diameter;
    }

    public int diameterEff(){
        DiaPair dia = diameterEff(root);
        return dia.diameter;
    }

    private DiaPair diameterEff(Node node){
        if(node==null){
            DiaPair base = new DiaPair();
            base.height=-1;
            base.diameter=0;
            return base;
        }
        DiaPair left = diameterEff(node.left); // left subtree ka kaam ho chuka
        DiaPair right = diameterEff(node.right);// right subtree ka kaam ho chuka
        // ab apne level ke tree ka kaam krte h
        DiaPair myDp= new DiaPair();
        myDp.height=Math.max(left.height,right.height)+1;
        myDp.diameter=Math.max(left.height+right.height+2,Math.max(left.diameter,right.diameter));

        return myDp;
    }


    class BalPair{
        boolean isBal;
        int height;
    }

    public void isBalanced(){
        BalPair bp = isBalanced(root);
        System.out.println(bp.isBal);
    }

    private BalPair isBalanced(Node node){
        
        if(node==null){
            BalPair base = new BalPair();
            base.height=-1;
            base.isBal = true;
            return base;
        }

        BalPair left = isBalanced(node.left);
        BalPair right = isBalanced(node.right);

        BalPair myBal = new BalPair();
        myBal.height = Math.max(left.height, right.height)+1;
        myBal.isBal = left.isBal && right.isBal && Math.abs(left.height-right.height)<=1;
        return myBal;

    }

    class BST{
        boolean isBST;
        int min;
        int max;

        Node lbstn;
        int lbsts;
    }
    
    public void isBST(){
        BST ans = isBST(root);
        System.out.println(ans.isBST);
        System.out.println(ans.lbstn.data+" -> "+ans.lbsts);
    }

    private BST isBST(Node node){

        if(node == null){
            BST base = new BST();
            base.isBST=true;
            base.max=Integer.MIN_VALUE;
            base.min=Integer.MAX_VALUE;
            return base;
        }

        BST leftTree = isBST(node.left);// kya left BST h
        BST rightTree = isBST(node.right);// kya right BST h

        //chlo ab apne level ki baat krte h
        // upr waale mere child h

        BST mybst = new BST();
        mybst.isBST = leftTree.isBST && rightTree.isBST && node.data>=leftTree.max && node.data<=rightTree.min;
        mybst.max = Math.max(node.data,Math.max(leftTree.max,rightTree.max));
        mybst.min = Math.min(node.data,Math.min(leftTree.min,rightTree.min));

        if(mybst.isBST){
            mybst.lbstn=node;
            mybst.lbsts=leftTree.lbsts+rightTree.lbsts+1;
        }
        else{
            if(leftTree.lbsts>rightTree.lbsts){ // agr left mei jo bst h uska size bda h right wale 
                mybst.lbstn=leftTree.lbstn;
                //mybst.lbstn=node.left;  // dono line hi shi h shyd(upr wali aur ye wali)
                mybst.lbsts=leftTree.lbsts; // largest size will become the size of bst on left side
            }else{
                mybst.lbstn=rightTree.lbstn;
               // mybst.lbstn=node.right;
                mybst.lbsts=rightTree.lbsts;
            }
        }

        return mybst;
    }



}
