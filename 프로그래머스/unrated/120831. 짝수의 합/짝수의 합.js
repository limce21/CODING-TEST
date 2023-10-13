function solution(n) {
    var answer = 0;
    for(var i=2; i <= n; i += 2){
        answer += i
    }
    return answer;
}