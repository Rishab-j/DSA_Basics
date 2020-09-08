package GenericTrees;

public class Client {

//10 3 20 2 50 0 60 0 30 3 70 0 80 2 110 0 120 0 90 0 40 1 100 0
//10 3 20 1 40 0 30 0 50 1 60 0
    public static void main(String[] args) {
        GenericTree gt =new GenericTree();
        //gt.display();
      //  System.out.println(gt.size2());  
        //System.out.println(gt.max());
        //System.out.println(gt.height());
        //System.out.println(gt.containsElement(120));
       // gt.preOrder();
       // System.out.println();
       // gt.postOrder();
        //System.out.println();
       // gt.levelOrder();
       // gt.levelOrderLinewise();
       // gt.levelOrderLinewise2();
       System.out.println();
       // gt.levelOrderZigZag();
      // gt.mirror();
     // gt.removeLeaf();
       //gt.linearise();
       //gt.display();
       //System.out.println();
       //gt.lineariseEff();
       //gt.display();
     //  System.out.println(gt.isSymmetric());
     // gt.multisolver(120);
     gt.predsucc(10);
     // System.out.println(gt.Kthsmallest(3));
    }
}
