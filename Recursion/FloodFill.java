package Recursion;

/**
 * FloodFill
 */
public class FloodFill {
    public static int floodFill(int[][] arr,int i,int j,String psf){
        if(i==arr.length-1 && j==arr[0].length-1){
            System.out.println(psf);
            return 1;
            
        }
        int count = 0;
        arr[i][j]=1;
        if(i-1>=0 && arr[i-1][j]==0){
            count = count + floodFill(arr, i-1, j, psf + "U");

        }
        if(j-1>=0 && arr[i][j-1]==0){
            count = count + floodFill(arr, i, j-1, psf + "L");
        }
        if(i+1<=arr.length-1 && arr[i+1][j]==0){
            count = count + floodFill(arr, i+1, j, psf + "D");
        }
        if(j+1<=arr[0].length-1 && arr[i][j+1]==0){
            count = count + floodFill(arr, i, j+1, psf + "R");
        } 
         arr[i][j]=0;
        return count;


    }


    public static int floodFillboolean(int[][] arr,int i,int j,boolean[][] visited,String psf){
        if(i==arr.length-1 && j==arr[0].length-1){
            System.out.println(psf);
            return 1;
            
        }
        int count = 0;
        visited[i][j] = true;

        if(i-1>=0 && arr[i-1][j]==0 && visited[i-1][j]==false){
            count = count + floodFillboolean(arr, i-1, j,visited, psf + "U");

        }
        if(j-1>=0 && arr[i][j-1]==0 && visited[i][j-1]==false){
            count = count + floodFillboolean(arr, i, j-1,visited, psf + "L");
        }
        if(i+1<=arr.length-1 && arr[i+1][j]==0 && visited[i+1][j]==false){
            count = count + floodFillboolean(arr, i+1, j,visited, psf + "D");
        }
        if(j+1<=arr[0].length-1 && arr[i][j+1]==0 && visited[i][j+1]==false){
            count = count + floodFillboolean(arr, i, j+1 , visited, psf + "R");
        } 
        visited[i][j]=false;
        return count;

    }
    public static void main(String[] args) {
        int[][] arr= {{0,0,0,0,0},{0,0,1,0,1},{0,0,0,0,0},{0,0,0,1,0}};
        boolean[][] visited = new boolean[arr.length][arr[0].length]; 
      // System.out.println(floodFill(arr,0,0,visited,""));

      System.out.println(floodFill(arr,0,0,""));
    }
}