package Sorting;

public class SelectionSort {
    
    public static void sSort(int[] arr){
        //int[] arr = {8,5,7,6,3,2,1};
        for(int i = 0;i<arr.length;i++){
            int min=Integer.MAX_VALUE;
            int minIdx=i;
            for(int j=i;j<arr.length;j++){
                if(arr[j]<min){
                    min = arr[j];
                    minIdx = j;
                }
            }
        int temp = arr[i];
        arr[i]=min;
        arr[minIdx]=temp;
        }
    } 

    public static void main(String[] args) {
        int[] arr = {8,5,7,6,3,2,1};
        sSort(arr);
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

}