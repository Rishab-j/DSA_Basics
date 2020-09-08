package LeetCode;

public class Cousins_tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        
        int hx=find(root,x,0);
        
        
        findParent(root,x,-1);
        
        int xp = Parent;
        
        int hy=find(root,y,0);
        
        findParent(root,y,-1);
        
        int yp = Parent;
        
        if(hx==hy && xp!=yp){
            return true;
        
        }
        else{
            return false;
        }
        
    }
    
    
    
    public int find(TreeNode node,int x,int h){
        
        if(node == null){
            return -1;
        }
        
        
        if(node.val == x){
            
            return h;
        }
        
        int l = 0;
        int r = 0;
        if(node.left!=null){
           l = find(node.left,x, h+1);
        }
        if(l!=0){   // pehle left node check hoga agr usme apna data h to whi se height l mei store hoke
                    // return ho jaaegi bina right node check hue
            return l;  
        }
        if(node.right!=null){
            r=find(node.right,x,h+1);
        }
        if(r!=0){
            return r;
        }
        
        
        return 0;
    }
    
    static int Parent = 0;
    public void findParent(TreeNode node, int val ,int par){
        if(node==null){
            return ;
        }
        
        if(node.val == val){
            Parent = par;
        }
        
        if(node.left!=null){
            findParent(node.left,val,node.val);
        }
        if(node.right!=null){
            findParent(node.right,val,node.val);
        }
    }
}