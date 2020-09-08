package LeetCode;

public class PixelsFloodFill {

    public static void floodFill(int[][] arr,int sr,int sc,int color,int newColor,boolean[][] visited){

        
        visited[sr][sc]=true;
        //top
        if(sr-1>=0 && arr[sr-1][sc]==color && visited[sr-1][sc]==false){
            arr[sr-1][sc]=newColor;
            floodFill(arr, sr-1, sc, color, newColor,visited);
        }
        //right
        if(sc+1<arr.length && arr[sr][sc+1]==color && visited[sr][sc+1]==false){
            arr[sr][sc+1]=newColor;
            floodFill(arr, sr, sc+1, color, newColor,visited);
        }
        //top
        if(sr+1<arr.length && arr[sr+1][sc]==color && visited[sr+1][sc]==false){
            arr[sr+1][sc]=newColor;
            floodFill(arr, sr+1, sc, color, newColor,visited);
        }
        //top
        if(sc-1>=0 && arr[sr][sc-1]==color && visited[sr][sc-1]==false){
            arr[sr][sc-1]=newColor;
            floodFill(arr, sr, sc-1, color, newColor,visited);
        }
        visited[sr][sc] = false;

        

    }

    public static void main(String[] args) {
        
        int[][] arr = {{0,0,0},{0,0,0}};
        int sr = 0, sc = 0, newColor = 2;
        
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        floodFill(arr, sr, sc, arr[sr][sc], newColor,visited);
        arr[sr][sc]=newColor;
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
    
}