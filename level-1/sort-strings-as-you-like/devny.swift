extension String {
    subscript(_ i: Int) -> String {
        let start = index(startIndex, offsetBy: i)
        let end = index(start, offsetBy: 1)
        return String(self[start..<end])
    }
}

func solution(_ s:String) -> String {
    let index = s.count / 2
    return s.count % 2 == 0  ? s[index-1]+s[index] : s[(index)]
}
