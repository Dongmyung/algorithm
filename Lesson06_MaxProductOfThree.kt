fun solution(A: IntArray): Int {
    A.sort()

    val lastIndex = A.lastIndex
    var max = A[lastIndex-2] * A[lastIndex-1] * A[lastIndex]
    if (A[0] < 0 && A[1] < 0 && (A[0] * A[1] * A[lastIndex]) > max ) {
        max = A[0] * A[1] * A[lastIndex]
    }
    return max
}
