package Sorting;

public class QuickSort {
    
    public static int partition(int[] arr,int low, int high){
        int i = low;
        int j = low;
        int pivot = arr[high];
        while(i<=high){
            if(arr[i]<=pivot){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        return j-1;
    }

    public static void quickSort(int[] arr,int low, int high){
        if(low>=high){
            return ;
        }

        int pIdx = partition(arr, low, high);
        quickSort(arr, low, pIdx-1);
        quickSort(arr, pIdx+1, high);
    }

    public static void main(String[] args) {
        int arr[] = {9,8,7,6,5,4,3,2,1};
        quickSort(arr, 0, arr.length-1);
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

}