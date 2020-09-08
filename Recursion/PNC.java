package Recursion;

/**
 * PNC
 */
public class PNC {

    public static void permutation(boolean[] boxes,int nq,int qpsf,String asf){

        if(qpsf==nq){
            System.out.println(asf);
            return ;
        }

        for(int b = 0;b<boxes.length;b++){
           
            if(boxes[b]==false){
                boxes[b]=true;
                permutation(boxes, nq, qpsf+1, asf + "b" + b +"q" +(qpsf+1)+" ");
            
            boxes[b]=false;
            }
        }
    }

    public static void combination(boolean[] boxes,int nq,int qpsf,int lqi,String asf){
        if(qpsf==nq){
            System.out.println(asf);
            return ;
        }
        for(int b = lqi+1;b<boxes.length;b++){
           if(boxes[b]==false){
                boxes[b]=true;
                combination(boxes, nq, qpsf+1 , b , asf + "b" + b +"q" +(qpsf+1)+" ");
                boxes[b]=false;
            }
        }
    }


    public static void main(String[] args) {
        boolean[] boxes = new boolean[5];
        int nq = 2;
        permutation(boxes,nq,0,"");
        //combination(boxes,nq,0,-1,"");
    }
}