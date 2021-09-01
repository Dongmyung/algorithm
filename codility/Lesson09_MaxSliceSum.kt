import kotlin.math.max;
fun solution(A: IntArray): Int {
    if (A.size == 1) return A[0]
    var max_slice = A[0]
    var max_ending = A[0]
    for (i in 1 until A.size) {
        max_ending = max(A[i], max_ending+A[i])
        max_slice = max(max_slice, max_ending)
    }
    return max_slice
}
