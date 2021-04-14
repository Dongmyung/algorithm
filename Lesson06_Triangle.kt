fun solution(A: IntArray): Int {
    if (A.size < 3) return 0
    
    A.sort()
    for (i in 0..(A.lastIndex-2)) {
        if (A[i].toBigInteger() + A[i+1].toBigInteger() > A[i+2].toBigInteger() ) {
            return 1
        }
    }
    return 0
}
