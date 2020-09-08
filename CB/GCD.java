package CB;

public class GCD {

    public static int euclidAlgo(int a,int b){
       if(b==0){
           return a;
       }
       return euclidAlgo(b, a%b);
    }

    public static void main(String[] args) {
        int a = 20;
        int b = 12;
        int gcd = euclidAlgo(a,b);
        System.out.println(gcd);
        int lcm = (a*b)/gcd;
        System.out.println(lcm);
    }
}