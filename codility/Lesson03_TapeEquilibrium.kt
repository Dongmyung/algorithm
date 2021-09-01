import kotlin.math.abs
fun solution(A: IntArray): Int {
    val N = A.size
    val arraySum = A.sum()
    var minDiff = Int.MAX_VALUE
    var leftPartSum = 0
    for (i in 1..(N-1)) {
        leftPartSum += A[i-1]
        val curDiff = abs(2*leftPartSum - arraySum) // rightPartSum = arraySum - leftPartSUm
        if (minDiff > curDiff) {
            minDiff = curDiff
        }
    }
    return minDiff
}
