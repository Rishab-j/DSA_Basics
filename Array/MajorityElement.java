package Array;

import java.util.Arrays;

public class MajorityElement {
    
    public static int majorityElement(int[] arr){
        
        int l = arr.length;
        int count = -1;
        int maxCount = -1;
        
        int maxElement = -1;
        int temp = arr[0];
        int f=1;
        
        Arrays.sort(arr); // agr sort ni krenge to isme ans 2 aaega

        if(l==1){ // length agr 1 hi to yahi se return
            return arr[0];
        }
        else{
        for(int i=1;i<arr.length;i++){
            if(temp == arr[i]){
                count++;
            }
            else{
                temp=arr[i];
                count = 1;
            }

            if(maxCount<count){
                maxCount = count; // store maxCount so far
                maxElement =arr[i];  // store maxElement
                if(maxCount>l/2){
                    f=1; // flag
                    break;
                }
            }
        }
        return f==1?maxElement:-1;
    }
    }
    
    public static void main(String[] args) {
        int[] arr = {3,2,3};
        int ans = majorityElement(arr);
        System.out.println(ans);
    }
}