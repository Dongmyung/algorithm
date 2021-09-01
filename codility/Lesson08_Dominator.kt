fun solution(A: IntArray): Int {
    val N = A.size
    var cur_size = 0
    var cur_val = 0
    for (i in 0 until N) {
        if (cur_size == 0) {
            cur_size++
            cur_val = A[i]
        } else {
            if (cur_val != A[i]) {
                cur_size--
            } else {
                 cur_size++
            }
        }
    }

    if (cur_size <= 0) return -1

    var candidate = cur_val
    var count = 0
    var idx = -1
    for (i in 0 until N) {
        if (A[i] == candidate) {
            count++
            idx = i
        }
    }
    if (count > N / 2) return idx
    return -1
}
