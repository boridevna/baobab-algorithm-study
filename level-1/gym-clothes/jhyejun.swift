import Foundation

func solution(_ n:Int, _ lost:[Int], _ reserve:[Int]) -> Int {
    var result: Int = 0
    var extra: [Int] = reserve
    
    result += n - lost.count
    
    for i in 0 ..< lost.count {
        var has: Int?
        
        for j in 0 ..< extra.count {
            if lost[i] == extra[j] {
                has = j
                break
            } else if lost[i] - 1 == extra[j] || lost[i] + 1 == extra[j] {
                has = j
                break
            }
        }
        
        if let index = has {
            extra.remove(at: index)
            result += 1
        }
    }
    
    return result
}
