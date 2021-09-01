import kotlin.math.*
fun solution(A: IntArray): Int {
    val N = A.size
    val peaks = mutableListOf<Int>()

    if (N < 3) return 0
    for (i in 1..(N-2)) {
        if (A[i] > A[i-1] && A[i] > A[i+1]) {
            peaks.add(i)
        }
    }
    if (peaks.size < 3) return peaks.size

    var maxFlags = 0
    for (K in 2..peaks.size) {
        var flags = 1
        var peakIdx = 0
        var nextPeakIdx = 1
        while (peakIdx < (peaks.size - 1)) {
            if (peaks[nextPeakIdx] - peaks[peakIdx] >= K) {
                flags++
                peakIdx = nextPeakIdx
                nextPeakIdx = peakIdx + 1
            } else {
                nextPeakIdx++
            }
            if (nextPeakIdx == peaks.size || flags == K) break
        }
        if (maxFlags > flags) {
            return maxFlags
        }
        maxFlags = max(maxFlags, flags)
    }
    return maxFlags
}
