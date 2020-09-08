package CB;

public class Prime_Sieve {

    public static void primeSieve(int n){
        boolean[] prime = new boolean[n+1];
        
        for(int i = 0;i<prime.length;i++){ // mark every no. as prime 
            prime[i] = true;
        }

        for(int p = 2 ;p*p<n;p++){ // check only till sqrt(n)
            if(prime[p]==true){ // if the no. is prime only then mark its multiple false
                for(int j = p*p ; j<=n; j=j+p){
                    prime[j]=false;
                }
            }
        }
        for(int i = 2;i<prime.length;i++){
            if(prime[i]==true){
                System.out.print(i + " ");
            }
        }

    }

    public static void main(String[] args) {
        primeSieve(100);
    }
    
}