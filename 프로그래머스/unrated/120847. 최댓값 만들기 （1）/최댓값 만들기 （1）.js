function solution(numbers) {
    var answer = 0;
    var m1 = Math.max(...numbers)
    var m1Idx = numbers.indexOf(m1)
    numbers.splice(m1Idx, 1)
    var m2 = Math.max(...numbers)
    answer = m1 * m2
    return answer;
}