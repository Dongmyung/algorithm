fun solution(A: IntArray): Int {
    var B = BooleanArray(A.size+1)
    for (i in A.indices) {
        B.set(A[i]-1, true)
    }
    for (i in B.indices) {
        if (!B[i]) return i+1
    }
    return 0
}
