import kotlin.math.*
fun solution(N: Int): Int {
    val n_sqrt = sqrt(N.toDouble())
    if (n_sqrt - n_sqrt.toInt() == 0.0) return 4 * n_sqrt.toInt()
    var i = floor(n_sqrt).toInt()
    while (i > 1) {
        if (N % i == 0) return 2 * (i + (N / i))
        i--
    }
    return 2 * (1 + N)
}
