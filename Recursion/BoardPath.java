package Recursion;

import java.util.ArrayList;

/**
 * BoardPath
 */
public class BoardPath {

    public static int path(int source , int target ,String path){
        if(source == target){
            System.out.println(path);
            return 1;
        }
       
        int count = 0;       // the count of each level at starting is 0
        for(int i=1;i<=6;i++){
            if(source + i <= target){
                count = count + path(source+i, target, i+path); // add to count that is returned by their lower levels

            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(path(0, 6,""));
    }
}