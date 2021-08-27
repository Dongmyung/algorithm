import kotlin.math.*

fun solution(A: IntArray): Int {
    val N = A.size
    var dp = IntArray(N)
    for (i in 0 until N) {
        dp[i] = Int.MIN_VALUE
    }

    dp[0] = A[0];
    for (i in 1 until N) {
        for (k in 1..6) {
            if (i - k >= 0) {
                var maxValue = A[i] + dp[i-k] + getMaxSumPositive(A, i-k+1, i-1)
                dp[i] = max(dp[i], maxValue)
            }
        }
    }
    return dp[N-1]
}

fun getMaxSumPositive(A: IntArray, startIdx: Int, endIdx: Int) : Int {
    var sum = 0
    if (startIdx > endIdx) return sum;
    for (i in startIdx..endIdx) {
        if (A[i] > 0) sum += A[i]
    }
    return sum
}
