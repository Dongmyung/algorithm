fun solution(A: Int, B: Int, K: Int): Int {
    val start = A/K
    val end = B/K
    var cnt = end - start
    if (A % K == 0) cnt++
    return cnt
}
