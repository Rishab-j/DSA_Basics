package BinaryTrees;

import java.util.LinkedList;

public class Client {

    // 50 true 25 true 12 false true 20 false false true 37 true 30 false false false true 75 true 67 false false true 87 false false
    // 50 true 25 true 12 false true 20 false false true 37 true 30 false false false true 75 true 67 false false true 87 true 50 true 45 false false false false
    public static class Pair {
        int n;
        String bin = "";

        Pair(int n, String bin) {
            this.n = n;
            this.bin = bin;
        }

    }

    public static void printBinaries(int n) {
        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(1, "1"));

        while (queue.size() > 0) {
            Pair p = queue.removeFirst();
            if (p.n > n) {
                break;
            }
            System.out.println(p.n + "->" + p.bin + " ");
            queue.addLast(new Pair(2 * p.n, p.bin + "0"));
            queue.addLast(new Pair((2 * p.n) + 1, p.bin + "1"));
        }
    }

    public static void main(String[] args) {
        //BinaryTree bt = new BinaryTree();
        //bt.display();
        //System.out.println(bt.size2());
        //System.out.println(bt.max());

        //System.out.println(bt.height());
        //System.out.println(bt.find(98));
        //bt.postOrder();
        //bt.preOrder();
        //bt.inOrder();
        //bt.levelOrder();
        // printBinaries(15);
        //bt.preOrderIterative();
        //bt.removeLeaf();
        //bt.display();
        //bt.nodeToRootPath(37);
        //bt.rootToLeafPath(150);
        //int[] pre ={50,25,12,20,30,37,75,62,87};
        int[] in = {12,25,37,49,50,62,75,87};
        int[] post = {12,49,37,25,62,87,75,50};
        BinaryTree bt = new BinaryTree(post,in);
        //bt.display();
        System.out.println(bt.diameterEff());
        bt.isBalanced();
        bt.isBST();

    }

}