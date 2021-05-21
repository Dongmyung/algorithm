fun solution(A: IntArray): IntArray {
    val N = A.size
    var countA = IntArray(2*N+1)
    var ret = IntArray(N)

    for (i in 0 until N) {
        countA[A[i]]++
    }

    for (i in 0 until N) {
        var divisors = 0
        var j = 1
        while (j * j <= A[i]) {
            if (A[i] % j == 0) {
                divisors += countA[j]

                if (A[i] / j != j) {
                    divisors += countA[A[i]/j]
                }
            }
            j++
        }
        ret[i] = N - divisors
    }
    return ret
}
