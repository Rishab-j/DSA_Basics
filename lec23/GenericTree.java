package lec23;


import java.util.ArrayList;

import java.util.LinkedList;
import java.util.Queue;


/**
 * GenericTree
 */
public class GenericTree {

    static node root= null;                                         // @@@@@@@  DOUBT @@@@@@@
    static class node{
        int data;
        ArrayList<node> child;

        node(int d){
            this.data=d;
            this.child=new ArrayList<>();
        }
    }
public static void construct(int[] data){
    ArrayList<node> stack=new ArrayList<>();

for(int i=0;i<data.length;i++){
    if(data[i]==-1){
        stack.remove(stack.size()-1);
    }
    else {
        if(root==null){
            node n= new node(data[i]);
            root=n;
            stack.add(n);
        }
        else{
            node cp=stack.get(stack.size()-1); //  cp=current Parent
            node n=new node(data[i]);
            cp.child.add(n);
            stack.add(n);
        }
    }
}

}


public static void display(node croot){
    if(croot==null){
        return;
    }
    System.out.print(croot.data + "->");

    for(int i=0;i<croot.child.size();i++){
        System.out.print(croot.child.get(i).data+" ");
    }
    System.out.println(".");
    for(int i=0;i<croot.child.size();i++){
        display(croot.child.get(i));
    }
}

public static int noOfNodes(node croot){    //croot=current root
    if(croot==null){       //if the tree is null or you can say we forget to construct the tree
        return -1;
    }
int mySize=1;
for(int i=0;i<croot.child.size();i++){
    mySize+=noOfNodes(croot.child.get(i));
}

return mySize;

}

//int max=Integer.MIN_VALUE;

public static int max(node croot){
    //int myMax=croot.child.get(0);
    if(croot==null){       //if the tree is null or you can say we forget to construct the tree
        return -1;
    }
    int myMax=croot.data;

    //int max=Integer.MIN_VALUE;

for(int i=0;i<croot.child.size();i++){
   int recMax=max(croot.child.get(i));
   if(myMax<recMax){
       myMax=recMax;
   }
}
return myMax;
}

public static ArrayList<Integer> nodeToRootPath(node croot,int data){
if(croot==null){
    return null;
}
    if(croot.data==data){
    ArrayList<Integer> myAns= new ArrayList<>();
    myAns.add(data);
    return myAns;
}
//ArrayList<Integer> myAns=new ArrayList<>();

for(int i=0;i<croot.child.size();i++){
    ArrayList<Integer> recAns=nodeToRootPath(croot.child.get(i), data);
    if(recAns!= null){
        //recAns.add(0,croot.data);          THIS IS ALSO CORRECT ,THIS IS USED TO ADD DATA AT A PARTICULAR POSITION OF ARRAYLIST
        recAns.add(croot.data);
        return recAns;
    }
  
}
return null;
}

public static int lowestCommonAncestor (node root,int d1,int d2){
    ArrayList<Integer> n2rp1= nodeToRootPath(root, d1);
    ArrayList<Integer> n2rp2= nodeToRootPath(root, d2);

int i=n2rp1.size()-1;
int j=n2rp2.size()-1;

while(i>=0 && j>=0){
    if(n2rp1.get(i) != n2rp2.get(j)){
        break;
    }
    i--;
    j--;
}
return n2rp1.get(i+1);
}

public static void levelOrder(node root) {
    Queue<node> qu= new LinkedList<>();
    qu.add(root);
    while(qu.size()!=0){
        //get
        node cp = qu.peek();
        //remove
        qu.remove();
        //print
        System.out.println(cp.data+" ");
        //add child
        for(int i=0;i<cp.child.size();i++){
            qu.add(cp.child.get(i));
        }

    }
}


public static void wavePrint(node root){
Queue<node> qu= new LinkedList<>();
ArrayList<node> stack= new ArrayList<>();
boolean flag=true;
qu.add(root);
while(qu.size()!=0){
    node cp = qu.remove();
    System.out.print(cp.data + " ");
    if(flag){
        for(int i=0;i<cp.child.size();i++){
            stack.add(cp.child.get(i));
        }
    }
    else{
        for(int i=cp.child.size()-1;i>=0;i--){
            stack.add(cp.child.get(i));
        }
    } 
    if(qu.size()==0){
        while(stack.size()>0){
            qu.add(stack.remove(stack.size()-1));
        }
        flag= !flag;
    }   
    }
}


public static void levelOrderLinewise(node root){
Queue<node> main=new LinkedList<>();
Queue<node> helper=new LinkedList<>();
 main.add(root);

 while(main.size()>0){
     node cp = main.remove();
     System.out.print(cp.data + "");
 }

}



public static void main(String[] args) {

    // IMPLEMENTATION OF QUEUE

   // Queue<Integer> qu= new LinkedList<>();
 //   qu.add(10);
   // qu.add(20);
  //  qu.add(30);
  //  while(qu.size()>0){
   //     System.out.println(qu.peek());
   //     qu.remove();
   // }
  //  System.out.println();


    int[] data={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100};
    construct(data);
    System.out.println(root);
    //display(root);
   // System.out.println(noOfNodes(root));
   // System.out.println(max(root));
   // System.out.println(nodeToRootPath(root, 90));
   // System.out.println(lowestCommonAncestor(root, 80, 110));
    levelOrder(root);
    wavePrint(root);
   
}
}