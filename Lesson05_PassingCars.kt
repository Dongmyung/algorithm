fun solution(A: IntArray): Int {
    var passing = 0
    var carToEast = 0
    for (i in A.indices) {
        if (A[i] == 0) {
            carToEast++
        } else {
            passing += carToEast
        }
    }
    if (passing > 1_000_000_000 || passing < 0) return -1
    return passing
}
