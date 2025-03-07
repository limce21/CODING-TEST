class Solution {
    static int len;
    static int val;
    static int result = 0;
    static int[] arr;
    
    public void search(int k, int sum){
        if(k == len){
            if(sum == val){
                result++;
            }
            return;
        }
        search(k+1, sum + arr[k]);
        search(k+1, sum - arr[k]);
    }
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        arr = numbers;
        len = numbers.length;
        val = target;
        search(0, 0);
        answer = result;
        return answer;
    }
}