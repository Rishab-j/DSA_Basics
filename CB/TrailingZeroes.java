package CB;

public class TrailingZeroes {

    static int trailingZeroes(int n){

        int p = 5;
        int count = 0;
        while((n/p)>0){
            count = count + (n/p);
            p = p*5;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 100;
        int ans =trailingZeroes(n);
        System.out.println(ans);
    }
    
}