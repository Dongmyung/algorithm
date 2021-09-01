import kotlin.math.ceil

fun solution(X: Int, Y: Int, D: Int): Int {
    return ceil((Y - X).toDouble() / D).toInt()
}
