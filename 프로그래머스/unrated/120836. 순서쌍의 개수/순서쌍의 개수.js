function solution(n) {
    var answer = 0;
    for(var i = 1; i <= Math.trunc(n/2); i++){
        if (n%i === 0) {
            answer++
        }
    }
    answer++
    return answer;
}