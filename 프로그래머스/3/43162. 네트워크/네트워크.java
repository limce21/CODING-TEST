import java.util.*;

class Solution {
    static boolean[] visited;
    static int[][] arr;
    static int len;
    
    public void bfs(int f){
        Queue<Integer> queue = new LinkedList<>();
        visited[f] = true;
        queue.offer(f);
        while(!queue.isEmpty()){
            int val = queue.poll();
            for(int i=0; i<len; i++){
                if(!visited[i] && arr[val][i] == 1){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        len = n;
        arr = computers;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(i);
                answer++;
            }
        }
        
        return answer;
    }
}