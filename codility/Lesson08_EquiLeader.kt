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

    if (cur_size <= 0) return 0

    var candidate = cur_val
    var total_leader_count = 0
    for (i in 0 until N) {
        if (A[i] == candidate) {
            total_leader_count++
        }
    }
    if (total_leader_count <= N / 2) return 0
    
    val leader = candidate
    var equi_count = 0
    var cur_leader_count = 0
    for (i in 0 until N) {
        if (A[i] == leader) {
            cur_leader_count++
        }
        if (cur_leader_count > (i+1)/2 && (total_leader_count-cur_leader_count) > (N-i-1)/2) {
            equi_count++
        }        
    }
    return equi_count
}
