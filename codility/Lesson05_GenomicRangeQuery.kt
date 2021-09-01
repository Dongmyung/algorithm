fun solution(S: String, P: IntArray, Q: IntArray): IntArray {
    var ret = IntArray(P.size)
    var counterA = IntArray(S.length+1)
    var counterC = IntArray(S.length+1)
    var counterG = IntArray(S.length+1)
    for (i in S.indices) {
        counterA[i+1] = counterA[i]
        counterC[i+1] = counterC[i]
        counterG[i+1] = counterG[i]

        val c = S[i]
        when(c) {
            'A' -> counterA[i+1]++
            'C' -> counterC[i+1]++
            'G' -> counterG[i+1]++
            else -> {}
        }
    }

    for (i in 0..P.lastIndex) {
        val startIdx = P[i]
        val endIdx = Q[i]

        if (startIdx == endIdx) {
            val c = S[startIdx]
            ret[i] = when (c) {
                'A' -> 1
                'C' -> 2
                'G' -> 3
                'T' -> 4
                else -> -1
            }
        } else {
            if (counterA[startIdx] != counterA[endIdx+1]) {
                ret[i] = 1
            } else if (counterC[startIdx] != counterC[endIdx+1]) {
                ret[i] = 2
            } else if (counterG[startIdx] != counterG[endIdx+1]) {
                ret[i] = 3
            } else {
                ret[i] = 4
            } 
        }
    }

    return ret
}
