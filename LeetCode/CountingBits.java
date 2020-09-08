package LeetCode;

public class CountingBits {

    public int[] countBits(int num) {
        int[] bitCounts = new int[num+1];
        for(int i = 1;i<=num;i++){
            bitCounts[i] = bitCounts[i>>1] + i%2;
        
        }
    return bitCounts;
    }
    
}