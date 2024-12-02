fun main() {
    fun List<Int>.isValidList(): Boolean =
        zipWithNext().all { (first, second) -> second > first && second - first in 1..3 } ||
        zipWithNext().all { (first, second) -> first > second && first - second in 1..3 }

    fun part1(input: List<String>): Int {
        return input.count { line ->
            val report = line.split(" ").map { it.toInt() }
            report.isValidList()
        }
    }

    fun part2(input: List<String>): Int {
        return input.count { line ->
            val report = line.split(" ").map { it.toInt() }
            report.isValidList() || report.indices.any {
                (report.subList(0, it) + report.subList(it + 1, report.size)).isValidList()
            }
        }
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("15 12 15 18 20 23 25 27")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
