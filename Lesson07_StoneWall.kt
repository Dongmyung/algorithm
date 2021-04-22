import java.util.*
fun solution(H: IntArray): Int {
    val stack = Stack<Int>()
    var counter = 0
    for (i in 0 until H.size) {
        while (!stack.empty() && stack.peek() > H[i]) {
            stack.pop()
        }
        if (stack.empty() || stack.peek() < H[i]) {
            stack.push(H[i])
            counter++
        }
    }
    return counter
}
