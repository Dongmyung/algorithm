fun solution(A: IntArray, B: IntArray): Int {
    val N = A.size
    var count = 0
    for (i in 0 until N) {
        if (hasSamePrimeDivisors(A[i], B[i])) {
            count++
        }
    }
    return count
}

fun gcd(A: Int, B: Int): Int {
    if (A % B == 0) return B
    else return gcd(B, A%B)
}

fun hasSamePrimeDivisors(A: Int, B: Int): Boolean {
    val gcd_ab = gcd(A, B)
    var a = A
    var b = B
    
    do {
        var gcd_a = gcd(a, gcd_ab)
        a /= gcd_a
    } while (gcd_a != 1)

    do {
        var gcd_b = gcd(b, gcd_ab)
        b /= gcd_b
    } while (gcd_b != 1)

    if (a == 1 && b == 1) return true
    else return false
}
