package Recursion;

/**
 * CoinChange
 */
public class CoinChange {

    static int counter = 0;
    public static void coinChangePermutaion(int[] coins , int target , String asf){ // in this 3223 and 3232 are different 
        if(target == 0){
            counter++;
            System.out.println(counter + "."+asf);
            return;
        }
        for(int i = 0 ; i<coins.length;i++){
            if(target >= coins[i]){
            coinChangePermutaion(coins, target-coins[i], asf+coins[i]);
        }
    }
    }

    public static void coinChangecombination(int[] coins , int target , int lci,String asf){// in this 3223 and 3232 are same 
       
        // in this we have to keep check of the coin that was chosen and that is done by using li

        if(target == 0){
            counter++;
            System.out.println(counter + "."+asf);
            return;
        }

        for(int i = lci ; i<coins.length;i++){
            if(target >= coins[i]){
            coinChangecombination(coins, target-coins[i], i,asf+coins[i]);
        }
    }
}


    public static void main(String[] args) {
        int[] coins = {2,3,5,6};
        int target = 10;
        coinChangePermutaion(coins,target,"");
        //coinChangecombination(coins, target, 0, "");
    }
}