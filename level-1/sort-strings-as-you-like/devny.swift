extension String {
    subscript(_ i: Int) -> String {
        let start = index(startIndex, offsetBy: i)
        let end = index(start, offsetBy: 1)
        return String(self[start..<end])
    }
}

func solution(_ strings:[String], _ n:Int) -> [String] {
    return strings.map {  $0[n] + $0 }.sorted().map { (string) -> String in
        var value = string
        value.removeFirst()
        return value
    }
}
