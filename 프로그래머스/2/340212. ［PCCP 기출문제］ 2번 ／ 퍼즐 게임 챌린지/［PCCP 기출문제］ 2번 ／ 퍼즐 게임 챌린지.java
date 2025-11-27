import java.util.*;

class Solution {
    
    public int solution(int[] diffs, int[] times, long limit) {
        
        int maxLevel = Arrays.stream(diffs).max().getAsInt();
        int l = 1;
        int r = maxLevel;
        int answer = maxLevel;
        
        while(l < r){
            int level = (int)((l+r)/ 2);
            long total = 0;
            for(int i=0; i<diffs.length; i++){
                int diff = diffs[i];
                int time = times[i];
                if(diff <= level){
                    total += time;
                } else {
                    int sub = diff - level;
                    total = total + ((time + times[i-1]) * sub + time);
                }
            }
            if(total <= limit){
                answer = level;
                r = level;
            } else {
                l = level + 1;
            }
        
        }
        

        
        return answer;
    }
}