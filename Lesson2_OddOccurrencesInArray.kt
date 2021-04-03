fun solution(A: IntArray): Int {
    var ret = 0
    for (i in A) {
        ret = ret xor i
    }
    return ret
}
