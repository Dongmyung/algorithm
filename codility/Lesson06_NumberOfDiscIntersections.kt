fun solution(A: IntArray): Int {
    val N = A.size
    var cnt = 0
    var upper = LongArray(N)
    var lower = LongArray(N)
    for (i in 0 until N) {
        upper[i] = (i+A[i].toLong())
        lower[i] = (i-A[i].toLong())
    }
    upper.sort()
    lower.sort()
    var j = 0
    for (i in 0 until N) {
        while ( j < N && upper[i] >= lower[j]) {
            cnt += j
            cnt -= i
            j++
            if (cnt > 10_000_000) {
                return -1
            }
        }
    }
    return cnt
}
