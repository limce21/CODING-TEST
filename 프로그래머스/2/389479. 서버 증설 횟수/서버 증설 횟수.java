import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> sQueue = new LinkedList<>(); // 증설된 서버
        
        for(int i=0; i<24; i++){
            int pcnt = players[i]; // pcnt : 현재 시간 이용자 수
            int scnt = pcnt / m;   // 필요한 서버 수를 구한다.
            
            if(!sQueue.isEmpty()) {
                if(sQueue.peek() + k == i){
                    while(!sQueue.isEmpty()){
                        if(sQueue.peek() + k == i){
                            sQueue.poll();
                        } else {
                            break;
                        }
                    }
                }

                scnt -= sQueue.size();
            }
            if(scnt > 0){ // 추가로 서버 증설이 필요
                for(int j=0; j<scnt; j++){
                    sQueue.offer(i);
                    answer++;
                }
            }
            
        }
        return answer;
    }
}