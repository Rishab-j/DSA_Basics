package LeetCode;

import java.util.ArrayList;
import java.util.List;

// PROBLEM 986

public class IntersectionOfSets {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int n = A.length;
        int m = B.length;
        if (n == 0 || m == 0)
            return new int[0][0];

        List<int[]> res = new ArrayList<>(); // used list because we dont the size of our answer , will convert to 2d
                                             // array before returning
        int i = 0;
        int j = 0;
        int[] aHead = null; // declaration
        int[] bHead = null;
        while (i < n && j < m) {
            aHead = A[i]; // initialization
            bHead = B[j];

            int[] intersect = { Math.max(aHead[0], bHead[0]), Math.min(aHead[1], bHead[1]) };
            if (intersect[0] <= intersect[1]) {
                // add intersect
                res.add(intersect);
            }

            if (aHead[1] < bHead[1]) {
                i++;
            } else if (aHead[1] == bHead[1]) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        int dim = res.size();
        int[][] finalRes = new int[dim][2];
        for (i = 0; i < dim; i++) {
            finalRes[i] = res.get(i);
        }
        return finalRes;
    }

    // LOGIC IS SAME
    // BUT THE WAY OF CODING IS SMART

    public int[][] intervalIntersection2(int[][] A, int[][] B) {
        int n = A.length;
        int m = B.length;
        if (n == 0 || m == 0)
            return new int[0][0];

        List<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            int[] temp = new int[2];
            if (B[j][0] <= A[i][1] && A[i][0] <= B[j][1]) {
                temp[0] = Math.max(A[i][0], B[j][0]);
                temp[1] = Math.min(A[i][1], B[j][1]);
                res.add(temp);

            }
            if (A[i][1] < B[j][1]) {
                i++;
            } else if (A[i][1] == B[j][1]) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    // LOGIC IS SAME
    // BUT THE WAY OF CODING IS SMARTER

    public int[][] intervalIntersection3(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            // Let's check if A[i] intersects B[j].
            // lo - the startpoint of the intersection
            // hi - the endpoint of the intersection
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi)
                ans.add(new int[] { lo, hi });

            // Remove the interval with the smallest endpoint
            if (A[i][1] < B[j][1])
                i++;
            else
                j++;
        }

        return ans.toArray(new int[ans.size()][]);
    }

}