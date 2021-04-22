import java.util.*
fun solution(S: String): Int {
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
    // Assume the char c consists only of the following characters: "(", "{", "[", "]", "}" and/or ")"
    // Otherwise, need to check validity
    if (c == '(' || c == '{' || c == '[') return true
    else return false
}
private fun isMatchingNestingChar(c1: Char, c2: Char): Boolean {
    // Assume the char c consists only of the following characters: "(", "{", "[", "]", "}" and/or ")"
    // Otherwise, need to check validity
    if (c1 == '(' && c2 == ')') return true
    if (c1 == '{' && c2 == '}') return true
    if (c1 == '[' && c2 == ']') return true
    return false
}
