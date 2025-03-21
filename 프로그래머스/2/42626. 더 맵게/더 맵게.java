import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++){
            pq.offer(scoville[i]);
        }
        
        while(!pq.isEmpty()){
            int food1 = pq.poll();
            if(food1 >= K){
                break;
            }

            if(pq.isEmpty()){
                answer = -1;
                break;
            }
            
            int food2 = pq.poll();
            int ns = food1 + food2 * 2;
            answer++;
            pq.offer(ns);
        }
        
        return answer;
    }
}