fun solution(A: IntArray, K: Int): IntArray {
    if (A.size == 0) return IntArray(0)
    if (A.size == K) return A
    var ret = IntArray(A.size)
    for (i in 0 until A.size) {
        ret[(i+K)%A.size] = A[i]
    }
    return ret
}
