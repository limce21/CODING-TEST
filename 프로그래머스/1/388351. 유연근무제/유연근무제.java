class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i=0; i<schedules.length; i++){
            boolean success = true;
            int timelimit = schedules[i] + 10;
            if(timelimit % 100 >= 60){
                int tmp = (timelimit % 100) % 60;
                timelimit = (timelimit/100 + 1) * 100 + tmp;
            }
            int[] timelog = timelogs[i];
            for(int j=0; j<7; j++){
                int day = (startday - 1 + j) % 7;
                if(day == 5 || day == 6) continue;
                if(timelog[j] > timelimit){
                    success = false;
                    break;
                }
            }
            if(success){
                answer++;
            }
        }
        
        
        
        return answer;
        
    }
}