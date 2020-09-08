package Sorting;

public class MergeSort {

    public static int[] mergeSort(int[] arr, int left, int right) {

        if (left == right) {
            int[] array = new int[1];
            array[0] = arr[left];
            return array;
        }

        int mid = (left + right) / 2;
        int[] lefts = mergeSort(arr, left, mid);
        int[] rights = mergeSort(arr, mid + 1, right);

        int[] ans = merge(lefts, rights);

        return ans;
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] ans = new int[arr1.length + arr2.length];
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                ans[k] = arr1[i];
                k++;
                i++;
            } else {
                ans[k] = arr2[j];
                k++;
                j++;
            }
        }

        while (i < arr1.length) {
            ans[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            ans[k] = arr2[j];
            j++;
            k++;
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] arr = { 8, 9, 4, 7, 5, 3, 8, 1, 2, 8, 7, 4, 3, 6, 1, 7, 3, 7, 4, 6 };
        int left = 0;
        int right = arr.length - 1;
        arr = mergeSort(arr, left, right);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}