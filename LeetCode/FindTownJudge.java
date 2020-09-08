package LeetCode;

public class FindTownJudge {

    public int findJudge(int N, int[][] trust) {

        int[] count = new int[N + 1];
        for (int[] item : trust) {
            count[item[0]]--; // because a trusts b , if it trusts someone then it can't be the a judge  
            count[item[1]]++; // because it is trusted by a so if it is trusted then the candiate gets 1 point

        }

        for (int i = 1; i <= N; i++) {
            if (count[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }

}