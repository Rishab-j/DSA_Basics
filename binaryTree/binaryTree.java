package binaryTree;

import java.util.*;


class binaryTree{
    static node root = null;
    
    static class node{
        int data;
        node left;
        node right;

        node(int d){
            this.data = d;
        }
        
    }

    static void construct(int[] data){
        ArrayList<node> stack = new ArrayList<>();
        for(int i = 0 ; i < data.length ; i++){
            if(data[i] == -1){
                stack.remove(stack.size()-1);
            }else if(root == null){
                node n = new node(data[i]);
                root = n;
                stack.add(n);
            }else{
                node cp = stack.get(stack.size()-1);
                node n = new node(data[i]);
                if(cp.left == null){
                    cp.left = n;
                    stack.add(n);
                }
                else if(cp.right == null){
                    cp.right = n;
                    stack.add(n);
                }
            }
        }
    }

    public static void display(node croot){
        if(croot == null){
            return;
        }

        System.out.print(croot.data + "->");

        if(croot.left != null){
            System.out.print(croot.left.data + " ");
        }
        if(croot.right != null){
            System.out.print(croot.right.data + " ");
        }
        System.out.println(".");
        if(croot.left != null){
            display(croot.left);
        }
        if(croot.right != null){
            display(croot.right);
        }
    }

    public static int size(node croot){
   
        if(croot == null){
            return 0;
        }
     int myAns = 1;
       int myAnsL = size(croot.left);
       int myAnsR = size(croot.right);
       myAns += myAnsL+myAnsR;

       return myAns;
    }

    static int height(node croot){
        if(croot == null){
            return 0;
        }

        int leftH = height(croot.left);
        int rightH = height(croot.right);

        int myHeight = Math.max(leftH, rightH);

        return myHeight+1;
    }

    static int max(node croot){
        if(croot == null){
            return 0;
        }

        int mymax = croot.data;

        int lm = max(croot.left);
        mymax = mymax<=lm ? lm : mymax;
        int rm = max(croot.right);
        mymax = mymax<=rm ? rm : mymax;

        return mymax;
    }

    static boolean find(node croot , int data){
        if(croot == null){
            return false;
        }

        if(croot.data == data){
            return true;
        }
        if(croot.left != null){
            boolean ans = find(croot.left, data);
            if(ans){
                return ans;
            }
        }
        if(croot.right != null){
            boolean ans = find(croot.right, data);
            if(ans){
                return true;
            }
        }

        return false;
    }

    static void preOrder(node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");

        if(root.left != null){
            preOrder(root.left);
        }
        if(root.right != null){
            preOrder(root.right);
        }
    }

    
    static void postOrder(node root){
        if(root == null){
            return;
        }

        
        if(root.left != null){
            postOrder(root.left);
        }
        if(root.right != null){
            postOrder(root.right);
        }
        System.out.print(root.data + " ");
    }

    static void inOrder(node root){
        if(root == null){
            return;
        }

        
        if(root.left != null){
            inOrder(root.left);
        }
        System.out.print(root.data + " ");
        if(root.right != null){
            inOrder(root.right);
        }
    }

    public static void preOrderIterative(node root){
        ArrayList<node> stack= new ArrayList<>();
        if(root==null){
            return ;
        }
        stack.add(root);
        while(stack.size()>0){
            node cp= stack.remove(stack.size()-1);
            System.out.println(cp.data +" ");
            if(cp.right!=null){
                stack.add(cp.right);
            }
            if(cp.left!=null){
                stack.add(cp.left);
            }
        }
}
static class MyDataType{
    int height;
    int diameter;
    MyDataType(int h,int d){
        this.height=h;
        this.diameter=d;

    }
}
public static MyDataType diameterBetterWay(node root){

if(root== null){
    MyDataType baseRes= new MyDataType(0, 0);
    return baseRes;
}
MyDataType leftAns = diameterBetterWay(root.left);
MyDataType rightAns = diameterBetterWay(root.right);
int myHeight= Math.max(leftAns.height,rightAns.height)+1;
int myDia= Math.max(leftAns.height + rightAns.height +1,Math.max(leftAns.diameter,rightAns.diameter));
MyDataType myAns= new MyDataType(myHeight, myDia);
return myAns;
}


public static int diameter(node root){
    if(root == null){
        return 0 ;
    }
    int leftD = diameter(root.left);
    int rightD = diameter(root.right);
    int leftH = height(root.left);
    int rightH = height(root.right);
    int myDiameter= Math.max(leftH+rightH+1,Math.max(leftD,rightD));
    return myDiameter;
}


public static boolean balancedTree(node root){
if(root==null){
return true;
}
    boolean leftB=balancedTree(root.left);
    boolean rightB=balancedTree(root.right);
    int leftH = height(root.left);
    int rightH = height(root.right);
    int balance = leftH-rightH;
    if(balance==-1||balance==0||balance==1){
        if(leftB==true && rightB == true)
        return true;
    }
   return false;
    
}
static class BalancedHelper{
    int h;
    boolean bal;
}

static class MyDataType2{       //  *****try doing the same question using this class******
    boolean left; 
    boolean right;
    MyDataType2(boolean left,boolean right){
        this.left=true;
        this.right=true;
    }
    boolean check(){
        if (this.left == true && this.right == true){
            return true;
        }
        return false;
    }
}
//**********************************************************************
//******************************************************************/



//public static MyDataType2 balancedTreeBetterWay(node root){
//if(root == null){
//    MyDataType2 baseRes= new MyDataType2(true, true);
//    return baseRes.check();
//}
//}
static class BSThelper{
    int max;
    int min;
    boolean Bst;
}

// public static boolean isBST(node root){
// if(root == null){
//     return true;
// }
// if(root.child<root.right){

// }
// isBST(root.left);
// isBST(root.right);

// }
    public static void main(String[] args) {
        int[] data = {10,20,40,-1,50,-1,-1,30,60,-1,70};
         construct(data);
    //display(root);
        // System.out.println(size(root));
        // System.out.println(height(root));
        // System.out.println(max(root)); 
        // System.out.println(find(root,90));
        // preOrder(root);
        // postOrder(root);
        // inOrder(root);

       // int[] preOrd = {50,70,20,2,30,90,10};
       // int[] inOrd = {20,70,2,50,90,30,10};
      // preOrderIterative(root);
      System.out.println(diameter(root));
      MyDataType ans= diameterBetterWay(root);
      System.out.println(ans.diameter);
      System.out.println(balancedTree(root));
    }
}