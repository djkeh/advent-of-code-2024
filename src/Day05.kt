fun main() {
    fun getReversedOrderingRules(input: List<String>) = input
        .takeWhile { "|" in it }
        .map { it.split("|") }
        .groupBy({ it[1] }, { it[0] })
        .mapValues { it.value.toSet() }

    fun getUpdates(input: List<String>) = input
        .takeLastWhile { "," in it }
        .map { line -> line.split(",").toMutableList() }

    infix fun String.`in`(other: Set<String>?): Boolean = if (other == null) false else this in other

    fun part1(input: List<String>): Int {
        val reversedOrderingRules = getReversedOrderingRules(input)
        val updates = getUpdates(input)

        return updates.filter { line ->
            line.dropLast(1).withIndex().none { (index, pageNum) ->
                line.subList(index + 1, line.size).any { it `in` reversedOrderingRules[pageNum] }
            }
        }.sumOf { it[it.size / 2].toInt() }
    }

    fun part2(input: List<String>): Int {
        val reversedOrderingRules = getReversedOrderingRules(input)
        val updates = getUpdates(input)

        return updates.filterNot { line ->
            line.dropLast(1).withIndex().none { (index, pageNum) ->
                line.subList(index + 1, line.size).any { it `in` reversedOrderingRules[pageNum] }
            }
        }.onEach { line ->
            for (i in 0 until line.size - 1) {
                for (j in (i + 1) until line.size) {
                    val value = line[j]
                    if (value `in` reversedOrderingRules[line[i]]) {
                        val temp = line[i]
                        line[i] = line[j]
                        line[j] = temp
                    }
                }
            }
        }.sumOf { it[it.size / 2].toInt() }
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("1")) == 0)

    // Or read a large test input from the `src/Day01_test.txt` file:
    check(part1(readInput("Day05_test1")) == 143)
    check(part2(readInput("Day05_test1")) == 123)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day05")
    part1(input).println()
    part2(input).println()
}
