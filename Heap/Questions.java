package Heap;


import java.util.Collections;
import java.util.PriorityQueue;

public class Questions {

    public static int KthLargest(int[] arr,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // java creates min pq in default
        for(int ele: arr){
            pq.add(ele);
            if(pq.size()>k){
                pq.remove();
            }
        }

        return pq.peek();
    }

    public static int KthSmallest(int[] arr,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());  // java creates min pq in default
        for(int ele: arr){
            pq.add(ele);
            if(pq.size()>k){
                pq.remove();
            }
        }

        return pq.peek();
    }


    public static class pair implements Comparable<pair>{

        int val;
        int idx;

        pair(int val,int idx){
            this.val=val;
            this.idx=idx;
        }

        @Override
        public int compareTo(pair o){
            return this.val - o.val; // min pq
            //return o.val - this.val ; // max pq
        }
    }

    public static pair KthLargest_Index(int[] arr,int k){
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(new pair(arr[i],i));
            if(pq.size()>k){
                pq.remove();
            }
        }
    return pq.peek();
    }


    public static void main(String[] args) {
        int[] arr = {12,3,5,7,19};
        int k = 3;
        System.out.println(KthLargest(arr, k));
        System.out.println(KthSmallest(arr, k));

        pair ans = KthLargest_Index(arr, k);
        System.out.println(ans.val + " idx:"+ ans.idx);
    }
}