import kotlin.math.max;
fun solution(A: IntArray): Int {
    val N = A.size
    if (N <= 3) return 0

    val leftMax = IntArray(N)
    val rightMax = IntArray(N)

    for (i in 1 until N-1) {
        leftMax[i] = max(0, leftMax[i-1]+A[i])
    }

    for (i in N-2 downTo 1) {
        rightMax[i] = max(0, rightMax[i+1]+A[i])
    }

    var maxSum = 0
    for (i in 1 until N-1) {
        maxSum = max(maxSum, (leftMax[i-1]+rightMax[i+1]))
    }
    return maxSum
}
