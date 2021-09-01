fun solution(N: Int, A: IntArray): IntArray {
    var counter = IntArray(N)
    var max = 0
    var checkedMax = 0
    for (i in A.indices) {
        if (A[i] <= N) {
            if (counter[A[i]-1] < checkedMax) counter[A[i]-1] = checkedMax
            counter[A[i]-1]++
            if (max < counter[A[i]-1]) max = counter[A[i]-1]
        } else {
            // Max Counter
            checkedMax = max
        }
    }
    for (i in counter.indices) {
        if (counter[i] < checkedMax) counter[i] = checkedMax
    }
    return counter
}
