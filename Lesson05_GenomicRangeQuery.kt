fun solution(S: String, P: IntArray, Q: IntArray): IntArray {
    var ret = IntArray(P.size)
    for (i in 0..P.lastIndex) {
        val subStr = S.slice(P[i]..Q[i])
        ret[i] = getMinImpactFactor(subStr)
    }
    return ret
}

fun getMinImpactFactor(S: String): Int {
    var min = Int.MAX_VALUE
    for (s in S) {
        val impactFactor = getImpactFactor(s)
        if (impactFactor < min) min = impactFactor
    }
    return min
}

fun getImpactFactor(c: Char): Int {
    return when(c) {
        'A' -> 1
        'C' -> 2
        'G' -> 3
        'T' -> 4
        else -> -1
    }
}
