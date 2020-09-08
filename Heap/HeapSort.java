package Heap;

public class HeapSort {
    // Steps:
    // 1. set maxIdx(considering the case of maxHeap it should be minIdx if want to
    // create a min heap) as paridx
    // 2. compare paridx to lci and rci and set the maxIdx accordingly
    // 3. if maxIdx is not paridx after step 2 then swap the maxIdx and parIdx
    // 4. call downheapify on maxidx

    public static void downHeapify(int[] arr, int parIdx, int ei, boolean isMax) {  // logn
        int maxidx = parIdx;
        int lci = 2 * parIdx + 1;
        int rci = 2 * parIdx + 2;

        if (lci <= ei && compareTo(arr, lci, maxidx, isMax))
            maxidx = lci;
        if (rci <= ei && compareTo(arr, rci, maxidx, isMax))
            maxidx = rci;

        if (parIdx != maxidx) {
            swap(arr, maxidx, parIdx);
            downHeapify(arr, maxidx, ei, isMax);// agr left child bda tha to maxidx left child idx ko point krr rha hoga
                                                // and it
                                                // is possible that it may not following the heap property so call downheapify
                                                // on maxidx
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static boolean compareTo(int[] arr, int ci, int pi, boolean isMax) {
        if (isMax)
            return arr[ci] > arr[pi];
        else
            return arr[ci] < arr[pi];
    }

    // Steps for heapSort:
    // 1. call downheapify on each elemnent from the last idx of the array (means
    // create the heap)
    // 2. after the heap is created it is descending order if maxheap and vice versa
    // 3. to print in increasing order in case of maxheap swap the first and last
    // element and call downheapify again on the first idx and so on..
    // 4. we get a sorted heap

    public static void main(String[] args) {
        int[] arr = { 6, 8, 2, -4, 18, 4, 10, 9, 8, 9, 16, 15, 13, 11, -9, -10 };
        int ei = arr.length - 1;
        boolean isMax = true;
        
        // building heap in this step 
        // intuitively it seems like the complexity is nlogn 
        // but it is only n (proof in notes)
        
        for (int i = ei; i >= 0; i--) {  // we can somewhat reduce the time by starting the loop from i = n/2 
            downHeapify(arr, i, ei, isMax);
        }

        // for (int ele : arr)
        // System.out.print(ele + " ");
        // System.out.println();

        while (ei != 0) {
            swap(arr, 0, ei); // last index ko first index se swap kro lets say it was a maxheap then max
                              // element would come at end and then call downheapify again by calling
                              // downheapify again the 2nd max element would come to the top or first idx and
                              // virtually delete the last element by doing e-- do it until ei!=0
            ei--;
            downHeapify(arr, 0, ei, isMax);
        }

        for (int ele : arr)
            System.out.print(ele + " ");

    }

}