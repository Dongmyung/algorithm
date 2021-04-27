import kotlin.math.max;
fun solution(A: IntArray): Int {
    var max_slice = 0
    var max_ending = 0
    for (i in 0 until A.size) {
        max_ending = max(0, max_ending+A[i])
        max_slice = max(max_slice, max_ending)
    }
    return max_slice
}
