function solution(strings, n) {
  var answer = [];
  
  const list = strings.reduce((r, i) => {
      if (r[i[n]]) {
          r[i[n]].push(i)
      } else {
          r[i[n]] = [i]    
      }
      
      return r
  }, {})

  answer = Object.keys(list).sort().reduce((r, keyword) => {
      r = r.concat(list[keyword].sort())
      return r
  }, [])
  
  return answer;
}