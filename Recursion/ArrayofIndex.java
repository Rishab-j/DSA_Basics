package Recursion;

/**
 * ArrayofIndex
 */
public class ArrayofIndex {

    public static int[] indexArray(int[] arr,int data,int i,int c){

        if(i==arr.length){
            int[] base = new int[c];
            return base;
        }

        int[] ans = null;
        
        if(arr[i]==data){
            ans = indexArray(arr, data, i+1, c+1);
            ans[c]=i;    
        }
        else {
            ans = indexArray(arr, data, i+1, c);
            
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,8,1,2,3,1,1,2,6};
        int[] ans = indexArray(arr, 1, 0, 0);
        for(int i = 0; i<ans.length ; i++ ){
            System.out.println(ans[i]);
        }

    }
}