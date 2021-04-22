import java.util.*
fun solution(S: String): Int {
    if (S.length == 0) return 1
    
    val charArr = S.toCharArray()
    var stack = Stack<Char>()
    for (c in charArr) {
        if (isStartNesting(c)) {
            stack.push(c)
        } else {
            if (!stack.empty()) {
                val cPop = stack.pop()
                if (!isMatchingNestingChar(cPop, c)) return 0
            } else {
                return 0
            }
        }
    }
    if (stack.empty()) return 1
    return 0
}

private fun isStartNesting(c: Char): Boolean {
    // Assume the char c consists only of the following characters: "(",")"
    // Otherwise, need to check validity
    if (c == '(') return true
    else return false
}
private fun isMatchingNestingChar(c1: Char, c2: Char): Boolean {
    // Assume the char c consists only of the following characters: "(", ")"
    // Otherwise, need to check validity
    if (c1 == '(' && c2 == ')') return true
    return false
}
