import java.util.*
fun solution(A: IntArray, B: IntArray): Int {
    var counter = 0
    var stack = Stack<Int>()
    for (i in 0 until A.size) {
        // Assume B[i] has only 0 or 1. Otherwise need to check validity here
        if (B[i] == 1) {
            stack.push(A[i])
        } else {
            while (!stack.empty() && stack.peek() < A[i]) {
                stack.pop()
            }
            if (stack.empty()) {
                counter++
            }
        }
    }
    counter += stack.size
    return counter
}
