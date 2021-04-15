fun solution(A: IntArray): Int {
    val N = A.size
    val list = ArrayList<Pair<Long,Long>>()
    for (i in 0 until N) {
        list.add(Pair(i-A[i].toLong(), i+A[i].toLong()))
    }
    var sortedList = list.sortedWith(compareBy({it.first}))
    var count = 0
    for (i in 0 until N-1) {
        for (j in i+1 until N) {
            if (sortedList[j].first > sortedList[i].second) {
                break
            }
            if (sortedList[j].first >= sortedList[i].first && sortedList[j].first <= sortedList[i].second) {
                count++
            }
            if (count > 10_000_000) {
                return -1
            }
        }
    }
    return count
}
