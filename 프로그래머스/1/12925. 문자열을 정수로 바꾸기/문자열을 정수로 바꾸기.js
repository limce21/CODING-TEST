function solution(s) {
    var answer = 0;
    var arr = [...s]
    if (arr[0] === '+'){
        arr.shift()
        answer = Number(arr.join(''))
    } else if (arr[0] === '-'){
        arr.shift()
        answer = Number(arr.join('')) * (-1)
    } else {
        answer = Number(arr.join(''))
    }
    return answer;
}