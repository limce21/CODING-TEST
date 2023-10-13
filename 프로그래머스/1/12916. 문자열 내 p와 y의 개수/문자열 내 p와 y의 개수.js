function solution(s){
    var answer = true;
    var pCnt = 0
    var yCnt = 0
    s = [...s]
    s.forEach((e)=>{
        if(e === 'p' || e === 'P'){
            pCnt++
        }
        else if (e==='y' || e ==='Y'){
            yCnt++
        }
    })
    answer = pCnt === yCnt ? true : false
    return answer;
}