class Solution {
    // Time Complexity: O(m*n*w*3^l)
    // Space Complexity: O(w + l)
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val table = hashMapOf<Char, HashSet<String>>()
        // O(w) where w is the number of word in words
        words.forEach { word ->
            val char = word[0]
            val current = table[char] ?: hashSetOf<String>()
            current.add(word)
            table[char] = current 
        }
        
        val result = hashSetOf<String>()
        // O(m)
        board.forEachIndexed { y, charArray ->
            // O(n)
            charArray.forEachIndexed { x, char ->
                // O(w)
                table[char]?.forEach { word ->
                    if (!result.contains(word)) {
                        // O(3^l)
                        if (search(board, y, x, word, 0, hashSetOf())) {
                            result.add(word)
                        }
                    }
                }
            }
        }
        return result.toList()
    }
    
    private fun search(board: Array<CharArray>, y: Int, x: Int, word: String, index: Int, path: HashSet<Pair<Int, Int>>): Boolean {
        if (y < 0 || x < 0 || y >= board.size || x >= board[0].size)
            return false
        if (board[y][x] != word[index])
            return false
        val current = Pair(y, x)
        if (path.contains(current))
            return false
        if (index == word.length - 1)
            return true
        path.add(current)
        val yDir = intArrayOf(-1, 1, 0, 0)
        val xDir = intArrayOf(0, 0, -1, 1)
        for (i in 0..yDir.size - 1) {
            if (search(board, y + yDir[i], x + xDir[i], word, index + 1, path)) {
                path.remove(current)
                return true
            }
        }
        path.remove(current)
        return false
    }
}