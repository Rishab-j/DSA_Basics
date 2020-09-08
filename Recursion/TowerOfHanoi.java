package Recursion;

/**
 * TowerOfHanoi
 */
public class TowerOfHanoi {

    public static void toh(int n,String Source,String Destination,String Helper){
        if(n==0){
            return ;
        }

        toh(n-1,Source,Helper,Destination);
        System.out.println(n + " " + Source + " -> " + Destination );
        toh(n-1,Helper,Destination,Source);
    }

    public static void main(String[] args) {
        String Source = "S";
        String Destination = "D";
        String Helper = "H";
        int n = 3;
        toh(n,Source,Destination,Helper);
    }
}