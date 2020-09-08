package DP;


/**
 * LIS
 */
public class LIS {

    public static void Lis(int[] arr){

        int[] lis = new int[arr.length];
        String[] path = new String[arr.length];

        lis[0]=1;
        path[0]=arr[0] +"";
        int omax=0;
        String opath="";
        //int[] arr = {10,22,9,33,21,50,41,60,80,1};
        //int[] lis = {1,  0,0, 0, 0, 0, 0, 0, 0,0};
        
        
        // FIRST CHECK IF THE ARR[I]>ARR[J] IF YES THEN CHECK IF THE LIS[J]>LIS[I] 
        //IF YES THEN UPDATE THE LIS[I] AND PATH SO FAR THEN CHECK FOR NEXT J
        // THEN ADD 1 TO THE LIS[I] AND ADD ARR[I] TO THE PATH

        for(int i = 1;i<arr.length;i++){
            for(int j = 0;j<=i-1;j++){  
                if(arr[j]<arr[i]){
                    if(lis[i]<lis[j]){
                    lis[i]=lis[j];
                    path[i]=path[j];
                    }
                }   
            }
            lis[i]=lis[i]+1;
            path[i]=path[i]+ " "+arr[i];
            if(lis[i]>omax){
                omax = lis[i];
                opath = path[i];
            }
        }

        for(int i = 0;i<arr.length;i++){
            System.out.println(path[i]);
        }
        
       System.out.println(omax + " " + opath);
        
    }

    public static void main(String[] args) {
        int[] arr = {10,22,9,33,21,50,41,60,80,1};
        Lis(arr);
    }
}