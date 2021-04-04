fun solution(N: Int, A: IntArray): IntArray {
    var counter = IntArray(N)
    var max = 0
    for (i in A.indices) {
        if (A[i] <= N) {
            counter[A[i]-1]++
            if (max < counter[A[i]-1]) max = counter[A[i]-1]
        } else {
            // Max Counter
            for (idx in counter.indices) {
                counter[idx] = max
            }
        }
    }
    return counter
}
