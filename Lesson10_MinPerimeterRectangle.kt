import kotlin.math.sqrt
fun solution(N: Int): Int {
    val n_sqrt = sqrt(N.toDouble())
    var perimeter = 0
    var i = 1
    while (i < n_sqrt) {
        if (N % i == 0) perimeter = 2 * (i + (N / i))
        i += 1
    }
    if (i * i == N) perimeter = 4 * i
    return perimeter
}
