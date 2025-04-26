class Solution {
    public int solution(int n, int w, int num) {
        int answer = 1;
        int totalf = (int)Math.ceil((double)n/w);
        int currf = (int)Math.ceil((double)num/w);
        int nextNum = num;
        
        
        for(int i=currf; i<=totalf; i++){
            int modd = w - (nextNum % w);
            if(nextNum % w == 0){
                modd -= w;
            }
            nextNum = nextNum + 2 * modd + 1;
            
            if(nextNum <= n){
                answer++;
            }
        }
        
        
        
        
        return answer;
    }
}