fun solution(X: Int, A: IntArray): Int {
    var ret = 0
    var counter = IntArray(X)
    for (i in A.indices) {
        if (A[i] <= X && counter[A[i]-1] == 0) {
            counter[A[i]-1]++
            if (ret < i) ret = i
        }
    }
    for (i in counter.indices) {
        if (counter[i] == 0) return -1
    }
    return ret
}
