import kotlin.math.sqrt
fun solution(N: Int): Int {
    var count = 0
    var i = 1
    val n_sqrt = sqrt(N.toDouble())
    while (i < n_sqrt) {
        if (N % i == 0) count += 2
        i += 1
    }
    if (i * i == N) count += 1
    return count
}
