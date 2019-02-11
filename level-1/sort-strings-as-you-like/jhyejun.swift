func solution(_ strings:[String], _ n:Int) -> [String] {
    return strings.sorted {
            if $0[n] == $1[n] {
                return $0 < $1
            } else {
                return $0[n] < $1[n]
            }
        }
}

extension String {
    subscript (i: Int) -> String {
        return String(self[index(startIndex, offsetBy: i)])
    }
}
