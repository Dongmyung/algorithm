fun solution(N: Int, P: IntArray, Q: IntArray): IntArray {
    val F = getArrayF(N)

    var acm = IntArray(N+1)
    var sum = 0
    for (i in 1..N) {
        if (F[i] > 0 && F[i/F[i]] == 0) {
            sum++
        }
        acm[i] = sum
    }

    var ret = IntArray(P.size)
    for (i in 0 until P.size) {
        ret[i] = acm[Q[i]] - acm[P[i]-1]
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
