fun main() {
    fun part1(input: List<String>): Int {
        val regex = Regex("""mul\((\d+),(\d+)\)""")

        return regex.findAll(input.joinToString())
            .sumOf {
                val (x, y) = it.destructured
                x.toInt() * y.toInt()
            }
    }

    fun part2(input: List<String>): Int {
        val regex = Regex("""mul\((\d+),(\d+)\)""")

        return regex.findAll(
            input.joinToString()
                .replace(Regex("""don't\(\).*?do\(\)"""), "")
                .replace(Regex("""don't\(\).*$"""), "")
        )
            .sumOf {
                val (x, y) = it.destructured
                x.toInt() * y.toInt()
            }
    }

    // Test if implementation meets criteria from the description, like:
    check(part2(listOf("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](do()mul(11,8)undon't()?mul(8,5))")) == 144)

    // Or read a large test input from the `src/Day01_test.txt` file:
    check(part1(readInput("Day03_test1")) == 161)
    check(part2(readInput("Day03_test2")) == 48)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
