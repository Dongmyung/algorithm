fun solution(A: IntArray): Int {
    var cnt = 0
    for (i in A.indices) {
        if (A[i] == 0) {
            for (idx in i..A.lastIndex) {
                if (A[idx] == 1) {
                    cnt++
                }
            }
        }
    }   
    return cnt
}
