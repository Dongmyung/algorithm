fun solution(N: Int, M: Int): Int {
    return N / gcd(N, M)
}

fun gcd(A: Int, B: Int): Int {
    if (A % B == 0) return B
    else return gcd(B, A%B)
}
