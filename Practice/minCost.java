package Practice;

public class minCost {
    public static int min=Integer.MAX_VALUE;
    public static int minCostR(int[][] cost,int sr,int sc,int er,int ec){
        
        if(sr==er && sc==ec){
            return cost[er][ec];
        }
        int minCost=0;
        int intermediate1=Integer.MAX_VALUE;   //
        int intermediate2=Integer.MAX_VALUE;   // 
        int intermediate3=Integer.MAX_VALUE;   //
        if(sr+1<=er ){
            
            intermediate1=minCostR(cost, sr+1, sc, er, ec);
        }
        if(sc+1<=ec){
            intermediate2=minCostR(cost, sr, sc+1, er, ec);

        }
        if(sr+1<=er && sc+1<=ec){
          intermediate3=  minCostR(cost, sr+1, sc+1, er, ec);

        }
        int min1=Math.min(intermediate1, intermediate2);
        int min2=Math.min(min1, intermediate3);
        minCost=cost[sr][sc]+min2;
        return minCost;
    }
    public static int minCostDM(int[][] cost,int sr,int sc,int er,int ec,int[][] dp){

        if(sr==er && sc==ec){
            return cost[er][ec];
        }
        if(dp[sr][sc]!=0){
            return dp[sr][sc];
        }
        int minCost=0;
        int intermediate1=Integer.MAX_VALUE;   //
        int intermediate2=Integer.MAX_VALUE;   // 
        int intermediate3=Integer.MAX_VALUE;   //
        if(sr+1<=er ){
            
            intermediate1=minCostDM(cost, sr+1, sc, er, ec,dp);
        }
        if(sc+1<=ec){
            intermediate2=minCostDM(cost, sr, sc+1, er, ec,dp);

        }
        if(sr+1<=er && sc+1<=ec){
          intermediate3=  minCostDM(cost, sr+1, sc+1, er, ec,dp);

        }
        int min1=Math.min(intermediate1, intermediate2);
        int min2=Math.min(min1, intermediate3);
        minCost=cost[sr][sc]+min2;
        dp[sr][sc]=minCost;
        return minCost;



    }
    public static void main(String[] args) {
        
        int cost[][] = { {4, 5, 6}, 
                         {1, 2, 3}, 
                         {7, 5, 9} }; 
     //  System.out.println( minCostR(cost,0,0,2,2));  
       int[][] dp=new int[cost.length][cost[0].length];
       System.out.println(minCostDM(cost,0,0,2,2,dp));               
    }
}