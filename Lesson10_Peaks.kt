fun solution(A: IntArray): Int {
    val N = A.size
    val peaks = mutableListOf<Int>()

    if (N < 3) return 0
    for (i in 1..(N-2)) {
        if (A[i] > A[i-1] && A[i] > A[i+1]) {
            peaks.add(i)
        }
    }
    if (peaks.size == 0) return 0

    for (i in peaks.size downTo 1) {
        if (N % i == 0) {
            var block_size = N / i
            var idx = 0
            for (peak in peaks) {
                var start = idx * block_size
                var end = (idx + 1) * block_size
                if (peak >= start && peak < end) idx++
            }
            if (idx == i) return i
        }
    }
    return 1
}
