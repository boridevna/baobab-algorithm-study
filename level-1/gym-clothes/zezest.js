function solution(n, lost, reserve) {
  let answer = 0;
  let list = []

  for (let i = 0; i < n; i++) {
    list.push(1)
  }

  list = reserve.reduce((r, i) => {
    r[i - 1] = 2
    return r
  }, list)

  list = lost.reduce((r, i) => {
    r[i - 1] -= 1
    return r
  }, list)

  const temp = list.reduce((r, i, k) => {
    let { count, arr } = r

    if (i === 0) {
      if (arr[k - 1] === 2) {
        arr[k] += 1
        arr[k - 1] -= 1
        count += 1

      } else if (arr[k + 1] === 2) {
        arr[k] += 1
        arr[k + 1] -= 1
        count += 1
      }

    } else {
      count += 1
    }

    return {
      count,
      arr
    }

  }, {
    count: 0,
    arr: list
  })

  answer = temp.count

  return answer
}

const testCase = [{
    n: 5,
    lost: [2, 4],
    reserve: [1, 3, 5]
  },
  {
    n: 5,
    lost: [2, 4],
    reserve: [3]
  },
]

const play = () => {
  testCase.forEach(({
    n,
    lost,
    reserve
  }) => {
    const result = solution(n, lost, reserve)
    console.log(result)
  })
}

play()