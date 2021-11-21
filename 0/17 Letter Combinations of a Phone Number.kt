class Solution {
    // Time Complexity: O(4^n) where n is the length of digits
    // Space Complexity: O(n)
    fun letterCombinations(digits: String): List<String> {
        val mapping = hashMapOf<Char, CharArray>(
            '2' to charArrayOf('a', 'b', 'c'),
            '3' to charArrayOf('d', 'e', 'f'),
            '4' to charArrayOf('g', 'h', 'i'),
            '5' to charArrayOf('j', 'k', 'l'),
            '6' to charArrayOf('m', 'n', 'o'),
            '7' to charArrayOf('p', 'q', 'r', 's'),
            '8' to charArrayOf('t', 'u', 'v'),
            '9' to charArrayOf('w', 'x', 'y', 'z')
        )
        val list = arrayListOf<String>()
        generateCombination(digits, 0, "", list, mapping)
        return list
    }
    
    private fun generateCombination(digits: String, index: Int, combination: String, list: ArrayList<String>, mapping: HashMap<Char, CharArray>) {
        if (index >= digits.length) {
            if (combination.isNotBlank())
                list.add(combination)
            return
        }
        val current = digits[index]
        mapping[current]?.forEach  { char ->
            generateCombination(digits, index + 1, combination + char, list, mapping)
        }
    }
}