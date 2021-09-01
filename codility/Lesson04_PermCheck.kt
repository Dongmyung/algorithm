fun solution(A: IntArray): Int {
    val N = A.size
    var B = BooleanArray(N)
    for (i in A.indices) {
        if (A[i] > N) return 0
        B[A[i]-1] = true
    }
    for (i in B.indices) {
        if (!B[i]) return 0
    }
    return 1
}
