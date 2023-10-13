function solution(n)
{
    var answer = 0;
    arr = String(n).split('').map((e)=>{return Number(e)})
    answer = arr.reduce((acc, cur)=>{return acc + cur})
    return answer;
}