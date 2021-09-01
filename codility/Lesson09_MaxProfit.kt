import kotlin.math.max;
fun solution(A: IntArray): Int {
    if (A.size <= 1) return 0
    val B = IntArray(A.size-1)
    for (i in 0 until A.size-1) {
        B[i] = A[i+1] - A[i]
    }
    if (B.size == 1) {
        if (B[0] > 0) return B[0]
        else return 0
    }
    var max_slice = B[0]
    var max_ending = B[0]
    for (i in 1 until B.size) {
        max_ending = max(B[i], max_ending+B[i])
        max_slice = max(max_slice, max_ending)
    }
    if (max_slice > 0) return max_slice
    else return 0
}
