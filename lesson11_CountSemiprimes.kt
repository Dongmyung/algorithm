fun solution(N: Int, P: IntArray, Q: IntArray): IntArray {
    val F = getArrayF(N)

    var ret = IntArray(P.size)
    for (i in 0 until P.size) {
        var count = 0
        for (j in P[i]..Q[i]) {
            if (F[j] > 0 && F[j/F[j]] == 0) {
                count++
            }
        }
        ret[i] = count
    }
    return ret
}

fun getArrayF(N: Int): IntArray {
    var F = IntArray(N+1)
    var i = 2
    while (i * i <= N) {
        if (F[i] == 0) {
            var k = i * i
            while (k <= N) {
                if (F[k] == 0) {
                    F[k] = i
                }
                k += i
            }
        }
        i++
    }
    return F
}
