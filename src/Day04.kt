fun main() {
    fun List<String>.at(index: Int): String? = getOrNull(index)
    fun CharSequence.at(index: Int): Char? = getOrNull(index)

    fun countXMAS(matrix: List<String>, x: Int, y: Int): Int {
        var count = 0

        if (matrix[y][x] != 'X') return 0
        if (matrix[y].at(x + 1)         == 'M' && matrix[y].at(x + 2)         == 'A' && matrix[y].at(x + 3)         == 'S') count++
        if (matrix.at(y + 1)?.at(x + 1) == 'M' && matrix.at(y + 2)?.at(x + 2) == 'A' && matrix.at(y + 3)?.at(x + 3) == 'S') count++
        if (matrix.at(y + 1)?.at(x)     == 'M' && matrix.at(y + 2)?.at(x)     == 'A' && matrix.at(y + 3)?.at(x)     == 'S') count++
        if (matrix.at(y + 1)?.at(x - 1) == 'M' && matrix.at(y + 2)?.at(x - 2) == 'A' && matrix.at(y + 3)?.at(x - 3) == 'S') count++
        if (matrix[y].at(x - 1)         == 'M' && matrix[y].at(x - 2)         == 'A' && matrix[y].at(x - 3)         == 'S') count++
        if (matrix.at(y - 1)?.at(x - 1) == 'M' && matrix.at(y - 2)?.at(x - 2) == 'A' && matrix.at(y - 3)?.at(x - 3) == 'S') count++
        if (matrix.at(y - 1)?.at(x)     == 'M' && matrix.at(y - 2)?.at(x)     == 'A' && matrix.at(y - 3)?.at(x)     == 'S') count++
        if (matrix.at(y - 1)?.at(x + 1) == 'M' && matrix.at(y - 2)?.at(x + 2) == 'A' && matrix.at(y - 3)?.at(x + 3) == 'S') count++

        return count
    }

    fun countXMAS2(matrix: List<String>, x: Int, y: Int): Int {
        var count = 0

        if (matrix[y][x] != 'M') return 0
        if (matrix.at(y + 2)?.at(x) == 'M' && matrix.at(y + 1)?.at(x + 1) == 'A' && matrix[y].at(x + 2)         == 'S' && matrix.at(y + 2)?.at(x + 2) == 'S') count++
        if (matrix[y].at(x + 2)     == 'M' && matrix.at(y + 1)?.at(x + 1) == 'A' && matrix.at(y + 2)?.at(x)     == 'S' && matrix.at(y + 2)?.at(x + 2) == 'S') count++
        if (matrix.at(y + 2)?.at(x) == 'M' && matrix.at(y + 1)?.at(x - 1) == 'A' && matrix[y].at(x - 2)         == 'S' && matrix.at(y + 2)?.at(x - 2) == 'S') count++
        if (matrix[y].at(x + 2)     == 'M' && matrix.at(y - 1)?.at(x + 1) == 'A' && matrix.at(y - 2)?.at(x)     == 'S' && matrix.at(y - 2)?.at(x + 2) == 'S') count++

        return count
    }

    fun part1(input: List<String>): Int {
        return input.withIndex().sumOf { (y, line) ->
            line.indices.sumOf { x ->
                countXMAS(input, x, y)
            }
        }
    }

    fun part2(input: List<String>): Int {
        return input.withIndex().sumOf { (y, line) ->
            line.indices.sumOf { x ->
                countXMAS2(input, x, y)
            }
        }
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("1")) == 0)

    // Or read a large test input from the `src/Day01_test.txt` file:
    check(part1(readInput("Day04_test1")) == 18)
    check(part2(readInput("Day04_test2")) == 9)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}
