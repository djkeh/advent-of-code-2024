import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val left = input.map { it.split("   ")[0].toInt() }.sorted()
        val right = input.map { it.split("   ")[1].toInt() }.sorted()
        val answer = input.indices.sumOf { i -> abs(left[i] - right[i]) }

        return answer
    }

    fun part2(input: List<String>): Int {
        val (lefts, rights) = input.map {
            val splits = it.split("   ")
            splits[0].toInt() to splits[1].toInt()
        }.unzip()
        val answer = lefts.sumOf { left ->
            val count = rights.count { right -> left == right }
            left * count
        }

        return answer
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
