function solution(numbers) {
    var answer = 0;
    answer = numbers.reduce((accumulator, current)=>{
        return accumulator + current
    }) / numbers.length
    return answer;
}