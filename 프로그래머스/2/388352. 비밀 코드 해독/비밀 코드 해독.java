import java.util.*;
class Solution {
    static int N;
    static int M;
    static int[][] Q;
    static int answer = 0;
    static Integer[] arr;
    static int[] ansTmp; 
    
    static void backTracking(int k, int v){
        if(k == 5){
            List<Integer> list = Arrays.asList(arr);
            for(int i=0; i<M; i++){
                int cnt = 0;
                for(int j=0; j<5; j++){
                    if(list.indexOf(Q[i][j]) != -1) {
                        cnt++;
                    }
                }
                if(cnt != ansTmp[i]) return;
            }
            answer++;
            return;
        }
        for(int i=v+1; i<=N; i++){
            arr[k] = i;
            backTracking(k+1, i);
        }
    }
    
    public int solution(int n, int[][] q, int[] ans) {
        N = n;
        M = q.length;
        Q = q;
        arr = new Integer[n];
        ansTmp = ans;
        
        backTracking(0, 0);
        return answer;
    }
}