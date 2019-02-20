func solution(_ seoul:[String]) -> String {
    return "김서방은 \(seoul.index { $0 == "Kim" } ?? 0)에 있다"
}