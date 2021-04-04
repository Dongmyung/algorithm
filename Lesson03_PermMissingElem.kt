fun solution(A: IntArray): Int {
    val N = A.size
    val supposedToBeSum = (N+2)*(N+1)/2 // use math 1..N+1 Sum
    return supposedToBeSum - A.sum()
}
