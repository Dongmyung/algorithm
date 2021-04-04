fun solution(A: IntArray): Int {
    var max = 0
    for (i in A.indices) {
        if (max < A[i]) max = A[i]
    }

    if (max <= 0) return 1
    var B = BooleanArray(max)
    for (i in A.indices) {
        B[A[i]-1] = true
    }
    for (i in B.indices) {
        if (!B[i]) return i+1
    }
    return B.size+1
}
