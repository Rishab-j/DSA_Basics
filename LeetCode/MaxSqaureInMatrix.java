package LeetCode;

public class MaxSqaureInMatrix {

    public static int maxSqaureInMatrix(int[][] arr){
        int r = arr.length;
        int c = arr[0].length;
        int count = 0;
        
        for(int i = 0; i<r;i++){
            for(int j=0;j<c;j++){
                if(arr[i][j]!=0){
                    if(i==0){
                        count++;
                    }
                    else if(j==0){
                        count++;
                    }
                    else{
                        int min1 = Math.min(arr[i-1][j-1],arr[i-1][j]);
                        int min2 = 1+Math.min(min1,arr[i][j-1]);

                        arr[i][j]=min2;
                        count += min2;
                    }
                }
            }
        }

        return count;
    }
    
    public static void main(String[] args) {
        int[][] arr = {
            {1,0,1,0,0,1},
            {1,0,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,0,0},
            {1,1,1,1,1,1},
            {0,0,1,1,1,0}
        };
        int ans = maxSqaureInMatrix(arr);
        System.out.println(ans);
    }

}