fun solution(A: IntArray): Int {
    var minAvg = Double.MAX_VALUE
    var minIdx = 0
    for (i in 0..A.lastIndex) {
        var curSum = A[i]
        for (j in (i+1)..A.lastIndex) {
            curSum += A[j]
            val avg = curSum.toDouble()/(j-i+1)
            if (minAvg > (avg)) {
                minAvg = avg
                minIdx = i
            }
        }
    }
    return minIdx
}
