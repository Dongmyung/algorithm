fun solution(N: Int): Int {
    var max_gap = 0
    var gap = 0
    val bin = Integer.toBinaryString(N)
    for (i in 0 until bin.length) {
        if (bin[i] == '1') {
            if (max_gap < gap) {
                max_gap = gap
            }
            gap = 0
        } else {
            gap++
        }
    }
    return max_gap
}
