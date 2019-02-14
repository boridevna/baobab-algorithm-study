func solution(_ n:Int) -> String {
    var result = ""
    for _ in 0..<n/2 {
        result += "수박"
    }
    
    return n % 2 == 0 ? result : result + "수"
}
