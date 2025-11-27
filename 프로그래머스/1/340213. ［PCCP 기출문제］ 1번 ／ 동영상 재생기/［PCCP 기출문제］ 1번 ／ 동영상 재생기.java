import java.util.*;
class Solution {    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int vTime = Integer.parseInt(video_len.substring(0,2)) * 60 + Integer.parseInt(video_len.substring(3,5));
        int pTime = Integer.parseInt(pos.substring(0,2)) * 60 + Integer.parseInt(pos.substring(3,5));
        int oSTime = Integer.parseInt(op_start.substring(0,2)) * 60 + Integer.parseInt(op_start.substring(3,5));
        int oETime = Integer.parseInt(op_end.substring(0,2)) * 60 + Integer.parseInt(op_end.substring(3,5));
        
        // 시작점 오프닝 체크
        if(pTime >= oSTime && pTime <= oETime){
            pTime = oETime;
        }
        
        for(String cmd : commands){
           if(cmd.equals("next")){
               pTime += 10;
               if(pTime > vTime){
                   pTime = vTime;
               }
           } else {
              pTime -= 10;
              if(pTime < 0){
                  pTime = 0;
              }
           }
           if(pTime >= oSTime && pTime <= oETime){
               pTime = oETime;
           }
        }
        answer = String.format("%02d", pTime/60) + ":" + String.format("%02d", pTime%60);
        return answer;
    }
}