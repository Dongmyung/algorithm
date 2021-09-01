fun solution(A: IntArray): Int {
    var minAvg = (A[0]+A[1])/2f
    var minIdx = 0
    for (i in 2..(A.lastIndex)) {
        var avg = (A[i-1]+A[i])/2f
        if (avg < minAvg) {
            minAvg = avg
            minIdx = i-1
        }

        avg = (A[i-2]+A[i-1]+A[i])/3f
        if (avg < minAvg) {
            minAvg = avg
            minIdx = i-2
        }
    }
    return minIdx
}
