package GenericTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class GenericTree {

    private class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    private Node root;
    private int size = 0;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public GenericTree() {
        this.root = construct(new Scanner(System.in), null, 0);
    }

    // Expectation = to create ith child of node

    // Steps:
    // 1. agr parent null h so iska mtlb root ki baat ho rhi h to ab nya
    // node(here child) bnao jo ki root
    // 2. ab ye pta kro ki root ke kitne child hone chaie aur iss child ko parent
    // parameter mei pass krdo
    // 3. jitne child user ne enter kia utne ka loop lga do jisme nye grandchild
    // bnao aur construct ko cal krdo jisme parameters -> parent = child ; idx of
    // child: loop ka i
    // 4. ab jo grandchild aaega usko child ke arraylist mei add krdo
    // 5. child ko return krdo

    private Node construct(Scanner scn, Node parent, int childidx) {
        if (parent == null) {
            System.out.println("Enter data for root: ");
        } else {
            System.out.println("Enter data for " + childidx + " th child of " + parent.data);
        }
        int cdata = scn.nextInt();
        Node child = new Node();
        size++;
        child.data = cdata;
        System.out.println("Enter no. of children of " + child.data + " node");

        int numgc = scn.nextInt();

        for (int j = 0; j < numgc; j++) {
            Node gc = construct(scn, child, j); // faith
            child.children.add(gc);
        }

        return child;
    }

    public void display() {
        display(root);
    }

    // Steps:
    // 1.String str mei apna data add kro
    // 2.ek ek krke apne children ka data add kro aur print krdo
    // 3.ab ek ek krke usi node ke child pe display ka call lga do
    private void display(Node node) {
        String str = node.data + "-> ";

        for (Node child : node.children) {
            str = str + child.data + " , ";
        }
        str = str + ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public int size2() {
        return size2(root);
    }

    private int size2(Node node) {
        int size = 0;
        for (Node child : node.children) {

            size = size + size2(child);

        }
        size = size + 1;

        return size;
    }

    public int max() {
        return max(root);
    }

    private int max(Node node) {
        int mymax = node.data;
        for (Node child : node.children) {
            int max = max(child);
            mymax = Math.max(max, mymax);
        }
        return mymax;
    }

    public int height() {
        return this.height(root);
    }

    private int height(Node node) {
        int height = -1; // agr 0 hoga to nodes ke according height count hoke aaegi, abhi edges ke
                         // according height count ho rhi h
        for (Node child : node.children) {
            int myheight = height(child); // child se uski height mangao
            height = Math.max(myheight, height);// agr child ki height(myheight) bdi h to khudki(height) ko update krdo
        }
        height = height + 1; // sbse pehle 0 store hoga quki jis node ka koi child ni h uski height -1 h
        return height;// sbse pehle 0 return hoga
    }

    public boolean containsElement(int data) {
        return containsElement(root, data);
    }

    private boolean containsElement(Node node, int data) {

        if (node.data == data) { // agr node ka data same h to whi se true return krdo
            return true;
        }

        for (Node child : node.children) {
            boolean foundElement = containsElement(child, data);
            if (foundElement) {
                return true;
            }
        }
        return false;
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        System.out.print(node.data + " ");
        for (Node child : node.children) {
            preOrder(child);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {

        for (Node child : node.children) {
            postOrder(child);
        }
        System.out.print(node.data + " ");

    }

    public void levelOrder() {
        LinkedList<Node> queue = new LinkedList<>();

        queue.addLast(root);

        while (queue.isEmpty() == false) { // jbb tkk queue khali ni hojaati tbb tk chlega , queue khlai hote hi ni
                                           // chlega
            // 1. Remove or get
            Node node = queue.removeFirst();
            // 2. Print
            System.out.print(node.data + " ");
            // 3. Add Child or enqueue
            for (Node child : node.children) {
                queue.addLast(child);
            }
        }

    }

    private class Pair {
        Node node;
        int level;
    }

    public void levelOrderLinewise() {
        LinkedList<Pair> queue = new LinkedList<>();
        Pair rootPair = new Pair();
        rootPair.node = root;
        rootPair.level = 0;
        queue.addLast(rootPair);
        Pair prev = null;
        while (queue.size() > 0) {
            Pair curr = new Pair();
            curr = queue.removeFirst();
            if (prev != null && prev.level != curr.level) { // agr hn to ye kro
                System.out.println();
            }
            // ye to hona hi h
            System.out.print(curr.node.data + " ");

            for (Node child : curr.node.children) {
                Pair cpair = new Pair();
                cpair.node = child;
                cpair.level = curr.level + 1;
                queue.addLast(cpair);
            }

            prev = curr;
        }
    }

    public void levelOrderLinewise2() {
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);
        queue.addLast(null);
        while (queue.size() > 0) {

            Node node = queue.removeFirst();
            if (node == null) {
                System.out.println();
                if (queue.size() > 0) // queue mei agr elements honge tbhi null dobara add hoga
                    queue.add(null);
            } else {
                System.out.print(node.data + " ");
                for (Node child : node.children) {
                    queue.addLast(child);
                }
            }
        }
    }

    public void levelOrderZigZag() {
        LinkedList<Node> clq = new LinkedList<>(); // make current level as queue
        LinkedList<Node> nls = new LinkedList<>(); // make next level as stack
        boolean toggle = true; // if true means add child from left to right or else otherwise
        clq.addLast(root);

        while (clq.size() > 0) {
            Node node = clq.removeFirst();
            System.out.print(node.data + " ");

            if (toggle == true) {
                for (int i = 0; i < node.children.size(); i++) { // last child sbse pehle pda hoga stack mei so, jbb
                                                                 // stack se remove krke queue mei dalenge tbb queue mei
                                                                 // sbse pehle last child aaaega aur zig-zag print hoga
                    Node child = node.children.get(i);
                    nls.addFirst(child);
                }
            } else {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    Node child = node.children.get(i);
                    nls.addFirst(child);
                }
            }

            if (clq.size() == 0) {// size 0 tbhi hi hoga jbb nye level ki baari aaegi
                clq = nls; // nls ka data clq mei daaldo
                nls = new LinkedList<>(); // nls ko nya banao
                System.out.println();
                toggle = !toggle;// nye level ke lie
            }
        }
    }

    public void mirror() {
        mirror(root);
    }

    private void mirror(Node node) {
        for (Node child : node.children) {
            mirror(child);
        }
        Collections.reverse(node.children);
    }

    public void removeLeaf() {
        removeLeaf(root);
    }

    private void removeLeaf(Node node) {

        // loop ulta islie chalaya h quki :
        // agr seedha chalate to arraylist mei sbse pehle first wala element i.e. index
        // 0 wala element remove hota
        // uska remove hone ki wjh se sbhi ka index chnage hojata
        // sbb ke sbb ka index 1 pehle ho jata jiksi wjh i=0 ke baad jbb i=1 ki call
        // lagti
        // tbb nyi list ka index 1 wala remove hota jo ki actually index 2 ka element h

        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);
            if (child.children.size() == 0) { // agr child node ka children AL khali h tbb uske parent i.e. node se uss
                                              // child k remove krdo
                node.children.remove(child);
            } else {
                removeLeaf(child);
            }
        }

    }

    public void linearise() {
        linearise(root);
    }

    private void linearise(Node node) {
        for (Node child : node.children) { // apne sbhi child ko bol dia linearise ho jaao
            linearise(child);
        }
        // jbb saare linearise ho jaae tbb poore ko krte h
        while (node.children.size() > 1) {
            Node secondLast = node.children.get(node.children.size() - 2);
            Node last = node.children.remove(node.children.size() - 1);

            Node secondLastTail = getTail(secondLast);
            secondLastTail.children.add(last);
        }
    }

    private Node getTail(Node node) {
        Node tail = node;
        while (tail.children.size() == 1) { // children array ka size 1 islie hoga quki linearise ho chuka h
            tail = tail.children.get(0);
        }
        return tail;
    }

    public void lineariseEff() {
        lineariseEff(root);
    }

   // linearise krne ke lie most importantly tail chaie

   //Steps:
   //1. function mei aate hi uss level ke node ki original last tail mangwalo
   //2. fir uske children ko linearise hone ko boldo
   //     2.1 secondlast and last ko get kro
   //     2.2 secondlast ki tail mangwao -> by calling the lineariseEff function again 
   //           2.2.1 ab jo function mei node aaega wo second last hoga so mtlb wo iss level ka root node h to uska similar 
   //                 way se original last node mangwao and return krdo jo return hoga wo uss second last ka tail hoga
   //     2.3 secondlast ke tail ke children array mei ,last ko uske respective parent se remove krke ,add krdo

    private Node lineariseEff(Node node) { // this is effective because it returns the tail of the called node
                                           // instead of using another function henche reducing complexity from "n^2" to
                                           // "n"

        if (node.children.size() == 0) {
            return node;
        }
//1.
        Node oLastTail = lineariseEff(node.children.get(node.children.size() - 1)); // this is the original tail of the
                                                                                    // node of that level
//2.                                                                               // i.e. 100 for root node(10)
        while (node.children.size() > 1) {
       //2.1
            Node secondLast = node.children.get(node.children.size() - 2);
            Node last = node.children.get(node.children.size() - 1);
       //2.2
            Node secondLastTail = lineariseEff(secondLast); // recursive call,it is telling the secondlast child to get
                                                            // linearise
       //2.3                                                // yahi pe wo oLastTail wala node aata h jiske children mei last node add hota h
            node.children.remove(last);
            secondLastTail.children.add(last); // adds the last to tail of second last
        }

        return oLastTail;
    }

    public boolean isIsomorphic(GenericTree other) {
        return isIsomorphic(this.root, other.root);
    }

    private boolean isIsomorphic(Node t, Node o) {

        if (t.children.size() == o.children.size()) {
            for (int i = 0; i < t.children.size(); i++) {
                Node tchild = t.children.get(i);
                Node ochild = o.children.get(i);
                boolean isIso = isIsomorphic(tchild, ochild); // agr true aaya to loop apne hi chlta jaaega
                                                              // false aate hi hrr baar peeche false return krta jaaega
                if (isIso == false) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean isMirror(GenericTree other) {
        return isMirror(this.root, other.root);
    }

    private boolean isMirror(Node t, Node o) {

        if (t.children.size() == o.children.size()) {

            int l = 0;
            int r = o.children.size() - 1;
            while (l < t.children.size()) {
                Node tlchild = t.children.get(l); // t's left child
                Node orchild = o.children.get(r); // o's right child

                boolean isMirror = isMirror(tlchild, orchild);
                if (isMirror == false) {
                    return false;
                }
                l++;
                r--;
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean isSymmetric() { // for a tree to be symmetric the tree must be a mirror image of itself
        return isMirror(this.root, this.root);
    }

    private class HeapMover { 
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int size = 0;
        int height = 0;
        boolean find = false;

        Node curr = null;
        Node prev = null;

        Node pred = null;
        Node succ = null;

        Node justLarger = null;
    }

    public void multisolver(int data) {
        HeapMover hm = new HeapMover();
        multisolver(root, hm, data, 0);
        System.out.println(hm.min);
        System.out.println(hm.max);
        System.out.println(hm.find);
        System.out.println(hm.size);
        System.out.println(hm.height);
    }

    private void multisolver(Node node, HeapMover mover, int data, int depth) {
        mover.min = Math.min(node.data, mover.min);
        mover.max = Math.max(node.data, mover.max);
        mover.size = mover.size + 1;
        mover.height = Math.max(mover.height, depth);
        mover.find = mover.find || node.data == data;

        for (Node child : node.children) {
            multisolver(child, mover, data, depth + 1);
        }
    }

    public void predsucc(int data) {
        HeapMover mover = new HeapMover();
        predsucc(root, data, mover);

        System.out.println("Pred = " + (mover.pred == null ? "null" : mover.pred.data));
        System.out.println("Succ = " + (mover.succ == null ? "null" : mover.succ.data));
    }

    private void predsucc(Node node, int data, HeapMover mover) {
        mover.curr = node;
        if (mover.curr.data == data) {
            mover.pred = mover.prev;  // pred null hoga to mtlb apna data root h
            
        }
        if (mover.prev != null && mover.prev.data == data) {
            mover.succ = mover.curr;   //succ null hoga to mtlb last node h apna data
            
        }
        mover.prev = mover.curr;

        for (Node child : node.children) {
            predsucc(child, data, mover);
        }
    }

    public void justLarger(int data) {
        HeapMover mover = new HeapMover();
        justLarger(root, data, mover);
    }

    private void justLarger(Node node, int data, HeapMover mover) {
        if (node.data > data) {
            if (mover.justLarger == null || node.data < mover.justLarger.data) {
                mover.justLarger = node;  // milte hi return islie ni lgaya quki hme ye ni ki aage milega ya ni
            }
        }
        for (Node child : node.children) {
            justLarger(child, data, mover);
        }
    }

    public int Kthsmallest(int k) {
        HeapMover mover = new HeapMover();
        int data = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {

            justLarger(root, data, mover);
            data = mover.justLarger.data;
            mover.justLarger = null;
        }
        return data;
    }

}