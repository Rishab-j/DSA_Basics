package MIT;

/**
 * PeakFinder
 */
public class PeakFinder {

 /** -------------------------------------- 1D ARRAY --------------------------------------- */

    public static int peakFinder1d(int[] arr, int l, int h, int n) {

        int mid = l + (h - l) / 2;

        if ((mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == n - 1 || arr[mid] >= arr[mid + 1])) {
            return mid;
        } else if (mid > 0 && arr[mid - 1] > arr[mid]) {
            return peakFinder1d(arr, l, mid - 1, n);
        } else {
            return peakFinder1d(arr, mid + 1, h, n);
        }
    }

  /** -------------------------------------- 2D ARRAY --------------------------------------- */

    static int MAX = 100; 
  
    // Function to find the maximum in column  
    // 'mid', 'rows' is number of rows. 
    static int findMax(int[][] arr, int rows,  
                       int mid, int max) 
    { 
        int max_index = 0; 
        for (int i = 0; i < rows; i++) 
        { 
            if (max < arr[i][mid]) 
            { 
                  
                // Saving global maximum and its index 
                // to check its neighbours 
                max = arr[i][mid]; 
                max_index = i; 
            } 
        } 
        return max_index; 
    } 
  
    // Function to change the value of [max] 
    static int Max(int[][] arr, int rows, 
                   int mid, int max) 
    { 
        for (int i = 0; i < rows; i++) 
        { 
            if (max < arr[i][mid]) 
            { 
                  
                // Saving global maximum and its index 
                // to check its neighbours 
                max = arr[i][mid]; 
            } 
        } 
        return max; 
    } 
  
    // Function to find a peak element 
    static int findPeakRec(int[][] arr, int rows,  
                           int columns, int mid)  
    { 
        // Evaluating maximum of mid column.  
        // Note max is passed by reference. 
        int max = 0; 
        int max_index = findMax(arr, rows, mid, max); 
        max = Max(arr, rows, mid, max); 
  
        // If we are on the first or last column, 
        // max is a peak 
        if (mid == 0 || mid == columns - 1) 
            return max; 
  
        // If mid column maximum is also peak 
        if (max >= arr[max_index][mid - 1] &&  
            max >= arr[max_index][mid + 1]) 
            return max; 
  
        // If max is less than its left 
        if (max < arr[max_index][mid - 1]) 
            return findPeakRec(arr, rows, columns,  
                         (int)(mid - Math.ceil((double) mid / 2))); 
  
        // If max is less than its left 
        // if (max < arr[max_index][mid+1]) 
        return findPeakRec(arr, rows, columns,  
                     (int)(mid + Math.ceil((double) mid / 2))); 
    } 
  
    // A wrapper over findPeakRec() 
    static int findPeak(int[][] arr, int rows, int columns)  
    { 
        return findPeakRec(arr, rows, columns, columns / 2); 
    }

    

    public static void main(String[] args) {
        int arr[] = { 1, 3, 20, 4, 1, 0 };
        int n = arr.length;
        System.out.println("Index of a peak point is " + peakFinder1d(arr, 0, n - 1, n));
    }
}